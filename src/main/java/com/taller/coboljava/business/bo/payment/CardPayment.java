package com.taller.coboljava.business.bo.payment;

import com.taller.coboljava.business.bo.payer.CardPayer;

import java.math.BigDecimal;

public class CardPayment extends Payment {
    public CardPayment(CardPayer payerData, BigDecimal amount) {
        super(payerData, amount);
    }

    @Override
    public String toString() {
        return "CardPayment{" +
                "payerData=" + payerData +
                ", amount=" + amount +
                '}';
    }


    @Override
    public int executionTime() {
        return 1000;
    }
}
