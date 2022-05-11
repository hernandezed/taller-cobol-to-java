package com.taller.coboljava.business.bo.factory_method;

import com.taller.coboljava.business.bo.payment.Payment;

import java.util.Scanner;

public interface CreatePayment {

    Payment create(Scanner in);
}
