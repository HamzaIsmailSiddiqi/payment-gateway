package com.zap.payment.otp.service.service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.zap.payment.otp.service.exceptions.ErrorCode;
import com.zap.payment.otp.service.exceptions.ZAPException;
import lombok.CustomLog;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@CustomLog
@Service
public class TwilioService {

    @Value("#{environment.twilio_sender_phone_number}")
    private String twilioSenderNumber;

    public void sendSms(String fullPhoneNumber, String sms) {
        validateMobileNumber(fullPhoneNumber);
        callTwilioToSendSms(fullPhoneNumber, sms);
    }

    private void callTwilioToSendSms(String fullPhoneNumber, String messageBody) {
        CompletableFuture<Message> messageFuture = Message.creator(new PhoneNumber(fullPhoneNumber),
                        new PhoneNumber(twilioSenderNumber),messageBody)
                .createAsync();
        CompletableFuture<Message> future = messageFuture.handle((message, exception) -> {
            if (message != null) {
                log.debugf("SMS SEND message status %s; possibly we could wait for SENT or FAILED status to improve.", message.getStatus());
                return message;
            } else{
                log.errorf("SMS SEND message exception for phone %s: %s.", exception, fullPhoneNumber, exception.getMessage());
                return null;
            }
        });
        // let's wait for it anyhow
        try {
            Message resultMessage = future.get();
            if (resultMessage != null) {
                log.infof("SMS SEND message status %s, message=", resultMessage.getStatus(), resultMessage.toString());
            } else {
                log.errorf("SMS SEND message result missing for phone %s.", fullPhoneNumber);
            }
        } catch (Exception ignored) {
        }
    }

    private void validateMobileNumber(String fullPhoneNumber) {
        // Only send to mobile numbers - block others.
        String twilioLookupNumber = fullPhoneNumber.replace("+", "");
        try {
            com.twilio.rest.lookups.v1.PhoneNumber lookupPhoneNumber = com.twilio.rest.lookups.v1.PhoneNumber.fetcher(new PhoneNumber(twilioLookupNumber))
                    .setType(List.of("carrier")).fetch();
            if (lookupPhoneNumber == null
                    || lookupPhoneNumber.getCarrier() == null
                    || lookupPhoneNumber.getCarrier().isEmpty()) {
                log.warnf("SMS SEND: Unable to determine whether the phone number is mobile, NOT sending message.");
                throw new ZAPException.NotAllowed(ErrorCode.INTERNAL_ERROR);
            }

            Object kindOfNumber = lookupPhoneNumber.getCarrier().get("type");
            if (!(kindOfNumber instanceof String)) {
                log.warnf("SMS SEND: Unable to determine whether the phone number is mobile phone=%s, NOT sending message.", twilioLookupNumber);
                throw new ZAPException.NotAllowed(ErrorCode.INTERNAL_ERROR);
            }

            if (!"mobile".equalsIgnoreCase((String) kindOfNumber)) {
                log.warnf("SMS SEND: Unexpected attempt to send to a non-mobile number %s (type=%s), NOT sending message. ", fullPhoneNumber, kindOfNumber);
                throw new ZAPException.NotAllowed(ErrorCode.INTERNAL_ERROR);
            }

        } catch (com.twilio.exception.ApiException e) {
            log.warnf("SMS SEND: TWILIO LOOKUP ISSUE: phone=%s status=%s moreInfo=%s", twilioLookupNumber, e.getStatusCode(), e.getMoreInfo());
            throw new ZAPException.NotAllowed(ErrorCode.INTERNAL_ERROR);
        }
    }

}
