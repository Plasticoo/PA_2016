package ui.grafico.Controllers;


import logicaJogo.Dados.DadosJogo;
import logicaJogo.Utils;
import ui.grafico.Models.InitModel;
import ui.grafico.Models.MainModel;
import ui.grafico.Views.InitView;
import ui.grafico.Views.MainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class InitController {

    private InitModel init_model;
    private InitView init_view;

    private ActionListener alIniciarJogo;
    private ActionListener alCarregarJogo;
    private ActionListener alSair;

    public InitController(InitModel model, InitView view){
        this.init_model = model;
        this.init_view = view;
    }

    public void controllerActionListeners()
    {
        this.init_view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        alIniciarJogo = actionEvent -> accaoIniciarJogo();
        alCarregarJogo = actionEvent -> accaoCarregarJogo();
        alSair = actionEvent -> accaoSair();

        init_view.getButtonIniciarJogo().addActionListener(alIniciarJogo);
        init_view.getButtonCarregarJogo().addActionListener(alCarregarJogo);
        init_view.getButtonSairJogo().addActionListener(alSair);
    }

    private void accaoIniciarJogo()
    {
        this.init_model.getJogo().iniciarJogo();

        init_view.setVisible(false);

        MainModel model = new MainModel(this.init_model.getJogo());
        MainView view = new MainView();
        view.setVisible(true);
        view.setResizable(false);
        MainController controller = new MainController(model, view);
        controller.controllerActionListeners();
    }



    private void accaoCarregarJogo()
    {
        DadosJogo dados = Utils.carregarJogo();

        this.init_model.getJogo().carregarJogo(dados);
        this.init_model.getJogo().setJogoDados(dados);

        init_view.setVisible(false);

        MainModel model = new MainModel(this.init_model.getJogo());
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