package com.taller.coboljava;


import com.taller.coboljava.business.bo.PaymentType;
import com.taller.coboljava.business.bo.beneficiary.Beneficiary;
import com.taller.coboljava.business.bo.beneficiary.CryptoBeneficiary;
import com.taller.coboljava.business.bo.beneficiary.TransferBeneficiary;
import com.taller.coboljava.business.bo.payer.CardPayer;
import com.taller.coboljava.business.bo.payer.CryptoPayer;
import com.taller.coboljava.business.bo.payer.Payer;
import com.taller.coboljava.business.bo.payer.TransferPayer;
import com.taller.coboljava.business.bo.payment.CardPayment;
import com.taller.coboljava.business.bo.payment.CryptoPayment;
import com.taller.coboljava.business.bo.payment.Payment;
import com.taller.coboljava.business.bo.payment.TransferPayment;

import java.math.BigDecimal;
import java.util.Scanner;

public class Application {
    private static Scanner in = new Scanner(System.in);

    public static void main(String... args) throws InterruptedException {
        Integer option = 0;
        do {
            printPaymentTypes();

            String s = in.nextLine();
            option = Integer.parseInt(s);
            Payment p = null;
            switch (option) {
                case 1:
                    p = getTransfer();
                    break;
                case 2:
                    p = getCard();
                    break;
                case 3:
                    p = getCrypto();
                    break;
            }
            if (p != null) {
                System.out.println(p.toString());
                Thread.sleep(p.executionTime());
            }
        } while (option != 4);
    }

    private static Payment getCrypto() {
        System.out.println("Ingrese su nombre");
        String name = in.nextLine();
        System.out.println("Ingrese el id de su billetera");
        String walletId = in.nextLine();
        System.out.println("Ingrese el nombre del destinatario");
        String beneficiaryName = in.nextLine();
        System.out.println("Ingrese el id de la billetera de destino");
        String beneficiaryWalletId = in.nextLine();
        System.out.println("Ingrese el monto");
        BigDecimal amount = new BigDecimal(in.nextLine());

        CryptoPayer payerData = new CryptoPayer(name, walletId);
        CryptoBeneficiary beneficiaryData = new CryptoBeneficiary(beneficiaryName, beneficiaryWalletId);
        Payment payment = new CryptoPayment(payerData, amount, beneficiaryData);

        return payment;
    }

    private static Payment getCard() {
        System.out.println("Ingrese su nombre");
        String name = in.nextLine();
        System.out.println("Ingrese el numero de su tarjeta");
        String card = in.nextLine();
        System.out.println("Ingrese el monto");
        BigDecimal amount = new BigDecimal(in.nextLine());

        CardPayer payerData = new CardPayer(name, card);
        Payment payment = new CardPayment(payerData, amount);

        return payment;
    }

    private static Payment getTransfer() {
        System.out.println("Ingrese su nombre");
        String name = in.nextLine();
        System.out.println("Ingrese su cbu");
        String cbu = in.nextLine();
        System.out.println("Ingrese el nombre del beneficiario");
        String beneficiaryName = in.nextLine();
        System.out.println("Ingrese el cbu beneficiario");
        String beneficiaryCbu = in.nextLine();
        System.out.println("Ingrese el monto");
        BigDecimal amount = new BigDecimal(in.nextLine());
        TransferPayer payerData = new TransferPayer(name, cbu);
        TransferBeneficiary beneficiaryData = new TransferBeneficiary(beneficiaryName, beneficiaryCbu);
        Payment payment = new TransferPayment(payerData, amount, beneficiaryData);

        return payment;
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
