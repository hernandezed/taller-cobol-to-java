package com.taller.coboljava.business.bo.executor;

import com.taller.coboljava.business.bo.payment.Payment;

public interface PaymentExecutor<T extends Payment> {
    /*
         Imprimir un string con el nombre del tipo de pago
            CardPayment -> card payment
            TransferPayment -> transfer payment
            CryptoPayment -> crypto payment
         System.out.println(p);
         Thread.sleep(p.executionTime());


         Reemplazar
                if (p != null) {
                System.out.println(p);
                Thread.sleep(p.executionTime());
            }

            en Application.java por la llamada al executor

         Restricciones
         1- No pueden tocar el payment
         2- no pueden usar un if para decidir el nombre del payment -> deberian de tener un executor por cada tipo de payment

         Recomendaciones
         1- Utilizar un factory
         2- No modificar esta interfaz
         3- Pueden crear n implementaciones de executors
     */
    void execute(T payment);
}
