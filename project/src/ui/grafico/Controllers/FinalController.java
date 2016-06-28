package ui.grafico.Controllers;

import logicaJogo.Jogo;
import ui.grafico.Models.FinalModel;
import ui.grafico.Models.MainModel;
import ui.grafico.Views.FinalView;
import ui.grafico.Views.MainView;

import javax.swing.*;
import java.awt.event.ActionListener;

public class FinalController {
    private FinalView finalView;
    private FinalModel finalModel;

    private ActionListener alIniciarNovoJogo;
    private ActionListener alSair;

    public FinalController(FinalModel finalModel, FinalView finalView)
    {
        this.finalModel = finalModel;
        this.finalView  = finalView;
        controllerActionListeners();
    }

    public void controllerActionListeners()
    {
        this.finalView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        alIniciarNovoJogo = actionEvent -> accaoIniciarNovoJogo();
        alSair = actionEvent -> accaoSair();

        this.finalView.getLabelIniciarJogo().addActionListener(alIniciarNovoJogo);
        this.finalView.getButtonSair().addActionListener(alSair);

        this.finalView.getLabelPontos().setText(Integer.toString(this.finalModel.getJogo().getJogoDados().calcPontosVitoria()));
    }

    private void accaoIniciarNovoJogo()
    {
        finalView.setVisible(false);
        Jogo jogo = new Jogo();
        jogo.iniciarJogo();
        MainModel model = new MainModel(jogo);
        MainView view = new MainView();
        view.setVisible(true);
        view.setResizable(false);
        MainController controller = new MainController(model, view);
        controller.controllerActionListeners();
    }

    private void accaoSair()
    {
        System.exit(0);
    }

}