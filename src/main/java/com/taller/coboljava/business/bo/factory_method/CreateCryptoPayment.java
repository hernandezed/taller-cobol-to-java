package com.taller.coboljava.business.bo.factory_method;

import com.taller.coboljava.business.bo.beneficiary.CryptoBeneficiary;
import com.taller.coboljava.business.bo.payer.CryptoPayer;
import com.taller.coboljava.business.bo.payment.CryptoPayment;
import com.taller.coboljava.business.bo.payment.Payment;

import java.math.BigDecimal;
import java.util.Scanner;

public class CreateCryptoPayment implements CreatePayment {
    @Override
    public Payment create(Scanner in) {
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
}
