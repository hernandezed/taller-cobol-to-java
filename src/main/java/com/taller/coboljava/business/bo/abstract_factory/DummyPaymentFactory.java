package com.taller.coboljava.business.bo.abstract_factory;

import com.taller.coboljava.business.bo.factory_method.CreateCardPayment;
import com.taller.coboljava.business.bo.factory_method.CreateCryptoPayment;
import com.taller.coboljava.business.bo.factory_method.CreatePayment;
import com.taller.coboljava.business.bo.factory_method.CreateTransferPayment;
import com.taller.coboljava.business.bo.payment.Payment;
import com.taller.coboljava.business.bo.singleton.StdInSingleton;

import java.util.Scanner;

public class DummyPaymentFactory implements PaymentAbstractFactory {

    private CreatePayment createCardPayment;
    private CreatePayment createCryptoPayment;
    private CreatePayment createTransferPayment;
    private Scanner in;
    private static DummyPaymentFactory instance;

    private DummyPaymentFactory() {
        this.createCardPayment = new CreateCardPayment();
        this.createCryptoPayment = new CreateCryptoPayment();
        this.createTransferPayment = new CreateTransferPayment();
        this.in = StdInSingleton.getInstance();
    }

    @Override
    public Payment createCardPayment() {
        return createCardPayment.create(in);
    }

    @Override
    public Payment createCryptoPayment() {
        return createCryptoPayment.create(in);
    }

    @Override
    public Payment createTransferPayment() {
        return createTransferPayment.create(in);
    }

    public static DummyPaymentFactory getInstance() {
        if (instance == null) {
            instance = new DummyPaymentFactory();
        }
        return instance;
    }
}
