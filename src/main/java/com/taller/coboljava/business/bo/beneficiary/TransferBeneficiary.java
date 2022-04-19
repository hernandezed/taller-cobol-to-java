package com.taller.coboljava.business.bo.beneficiary;

public class TransferBeneficiary extends Beneficiary {
    private String cbu;

    public TransferBeneficiary(String name, String cbu) {
        super(name);
        this.cbu = cbu;
    }

    public String getCbu() {
        return cbu;
    }

    @Override
    public String toString() {
        return "TransferBeneficiary{" +
                "name='" + name + '\'' +
                ", cbu='" + cbu + '\'' +
                '}';
    }
}
