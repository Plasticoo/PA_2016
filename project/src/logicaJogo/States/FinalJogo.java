package logicaJogo.States;

import logicaJogo.Dados.DadosJogo;
import logicaJogo.Sistemas.MSESystem;
import logicaJogo.Tecnologias.Tecnologia;

public class FinalJogo extends StateAdapter {

    public FinalJogo(DadosJogo dadosJogo) {
        super(dadosJogo);
    }

    @Override
    public IStates FimJogo() {
        for(MSESystem sistema : this.getDadosJogo().getListNearSys())
        {
            if(sistema.isConquistado())
            {
                this.getDadosJogo().setPontosVitoria(this.getDadosJogo().getPontosDado() + sistema.getVictoryPoint());
            }
        }

        for(MSESystem sistema : this.getDadosJogo().getListDistantSys())
        {
            if(sistema.isConquistado())
            {
                this.getDadosJogo().setPontosVitoria(this.getDadosJogo().getPontosDado() + sistema.getVictoryPoint());
            }
        }

        for(Tecnologia tecnologia : this.getDadosJogo().getListTecnologias())
        {
            if(tecnologia.isDescoberta())
            {
                this.getDadosJogo().setPontosVitoria(this.getDadosJogo().getPontosDado() + 1);
            }
        }

        if(this.getDadosJogo().isAllExplorados())
        {
            this.getDadosJogo().setPontosVitoria(this.getDadosJogo().getPontosDado() + 1);
        }

        if(this.getDadosJogo().isAllDescobertas())
        {
            this.getDadosJogo().setPontosVitoria(this.getDadosJogo().getPontosDado() + 1);
        }

        if(this.getDadosJogo().isAllConquistados())
        {
            this.getDadosJogo().setPontosVitoria(this.getDadosJogo().getPontosDado() + 3);
        }

        return this;
    }
}
