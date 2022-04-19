package com.taller.coboljava.business.bo.payer;

import com.taller.coboljava.business.bo.payment.Payment;

public abstract class Payer {
    protected String name;

    public Payer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
