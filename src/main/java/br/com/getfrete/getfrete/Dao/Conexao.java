package br.com.getfrete.getfrete.Dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Conexao conexao;
    public static Conexao main(String[] args){
        Connection connection = null;

        try {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            connection = DriverManager.getConnection("jdbc:postgresql://motty.db.elephantsql.com:5432/brzogcrh","brzogcrh","zE_Yo7fM1YuGmm8jBPerSPZQ6q55H4OF");

            if(connection != null){
                System.out.println("Okkkkkkkk");
            } else {
                System.out.println("Notttttttttt");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }


    public static Conexao getInstance() {
        if(conexao == null){
            conexao = new Conexao();
        }
        return conexao;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://motty.db.elephantsql.com:5432/brzogcrh","brzogcrh","zE_Yo7fM1YuGmm8jBPerSPZQ6q55H4OF");
        return connection;
    }
}
