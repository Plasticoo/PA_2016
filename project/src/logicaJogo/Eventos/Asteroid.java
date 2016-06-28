package logicaJogo.Eventos;

import logicaJogo.Dados.DadosJogo;

public class Asteroid extends Evento {

    public Asteroid() {
        super("Asteroide", 0);
    }

    @Override
    public void execute() {

    }

    public void execute(DadosJogo dadosJogo)
    {
        dadosJogo.setPontosRiqueza(dadosJogo.getPontosRiqueza() + 1);
    }
}
