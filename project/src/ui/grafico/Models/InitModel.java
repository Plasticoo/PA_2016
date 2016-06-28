package ui.grafico.Models;

import logicaJogo.Jogo;

public class InitModel
{
    private int option;
    private Jogo jogo;

    public InitModel(Jogo jogo){
        this.jogo = jogo;
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }
}