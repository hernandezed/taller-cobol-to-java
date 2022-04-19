package com.taller.coboljava.business.bo.payment;

import com.taller.coboljava.business.bo.beneficiary.TransferBeneficiary;
import com.taller.coboljava.business.bo.payer.TransferPayer;

import java.math.BigDecimal;

public class TransferPayment extends PaymentWithBeneficiary {
    public TransferPayment(TransferPayer payerData, BigDecimal amount, TransferBeneficiary beneficiary) {
        super(payerData, amount, beneficiary);
    }

    @Override
    public String toString() {
        return "TransferPayment{" +
                "payerData=" + payerData +
                ", amount=" + amount +
                ", beneficiary=" + beneficiary +
                '}';
    }

    @Override
    public int executionTime() {
        return 4000;
    }
}
