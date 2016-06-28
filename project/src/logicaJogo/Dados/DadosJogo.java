package logicaJogo.Dados;

import logicaJogo.Eventos.*;
import logicaJogo.Sistemas.DistantSystem;
import logicaJogo.Sistemas.MSESystem;
import logicaJogo.Sistemas.NearSystem;
import logicaJogo.Tecnologias.*;
import logicaJogo.Utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static java.util.Collections.shuffle;

public class DadosJogo implements Serializable {

    private int pontosMetal;
    private int pontosRiqueza;
    private int pontosVitoria;
    private int pontosMilitar;

    private int pontosDado;
    private int ano;

    private int producaoMetal;
    private int producaoRiqueza;

    private boolean mesmoTurno;
    private boolean greve;

    private int indiceConquista;

    private String ultimoEvento;

    private ArrayList<NearSystem> listNearSys;
    private ArrayList<DistantSystem> listDistantSys;

    private List<Tecnologia> listTecnologias;
    private List<Evento> listEventos;

    public int getPontosDado() {
        return pontosDado;
    }

    public void setPontosDado() {
        Utils dado = new Utils();
        this.pontosDado = dado.lancaDado(1, 6);
    }

    public void setUltimoEvento(String ultimoEvento) {
        this.ultimoEvento = ultimoEvento;
    }
    public String getUltimoEvento()
    {
        return this.ultimoEvento;
    }

    public int getProducaoRiquezaTotal()
    {
        int conta = 0;

        for(MSESystem sistema : this.getListDistantSys())
        {
            if(sistema.isConquistado())
                conta += sistema.getRiqueza();
        }

        for(MSESystem sistema : this.getListNearSys())
        {
            if(sistema.isConquistado())
                conta += sistema.getRiqueza();
        }

        return conta;
    }

    public int getProducaoMetalTotal()
    {
        int conta = 0;

        for(MSESystem sistema : this.getListDistantSys())
        {
            if(sistema.isConquistado())
                conta += sistema.getMetal();
        }

        for(MSESystem sistema : this.getListNearSys())
        {
            if(sistema.isConquistado())
                conta += sistema.getMetal();
        }

        return conta;
    }

    public boolean existsTecnology(String name)
    {
        for(Tecnologia tecnologia : this.getListTecnologias())
        {
            if(tecnologia.getNome().equals(name) && tecnologia.isDescoberta())
            {
                return true;
            }
        }

        return false;
    }

    public int getProducaoRiqueza() {
        return producaoRiqueza;
    }

    public void setProducaoRiqueza(int producaoRiqueza) {
        if(producaoRiqueza > 5)
            this.producaoRiqueza = 5;
        else if(producaoRiqueza < 0)
            this.producaoRiqueza = 0;
        else this.producaoRiqueza = producaoRiqueza;
    }

    public int getProducaoMetal() {
        return producaoMetal;
    }

    public void setProducaoMetal(int producaoMetal) {
        if(producaoMetal > 5)
            this.producaoMetal = 5;
        else if(producaoMetal < 0)
            this.producaoMetal = 0;
        else this.producaoMetal = producaoMetal;
    }

    public int getPontosMetal()
    {
        return pontosMetal;
    }

    public void setPontosMetal(int pontosMetal)
    {
        if(pontosMetal > 3 && existsTecnology("Interstellar Banking"))
        {
            if(pontosMetal > 5)
            {
                this.pontosMetal = 5;
            }
            else
                this.pontosMetal = 4;
        }
        else if(pontosMetal > 3)
        {
            this.pontosMetal = 3;
        }
        else
        {
            this.pontosMetal = pontosMetal;
        }
    }

    public int getPontosRiqueza()
    {
        return pontosRiqueza;
    }

    public void setPontosRiqueza(int pontosRiqueza)
    {
        if(pontosRiqueza > 3 && existsTecnology("Interstellar Banking"))
        {
            if(pontosRiqueza > 5)
            {
                this.pontosRiqueza = 5;
            }
            else
                this.pontosRiqueza = 4;
        }
        else if(pontosRiqueza > 3)
        {
            this.pontosRiqueza = 3;
        }
        else
        {
            this.pontosRiqueza = pontosRiqueza ;
        }
    }

    public int getPontosVitoria()
    {
        return pontosVitoria;
    }

    public void setPontosVitoria(int pontosVitoria)
    {
        this.pontosVitoria = pontosVitoria;
    }

    public int getPontosMilitar()
    {
        return pontosMilitar;
    }

