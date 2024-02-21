package com.example.restcountriesfx.Models;

public class CountryDTO {
    private String name;
    private String flag;
    private String region;
    private String capital;
    private String coin;
    private int population;

    private String cca3;

    public CountryDTO() {
    }

    public static CountryDTO from(CountryDao countryDao){
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setName(countryDao.name.common);
        countryDTO.setFlag(countryDao.flags.png);
        countryDTO.setPopulation(countryDao.population);
        String coin = "";
        if(countryDao.currencies!= null){
            String keyCurrency = (String) countryDao.currencies.keySet().toArray()[0];
            coin=(countryDao.currencies.get(keyCurrency).name);
        }
        countryDTO.setCoin(coin);
        String capital= "";
        if(countryDao.capital!= null)
            if(countryDao.capital.length >0)
            capital= countryDao.capital[0];
            countryDTO.setCapital(capital);
            countryDTO.setCca3(countryDao.cca3);
        return countryDTO;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCca3() {
        return cca3;
    }

    public void setCca3(String cca3) {
        this.cca3 = cca3;
    }
}
