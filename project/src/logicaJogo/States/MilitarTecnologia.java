package logicaJogo.States;

import logicaJogo.Dados.DadosJogo;
import logicaJogo.Eventos.Evento;
import logicaJogo.Tecnologias.Tecnologia;
import logicaJogo.Utils;

import java.util.Objects;

import static java.util.Collections.shuffle;

public class MilitarTecnologia extends StateAdapter {

    public MilitarTecnologia(DadosJogo dadosJogo) {
        super(dadosJogo);
    }

    public int criarEventosVerificarAno(){
        for(Evento evento : this.getDadosJogo().getListEventos())
        {
            if(!evento.isOcorreu())
            {
                evento.execute();
                evento.setOcorreu(true);

                this.getDadosJogo().setUltimoEvento(evento.getNome());

                if(Objects.equals(evento.getNome(), "Revolta") && this.getDadosJogo().getAno() == 2)
                {
                    return 1;
                }
                break;
            }
        }

        if(this.getDadosJogo().getAno() == 1 && this.getDadosJogo().eventosTodosUsados())
        {
            this.getDadosJogo().setAno(2);

            for(Evento evento : this.getDadosJogo().getListEventos())
            {
                evento.setOcorreu(false);
            }

            shuffle(this.getDadosJogo().getListEventos());

            Utils.gravarJogo(this.getDadosJogo());

            return 2;
        }
        else if(this.getDadosJogo().getAno() == 2 && this.getDadosJogo().eventosTodosUsados())
        {
            // fim do jogo
            return 1;
        }

        return 2;
    }

    @Override
    public IStates ForcaMilitar() {
        System.out.println("State ForcaMilitar");

        if(this.getDadosJogo().getPontosMilitar() == 3 && !this.getDadosJogo().existsTecnology("Capital Ships"))
        {
            int valor = criarEventosVerificarAno();
            if(valor == 1)
                return new FinalJogo(this.getDadosJogo());
            else
                return new ExplorarAtacarConquistarPassar(this.getDadosJogo());
        }
        else if(this.getDadosJogo().getPontosMilitar() == 5)
        {
            int valor = criarEventosVerificarAno();
            if(valor == 1)
                return new FinalJogo(this.getDadosJogo());
            else
                return new ExplorarAtacarConquistarPassar(this.getDadosJogo());
        }
        else if(this.getDadosJogo().getPontosMilitar() == 4)
        {
            this.getDadosJogo().setPontosMetal(this.getDadosJogo().getPontosMetal() - 1);
            this.getDadosJogo().setPontosRiqueza(this.getDadosJogo().getPontosRiqueza() - 1);

            this.getDadosJogo().setPontosMilitar(this.getDadosJogo().getPontosMilitar() + 1);
        }
        else if(this.getDadosJogo().getPontosRiqueza() >= 1 && this.getDadosJogo().getPontosMilitar() < 4 &&  this.getDadosJogo().getPontosMetal() >= 1
                && !this.getDadosJogo().isMesmoTurno())
        {
            this.getDadosJogo().setPontosMetal(this.getDadosJogo().getPontosMetal() - 1);
            this.getDadosJogo().setPontosRiqueza(this.getDadosJogo().getPontosRiqueza() - 1);

            this.getDadosJogo().setPontosMilitar(this.getDadosJogo().getPontosMilitar() + 1);
        }
        int valor = criarEventosVerificarAno();
        if(valor == 1)
            return new FinalJogo(this.getDadosJogo());
        else
            return new ExplorarAtacarConquistarPassar(this.getDadosJogo());



    }

    @Override
    public IStates DTecnologia(String nome, boolean passar)
    {
        if(!passar) {
            for (Tecnologia tecnologia : this.getDadosJogo().getListTecnologias()) {
                if (tecnologia.getNome().equals(nome)) {
                    if (nome.equals("Forward Starbases") && this.getDadosJogo().existsTecnology("Capital Ships")
                            && tecnologia.getPreco() <= this.getDadosJogo().getPontosRiqueza()) {
                        this.getDadosJogo().setPontosRiqueza(this.getDadosJogo().getPontosRiqueza() - tecnologia.getPreco());
                        tecnologia.setDescoberta(true);
                    } else if (nome.equals("Planetary Defense") && this.getDadosJogo().existsTecnology("Robot Workers")
                            && tecnologia.getPreco() <= this.getDadosJogo().getPontosRiqueza()) {
                        this.getDadosJogo().setPontosRiqueza(this.getDadosJogo().getPontosRiqueza() - tecnologia.getPreco());
                        tecnologia.setDescoberta(true);
                    } else if (nome.equals("Interstellar Diplomacy") && this.getDadosJogo().existsTecnology("Hyper Television")
                            && tecnologia.getPreco() <= this.getDadosJogo().getPontosRiqueza()) {
                        this.getDadosJogo().setPontosRiqueza(this.getDadosJogo().getPontosRiqueza() - tecnologia.getPreco());
                        tecnologia.setDescoberta(true);
                    } else if (nome.equals("Interstellar Banking") && this.getDadosJogo().existsTecnology("Interspecies Commerce")
                            && tecnologia.getPreco() <= this.getDadosJogo().getPontosRiqueza()) {
                        this.getDadosJogo().setPontosRiqueza(this.getDadosJogo().getPontosRiqueza() - tecnologia.getPreco());
                        tecnologia.setDescoberta(true);
                    } else {
                        if (tecnologia.getPreco() <= this.getDadosJogo().getPontosMetal()) {
                            this.getDadosJogo().setPontosRiqueza(this.getDadosJogo().getPontosRiqueza() - tecnologia.getPreco());
                            tecnologia.setDescoberta(true);
                        }
                    }
                }
            }
        }

        int valor = criarEventosVerificarAno();
        if(valor == 1)
            return new FinalJogo(this.getDadosJogo());
        else
            return new ExplorarAtacarConquistarPassar(this.getDadosJogo());
    }

    @Override
    public IStates PassarMT(){

        int valor = criarEventosVerificarAno();
        if(valor == 1)
            return new FinalJogo(this.getDadosJogo());
        else
            return new ExplorarAtacarConquistarPassar(this.getDadosJogo());
    };
}
