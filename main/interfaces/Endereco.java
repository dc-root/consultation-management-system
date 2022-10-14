package main.interfaces;

public class Endereco {
    private String logradouro;
    private int numero;
    private int complemento;
    private String bairro;
    private String municipio;
    private String cep;
    private int tipo;

    public Endereco(
        String logradouro,
        int numero,
        int complemento,
        String bairro,
        String municipio,
        String cep,
        int tipo
    ) {

        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.municipio = municipio;
        this.cep = cep;
        this.tipo = tipo;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public int getComplemento() {
        return complemento;
    }

    public void setComplemento(int complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
