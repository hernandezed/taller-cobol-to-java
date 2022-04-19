package com.taller.coboljava.business.bo.beneficiary;

public class CryptoBeneficiary extends Beneficiary {
    private String walletId;

    public CryptoBeneficiary(String name, String walletId) {
        super(name);
        this.walletId = walletId;
    }

    public String getWalletId() {
        return walletId;
    }

    @Override
    public String toString() {
        return "CryptoBeneficiary{" +
                "name='" + name + '\'' +
                ", walletId='" + walletId + '\'' +
                '}';
    }
}
