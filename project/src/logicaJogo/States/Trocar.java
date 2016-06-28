package logicaJogo.States;

import logicaJogo.Dados.DadosJogo;

/**
 * Created by andre on 03-05-2016.
 */
public class Trocar extends StateAdapter {
    public Trocar(DadosJogo dadosJogo) {
        super(dadosJogo);
    }

    @Override
    public IStates Trocar(String name) {

        if(!name.equals("salta")) {
            if (this.getDadosJogo().existsTecnology("Interspecies Commerce")) {
                if (name.equals("metal") && this.getDadosJogo().getPontosMetal() >= 2) {
                    this.getDadosJogo().setPontosMetal(this.getDadosJogo().getPontosMetal() - 2);
                    this.getDadosJogo().setPontosRiqueza(this.getDadosJogo().getPontosRiqueza() + 1);
                } else if (name.equals("riqueza") && this.getDadosJogo().getPontosRiqueza() >= 2) {
                    this.getDadosJogo().setPontosMetal(this.getDadosJogo().getPontosMetal() + 1);
                    this.getDadosJogo().setPontosRiqueza(this.getDadosJogo().getPontosRiqueza() - 2);
                }
            }
        }
        // return forca militar
        return new MilitarTecnologia(this.getDadosJogo());
    }
}