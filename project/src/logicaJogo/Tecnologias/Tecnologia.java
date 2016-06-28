package logicaJogo.Tecnologias;

import java.io.Serializable;

public abstract class Tecnologia implements Serializable {

    private String nome;
    private int preco;
    private boolean descoberta;
    private int geracao;

    public Tecnologia(String nome, int preco, int geracao) {
        this.nome = nome;
        this.preco = preco;
        this.descoberta = false;
        this.geracao = geracao;
    }

    public boolean isDescoberta() {
        return descoberta;
    }

    public void setDescoberta(boolean descoberta) {
        this.descoberta = descoberta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public int getGeracao() {
        return geracao;
    }

    public void setGeracao(int geracao) {
        this.geracao = geracao;
    }
}
