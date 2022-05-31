package com.taller.coboljava;


import com.taller.coboljava.business.bo.PaymentType;
import com.taller.coboljava.business.bo.abstract_factory.DummyPaymentFactory;
import com.taller.coboljava.business.bo.abstract_factory.PaymentAbstractFactory;
import com.taller.coboljava.business.bo.factory_method.CreateCardPayment;
import com.taller.coboljava.business.bo.factory_method.CreateCryptoPayment;
import com.taller.coboljava.business.bo.factory_method.CreatePayment;
import com.taller.coboljava.business.bo.factory_method.CreateTransferPayment;
import com.taller.coboljava.business.bo.payment.CardPayment;
import com.taller.coboljava.business.bo.payment.CryptoPayment;
import com.taller.coboljava.business.bo.payment.Payment;
import com.taller.coboljava.business.bo.payment.TransferPayment;
import com.taller.coboljava.business.bo.singleton.StdInSingleton;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Application {

    public Double ejecutarOperacionMatematica(Integer i, Integer j, String operacion) {
        if (operacion == "SUMA") {
            return (double) i + j;
        } else if (operacion == "RESTA") {
            return (double) i - j;
        }
        return null;
    }

    private static Scanner in = StdInSingleton.getInstance();

    public static void main(String... args) throws InterruptedException {
        Integer option = 0;
        do {
            printPaymentTypes();

            String s = in.nextLine();
            option = Integer.parseInt(s);
            Payment p = null;

            Class<? extends Payment> targetPayment = null;

            switch (option) {
                case 1:
                    targetPayment = TransferPayment.class;
                    break;
                case 2:
                    targetPayment = CardPayment.class;
                    break;
                case 3:
                    targetPayment = CryptoPayment.class;
                    break;
            }

            PaymentAbstractFactory paymentAbstractFactory = DummyPaymentFactory.getInstance(targetPayment);
            p = paymentAbstractFactory.create();

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
