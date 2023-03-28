package br.com.getfrete.getfrete.Controller;

import br.com.getfrete.getfrete.Dao.Conexao;
import br.com.getfrete.getfrete.Model.LoginModel;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    private Label txtName;
    LoginModel data = LoginModel.getInstance();

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
    private Label tvNomeUser;

    @FXML
    private ImageView imgEdit;
    @FXML
    private Button btnExcluirConta;

    @FXML
    private Button btnSalvarEdit;

    @FXML
    private TextField txtCnhEdit;

    @FXML
    private TextField txtCpf;

    @FXML
    private TextField txtDataEdit;

    @FXML
    private TextField txtEmailEdit;

    @FXML
    private TextField txtNomeEdit;

    @FXML
    private PasswordField txtSenhaEdit;

    @FXML
    private TextField txtTelefoneEdit;
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
    void btnMyJobs(ActionEvent event) throws IOException {
        AnchorPane view = (AnchorPane)FXMLLoader.load(getClass().getResource("/br/com/getfrete/getfrete/myJobs.fxml"));
        borderpane.setCenter(view);
    }

    @FXML
    void btnMyTrucks(ActionEvent event) throws IOException {
        AnchorPane view = (AnchorPane)FXMLLoader.load(getClass().getResource("/br/com/getfrete/getfrete/myTrucks.fxml"));
        borderpane.setCenter(view);
    }

    @FXML
    void btnProfile(ActionEvent event) throws IOException {
        AnchorPane view = (AnchorPane)FXMLLoader.load(getClass().getResource("/br/com/getfrete/getfrete/profile.fxml"));
        borderpane.setCenter(view);
    }
    @FXML
    void btnEdit(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/br/com/getfrete/getfrete/profileEdit.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Edite seu perfil");
        primaryStage.setScene(scene);
        primaryStage.initModality(Modality.WINDOW_MODAL);
        primaryStage.showAndWait();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Label tvNomeUser = new Label();
        String user = data.getUserName();
        Conexao connection = new Conexao();
        try {
            PreparedStatement stmt = connection.getConnection().prepareStatement("SELECT * FROM caminhoneiro where cpf = ?");
            stmt.setInt(1, Integer.parseInt(user));
            ResultSet rs = stmt.executeQuery();

            String nome = null;

            if(rs.next()){
                nome = rs.getString("nome");

                tvNomeUser.setText(nome);

            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    @FXML
    void ExcluirConta(ActionEvent event) {

    }

    @FXML
    void SalvarEdit(ActionEvent event) {

    }


}


