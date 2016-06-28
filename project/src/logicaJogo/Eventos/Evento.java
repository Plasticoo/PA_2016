package logicaJogo.Eventos;

import logicaJogo.Dados.DadosJogo;

import java.io.Serializable;

public abstract class Evento implements Serializable {
    private String nome;
    private int forca;
    private boolean ocorreu;

    public Evento(String nome, int forca) {
        this.nome = nome;
        this.forca = forca;
        this.ocorreu = false;
    }


    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isOcorreu() {
        return ocorreu;
    }

    public void setOcorreu(boolean ocorreu) {
        this.ocorreu = ocorreu;
    }

    public abstract void execute();

    public abstract void execute(DadosJogo dadosJogo);
}
