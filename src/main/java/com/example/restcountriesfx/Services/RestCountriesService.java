package com.example.restcountriesfx.Services;

import com.example.restcountriesfx.Models.CountryDTO;
import com.example.restcountriesfx.Models.CountryDao;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RestCountriesService implements IRestCountries{
    @Override
    public String[] getRegions() {
        List<String> regions= new ArrayList<>();
        String url ="https://restcountries.com/v3.1/all";
        try {
            String data = getDataUrl(url);
            Gson gson = new Gson();
            CountryDao[] objects = gson.fromJson(data,CountryDao[].class);
            for(CountryDao countryDao: objects){
                if(!regions.contains(countryDao.region)){
                    regions.add(countryDao.region);
                }

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] regionArray = new String[regions.size()];
        for(int i = 0; i< regions.size(); i++){
            regionArray[i]=regions.get(i);
        }
        return regionArray;
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
