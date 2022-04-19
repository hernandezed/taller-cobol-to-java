package com.taller.coboljava.business.bo.payment;

import com.taller.coboljava.business.bo.beneficiary.CryptoBeneficiary;
import com.taller.coboljava.business.bo.payer.CryptoPayer;

import java.math.BigDecimal;

public class CryptoPayment extends PaymentWithBeneficiary {

    public CryptoPayment(CryptoPayer payerData, BigDecimal amount, CryptoBeneficiary beneficiary) {
        super(payerData, amount, beneficiary);
    }

    @Override
    public String toString() {
        return "CryptoPayment{" +
                "payerData=" + payerData +
                ", amount=" + amount +
                ", beneficiary=" + beneficiary +
                '}';
    }

    @Override
    public int executionTime() {
        return 2000;
    }
}
