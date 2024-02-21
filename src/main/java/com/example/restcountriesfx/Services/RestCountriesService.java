package com.example.restcountriesfx.Services;

import com.example.restcountriesfx.Models.CountryDTO;
import com.example.restcountriesfx.Models.CountryDao;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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
        String url = "https://restcountries.com/v3.1/region/"+region;
        List<CountryDTO> countryDTOList = new ArrayList<>();
        try {
            String datos = getDataUrl(url);
            Gson gson = new Gson();
            List<CountryDao> objects = gson.fromJson(datos,new TypeToken<List<CountryDao>>(){}.getType());

            for(CountryDao countryDao:objects){
                countryDTOList.add(CountryDTO.from(countryDao));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return countryDTOList;
    }

    @Override
    public CountryDTO getCountryByName(String name) {
        String nameFormated = name.split(" ")[0];
        String url = "https://restcountries.com/v3.1/name/" +name;
        CountryDTO countryDTO= null;
        try {
            String datos = getDataUrl(url);
            Gson gson = new Gson();
            CountryDao[] countryDao = gson.fromJson(datos, CountryDao[].class);
            countryDTO= CountryDTO.from(countryDao[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return countryDTO;
    }

    @Override
    public CountryDTO getCountrybyCca3(String cca3) {
        String url = "https://restcountries.com/v3.1/alpha/" +cca3;
        CountryDTO countryDTO= null;
        try {
            String datos = getDataUrl(url);
            Gson gson = new Gson();
            CountryDao[] countryDao = gson.fromJson(datos, CountryDao[].class);
            countryDTO= CountryDTO.from(countryDao[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return countryDTO;
    }

    private String getDataUrl(String url) throws IOException {
        HttpClient httpClient= HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response= httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    }