    public void setPontosMilitar(int pontosMilitar)
    {
        if(this.pontosMilitar == 0 && pontosMilitar < 0) {
            this.pontosMilitar = 0;
        }
        else if(pontosMilitar > 3 && existsTecnology("Capital Ships"))
        {
            if(pontosMilitar >= 5)
            {
                this.pontosMilitar = 5;
            }
            else
                this.pontosMilitar = 4;
        }
        else if(pontosMilitar > 3)
            this.pontosMilitar = 3;
        else if(pontosMilitar < 0)
            this.pontosMilitar = pontosMilitar;
        else
        {
            this.pontosMilitar = pontosMilitar ;
        }
    }

    public int calcPontosVitoria()
    {
        for(MSESystem sistema : this.getListNearSys())
        {
            if(sistema.isConquistado())
            {
                this.setPontosVitoria(this.getPontosDado() + sistema.getVictoryPoint());
            }
        }

        for(MSESystem sistema : this.getListDistantSys())
        {
            if(sistema.isConquistado())
            {
                this.setPontosVitoria(this.getPontosDado() + sistema.getVictoryPoint());
            }
        }

        for(Tecnologia tecnologia : this.getListTecnologias())
        {
            if(tecnologia.isDescoberta())
            {
                this.setPontosVitoria(this.getPontosDado() + 1);
            }
        }

        if(this.isAllExplorados())
        {
            this.setPontosVitoria(this.getPontosDado() + 1);
        }

        if(this.isAllDescobertas())
        {
            this.setPontosVitoria(this.getPontosDado() + 1);
        }

        if(this.isAllConquistados())
        {
            this.setPontosVitoria(this.getPontosDado() + 3);
        }

        return getPontosVitoria();
    }

