package com.zap.payment.user.service.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "tbl_wallet")
public class Wallet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long walletId;
    @Column(name = "balance")
    private BigDecimal balance;
    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private UserProfile userProfile;
    @OneToOne
    @JoinColumn(name = "currency_id",referencedColumnName = "id")
    private Currency currency;
}
