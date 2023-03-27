package br.com.getfrete.getfrete.Model;

public class CaminhoneiroModel {

    private Integer CPF;
    private String Nome;
    private String DataDeNascimento;
    
    private Integer CarteiraDeMotorista;

    private String Email;
    private Integer Telefone;
    private String Senha;
    private Boolean PossuiCaminhao;


    public CaminhoneiroModel(Integer cpf, String nome, String datadenascimento,
                             int carteirademotorista, String email, int telefone, String senha, boolean possuicaminhao) {
        CPF = cpf;
        Nome = nome;
        DataDeNascimento = datadenascimento;
        CarteiraDeMotorista = carteirademotorista;
        Telefone = telefone;
        Senha = senha;
        PossuiCaminhao = possuicaminhao;
        Email = email;
    }
    public CaminhoneiroModel(){}

    public CaminhoneiroModel(String name) {
    }

    public CaminhoneiroModel(Integer cpf, String senha) {
        CPF = cpf;
        Senha = senha;
    }

    public Boolean getPossuiCaminhao() {
        return PossuiCaminhao;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Integer getCarteiraDeMotorista() {
        return CarteiraDeMotorista;
    }

    public Integer getCPF() {
        return CPF;
    }

    public Integer getTelefone() {
        return Telefone;
    }

    public String getDataDeNascimento() {
        return DataDeNascimento;
    }

    public String getNome() {
        return Nome;
    }

    public String getSenha() {
        return Senha;
    }

    public void setCarteiraDeMotorista(Integer carteiraDeMotorista) {
        CarteiraDeMotorista = carteiraDeMotorista;
    }

    public void setCPF(Integer CPF) {
        this.CPF = CPF;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        DataDeNascimento = dataDeNascimento;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public void setPossuiCaminhao(Boolean possuiCaminhao) {
        PossuiCaminhao = possuiCaminhao;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public void setTelefone(Integer telefone) {
        Telefone = telefone;
    }
}
