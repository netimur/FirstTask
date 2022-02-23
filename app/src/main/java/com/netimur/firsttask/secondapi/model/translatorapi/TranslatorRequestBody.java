package com.netimur.firsttask.secondapi.model.translatorapi;

public class TranslatorRequestBody {
    private final String q;
    private final String source = "en";
    private final String target = "ru";
    private final String format = "text";


    public TranslatorRequestBody(String textToTranslate) {
        this.q = textToTranslate;
    }

}
