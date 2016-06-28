package ui.grafico.Models;

import logicaJogo.Jogo;

public class MainModel {

    private Jogo jogo;
    private int indexTroca;
    private int indexTipoSistema;
    private int indexSistemaPorConquistar;
    private int indexTecnologiasPorComprar;


    public MainModel(Jogo jogo) {
        this.jogo = jogo;

        this.indexTroca = 0;
        this.indexTipoSistema = 0;
        this.indexSistemaPorConquistar = 0;
        this.indexTecnologiasPorComprar = 0;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public int getIndexTecnologiasPorComprar() {
        return indexTecnologiasPorComprar;
    }

    public void setIndexTecnologiasPorComprar(int indexTecnologiasPorComprar) {
        this.indexTecnologiasPorComprar = indexTecnologiasPorComprar;
    }

    public int getIndexTroca() {
        return indexTroca;
    }

    public void setIndexTroca(int indexTroca) {
        this.indexTroca = indexTroca;
    }

    public int getIndexTipoSistema() {
        return indexTipoSistema;
    }

    public void setIndexTipoSistema(int indexTipoSistema) {
        this.indexTipoSistema = indexTipoSistema;
    }

    public int getIndexSistemaPorConquistar() {
        return indexSistemaPorConquistar;
    }

    public void setIndexSistemaPorConquistar(int indexSistemaPorConquistar) {
        this.indexSistemaPorConquistar = indexSistemaPorConquistar;
    }
}
