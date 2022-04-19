package com.taller.coboljava.business.bo.payer;

public class TransferPayer extends Payer {
    private String cbu;

    public TransferPayer(String name, String cbu) {
        super(name);
        this.cbu = cbu;
    }

    public String getCbu() {
        return cbu;
    }

    @Override
    public String toString() {
        return "TransferPayer{" +
                "name='" + name + '\'' +
                ", cbu='" + cbu + '\'' +
                '}';
    }
}
