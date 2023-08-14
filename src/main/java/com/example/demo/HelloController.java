package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    private char nowSymbol = 'X';
    private final char[][] gameField = new char[3][3];
    private boolean inGame = true;

    @FXML
    void btnOnclick(ActionEvent event) {
        if (inGame){
            Button btn = (Button)event.getSource();
            int rowIndex = GridPane.getRowIndex(btn) == null ? 0 : GridPane.getRowIndex(btn);
            int columnIndex = GridPane.getColumnIndex(btn) == null ? 0 : GridPane.getColumnIndex(btn);

            if (gameField[rowIndex][columnIndex] == 0){
                gameField[rowIndex][columnIndex] = nowSymbol;
                btn.setText(String.valueOf(nowSymbol));
                if ((gameField[0][0] == gameField[0][1] && gameField[0][1] == gameField[0][2] && gameField[0][0] != 0)
                || (gameField[1][0] == gameField[1][1] && gameField[1][1] == gameField[1][2] && gameField[1][0] != 0)
                || (gameField[0][1] == gameField[1][1] && gameField[1][1] == gameField[2][1] && gameField[0][1] != 0)
                || (gameField[2][0] == gameField[2][1] && gameField[2][1] == gameField[2][2] && gameField[2][0] != 0)
                || (gameField[0][0] == gameField[1][0] && gameField[1][0] == gameField[2][0] && gameField[0][0] != 0)
                || (gameField[0][2] == gameField[1][2] && gameField[1][2] == gameField[2][2] && gameField[0][2] != 0)
                || (gameField[0][0] == gameField[1][1] && gameField[1][1] == gameField[2][2] && gameField[0][0] != 0)
                || (gameField[2][0] == gameField[1][1] && gameField[1][1] == gameField[0][2] && gameField[2][0] != 0))
                    congratulation();
                nowSymbol = nowSymbol == 'X' ? 'O' : 'X';
            }
        }
    }

    private void congratulation() {
        inGame = false;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, nowSymbol + " - won!", ButtonType.CLOSE);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.CLOSE) System.exit(0);
    }


    @FXML
    void initialize() {
    }

}
