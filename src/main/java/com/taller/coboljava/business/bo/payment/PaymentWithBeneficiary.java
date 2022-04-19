package com.taller.coboljava.business.bo.payment;

import com.taller.coboljava.business.bo.beneficiary.Beneficiary;
import com.taller.coboljava.business.bo.payer.Payer;

import java.math.BigDecimal;

public abstract class PaymentWithBeneficiary extends Payment {
    protected Beneficiary beneficiary;

    public PaymentWithBeneficiary(Payer payerData, BigDecimal amount, Beneficiary beneficiary) {
        super(payerData, amount);
        this.beneficiary = beneficiary;
    }

    public Beneficiary getBeneficiary() {
        return beneficiary;
    }
}
