package com.example.restcountriesfx;

import com.example.restcountriesfx.Models.CountryDTO;
import com.example.restcountriesfx.Services.FakeRestCountriesService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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
        FakeRestCountriesService fakeRestCountriesService = new FakeRestCountriesService();
        comboRegions.getItems().addAll(fakeRestCountriesService.getRegions());
        comboRegions.setOnAction(e -> {
            if(comboRegions.getSelectionModel().getSelectedItem()!= null){
                String region = comboRegions.getSelectionModel().getSelectedItem().toString();
                observableList.clear();
                observableList.addAll(fakeRestCountriesService.getCountriesByRegion(region));
                tableCountry.setItems(observableList);
            }
        });
        countryNameColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getName()));

    }


    public void btnClear(ActionEvent actionEvent) {
        observableList.clear();
        comboRegions.getSelectionModel().clearSelection();

    }
}