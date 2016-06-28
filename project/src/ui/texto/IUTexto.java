package ui.texto;

import logicaJogo.Dados.DadosJogo;
import logicaJogo.Eventos.Evento;
import logicaJogo.Jogo;
import logicaJogo.Sistemas.MSESystem;
import logicaJogo.States.FinalJogo;
import logicaJogo.States.*;
import logicaJogo.Tecnologias.Tecnologia;
import logicaJogo.Utils;

import java.util.ArrayList;
import java.util.Scanner;

public class IUTexto {

    private Jogo jogo;
    private int tipoSistema;
    private boolean conquistado;

    private Scanner s;

    public IUTexto(Jogo jogo) {
        this.jogo = jogo;
        s = new Scanner(System.in);
    }

    private void printPossiveisDeConquistar (ArrayList<MSESystem> disp) {
            int index = 1;

            System.out.println("Pode tentar conquistar:");

            for(MSESystem sistema : disp)
            {
                System.out.println(index + " - " + sistema.getNomeSistema() +
                        " - resistencia: " + sistema.getResistance() +
                        " - Metal: " + sistema.getMetal() +
                        " - Riqueza: " + sistema.getRiqueza() +
                        " - Ponto Victória: " + sistema.getVictoryPoint());
                index++;
            }
    }

    private ArrayList<MSESystem> getSistemaParaConquistar() {
        ArrayList<MSESystem> nomes = new ArrayList<>();

        for(MSESystem sistema : jogo.getJogoDados().getListNearSys())
        {
            if(!sistema.isConquistado() && sistema.isExplorado()) {
                nomes.add(sistema);
            }
        }
        for(MSESystem sistema : jogo.getJogoDados().getListDistantSys())
        {
            if(!sistema.isConquistado() && sistema.isExplorado())
            {
                nomes.add(sistema);
            }
        }
        return nomes;
    }

    private ArrayList<Tecnologia> getTecDisponiveis() {
        ArrayList<Tecnologia> nomes = new ArrayList<>();

        for(Tecnologia tecnologia : jogo.getJogoDados().getListTecnologias())
        {
            if(tecnologia.getGeracao() == 1 && !tecnologia.isDescoberta() && tecnologia.getPreco() <= jogo.getJogoDados().getPontosRiqueza()) {
                //System.out.println(index + " - " + "Tecnologia: " + tecnologia.getNome());
                nomes.add(tecnologia);
            }
            else if(tecnologia.getGeracao() == 2 && !tecnologia.isDescoberta())
            {
                if(tecnologia.getNome().equals("Forward Starbases") && jogo.getJogoDados().existsTecnology("Capital Ships")
                        && tecnologia.getPreco() <= jogo.getJogoDados().getPontosRiqueza())
                {
                    //System.out.println(index + " - " + "Tecnologia: " + tecnologia.getNome());
                    nomes.add(tecnologia);
                }
                else if(tecnologia.getNome().equals("Planetary Defense") && jogo.getJogoDados().existsTecnology("Robot Workers")
                        && tecnologia.getPreco() <= jogo.getJogoDados().getPontosRiqueza())
                {
                    //System.out.println(index + " - " + "Tecnologia: " + tecnologia.getNome());
                    nomes.add(tecnologia);
                }
                else if(tecnologia.getNome().equals("Interstellar Diplomacy") && jogo.getJogoDados().existsTecnology("Hyper Television")
                        && tecnologia.getPreco() <= jogo.getJogoDados().getPontosRiqueza())
                {
                    //System.out.println(index + " - " + "Tecnologia: " + tecnologia.getNome());
                    nomes.add(tecnologia);
                }
                else if(tecnologia.getNome().equals("Interstellar Banking") && jogo.getJogoDados().existsTecnology("Interspecies Commerce")
                        && tecnologia.getPreco() <= jogo.getJogoDados().getPontosRiqueza())
                {
                    //System.out.println(index + " - " + "Tecnologia: " + tecnologia.getNome());
                    nomes.add(tecnologia);
                }
            }
        }
        return nomes;
    }

