package com.example.restcountriesfx.Services;

import com.example.restcountriesfx.Models.CountryDTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class RestCountriesService implements IRestCountries{
    @Override
    public String[] getRegions() {
        String url ="https://restcountries.com/v3.1/All";
        return new String[0];
    }

    @Override
    public List<CountryDTO> getCountriesByRegion(String region) {
        return null;
    }

    @Override
    public CountryDTO getCountryByName(String name) {
        return null;
    }

    private String getDataUrl(String url) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();

    }
}
