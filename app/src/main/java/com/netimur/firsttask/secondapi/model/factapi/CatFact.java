package com.netimur.firsttask.secondapi.model.factapi;

public class CatFact {
    private final String fact;
    private final int length;

    public CatFact(String fact, int length) {
        this.fact = fact;
        this.length = length;
    }

    public String getFact() {
        return fact;
    }

    public int getLength() {
        return length;
    }
}