    private void printTecDisponiveis(ArrayList<Tecnologia> disp) {
        int index = 1;

        System.out.println("Tecnologias disponiveis:");

        for(Tecnologia nome : disp)
        {
            System.out.println(index + " - " + nome.getNome() + " - " +" Geração: "+ nome.getGeracao() + " - " +"Preço: " + nome.getPreco());
            index++;
        }
    }

    private void printTecDescobertas() {
        for(Tecnologia tecnologia : jogo.getJogoDados().getListTecnologias())
        {
            if(tecnologia.isDescoberta())
                System.out.println("Já tem a tecnologia: " + tecnologia.getNome());
        }
    }

    private boolean podeTrocar(String name) {
            if(name.equals("metal") && this.jogo.getJogoDados().getPontosMetal() >= 2)
            {
                return true;
            }
            else if(name.equals("riqueza") && this.jogo.getJogoDados().getPontosRiqueza() >= 2)
            {
                return true;
            }
        return false;
    }

    private boolean isPossibleDistantSystem() {
        if(jogo.getJogoDados().nearAllConquistados() && jogo.getJogoDados().existsTecnology("Forward Starbases"))
        {
            return true;
        }
        return false;
    }
    
    private void iuInicio(){
        int opcao;

        //printInformacaoBasica();

        System.out.println("1 - Iniciar");
        System.out.println("2 - Carregar Jogo");
        System.out.print("->> ");

        while(!s.hasNextInt()) s.next();

        opcao = s.nextInt();
        if(opcao == 1) {
            jogo.iniciarJogo();
        }
        else if(opcao == 2)
        {
            DadosJogo dados = Utils.carregarJogo();

            jogo.carregarJogo(dados);
            jogo.setJogoDados(dados);
        }
    }

    private void printInformacaoBasica() {
        System.out.println("Produção:\nMetal: +" + jogo.getJogoDados().getProducaoMetal() +
                " - Riqueza: +" + jogo.getJogoDados().getProducaoRiqueza() + "\n");

        System.out.println("Adquiridos: \nMetal: " + jogo.getJogoDados().getPontosMetal() +
                " - Riqueza: " + jogo.getJogoDados().getPontosRiqueza() + " - Pontos militar: " +
                jogo.getJogoDados().getPontosMilitar() + "\n");
    }

    private void proximoAExplorar() {
        if(tipoSistema == 1) {
            for (MSESystem sistema : jogo.getJogoDados().getListNearSys())
            {
                if(!sistema.isExplorado())
                {
                    System.out.println("Vai explorar o sistema: " + sistema.getNomeSistema());
                    break;
                }
            }
        }
        else if(tipoSistema == 2)
        {
            for (MSESystem sistema : jogo.getJogoDados().getListDistantSys())
            {
                if(!sistema.isExplorado())
                {
                    System.out.println("Vai explorar o sistema: " + sistema.getNomeSistema());
                    break;
                }
            }
        }
    }

    private void printInformacaoTotal() {
        int index = 0;
        printInformacaoBasica();
        for(Tecnologia tecnologia : jogo.getJogoDados().getListTecnologias())
        {
            if(tecnologia.isDescoberta())
            {
                System.out.println(index + " - " + tecnologia.getNome() + " - geração: " +tecnologia.getGeracao());
                index++;
            }
        }
    }

