package br.com.fs.dao;

import br.com.fs.to.FuncionarioTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginDAO {

    public static FuncionarioTO operador = new FuncionarioTO();

    public FuncionarioTO login(String usuario, String senha) throws Exception{
        Conexao c = new Conexao();
        try {
            String sql = "SELECT id, nome FROM funcionario WHERE "
                    + "login = '" + usuario + "' AND senha = '" + senha + "' AND situacao = 'A'";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                FuncionarioTO to = new FuncionarioTO();
                to.setIdFuncionario(rs.getInt("id"));
                to.setNome(rs.getString("nome"));
                operador = to;
            }
            return operador;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }

    public static boolean senhaSupervisor(String senha) throws Exception{
        Conexao c = new Conexao();
        try{
            String sql = "SELECT null FROM funcionario WHERE id = 1 AND senha = '"+senha+"'";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch(SQLException e){
            throw new Exception(e.getMessage());
        }finally{
            if(!c.getCon().isClosed()){
                c.getCon().close();
            }
        }
    }
    
    public static ArrayList recuperaSenha(String cpf) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT login, senha FROM funcionario WHERE cpf = '" + 
                    cpf.replace(".", "").
                            replace("-", "") + "' LIMIT 1";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList dados = new ArrayList();
            if (rs.next()) {
                dados.add(rs.getString("login"));
                dados.add(rs.getString("senha"));
            }
            return dados;
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }
}
