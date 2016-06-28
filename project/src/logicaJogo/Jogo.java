package logicaJogo;

import logicaJogo.Dados.DadosJogo;
import logicaJogo.States.IStates;
import logicaJogo.States.PreparacaoJogo;
import logicaJogo.States.StateAdapter;

import java.io.Serializable;

public class Jogo implements Serializable {
    private DadosJogo jogoDados;
    private IStates states;

    public Jogo() {
        jogoDados = new DadosJogo();
        states = new PreparacaoJogo(jogoDados);
    }

    public IStates getStates() {
        return states;
    }

    public void setStates(IStates states) {
        this.states = states;
    }

    public DadosJogo getJogoDados() {
        return jogoDados;
    }

    public void setJogoDados(DadosJogo jogoDados) {
        this.jogoDados = jogoDados;
    }

    public void iniciarJogo()
    {
        setStates(getStates().PreparacaoJogo());
    }

    public void acabarJogo()
    {
        setStates(getStates().FimJogo());
    }


    public void iniciarExplorarAtacar(int tipoSistema) {
        setStates(getStates().ExplorarAtacar(tipoSistema));
    }

    public void iniciarTrocar(String nome) {
        setStates(getStates().Trocar(nome));

    }

    public void iniciarConquistar(String nome)
    {
        setStates(getStates().Conquistar(nome));
    }

    public void iniciarForcaMilitar()
    {
        setStates(getStates().ForcaMilitar());
    }

    public void iniciarDTecnologia(String nome, boolean passar)
    {
        setStates(getStates().DTecnologia(nome, passar));
    }

    public void iniciarPassar(){
        setStates((getStates().Passar()));
    }

    public void iniciarPassarMT(){
        setStates((getStates().PassarMT()));
    }
    public void carregarJogo(DadosJogo dados)
    {
        setStates((getStates().CarregarJogo(dados)));
    }


}
