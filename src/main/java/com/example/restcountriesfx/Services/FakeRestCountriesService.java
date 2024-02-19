package com.example.restcountriesfx.Services;

import com.example.restcountriesfx.Models.CountryDTO;

import java.util.ArrayList;
import java.util.List;

public class FakeRestCountriesService implements  IRestCountries{
    @Override
    public String[] getRegions() {
       return new String[]{"Europe", "Asia", "America","Antartida", "Oceania", "Africa"};

    }

    @Override
    public List<CountryDTO> getCountriesByRegion(String region) {
        List<CountryDTO> countryDTOList = new ArrayList<>();
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setName("Spain");
        CountryDTO countryDTO1 = new CountryDTO();
        countryDTO1.setName("Portugal");
        countryDTOList.add(countryDTO);
        countryDTOList.add(countryDTO1);
        return countryDTOList;
    }

    @Override
    public CountryDTO getCountryByName(String name) {
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setName("Spain");
        countryDTO.setCapital("Madrid");
        countryDTO.setCoin("€");
        countryDTO.setRegion("Europe");
        countryDTO.setPopulation(48000000);
        countryDTO.setFlag("https://flagcdn.com/w320/es.png");
        return countryDTO;
    }
}
