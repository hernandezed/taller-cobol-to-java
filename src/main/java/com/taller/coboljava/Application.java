package com.taller.coboljava;


import com.taller.coboljava.business.bo.PaymentType;
import com.taller.coboljava.business.bo.abstract_factory.DummyPaymentFactory;
import com.taller.coboljava.business.bo.abstract_factory.PaymentAbstractFactory;
import com.taller.coboljava.business.bo.factory_method.CreateCardPayment;
import com.taller.coboljava.business.bo.factory_method.CreateCryptoPayment;
import com.taller.coboljava.business.bo.factory_method.CreatePayment;
import com.taller.coboljava.business.bo.factory_method.CreateTransferPayment;
import com.taller.coboljava.business.bo.payment.Payment;
import com.taller.coboljava.business.bo.singleton.StdInSingleton;

import java.util.Scanner;

public class Application {
    private static Scanner in = StdInSingleton.getInstance();

    public static void main(String... args) throws InterruptedException {
        Integer option = 0;
        do {
            printPaymentTypes();

            String s = in.nextLine();
            option = Integer.parseInt(s);
            Payment p = null;

            PaymentAbstractFactory paymentAbstractFactory = DummyPaymentFactory.getInstance();

            switch (option) {
                case 1:
                    p = paymentAbstractFactory.createTransferPayment();
                    break;
                case 2:
                    p = paymentAbstractFactory.createCardPayment();
                    break;
                case 3:
                    p = paymentAbstractFactory.createCryptoPayment();
                    break;
            }
            if (p != null) {
                System.out.println(p);
                Thread.sleep(p.executionTime());
            }

        } while (option != 4);
    }

    private static void printPaymentTypes() {
        System.out.println("Seleccione una opcion de pago");
        PaymentType last = null;
        for (PaymentType paymentType : PaymentType.values()) {
            System.out.println(paymentType.ordinal() + 1 + "- " + paymentType.name());
            last = paymentType;
        }
        System.out.println(last.ordinal() + 2 + "- EXIT");
        System.out.print("Selecciono: ");
    }
}
