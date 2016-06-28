package ui.grafico.Controllers;


import ui.grafico.Views.InfoTecView;

import javax.swing.*;

public class InfoTecController {

    private InfoTecView infoTecView;

    public InfoTecController(InfoTecView view){
        this.infoTecView = view;
    }

    public void controllerActionListeners()
    {
        this.infoTecView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
