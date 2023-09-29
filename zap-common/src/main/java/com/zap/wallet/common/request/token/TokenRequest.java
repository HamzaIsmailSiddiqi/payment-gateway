package com.zap.wallet.common.request.token;

import com.zap.wallet.common.request.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TokenRequest extends BaseRequest implements Serializable {
	private static final long serialVersionUID = 5926468583005150707L;
	private String userName;
	private String tokenType;
}
