package logicaJogo.Eventos;

import logicaJogo.Dados.DadosJogo;

public class DerelictShip extends Evento {

    public DerelictShip() {
        super("Nave Abandonada", 0);
    }

    @Override
    public void execute() {

    }

    @Override
    public void execute(DadosJogo dadosJogo)
    {
        dadosJogo.setPontosMetal(dadosJogo.getPontosMetal() + 1);
    }
}