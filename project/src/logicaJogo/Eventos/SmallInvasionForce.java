package logicaJogo.Eventos;

import logicaJogo.Dados.DadosJogo;
import logicaJogo.Sistemas.MSESystem;
import logicaJogo.Utils;

public class SmallInvasionForce extends Evento  {

    public SmallInvasionForce() {
        super("Invasao Pequena", 0);
    }

    @Override
    public void execute() {

    }

    public void execute(DadosJogo dadosJogo)
    {
        int dado = Utils.lancaDado(1, 6);

        if (dadosJogo.getAno() == 1) this.setForca(1 + dado);
        else if (dadosJogo.getAno() == 2) this.setForca(2 + dado);

        String sistemaRecente = dadosJogo.getMaiorId();

        for(MSESystem sistema : dadosJogo.getListDistantSys())
        {
            if(sistemaRecente.equals(sistema.getNomeSistema()))
            {
                if(dadosJogo.existsTecnology("Planetary Defense"))
                {
                    if(sistema.getResistance() + 1 <= this.getForca())
                    {
                        sistema.setConquistado(false);
                        sistema.setId(0);
                    }
                }
            }
        }

        for(MSESystem sistema : dadosJogo.getListNearSys())
        {
            if(sistemaRecente.equals(sistema.getNomeSistema()))
            {
                if(dadosJogo.existsTecnology("Planetary Defense"))
                {
                    if(sistema.getResistance() + 1 <= this.getForca())
                    {
                        sistema.setConquistado(false);
                        sistema.setId(0);
                    }
                }
            }
        }
    }
}
