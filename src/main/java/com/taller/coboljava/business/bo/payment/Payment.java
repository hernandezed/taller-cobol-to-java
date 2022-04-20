package com.taller.coboljava.business.bo.payment;


import com.taller.coboljava.business.bo.payer.Payer;

import java.math.BigDecimal;

public abstract class Payment implements ExecutableInTime {
    protected Payer payerData;
    protected BigDecimal amount;

    public Payment(Payer payerData, BigDecimal amount) {
        this.payerData = payerData;
        this.amount = amount;
    }

    public Payer getPayerData() {
        return payerData;
    }

    public BigDecimal getAmount() {
        return amount;
    }


}
