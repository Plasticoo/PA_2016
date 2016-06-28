package logicaJogo.States;

import logicaJogo.Dados.DadosJogo;
import logicaJogo.Sistemas.MSESystem;

import java.io.Serializable;

public abstract class StateAdapter implements IStates, Serializable {

    private DadosJogo dadosJogo;

    public StateAdapter(DadosJogo dadosJogo)
    {
        this.dadosJogo = dadosJogo;
    }

    public DadosJogo getDadosJogo() {
        return dadosJogo;
    }

    public void setDadosJogo(DadosJogo dadosJogo) {
        this.dadosJogo = dadosJogo;
    }


    @Override
    public IStates PreparacaoJogo() {return this;}
    @Override
    public IStates CarregarJogo(DadosJogo dados) {return this;}
    @Override
    public IStates ExplorarAtacar(int tipoSistema) {return this;}
    @Override
    public IStates Conquistar(String nome) {return this;}
    @Override
    public IStates Passar() {return this;}
    @Override
    public IStates PassarMT() {return this;}
    @Override
    public IStates Trocar(String name) {return this;}
    @Override
    public IStates ForcaMilitar() {return this;}
    @Override
    public IStates DTecnologia(String nome, boolean passar) {return this;}
    @Override
    public IStates FimJogo() {return this;}


}