    private void printFoiConquistado() {
        int index = 0;
        if(tipoSistema == 1) {

            for (MSESystem sistema : jogo.getJogoDados().getListNearSys()) {
                if (sistema.isExplorado())
                    index++;
            }

            if (index == 0) {
                if (jogo.getJogoDados().getListNearSys().get(index).isConquistado())
                    System.out.println("O sistema: " + jogo.getJogoDados().getListNearSys().get(index).getNomeSistema()
                            + " foi conquistado - Resistencia: " + jogo.getJogoDados().getListNearSys().get(index).getResistance());
                else
                    System.out.println("O sistema: " + jogo.getJogoDados().getListNearSys().get(index).getNomeSistema()
                            + " não foi conquistado - Resistencia: " + jogo.getJogoDados().getListNearSys().get(index).getResistance());
            } else {
                if (jogo.getJogoDados().getListNearSys().get(index - 1).isConquistado())
                    System.out.println("O sistema: " + jogo.getJogoDados().getListNearSys().get(index - 1).getNomeSistema()
                            + " foi conquistado - Resistencia: " + jogo.getJogoDados().getListNearSys().get(index - 1).getResistance());
                else
                    System.out.println("O sistema: " + jogo.getJogoDados().getListNearSys().get(index - 1).getNomeSistema()
                            + " não foi conquistado - Resistencia: " + jogo.getJogoDados().getListNearSys().get(index - 1).getResistance());
            }
        }
        else{
            for (MSESystem sistema : jogo.getJogoDados().getListDistantSys())
            {
                if(sistema.isExplorado())
                    index++;
            }
            if(index == 0)
            {
                if (jogo.getJogoDados().getListDistantSys().get(index).isConquistado())
                    System.out.println("O sistema: " + jogo.getJogoDados().getListDistantSys().get(index).getNomeSistema()
                            + " foi conquistado - Resistencia: " + jogo.getJogoDados().getListNearSys().get(index).getResistance());
                else
                    System.out.println("O sistema: " + jogo.getJogoDados().getListDistantSys().get(index).getNomeSistema()
                            + " não foi conquistado - Resistencia: " + jogo.getJogoDados().getListNearSys().get(index).getResistance());
            }
            else
            {
                if (jogo.getJogoDados().getListDistantSys().get(index - 1).isConquistado())
                    System.out.println("O sistema: " + jogo.getJogoDados().getListDistantSys().get(index - 1).getNomeSistema()
                            + " foi conquistado - Resistencia: " + jogo.getJogoDados().getListNearSys().get(index - 1).getResistance());
                else
                    System.out.println("O sistema: " + jogo.getJogoDados().getListDistantSys().get(index - 1).getNomeSistema()
                            + " não foi conquistado - Resistencia: " + jogo.getJogoDados().getListNearSys().get(index - 1).getResistance());
            }
        }
    }

    private void iuExplorarAtacarConquistarPassar() {
        printInformacaoBasica();

        int numeroOpcoes;
        int opcao;
        int input;

        ArrayList<MSESystem> sistemas = getSistemaParaConquistar();

        this.jogo.getJogoDados().setPontosDado();

        if(jogo.getJogoDados().getNumeroExplorados() != 0 && sistemas.size() != 0)
            numeroOpcoes = 3;
        else
            numeroOpcoes = 2;


        System.out.println("Escolha uma das " + numeroOpcoes + " opções:");
        System.out.println("1 - Explorar e atacar");
        if(numeroOpcoes == 3)
            System.out.println("2 - Conquistar");
        System.out.println(numeroOpcoes + " - Passar");
        System.out.print("->> ");

        if(numeroOpcoes == 3)
        {
            opcao = s.nextInt();
            if(opcao == 1)
            {
                System.out.println("Tipo de sistema a explorar:");
                System.out.println("1 - Near System");
                if(isPossibleDistantSystem())
                    System.out.println("2 - Distant System");
                System.out.print("->> ");
                if((input = s.nextInt()) != 1 && !isPossibleDistantSystem())
                    input = 1;

                this.tipoSistema = input;
                proximoAExplorar();
                jogo.iniciarExplorarAtacar(input);
                
            }
            else if(opcao == 2)
            {
                conquistado = true;
                printPossiveisDeConquistar(sistemas);
                System.out.print("->> ");
                jogo.iniciarConquistar(sistemas.get(s.nextInt() - 1).getNomeSistema());
            }
            else if(opcao == 3)
            {
                //printInformacaoBasica();
                jogo.iniciarPassar();
            }
        }
        if(numeroOpcoes == 2)
        {
            opcao = s.nextInt();
            if(opcao == 1)
            {
                //printInformacaoBasica();
                System.out.println("Tipo de sistema a explorar:");
                System.out.println("1 - Near System");
                if(isPossibleDistantSystem())
                    System.out.println("2 - Distant System");
                System.out.print("->> ");
                if((input = s.nextInt()) != 1 && !isPossibleDistantSystem())
                    input = 1;
                System.out.print("->> ");
                this.tipoSistema = input;
                proximoAExplorar();
                jogo.iniciarExplorarAtacar(input);
            }
            else if(opcao == 2)
            {
                jogo.iniciarPassar();
            }
        }
    }


