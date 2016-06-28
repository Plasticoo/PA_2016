package logicaJogo.Eventos;

import logicaJogo.Dados.DadosJogo;

public class Strike extends Evento {

    public Strike() {
        super("Greve", 0);
    }

    @Override
    public void execute() {

    }

    public void execute(DadosJogo dadosJogo)
    {
        dadosJogo.setGreve(true);
    }
}
