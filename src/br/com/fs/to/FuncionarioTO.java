package br.com.fs.to;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.text.MaskFormatter;

public class FuncionarioTO {

    private int idFuncionario;
    private String nome;
    private String telefone;
    private String celular;
    private String email;
    private String sexo;
    private String rg;
    private String cpf;
    private String logradouro;
    private String numero;
    private String bairro;
    private CidadeTO cidade;
    private String cep;
    private Date datanasc;
    private Date dataadmissao;
    private Date datademissao;
    private String login;
    private String senha;
    private String situacao;
    private String observacao;
    private String query = "";

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        this.nome = nome.trim().toUpperCase();
    }

    public String getTelefone() {
        return telefone;
    }
    
    public String getTelefoneFormatado() throws ParseException {
        MaskFormatter mf = new MaskFormatter("(##) ####-####");
        mf.setValueContainsLiteralCharacters(false);
        return mf.valueToString(String.format("%010d", Long.valueOf(telefone)));
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setTelefone(String newTelefone) throws Exception {
        this.telefone = newTelefone.trim();
    }

    public String getCelular() {
        return celular;
    }
    
    public String getCelularFormatado() throws ParseException {
        MaskFormatter mf = new MaskFormatter("(##) ####-####");
        mf.setValueContainsLiteralCharacters(false);
        return mf.valueToString(String.format("%010d", Long.valueOf(celular)));
    }

    public void setCelular(String newCelular) throws Exception {
        this.celular = newCelular.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String newEmail) throws Exception {
        this.email = newEmail.trim().toUpperCase();
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg.trim().toUpperCase();
    }

    public Date getDatademissao() {
        return datademissao;
    }

    public void setDatademissao(Date datademissao) {
        this.datademissao = datademissao;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login.trim().toUpperCase();
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha.trim().toUpperCase();
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao.trim().toUpperCase();
    }

    public String getCpf() {
        return cpf;
    }
    
    public String getCpfFormatado() throws ParseException {
        MaskFormatter mf = new MaskFormatter("###.###.###-##");
        mf.setValueContainsLiteralCharacters(false);
        return mf.valueToString(String.format("%011d", Long.valueOf(cpf)));
    }

    public void setCpf(String newCpf) throws Exception {
        this.cpf = newCpf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String newLogradouro) throws Exception {
        this.logradouro = newLogradouro.trim().toUpperCase();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String newNumero) throws Exception {
        this.numero = newNumero.trim().toUpperCase();
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro.trim().toUpperCase();
    }

    public CidadeTO getCidade() {
        return cidade;
    }

    public void setCidade(CidadeTO cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String newCep) throws Exception {
        this.cep = newCep.trim();
    }

    public Date getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(Date datanasc) {
        this.datanasc = datanasc;
    }

    public Date getDataadmissao() {
        return dataadmissao;
    }

    public void setDataadmissao(Date dataadmissao) {
        this.dataadmissao = dataadmissao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao.trim().toUpperCase();
    }

    public void setIdFuncionario(String id) throws Exception {
        try {
            setIdFuncionario(Integer.parseInt(id));
        } catch (NumberFormatException e) {
            throw new Exception("Código do funcionário inválido!" + e.getMessage());
        }
    }

    public String getIdFuncFormatado(int id) {
        String formatado = String.format("%03d", (id));
        return (formatado);
    }

    public String getDataAd(Date data) throws Exception {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").format(data);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String value, String lista) {
        if (value.trim().length() > 0) {
            query = query + " " + lista;
        }
        this.query = query;
    }
}
