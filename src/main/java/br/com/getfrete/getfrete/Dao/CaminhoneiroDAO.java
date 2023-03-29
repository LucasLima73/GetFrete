package br.com.getfrete.getfrete.Dao;

import br.com.getfrete.getfrete.Model.CaminhoneiroModel;
import br.com.getfrete.getfrete.Model.LoginModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CaminhoneiroDAO implements GenericoDAO<CaminhoneiroModel>{
    LoginModel data = LoginModel.getInstance();
    @Override
    public List<CaminhoneiroModel> listar() {
        List<CaminhoneiroModel> caminhoneiros = new ArrayList<>();
        String sql = "SELECT * FROM Caminhoneiro";
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            ResultSet result = pStatement.executeQuery();
            while (result.next()) {
                caminhoneiros.add(new CaminhoneiroModel(result.getInt("CPF"), result.getString("Nome"), result.getString("DataDeNascimento"),
                        result.getInt("CarteiraDeMotorista"),
                        result.getString("Email"),result.getInt("Telefone"),
                        result.getString("Senha"),result.getBoolean("PossuiCaminhao")));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CaminhoneiroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CaminhoneiroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CaminhoneiroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return caminhoneiros;
    }

    @Override
    public void inserir(CaminhoneiroModel caminhoneiro) {
        String sql = "INSERT INTO caminhoneiro (cpf, nome, datadenascimento, carteirademotorista, email, telefone, senha, possuicaminhao) VALUES (?,?,?,?,?,?,?,?)";
        Connection connection = null;

        try{
            connection = Conexao.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, (caminhoneiro.getCPF()));
            statement.setString(2,caminhoneiro.getNome());
            statement.setString(3,caminhoneiro.getDataDeNascimento());
            statement.setInt(4, caminhoneiro.getCarteiraDeMotorista());
            statement.setString(5,caminhoneiro.getEmail());
            statement.setInt(6, caminhoneiro.getTelefone());
            statement.setString(7,caminhoneiro.getSenha());
            statement.setBoolean(8,caminhoneiro.getPossuiCaminhao());
            statement.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CaminhoneiroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CaminhoneiroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CaminhoneiroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @Override
    public void alterar(CaminhoneiroModel caminhoneiroModel) {
        String sql = "UPDATE caminhoneiro SET senha = ? WHERE cpf = ?";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, caminhoneiroModel.getSenha());
            pStatement.setInt(2, caminhoneiroModel.getCPF());
            pStatement.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CaminhoneiroDAO.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(CaminhoneiroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CaminhoneiroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void remover(CaminhoneiroModel caminhoneiroModel) {
        String sql = "DELETE FROM caminhoneiro WHERE cpf = ?";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, Integer.valueOf(data.getUserName()));
            pStatement.execute();
            connection.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CaminhoneiroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CaminhoneiroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(connection != null){

                connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CaminhoneiroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public CaminhoneiroModel listarPorID(CaminhoneiroModel caminhoneiroModel)  {
        String sql = "SELECT * FROM caminhoneiro WHERE cpf = ?";
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, caminhoneiroModel.getCPF());
            ResultSet result = pStatement.executeQuery();
            if (result.next()) {
                caminhoneiroModel.setCPF(result.getInt("cpf"));
                caminhoneiroModel.setNome(result.getString("nome"));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CaminhoneiroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CaminhoneiroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CaminhoneiroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return caminhoneiroModel;
    }

}
