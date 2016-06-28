package logicaJogo.States;

import logicaJogo.Dados.DadosJogo;
import logicaJogo.Utils;

public class PreparacaoJogo extends StateAdapter {
    public PreparacaoJogo(DadosJogo dadosJogo) {
        super(dadosJogo);
    }

    @Override
    public IStates PreparacaoJogo() {
        this.getDadosJogo().iniciar();

        return new ExplorarAtacarConquistarPassar(this.getDadosJogo());
    }

    @Override
    public IStates CarregarJogo(DadosJogo dados)
    {
        this.setDadosJogo(dados);

        return new ExplorarAtacarConquistarPassar(this.getDadosJogo());
    }
}
