package com.taller.coboljava.business.bo.factory_method;

import com.taller.coboljava.business.bo.payer.CardPayer;
import com.taller.coboljava.business.bo.payment.CardPayment;
import com.taller.coboljava.business.bo.payment.Payment;

import java.math.BigDecimal;
import java.util.Scanner;

public class CreateCardPayment implements CreatePayment<CardPayment> {
    @Override
    public CardPayment create(Scanner in) {
        System.out.println("Ingrese su nombre");
        String name = in.nextLine();
        System.out.println("Ingrese el numero de su tarjeta");
        String card = in.nextLine();
        System.out.println("Ingrese el monto");
        BigDecimal amount = new BigDecimal(in.nextLine());

        CardPayer payerData = new CardPayer(name, card);
        return new CardPayment(payerData, amount);
    }
}
