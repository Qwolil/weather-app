/**
 * Sample Skeleton for 'hello-view.fxml' Controller Class
 */

package com.example.weather1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.InputStream;

import javafx.scene.text.Text;
import org.json.*;

public class Controller {



    @FXML
    private TextField city;
    @FXML
    private Text feels;
    @FXML
    private Text feels_info;
    @FXML
    private Button getData;
    @FXML
    private Text max;
    @FXML
    private Text max_info;
    @FXML
    private Text min;
    @FXML
    private Text min_info;

    @FXML
    private Text pres;

    @FXML
    private Text pres_info;

    @FXML
    private Text temp;

    @FXML
    private Text temp_info;

        @FXML
        void initialize() {
            assert city != null : "fx:id=\"city\" was not injected: check your FXML file 'Weather.fxml'.";
            assert feels != null : "fx:id=\"feels\" was not injected: check your FXML file 'Weather.fxml'.";
            assert feels_info != null : "fx:id=\"feels_info\" was not injected: check your FXML file 'Weather.fxml'.";
            assert getData != null : "fx:id=\"getData\" was not injected: check your FXML file 'Weather.fxml'.";
            assert max != null : "fx:id=\"max\" was not injected: check your FXML file 'Weather.fxml'.";
            assert max_info != null : "fx:id=\"max_info\" was not injected: check your FXML file 'Weather.fxml'.";
            assert min != null : "fx:id=\"min\" was not injected: check your FXML file 'Weather.fxml'.";
            assert min_info != null : "fx:id=\"min_info\" was not injected: check your FXML file 'Weather.fxml'.";
            assert pres != null : "fx:id=\"pres\" was not injected: check your FXML file 'Weather.fxml'.";
            assert pres_info != null : "fx:id=\"pres_info\" was not injected: check your FXML file 'Weather.fxml'.";
            assert temp != null : "fx:id=\"temp\" was not injected: check your FXML file 'Weather.fxml'.";
            assert temp_info != null : "fx:id=\"temp_info\" was not injected: check your FXML file 'Weather.fxml'.";
            getData.setOnAction(event -> {
                String getUserCity = city.getText().trim();
                String output = getUrlContent("https://api.openweathermap.org/data/2.5/weather?q=" + getUserCity + "&appid=9c31863f07de90a7dcb2752cb9ec907a&units=metric");
                //System.out.println(output);
                if (!output.isEmpty()){
                    JSONObject jObj = new JSONObject(output);
                    temp_info.setText(""+jObj.getJSONObject("main").getDouble("temp"));
                    feels_info.setText(""+jObj.getJSONObject("main").getDouble("feels_like"));
                    max_info.setText(""+jObj.getJSONObject("main").getDouble("temp_max"));
                    min_info.setText(""+jObj.getJSONObject("main").getDouble("temp_min"));
                    pres_info.setText(""+jObj.getJSONObject("main").getDouble("pressure"));
                }
          });

        }
private static String getUrlContent(String urlAdress){
                StringBuffer content = new StringBuffer();
    try {
        URL url = new URL(urlAdress);
        URLConnection urlConnection = url.openConnection();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String line;

        while((line = bufferedReader.readLine()) != null){
            content.append(line + "\n");
        }

    }catch (Exception e){
        System.out.println("This city was not found!");

    }
    return content.toString();
}

    }