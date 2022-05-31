package com.taller.coboljava.business.bo.abstract_factory;

import com.taller.coboljava.business.bo.factory_method.CreateCardPayment;
import com.taller.coboljava.business.bo.factory_method.CreateCryptoPayment;
import com.taller.coboljava.business.bo.factory_method.CreatePayment;
import com.taller.coboljava.business.bo.factory_method.CreateTransferPayment;
import com.taller.coboljava.business.bo.payment.CardPayment;
import com.taller.coboljava.business.bo.payment.Payment;
import com.taller.coboljava.business.bo.payment.TransferPayment;
import com.taller.coboljava.business.bo.singleton.StdInSingleton;

import java.util.Scanner;


public class DummyPaymentFactory<T extends Payment, S extends CreatePayment<T>> implements PaymentAbstractFactory<T> {
    private S createPaymentFactoryMethod;
    private Scanner in;

    public DummyPaymentFactory(S createPaymentFactoryMethod) {
        this.createPaymentFactoryMethod = createPaymentFactoryMethod;
        this.in = StdInSingleton.getInstance();
    }

    @Override
    public T create() {
        return createPaymentFactoryMethod.create(in);
    }

    public static <T extends Payment, S extends CreatePayment<T>> DummyPaymentFactory<T, S> getInstance(Class<T> targetPayment) {
        S factory = null;
        if (targetPayment.equals(CardPayment.class)) {
            factory = (S) new CreateCardPayment();
        } else if (targetPayment.equals(TransferPayment.class)) {
            factory = (S) new CreateTransferPayment();
        } else {
            factory = (S) new CreateCryptoPayment();
        }
        return new DummyPaymentFactory<>(factory);
    }
}
