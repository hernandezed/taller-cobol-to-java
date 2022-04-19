package com.taller.coboljava.business.bo.beneficiary;

public abstract class Beneficiary {
    protected String name;

    public Beneficiary(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
