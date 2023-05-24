package br.com.fs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {

    private Connection con;

    public Conexao() throws Exception {
        try {
            String driver, url, usuario, senha;

            driver = "com.mysql.cj.jdbc.Driver";
            url = "jdbc:mysql://localhost:3306/dbfastfood?useTimezone=true&serverTimezone=GMT-3";
            usuario = "root";
            senha = "root";

            Class.forName(driver);
            con = DriverManager.getConnection(url, usuario, senha);
            con.setAutoCommit(false);
        } catch (ClassNotFoundException cnf) {
            String msg = "O driver não foi encontrado!";
            throw new Exception(msg);
        } catch (SQLException se) {
            String msg = "Impossível abrir conexão com o banco!"
                    + "\n\nMensagem original: "
                    + se.getLocalizedMessage();
            throw new Exception(msg);
        }
    }

    public Connection getCon() {
        return con;
    }

    public void confirmar() throws Exception {
        try {
            con.commit();
        } catch (SQLException se) {
            con.rollback();
            String msg = "Não foi possível confirmar a transação";
            throw new Exception(msg);
        }
    }
}