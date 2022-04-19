package com.taller.coboljava.business.bo.payer;

public class CardPayer extends Payer {
    private String number;

    public CardPayer(String name, String number) {
        super(name);
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "CardPayer{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
