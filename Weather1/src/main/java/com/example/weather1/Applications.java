package com.example.weather1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Applications extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Applications.class.getResource("Weather.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 307, 433);
        stage.setTitle("Погодник");
        stage.getIcons().add(new Image("C:\\Users\\denma\\OneDrive\\Изображения\\512x512bb.jpg"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}