    public void setPontosDado(int pontosDado) {
        this.pontosDado = pontosDado;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public boolean isGreve() {
        return greve;
    }

    public void setGreve(boolean greve) {
        this.greve = greve;
    }

    public int getNumeroConquistados() {
        int conta = 0;

        for(MSESystem sistema : this.getListNearSys())
        {
            if(sistema.isConquistado()) conta++;
        }

        for(MSESystem sistema : this.getListDistantSys())
        {
            if(sistema.isConquistado()) conta++;
        }

        return conta;
    }

    public String getSistemasConquistados()
    {
        StringBuffer str = new StringBuffer();
        for(MSESystem system : getListNearSys())
        {
            if(system.isConquistado())
                str.append(system.getNomeSistema() + "\n");
        }
        for(MSESystem system : getListDistantSys())
        {
            if(system.isConquistado())
                str.append(system.getNomeSistema() + "\n");
        }

        return str.toString();
    }

    public int getNumeroExploradosNearSystems() {
        int conta = 0;

        for(MSESystem sistema : this.getListNearSys())
        {
            if(sistema.isExplorado())
            {
                conta++;
            }
        }

        return conta;
    }

    public int getNumeroExploradosDistantSystems() {
        int conta = 0;

        for(MSESystem sistema : this.getListDistantSys())
        {
            if(sistema.isExplorado())
            {
                conta++;
            }
        }

        return conta;
    }

    public int getNumeroExplorados() {
        int conta = 0;

        for(MSESystem sistema : this.getListNearSys())
        {
            if(sistema.isExplorado()) conta++;
        }

        for(MSESystem sistema : this.getListDistantSys())
        {
            if(sistema.isExplorado()) conta++;
        }

        return conta;
    }

    public boolean isAllExplorados() {
        for(MSESystem sistema : this.getListNearSys())
        {
            if(!sistema.isExplorado()) return false;
        }

        for(MSESystem sistema : this.getListDistantSys())
        {
            if(!sistema.isExplorado()) return false;
        }

        return true;
    }

    public boolean isAllDescobertas() {
        for(Tecnologia tecnologia : this.getListTecnologias())
        {
            if(!tecnologia.isDescoberta()) return false;
        }

        for(Tecnologia tecnologia : this.getListTecnologias())
        {
            if(!tecnologia.isDescoberta()) return false;
        }

        return true;
    }

    public boolean isAllConquistados() {
        for(MSESystem sistema : this.getListNearSys())
        {
            if(!sistema.isConquistado()) return false;
        }

        for(MSESystem sistema : this.getListDistantSys())
        {
            if(!sistema.isConquistado()) return false;
        }

        return true;
    }

    public boolean isMesmoTurno() {
        return mesmoTurno;
    }

    public Vector<String> getArrayNaoConquistados()
    {
        Vector<String> lista = new Vector<>();

        for(MSESystem sistema : this.getListNearSys())
        {
            if(!sistema.isConquistado() && sistema.isExplorado())
            {
                lista.add(sistema.getNomeSistema());
            }
        }

        for(MSESystem sistema : this.getListDistantSys())
        {
            if(!sistema.isConquistado() && sistema.isExplorado())
            {
                lista.add(sistema.getNomeSistema());
            }
        }

        return lista;
    }

    public List<MSESystem> getSistemasMenorResistencia() {
        MSESystem sistemaInicial;
        List<MSESystem> listaIguais = new ArrayList<>();

        String nome;
        int menor;

        sistemaInicial = this.getListDistantSys().get(0);

        nome = sistemaInicial.getNomeSistema();
        menor = sistemaInicial.getResistance();

        for(MSESystem sistema : this.listDistantSys)
        {
            if(sistema.isConquistado())
            {
                if(sistema.getResistance() <= menor)
                {
                    nome = sistema.getNomeSistema();
                    menor = sistema.getResistance();
                }
            }
        }

        for(MSESystem sistema : this.listNearSys)
        {
            if(sistema.isConquistado())
            {
                if(sistema.getResistance() <= menor)
                {
                    nome = sistema.getNomeSistema();
                    menor = sistema.getResistance();
                }
            }
        }

        for(MSESystem sistema : this.listNearSys)
        {
            if(sistema.isConquistado())
            {
                if(sistema.getResistance() == menor)
                {
                    listaIguais.add(sistema);
                }
            }
        }

        for(MSESystem sistema : this.listDistantSys)
        {
            if(sistema.isConquistado())
            {
                if(sistema.getResistance() == menor)
                {
                    listaIguais.add(sistema);
                }
            }
        }

        shuffle(listaIguais);

        return listaIguais;
    }

    public String getMaiorId() {
        int maior = 0;
        String nome = "";

        for(MSESystem sistema : this.listDistantSys)
        {
            if(sistema.isConquistado())
            {
                if(sistema.getId() > maior)
                {
                    maior = sistema.getId();
                    nome = sistema.getNomeSistema();
                }
            }
        }

        for(MSESystem sistema : this.listNearSys)
        {
            if(sistema.isConquistado())
            {
                if(sistema.getId() > maior)
                {
                    maior = sistema.getId();
                    nome = sistema.getNomeSistema();
                }
            }
        }

        return nome;
    }

    public Vector<? extends String> getTecnologiasPossiveisDeComprar()
    {
        Vector<String> nomes = new Vector<>();

        for(Tecnologia tecnologia : this.getListTecnologias())
        {
            if(tecnologia.getGeracao() == 1 && !tecnologia.isDescoberta() && tecnologia.getPreco() <= this.getPontosRiqueza()) {
                //System.out.println(index + " - " + "Tecnologia: " + tecnologia.getNome());
                nomes.add(tecnologia.getNome());
            }
            else if(tecnologia.getGeracao() == 2 && !tecnologia.isDescoberta())
            {
                if(tecnologia.getNome().equals("Forward Starbases") && this.existsTecnology("Capital Ships")
                        && tecnologia.getPreco() <= this.getPontosRiqueza())
                {
                    //System.out.println(index + " - " + "Tecnologia: " + tecnologia.getNome());
                    nomes.add(tecnologia.getNome());
                }
                else if(tecnologia.getNome().equals("Planetary Defense") && this.existsTecnology("Robot Workers")
                        && tecnologia.getPreco() <= this.getPontosRiqueza())
                {
                    //System.out.println(index + " - " + "Tecnologia: " + tecnologia.getNome());
                    nomes.add(tecnologia.getNome());
                }
                else if(tecnologia.getNome().equals("Interstellar Diplomacy") && this.existsTecnology("Hyper Television")
                        && tecnologia.getPreco() <= this.getPontosRiqueza())
                {
                    //System.out.println(index + " - " + "Tecnologia: " + tecnologia.getNome());
                    nomes.add(tecnologia.getNome());
                }
                else if(tecnologia.getNome().equals("Interstellar Banking") && this.existsTecnology("Interspecies Commerce")
                        && tecnologia.getPreco() <= this.getPontosRiqueza())
                {
                    //System.out.println(index + " - " + "Tecnologia: " + tecnologia.getNome());
                    nomes.add(tecnologia.getNome());
                }
            }
        }
        return nomes;
    }

    public int getIndiceConquista() {
        return indiceConquista;
    }

    public void setIndiceConquista(int indiceConquista) {
        this.indiceConquista = indiceConquista;
    }

    public boolean eventosTodosUsados() {
        for(Evento evento : this.listEventos)
        {
            if(!evento.isOcorreu())
            {
                return false;
            }
        }
        return true;
    }

    public boolean nearAllConquistados() {
        for(MSESystem sistema : this.listNearSys)
        {
            if(sistema.isExplorado())
            {
                if(!sistema.isConquistado())
                {
                    return false;
                }
            }
        }

        return true;
    }

    public int eventosAcontecidos() {
        int conta = 0;
        for(Evento evento : this.listEventos)
            if (evento.isOcorreu())
                conta++;
        return conta;

    }

    public void setMesmoTurno(boolean mesmoTurno) {
        this.mesmoTurno = mesmoTurno;
    }

    public ArrayList<NearSystem> getListNearSys()
    {
        return listNearSys;
    }

    public void setListNearSys(ArrayList<NearSystem> listNearSys)
    {
        this.listNearSys = listNearSys;
    }

    public ArrayList<DistantSystem> getListDistantSys()
    {
        return listDistantSys;
    }

    public void setListDistantSys(ArrayList<DistantSystem> listDistantSys)
    {
        this.listDistantSys = listDistantSys;
    }

    public List<Tecnologia> getListTecnologias()
    {
        return this.listTecnologias;
    }

    public void setListTecnologias(ArrayList<Tecnologia> listTecnologias)
    {
        this.listTecnologias = listTecnologias;
    }

    public List<Evento> getListEventos()
    {
        return listEventos;
    }

    public void setListEventos(ArrayList<Evento> listEventos) {
        this.listEventos = listEventos;
    }

    public DistantSystem getDistantSystemOfIndex(int index)
    {
        return this.listDistantSys.get(index);
    }

    public NearSystem getNearSystemOfIndex(int index)
    {
        return this.listNearSys.get(index);
    }

    public boolean isAllNearExp() {
        for(MSESystem sistema : this.listNearSys)
        {
            if(!sistema.isExplorado())
                return false;
        }

        return true;
    }

    public boolean isAllDistantExp() {
        for(MSESystem sistema : this.listDistantSys)
        {
            if(!sistema.isExplorado())
                return false;
        }

        return true;
    }

    public void shuffleAllSystems() {
        shuffle(listDistantSys);
        shuffle(listNearSys);
    }

    public void shuffleEvents()
    {
        shuffle(listEventos);
    }

    public void createNearSys() {
        this.listNearSys = new ArrayList<>();
        this.listNearSys.add(new NearSystem(false, 1, 0, 5, 1, "Wolf 359"));
        this.listNearSys.add(new NearSystem(false, 1, 0, 6, 1, "Proxima"));
        this.listNearSys.add(new NearSystem(false, 0, 0, 8, 1, "Epsilon Eridani"));
        this.listNearSys.add(new NearSystem(false, 0, 1, 5, 1, "Cygnus"));
        this.listNearSys.add(new NearSystem(false, 0, 0, 4, 1, "Tau Ceti"));
        this.listNearSys.add(new NearSystem(false, 0, 1, 7, 1, "Procyon"));
        this.listNearSys.add(new NearSystem(false, 0, 0, 6, 1, "Sirius"));
    }

    public void createDistantSys() {
        this.listDistantSys = new ArrayList<>();
        this.listDistantSys.add(new DistantSystem(false, 1, 0, 9, 2, "Polaris"));
        this.listDistantSys.add(new DistantSystem(false, 0, 1, 9, 2, "Canapus"));
        this.listDistantSys.add(new DistantSystem(false, 0, 0, 10, 3, "Galaxy's Edge"));
    }

    public void createEvents() {
        this.listEventos = new ArrayList<>();
        this.listEventos.add(0, new Asteroid());
        this.listEventos.add(1, new DerelictShip());
        this.listEventos.add(2, new LargeInvasionForce());
        this.listEventos.add(3, new PeaceAndQuiet());
        this.listEventos.add(4, new Revolt());
        this.listEventos.add(5, new SmallInvasionForce());
        this.listEventos.add(6, new SRevolt());
        this.listEventos.add(7, new Strike());
    }

    public void createTecnologias() {
        this.listTecnologias = new ArrayList<>();
        this.listTecnologias.add(0, new CapitalShips());
        this.listTecnologias.add(1, new ForwardStarbases());
        this.listTecnologias.add(2, new RobotWorkers());
        this.listTecnologias.add(3, new PlanetaryDefense());
        this.listTecnologias.add(4, new HyperTelevision());
        this.listTecnologias.add(5, new InterstellarDiplomacy());
        this.listTecnologias.add(6, new InterspeciesCommerce());
        this.listTecnologias.add(7, new InterstellarBanking());
    }

    public void iniciar() {
        createDistantSys();
        createNearSys();
        createEvents();
        createTecnologias();
        shuffleAllSystems();
        shuffleEvents();

        this.producaoMetal = 1;
        this.producaoRiqueza = 1;
        this.pontosMetal = 0;
        this.pontosRiqueza = 0;
        this.pontosMilitar = 0;
        this.pontosVitoria = 0;
        this.ano = 1;
    }
    
}
