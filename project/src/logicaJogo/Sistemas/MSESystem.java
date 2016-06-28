package logicaJogo.Sistemas;

import java.io.Serializable;

public abstract class MSESystem implements Serializable {

    private int id;
    private int resistance;
    private int riqueza;
    private int metal;
    private int victoryPoint;
    private String nomeSistema;
    private boolean conquistado;
    private boolean explorado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isExplorado() {
        return explorado;
    }

    public void setExplorado(boolean explorado) {
        this.explorado = explorado;
    }

    public String getNomeSistema() {
        return nomeSistema;
    }

    public void setNomeSistema(String nomeSistema) {
        this.nomeSistema = nomeSistema;
    }

    public int getVictoryPoint() {
        return victoryPoint;
    }

    public void setVictoryPoint(int victoryPoint) {
        this.victoryPoint = victoryPoint;
    }

    public boolean isConquistado() {
        return conquistado;
    }

    public void setConquistado(boolean conquistado) {
        this.conquistado = conquistado;
    }

    public int getMetal() {
        return metal;
    }

    public void setMetal(int metal) {
        this.metal = metal;
    }

    public int getRiqueza() {
        return riqueza;
    }

    public void setRiqueza(int riqueza) {
        this.riqueza = riqueza;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public MSESystem(boolean conquistado, int metal, int riqueza, int resistance, int victoryPoint, String nomeSistema) {
        this.conquistado = conquistado;
        this.metal = metal;
        this.riqueza = riqueza;
        this.resistance = resistance;
        this.victoryPoint = victoryPoint;
        this.nomeSistema = nomeSistema;
        this.explorado = false;
        this.id = 0;
    }
}
