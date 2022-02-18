package com.netimur.firsttask.secondapi.model.translatorapi;

public class TranslatorRequestBody {
    public String q;
    public String source = "en";
    public String target = "ru";
    public String format = "text";


    public TranslatorRequestBody(String textToTranslate) {
        this.q = textToTranslate;
    }
}
