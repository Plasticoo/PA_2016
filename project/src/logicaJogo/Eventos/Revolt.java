package logicaJogo.Eventos;

import logicaJogo.Dados.DadosJogo;
import logicaJogo.Sistemas.MSESystem;
import logicaJogo.Utils;

import java.util.List;

public class Revolt extends Evento {

    public Revolt() {
        super("Revolta", 0);
    }

    @Override
    public void execute() {

    }

    public void execute(DadosJogo dadosJogo) {

        if (dadosJogo.getNumeroConquistados() != 0) {
            int dado = Utils.lancaDado(1, 6);

            if (dadosJogo.getAno() == 1) this.setForca(1 + dado);
            else if (dadosJogo.getAno() == 2) this.setForca(3 + dado);

            List<MSESystem> sistemasMenorResistencia = dadosJogo.getSistemasMenorResistencia();

            if (dadosJogo.existsTecnology("Hyper Television")) {
                if (this.getForca() >= sistemasMenorResistencia.get(0).getResistance() + 1) {
                    for (MSESystem sistema : dadosJogo.getListNearSys()) {
                        if (sistema.getNomeSistema().equals(sistemasMenorResistencia.get(0).getNomeSistema())) {
                            sistema.setConquistado(false);
                            sistema.setId(0);
                        }
                    }
                }
            }
        }
    }
}
