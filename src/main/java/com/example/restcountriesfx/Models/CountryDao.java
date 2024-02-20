package com.example.restcountriesfx.Models;

public class CountryDao {
    public Name name;
    public String[] capital;
    public String[] region;
    public int population;
    public Flag flags;
    public Currencies currencies;
}

class Name {
    public String common;
}

class Flag {
    public String png;
}

class Currency {
    public String symbol;
}

class Currencies {
    public String currencyCode;
    public Currency currency;
}
