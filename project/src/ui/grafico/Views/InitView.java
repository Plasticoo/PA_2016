package ui.grafico.Views;

import javax.swing.*;
import java.awt.*;

public class InitView extends JFrame {

    private JLabel labelTitle;

    private JButton buttonIniciarJogo;
    private JButton buttonCarregarJogo;
    private JButton buttonSairJogo;

    public InitView()
    {
        initView();
    }

    private void initView()
    {

        buttonIniciarJogo = new JButton();
        buttonCarregarJogo = new JButton();
        buttonSairJogo = new JButton();
        labelTitle = new JLabel();

        Container contentPane = getContentPane();

        buttonIniciarJogo.setText("Iniciar Jogo");
        buttonCarregarJogo.setText("Carregar Jogo");
        buttonSairJogo.setText("Sair");

        labelTitle.setText("Micro Space Empires");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(buttonSairJogo)
                                        .addComponent(buttonCarregarJogo)
                                        .addComponent(buttonIniciarJogo)
                                        .addComponent(labelTitle))
                                .addContainerGap(147, Short.MAX_VALUE))
        );

        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(labelTitle)
                                .addGap(46, 46, 46)
                                .addComponent(buttonIniciarJogo)
                                .addGap(18, 18, 18)
                                .addComponent(buttonCarregarJogo)
                                .addGap(18, 18, 18)
                                .addComponent(buttonSairJogo)
                                .addContainerGap(67, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
    }



    public JButton getButtonCarregarJogo() {
        return buttonCarregarJogo;
    }

    public void setButtonCarregarJogo(JButton buttonCarregarJogo) {
        this.buttonCarregarJogo = buttonCarregarJogo;
    }

    public JButton getButtonSairJogo() {
        return buttonSairJogo;
    }

    public void setButtonSairJogo(JButton buttonSairJogo) {
        this.buttonSairJogo = buttonSairJogo;
    }

    public JButton getButtonIniciarJogo() {
        return buttonIniciarJogo;
    }

    public void setButtonIniciarJogo(JButton buttonIniciarJogo) {
        this.buttonIniciarJogo = buttonIniciarJogo;
    }
}