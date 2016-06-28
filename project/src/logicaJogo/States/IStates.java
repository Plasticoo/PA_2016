package logicaJogo.States;

import logicaJogo.Dados.DadosJogo;
import logicaJogo.Sistemas.MSESystem;

public interface IStates {
    IStates PreparacaoJogo();
    IStates CarregarJogo(DadosJogo dados);
    IStates ExplorarAtacar(int tipoSistema);
    IStates Conquistar(String nome);
    IStates Passar();
    IStates PassarMT();
    IStates Trocar(String nome);
    IStates ForcaMilitar();
    IStates DTecnologia(String nome, boolean passar);
    IStates FimJogo();

}
