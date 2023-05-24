package br.com.fs.dao;

import br.com.fs.to.CidadeTO;
import br.com.fs.to.FuncionarioTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

public class FuncionarioDAO {

    public void inserir(Object obj) throws Exception {
        Conexao c = new Conexao();
        try {
            FuncionarioTO to = (FuncionarioTO) obj;
            String sql = "INSERT INTO funcionario (nome, "
                    + "telefone, celular, email, rg,  cpf, sexo, logradouro, "
                    + "numero, idcidade, cep, data_nasc, "
                    + "data_admissao, login, senha, situacao, observacao, bairro) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + "?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setString(1, to.getNome());
            ps.setString(2, to.getTelefone());
            ps.setString(3, to.getCelular());
            ps.setString(4, to.getEmail());
            ps.setString(5, to.getRg());
            ps.setString(6, to.getCpf().replace(".", "").replace("-", ""));
            ps.setString(7, to.getSexo());
            ps.setString(8, to.getLogradouro());
            ps.setString(9, to.getNumero());
            ps.setInt(10, to.getCidade().getIdCidade());
            ps.setString(11, to.getCep().replace("-", ""));
            ps.setDate(12, new java.sql.Date(to.getDatanasc().getTime()));
            ps.setDate(13, new java.sql.Date(to.getDataadmissao().getTime()));
            ps.setString(14, to.getLogin());
            ps.setString(15, to.getSenha());
            ps.setString(16, to.getSituacao());
            ps.setString(17, to.getObservacao());
            ps.setString(18, to.getBairro());
            ps.execute();
            c.confirmar();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }

    public void alterar(Object obj) throws Exception {
        Conexao c = new Conexao();
        try {
            FuncionarioTO to = (FuncionarioTO) obj;
            String sql = "UPDATE funcionario SET nome = ?, telefone = ?, "
                    + "celular = ?, email = ?, rg = ?, cpf = ?, sexo = ?, logradouro = ?, "
                    + "numero = ?, idcidade = ?, cep = ?, data_nasc = ?, "
                    + "data_admissao = ?, data_demissao = ?, login = ?, "
                    + "senha = ?, situacao = ?, observacao = ?, bairro = ? WHERE id = ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setString(1, to.getNome());
            ps.setString(2, to.getTelefone());
            ps.setString(3, to.getCelular());
            ps.setString(4, to.getEmail());
            ps.setString(5, to.getRg());
            ps.setString(6, to.getCpf().replace(".", "").replace("-", ""));
            ps.setString(7, to.getSexo());
            ps.setString(8, to.getLogradouro());
            ps.setString(9, to.getNumero());
            ps.setInt(10, to.getCidade().getIdCidade());
            ps.setString(11, to.getCep().replace("-", ""));
            ps.setDate(12, new java.sql.Date(to.getDatanasc().getTime()));
            ps.setDate(13, new java.sql.Date(to.getDataadmissao().getTime()));
            if (to.getDatademissao() != null) {
                ps.setDate(14, new java.sql.Date(to.getDatademissao().getTime()));
                ps.setString(17, "I");
            } else {
                ps.setNull(14, Types.DATE);
                ps.setString(17, to.getSituacao());
            }
            ps.setString(15, to.getLogin());
            ps.setString(16, to.getSenha());
            ps.setString(18, to.getObservacao());
            ps.setString(19, to.getBairro());
            ps.setInt(20, to.getIdFuncionario());
            ps.execute();
            c.confirmar();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }

    public static boolean verificaExiste(String campo, String cpf, int id) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT null FROM funcionario WHERE " + campo + " = ? and id <> ? LIMIT 1";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setString(1, cpf);
            ps.setInt(2, id);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }

    public void excluir(Object obj) throws Exception {
        Conexao c = new Conexao();
        try {
            FuncionarioTO to = (FuncionarioTO) obj;
            String sql = "DELETE FROM funcionario WHERE id = ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, to.getIdFuncionario());
            ps.execute();
            c.confirmar();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }

    public boolean validarDeletePedido(int id) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT null FROM pedido WHERE idfuncionario = ? LIMIT 1";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }
    
    public boolean validarDeletePerca(int id) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT null FROM perca WHERE idfuncionario = ? LIMIT 1";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }

    public Object buscarId(int id) throws Exception {
        Conexao c = new Conexao();
        try {
            String sql = "SELECT f.id, f.nome, f.telefone, f.celular, f.email, "
                    + "f.rg, f.cpf, f.sexo, f.logradouro, f.numero, f.bairro, "
                    + "f.cep, f.data_nasc, f.data_admissao, f.data_demissao, "
                    + "f.login, f.senha, f.situacao, f.observacao, f.idcidade, "
                    + "c.nome as nomecidade, c.uf FROM funcionario f JOIN cidade c "
                    + "ON (f.idcidade = c.id) WHERE f.id = ?";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            FuncionarioTO to = new FuncionarioTO();
            if (rs.next()) {
                to.setIdFuncionario(rs.getInt("id"));
                to.setNome(rs.getString("nome"));
                to.setRg(rs.getString("rg"));
                to.setCpf(rs.getString("cpf"));
                to.setDatanasc(rs.getDate("data_nasc"));
                to.setSexo(rs.getString("sexo"));
                to.setLogradouro(rs.getString("logradouro"));
                to.setBairro(rs.getString("bairro"));
                to.setNumero(rs.getString("numero"));
                CidadeTO cidade = new CidadeTO();
                cidade.setIdCidade(rs.getInt("idcidade"));
                cidade.setNome(rs.getString("nomecidade"));
                cidade.setUf(rs.getString("uf"));
                to.setCidade(cidade);
                to.setTelefone(rs.getString("telefone"));
                to.setCelular(rs.getString("celular"));
                to.setEmail(rs.getString("email"));
                to.setCep(rs.getString("cep"));
                to.setDataadmissao(rs.getDate("data_admissao"));
                to.setDatademissao(rs.getDate("data_demissao"));
                to.setLogin(rs.getString("login"));
                to.setSenha(rs.getString("senha"));
                to.setSituacao(rs.getString("situacao"));
                to.setObservacao(rs.getString("observacao"));
            }
            return to;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }

    public ArrayList buscarTodos() throws Exception {
        Conexao c = new Conexao();
        try {
            FuncionarioTO to = new FuncionarioTO();
            String sql = "SELECT id, nome, data_admissao, case when situacao = 'A' then 'ATIVO'"
                    + " when situacao = 'I' then 'INATIVO' else null end as situacao"
                    + " FROM funcionario ORDER BY id DESC";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList dados = new ArrayList();
            while (rs.next()) {
                ArrayList linha = new ArrayList();
                linha.add(to.getIdFuncFormatado(rs.getInt("id")));
                linha.add(rs.getString("nome"));
                linha.add(to.getDataAd(rs.getDate("data_admissao")));
                linha.add(rs.getString("situacao"));
                dados.add(linha);
            }
            return dados;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }

    public ArrayList filtro(String query) throws Exception {
        Conexao c = new Conexao();
        try {
            FuncionarioTO to = new FuncionarioTO();
            String sql = "SELECT id, nome, data_admissao, case when situacao = 'A' then 'ATIVO'"
                    + " when situacao = 'I' then 'INATIVO' else null end as situacao"
                    + " FROM funcionario WHERE 1 = 1 " + query + " ORDER BY id DESC";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList dados = new ArrayList();
            while (rs.next()) {
                ArrayList linha = new ArrayList();
                linha.add(to.getIdFuncFormatado(rs.getInt("id")));
                linha.add(rs.getString("nome"));
                linha.add(to.getDataAd(rs.getDate("data_admissao")));
                linha.add(rs.getString("situacao"));
                dados.add(linha);
            }
            return dados;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            if (!c.getCon().isClosed()) {
                c.getCon().close();
            }
        }
    }
    
    public static ArrayList montaCombo() {
        try {
            ArrayList dados = new ArrayList();
            Conexao c = new Conexao();
            String sql = "select id, nome from funcionario where situacao = 'A' order by id";
            PreparedStatement ps = c.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList vazio = new ArrayList();
            vazio.add("0");
            vazio.add("Selecione um item");
            dados.add(vazio);
            while (rs.next()) {
                ArrayList linha = new ArrayList();
                linha.add(rs.getString("id"));
                linha.add(rs.getString("nome"));
                dados.add(linha);
            }
            c.getCon().close();
            return dados;
        } catch (Exception e) {
            return null;
        }
    }
}
