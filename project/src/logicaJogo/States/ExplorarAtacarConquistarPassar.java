package logicaJogo.States;

import logicaJogo.Dados.DadosJogo;
import logicaJogo.Sistemas.DistantSystem;
import logicaJogo.Sistemas.MSESystem;

public class ExplorarAtacarConquistarPassar extends StateAdapter {

    public ExplorarAtacarConquistarPassar(DadosJogo dadosJogo) {
        super(dadosJogo);
    }

    public void recolher()
    {
        System.out.println("Dado = " + getDadosJogo().getPontosDado());

        getDadosJogo().setProducaoMetal(1 + getDadosJogo().getProducaoMetalTotal());
        getDadosJogo().setProducaoRiqueza(1 + getDadosJogo().getProducaoRiquezaTotal());

        if(!this.getDadosJogo().isGreve())
        {
            this.getDadosJogo().setPontosMetal(this.getDadosJogo().getProducaoMetalTotal() + this.getDadosJogo().getPontosMetal() + 1);
            this.getDadosJogo().setPontosRiqueza(this.getDadosJogo().getProducaoRiquezaTotal() + this.getDadosJogo().getPontosRiqueza() + 1);
        }
        else if(this.getDadosJogo().isGreve() && this.getDadosJogo().existsTecnology("Robot Workers"))
        {
            this.getDadosJogo().setPontosMetal((this.getDadosJogo().getProducaoMetalTotal() + 1 )/ 2 + this.getDadosJogo().getPontosMetal());
            this.getDadosJogo().setPontosRiqueza((this.getDadosJogo().getProducaoRiquezaTotal() + 1) / 2 + this.getDadosJogo().getPontosRiqueza());
        }
    }




    @Override
    public IStates ExplorarAtacar(int tipoSistema){
        int i = 0;

        getDadosJogo().setPontosDado();

        if(tipoSistema == 1)
        {
            i = getDadosJogo().getNumeroExploradosNearSystems();
        }
        else if(tipoSistema == 2)
        {
            i = getDadosJogo().getNumeroExploradosDistantSystems();
        }
        if(i != 7) {
            if (tipoSistema == 2) {
                if (this.getDadosJogo().existsTecnology("Forward Starbases") &&
                        this.getDadosJogo().nearAllConquistados() && !this.getDadosJogo().isAllDistantExp()) {
                    if (this.getDadosJogo().getListDistantSys().get(i).getResistance()
                            <= this.getDadosJogo().getPontosDado() + this.getDadosJogo().getPontosMilitar()) {
                        this.getDadosJogo().getListDistantSys().get(i).setConquistado(true);
                        this.getDadosJogo().getListDistantSys().get(i).setExplorado(true);

                        System.out.println(this.getDadosJogo().getListDistantSys().get(i).getNomeSistema());

                        this.getDadosJogo().getListDistantSys().get(i).setId(this.getDadosJogo().getIndiceConquista());
                        this.getDadosJogo().setIndiceConquista(this.getDadosJogo().getIndiceConquista() + 1);
                    } else {
                        this.getDadosJogo().getListDistantSys().get(i).setExplorado(true);
                        if (this.getDadosJogo().getPontosMilitar() != 0)
                            this.getDadosJogo().setPontosMilitar(this.getDadosJogo().getPontosMilitar() - 1);

                        // System.out.println(this.getDadosJogo().getListDistantSys().get(index).getNomeSistema());
                    }
                }
            } else {
                if (this.getDadosJogo().getListNearSys().get(i).getResistance() <= this.getDadosJogo().getPontosDado()
                        + this.getDadosJogo().getPontosMilitar() && !this.getDadosJogo().isAllNearExp())
                {
                    this.getDadosJogo().getListNearSys().get(i).setConquistado(true);
                    this.getDadosJogo().getListNearSys().get(i).setExplorado(true);

                    this.getDadosJogo().getListNearSys().get(i).setId(this.getDadosJogo().getIndiceConquista());
                    this.getDadosJogo().setIndiceConquista(this.getDadosJogo().getIndiceConquista() + 1);

                    //System.out.println(this.getDadosJogo().getListDistantSys().get(index).getNomeSistema());
                } else {
                    if (!this.getDadosJogo().isAllNearExp()) {
                        this.getDadosJogo().getListNearSys().get(i).setExplorado(true);
                        if (this.getDadosJogo().getPontosMilitar() != 0)
                            this.getDadosJogo().setPontosMilitar(this.getDadosJogo().getPontosMilitar() - 1);
                    }
                }
            }
        }
        // return recolher riqueza e material
        recolher();
        return new Trocar(this.getDadosJogo());
    };

    @Override
    public IStates Conquistar(String nome){

        for(MSESystem sistema : this.getDadosJogo().getListDistantSys())
        {
            if(nome.equals(sistema.getNomeSistema()))
            {
                if(sistema.getResistance() <= this.getDadosJogo().getPontosDado() + this.getDadosJogo().getPontosMilitar())
                {
                    sistema.setConquistado(true);

                    sistema.setId(this.getDadosJogo().getIndiceConquista());
                    this.getDadosJogo().setIndiceConquista(this.getDadosJogo().getIndiceConquista() + 1);

                    recolher();
                    return new Trocar(this.getDadosJogo());
                }
                else
                    getDadosJogo().setPontosMilitar(getDadosJogo().getPontosMilitar() - 1);
            }
        }

        for(MSESystem sistema : this.getDadosJogo().getListNearSys())
        {
            if(nome.equals(sistema.getNomeSistema()))
            {
                if(sistema.getResistance() <= this.getDadosJogo().getPontosDado() + this.getDadosJogo().getPontosMilitar())
                {
                    sistema.setConquistado(true);

                    sistema.setId(this.getDadosJogo().getIndiceConquista());
                    this.getDadosJogo().setIndiceConquista(this.getDadosJogo().getIndiceConquista() + 1);

                    recolher();
                    return new Trocar(this.getDadosJogo());
                }
                else
                    getDadosJogo().setPontosMilitar(getDadosJogo().getPontosMilitar() - 1);
            }
        }
        recolher();
        return new Trocar(this.getDadosJogo());
    }

    public IStates Passar(){
        recolher();
        return new Trocar(this.getDadosJogo());
    };
}
