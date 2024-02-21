package com.example.restcountriesfx.Services;

import com.example.restcountriesfx.Models.CountryDTO;

import java.util.List;

public interface IRestCountries {
    public String[] getRegions();
    public List<CountryDTO> getCountriesByRegion(String region);
    public CountryDTO getCountryByName(String name);

    public CountryDTO getCountrybyCca3(String cca3);
}
