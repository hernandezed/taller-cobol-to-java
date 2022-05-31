package com.taller.coboljava.business.bo.factory_method;

import com.taller.coboljava.business.bo.beneficiary.TransferBeneficiary;
import com.taller.coboljava.business.bo.payer.TransferPayer;
import com.taller.coboljava.business.bo.payment.Payment;
import com.taller.coboljava.business.bo.payment.TransferPayment;

import java.math.BigDecimal;
import java.util.Scanner;

public class CreateTransferPayment implements CreatePayment<TransferPayment> {
    @Override
    public TransferPayment create(Scanner in) {
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
        return new TransferPayment(payerData, amount, beneficiaryData);
    }
}
