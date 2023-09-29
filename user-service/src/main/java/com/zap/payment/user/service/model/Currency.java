package com.zap.payment.user.service.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tbl_currency")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long currencyId;
    @Column(name = "name")
    String currencyName;
    @Column(name = "abbreviation")
    String abbreviation;

}
