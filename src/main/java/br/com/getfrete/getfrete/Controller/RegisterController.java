package br.com.getfrete.getfrete.Controller;

import br.com.getfrete.getfrete.Dao.CaminhoneiroDAO;
import br.com.getfrete.getfrete.Dao.Conexao;
import br.com.getfrete.getfrete.HelloApplication;
import br.com.getfrete.getfrete.Model.CaminhoneiroModel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class RegisterController {

    @FXML
    private void switchToDriver() throws IOException {
        HelloApplication.setRoot("driver");
    }

    @FXML
    private void switchToLogin() throws IOException {
        HelloApplication.setRoot("loginView");
    }


    @FXML
    private BorderPane root;

    @FXML
    private Button btnSalvarCadastro;

    @FXML
    private TextField txtCnh;

    @FXML
    private TextField txtCpf;

    @FXML
    private TextField txtData;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFoto;

    @FXML
    private TextField txtNome;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private TextField txtTelefone;
    @FXML
    private CheckBox cbPossui;


    @FXML
    private TextField txtPlaca;
    @FXML
    private TextField txtMarca;

    @FXML
    private TextField txtModelo;
    @FXML
    private TextField txtAno;

    @FXML
    private TextField txtCapacidade;
    @FXML
    private Label Tcapacidade;
    @FXML
    private Label tAno;

    @FXML
    private Label tMarca;

    @FXML
    private Label tModelo;

    @FXML
    private Label tPlaca;

    @FXML
    void Login() throws SQLException, ClassNotFoundException {
        verifyName();
        verifyAge();
        verifyAgeIsNumber();
        verifyEmail();
        verifyCNHIsANumber();
        verifyPhoneIsANumber();
        verifyCPFIsANumber();
        verifyPassword();
        verifyPhone();


        btnSalvarCadastro.setOnAction(event -> {
            CaminhoneiroDAO dao = new CaminhoneiroDAO();
            try {

                dao.inserir(new CaminhoneiroModel(Integer.valueOf(txtCpf.getText()), String.valueOf(txtNome.getText()), String.valueOf(txtData.getText()), Integer.valueOf(txtCnh.getText()), String.valueOf(txtEmail.getText()), Integer.valueOf(txtTelefone.getText()), String.valueOf(txtSenha.getText()), Boolean.valueOf(cbPossui.isSelected())));
                showConfirmation();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


    }

    void verifyName() {
        if (txtNome.getText().length() == 0) {
            txtNome.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            new animatefx.animation.Shake(txtNome).play();
        } else {
            txtNome.setStyle(null);
        }
    }

    void verifyAge() {
        if (txtData.getText().length() == 0) {
            txtData.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            new animatefx.animation.Shake(txtData).play();
        } else {
            txtData.setStyle(null);
        }
    }

    void verifyAgeIsNumber() {
        String tex = txtData.getText();
        if (tex.matches("\\d+")) {
            txtData.setStyle(null);
        } else {
            txtData.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            new animatefx.animation.Shake(txtData).play();
        }
    }

    void verifyPhoneIsANumber() {
        String tex = txtTelefone.getText();
        if (tex.matches("\\d+")) {
            txtTelefone.setStyle(null);
        } else {
            txtTelefone.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            new animatefx.animation.Shake(txtTelefone).play();
        }
    }

    void verifyCPFIsANumber() {
        String tex = txtCpf.getText();
        if (tex.matches("\\d+")) {
            txtCpf.setStyle(null);
        } else {
            txtCpf.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            new animatefx.animation.Shake(txtCpf).play();
        }
    }

    void verifyCNHIsANumber() {
        String tex = txtCnh.getText();
        if (tex.matches("\\d+")) {
            txtCnh.setStyle(null);
        } else {
            txtCnh.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            new animatefx.animation.Shake(txtCnh).play();
        }
    }

    void verifyEmail() {
        String regex = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        String text = txtEmail.getText();
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        if (matcher.matches()) {
            txtEmail.setStyle(null);
        } else {
            txtEmail.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            new animatefx.animation.Shake(txtEmail).play();
        }
    }

    void verifyPassword() {
        if (txtSenha.getText().length() == 0) {
            txtSenha.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            new animatefx.animation.Shake(txtSenha).play();
        } else {
            txtSenha.setStyle(null);
        }
    }

    void verifyPhoto() {
        if (txtFoto.getText().length() == 0) {
            txtFoto.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            new animatefx.animation.Shake(txtFoto).play();
        } else {
            txtFoto.setStyle(null);
        }
    }

    void verifyPhone() {
        if (txtTelefone.getText().length() == 0) {
            txtTelefone.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            new animatefx.animation.Shake(txtTelefone).play();
        } else {
            txtTelefone.setStyle(null);
        }
    }

    void showConfirmation() throws IOException {
        if (cbPossui.isSelected()) {
            Parent root = FXMLLoader.load(getClass().getResource("/br/com/getfrete/getfrete/dialog.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Cadastre seu caminhão");
            primaryStage.setScene(scene);
            primaryStage.initModality(Modality.WINDOW_MODAL);
            primaryStage.showAndWait();
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conta Criada com sucesso");
        alert.setContentText("Bem-vindo " + txtNome.getText());
        alert.showAndWait();

        txtNome.clear();
        txtSenha.clear();
        txtTelefone.clear();
        txtCnh.clear();
        txtEmail.clear();
        txtCpf.clear();
        txtData.clear();
        cbPossui.setSelected(false);


    }


}