    private void iuTrocar() {
        for(MSESystem sistema : jogo.getJogoDados().getListNearSys())
            if(sistema.isConquistado())
                System.out.println(sistema.getNomeSistema() + ": " + "metal: " + sistema.getMetal() +
                        " - riqueza: " + sistema.getRiqueza());

        for(MSESystem sistema : jogo.getJogoDados().getListDistantSys())
            if(sistema.isConquistado())
                System.out.println(sistema.getNomeSistema() + ": metal: " + sistema.getMetal() +
                        " - riqueza: " + sistema.getRiqueza());

        System.out.println("\n");

        if(jogo.getJogoDados().existsTecnology("Interspecies Commerce"))
        {
            printInformacaoBasica();
            System.out.println("1 - Trocar");
            System.out.println("2 - Passar");
            System.out.println("->>> ");
            if(s.nextInt() == 1)
            {
                System.out.println("1 - Trocar metal por riqueza");
                System.out.println("2 - Trocar riqueza por metal");

                if (s.nextInt() == 1)
                {
                    if(podeTrocar("metal"))
                    {
                        jogo.iniciarTrocar("metal");
                    }
                    else
                        System.out.println("Não pode trocar metal por riqueza\nNão existem pontos de metal suficentes");
                }
                else
                {
                    if (podeTrocar("riqueza"))
                        jogo.iniciarTrocar("riqueza");
                    else
                        System.out.println("Não pode trocar riqueza por metal\nNão existem pontos de riqueza suficentes");
                }
            }
        }

        jogo.iniciarTrocar("salta");
    }

    private void iuMilitarTecnologia() {

        ArrayList<Tecnologia> nomes;
        int userInput;

        printInformacaoBasica();

        nomes = getTecDisponiveis();

        if(nomes.size() > 0)
        {
            System.out.println("1 - Aumentar força militar");
            System.out.println("2 - Aumentar tecnologia");
            System.out.println("3 - Passar");
        }
        else
        {
            System.out.println("1 - Aumentar força militar");
            System.out.println("2 - Passar");
        }

        System.out.print("->> ");
        if( (userInput = s.nextInt()) == 1)
        {
            jogo.iniciarForcaMilitar();
        }
        else if(nomes.size() > 0 && userInput == 2)
        {
            printTecDescobertas();
            printTecDisponiveis(nomes);

            System.out.print("->> ");

            jogo.iniciarDTecnologia(nomes.get(s.nextInt() - 1).getNome(), false);
        }
        else if(nomes.size() > 0 && userInput == 3)
        {
            jogo.iniciarDTecnologia(null, true);
        }
        else if(userInput == 2)
        {
            jogo.iniciarDTecnologia(null, true);
        }

    }


    private void iuFimJogo() {

        boolean ganha = true;
        for(Evento evento : jogo.getJogoDados().getListEventos())
        {
            if((evento.getNome().equals("SRevolt") || evento.getNome().equals("Revolt")) && jogo.getJogoDados().getAno() == 2)
            {
                System.out.println("Perdeu o jogo!");
                ganha = false;
            }
        }

        if(ganha)
        {
            System.out.println("Ganhou! Parabéns!");
        }

        jogo.acabarJogo();
        System.out.println("Pontos: " + jogo.getJogoDados().getPontosVitoria());

        System.out.println("1 - Começar um novo jogo");
        System.out.println("2 - Sair");
        System.out.println("->> ");

        if(s.nextInt() == 1)
            jogo.iniciarJogo();
    }

    public void corre() {
        while(!(jogo.getStates() instanceof FinalJogo))
        {
            if(jogo.getStates() instanceof PreparacaoJogo)
            {
                iuInicio();
            }
            else if(jogo.getStates() instanceof ExplorarAtacarConquistarPassar)
            {
                iuExplorarAtacarConquistarPassar();
            }
            else if(jogo.getStates() instanceof Trocar)
            {
                iuTrocar();
            }
            else if(jogo.getStates() instanceof MilitarTecnologia)
            {
                iuMilitarTecnologia();
            }
            if(jogo.getStates() instanceof FinalJogo)
            {
                iuFimJogo();
            }
        }
    }
}
