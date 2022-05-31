package com.taller.coboljava.business.bo.abstract_factory;

import com.taller.coboljava.business.bo.payment.Payment;

public interface PaymentAbstractFactory<T extends Payment> {

    T create();
}
