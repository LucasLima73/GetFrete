package br.com.getfrete.getfrete.Controller;

import br.com.getfrete.getfrete.Model.LoginModel;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController {
    @FXML
    private Label txtName;
    LoginModel data = LoginModel.getInstance();
    public void initialize() {
        txtName.setText(data.getUserName().toLowerCase());
    }
    @FXML
    private JFXButton btnBudget;

    @FXML
    private JFXButton btnMyJobs;

    @FXML
    private JFXButton btnMyTrucks;

    @FXML
    private JFXButton btnProfile;

    @FXML
    private BorderPane borderpane;


    @FXML
    private Button btnApagar;


    @FXML
    void Apagar(ActionEvent event) {

    }
    @FXML
    void btnBudget(ActionEvent event) throws IOException {
        AnchorPane view = (AnchorPane)FXMLLoader.load(getClass().getResource("/br/com/getfrete/getfrete/myBudget.fxml"));
        borderpane.setCenter(view);
    }
    public void displayName(String user){
        txtName.setText(user);
    }

    @FXML
    void btnMyJobs(ActionEvent event) {

    }

    @FXML
    void btnMyTrucks(ActionEvent event) {

    }

    @FXML
    void btnProfile(ActionEvent event) throws IOException {
        AnchorPane view = (AnchorPane)FXMLLoader.load(getClass().getResource("/br/com/getfrete/getfrete/profile.fxml"));
        borderpane.setCenter(view);
    }

}


