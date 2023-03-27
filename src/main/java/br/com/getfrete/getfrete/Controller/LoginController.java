package br.com.getfrete.getfrete.Controller;

import br.com.getfrete.getfrete.Dao.CaminhoneiroDAO;
import br.com.getfrete.getfrete.Dao.Conexao;
import br.com.getfrete.getfrete.HelloApplication;
import br.com.getfrete.getfrete.Model.CaminhoneiroModel;
import br.com.getfrete.getfrete.Model.LoginModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class LoginController {
    @FXML
    private Button btnSalvar;

    @FXML
    private TextField tvCpf;

    @FXML
    private TextField tvSenha;

    @FXML
    private PasswordField tvPassword;

    @FXML
    private TextField tvUser;

    @FXML
    void Recovery() {
            String tex = tvCpf.getText();
            if (tex.matches("\\d+")) {
                tvCpf.setStyle(null);
            } else {
                tvCpf.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
                new animatefx.animation.Shake(tvCpf).play();
            }
        if (tvSenha.getText().length() == 0) {
            tvSenha.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            new animatefx.animation.Shake(tvSenha).play();
        } else {
            tvSenha.setStyle(null);
        }
        btnSalvar.setOnAction(event -> {
            CaminhoneiroDAO dao = new CaminhoneiroDAO();
            try {
                dao.alterar(new CaminhoneiroModel(Integer.valueOf(tvCpf.getText()), String.valueOf(tvSenha.getText())));
                showConfirmation();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    void showConfirmation() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Senha atualizada com sucesso");
        alert.setContentText("Faça o Login novamente");
        alert.showAndWait();

        tvSenha.clear();
        tvCpf.clear();
    }

    @FXML
    private void switchToRegister() throws IOException {
        HelloApplication.setRoot("register");
    }
    @FXML
    private void switchToLogin() throws IOException {
        HelloApplication.setRoot("loginView");
    }
    @FXML
    private void switchToRecovery() throws IOException {
        HelloApplication.setRoot("recovery");
    }
    @FXML
    private void switchToDash() throws IOException {
        HelloApplication.setRoot("dashboard");
    }

    @FXML
    void Login(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        Params();

        String user = tvUser.getText();
        String password = tvPassword.getText();

        if(user.equals("") && password.equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Não pode ter espaços em branco");
            alert.setContentText("Tente novamente");
            alert.showAndWait();
        } else {


            try{
                Conexao connection = new Conexao();
                Connection connectionDB = connection.getConnection();

                String connectionQuery = "SELECT * FROM caminhoneiro where cpf = ? and senha = ?";
                PreparedStatement pst = connectionDB.prepareStatement(connectionQuery);
                pst.setInt(1,Integer.valueOf(user));
                pst.setString(2,password);

                 ResultSet resultSet = pst.executeQuery();

                 if(resultSet.next()){
                     switchToDash();
                 }

                } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }




    }
    public void Params() throws IOException {
        Stage stage;

        LoginModel data = LoginModel.getInstance();
        data.setUserName(tvUser.getText());
    }
   /* public void initialize() throws SQLException, ClassNotFoundException {
        Conexao connection = new Conexao();
        Connection connectionDB = connection.getConnection();

        String connectionQuery = "SELECT * FROM caminhoneiro";

        try{
            Statement statment = connectionDB.createStatement();
            ResultSet queryOutput = statment.executeQuery(connectionQuery);
            while(queryOutput.next()){
                String name = queryOutput.getString("Nome");
                String CPF = String.valueOf(queryOutput.getInt("CPF"));
                accountListView.setText(queryOutput.getString("Nome"));

            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }*/
}