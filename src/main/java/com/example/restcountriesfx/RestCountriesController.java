package com.example.restcountriesfx;

import com.example.restcountriesfx.Models.CountryDTO;
import com.example.restcountriesfx.Services.FakeRestCountriesService;
import com.example.restcountriesfx.Services.RestCountriesService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RestCountriesController {
    @FXML
    private ComboBox comboRegions;

    @FXML
    protected TableView<CountryDTO> tableCountry;

    @FXML
    protected TableColumn<CountryDTO, String> countryNameColumn;

    @FXML
    protected ImageView imgFlag;

    @FXML
    protected TextField txtCountryName;

    @FXML
    protected TextField txtCountryPopulation;

    @FXML
    protected TextField txtCountryCapital;

    @FXML
    protected TextField txtCountryCoin;

    private ObservableList<CountryDTO> observableList = FXCollections.observableArrayList();
    @FXML
    public void initialize() {
        RestCountriesService fakeRestCountriesService = new RestCountriesService();
        comboRegions.getItems().addAll(fakeRestCountriesService.getRegions());
        comboRegions.setOnAction(e -> {
            if(comboRegions.getSelectionModel().getSelectedItem()!= null){
                String region = comboRegions.getSelectionModel().getSelectedItem().toString();
                observableList.clear();
                observableList.addAll(fakeRestCountriesService.getCountriesByRegion(region));
                tableCountry.setItems(observableList);
            }
        });
        tableCountry.setOnMouseClicked(e->{
            String countryName = tableCountry.getSelectionModel().getSelectedItem().getName();
            CountryDTO countryDTO = fakeRestCountriesService.getCountryByName(countryName);
            txtCountryName.setText(countryDTO.getName());
            txtCountryCapital.setText(countryDTO.getCapital());
            txtCountryCoin.setText(countryDTO.getCoin());
            txtCountryPopulation.setText(String.valueOf(countryDTO.getPopulation()));
            Image image = new Image(countryDTO.getFlag());
            imgFlag.setImage(image);


        });
        countryNameColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getName()));

    }


    public void btnClear(ActionEvent actionEvent) {
        observableList.clear();
        comboRegions.getSelectionModel().clearSelection();
        txtCountryName.clear();
        txtCountryCapital.clear();
        txtCountryCoin.clear();
        txtCountryPopulation.clear();
        imgFlag.setImage(null);
    }
}