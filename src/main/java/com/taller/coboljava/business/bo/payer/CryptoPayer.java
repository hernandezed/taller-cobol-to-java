package com.taller.coboljava.business.bo.payer;

public class CryptoPayer extends Payer {
    private String walletId;

    public CryptoPayer(String name, String walletId) {
        super(name);
        this.walletId = walletId;
    }

    public String getWalletId() {
        return walletId;
    }

    @Override
    public String toString() {
        return "CryptoPayer{" +
                "walletId='" + walletId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
