package ui.grafico.Models;

import logicaJogo.Jogo;
import ui.grafico.Views.FinalView;

/**
 * Created by andre on 08-06-2016.
 */
public class FinalModel {

    private Jogo jogo;

    public FinalModel(Jogo jogo)
    {
        this.jogo = jogo;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }
}
