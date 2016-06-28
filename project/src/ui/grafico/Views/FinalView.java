/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.grafico.Views;

import javax.swing.*;

public class FinalView extends JFrame {

    private JButton labelIniciarJogo;
    private JButton buttonSair;
    private JDialog jDialog1;
    private JLabel labelPontosText;
    private JLabel labelPontos;

    public FinalView()
    {
        initComponents();
    }

    private void initComponents()
    {

        jDialog1 = new JDialog();
        labelIniciarJogo = new JButton();
        buttonSair = new JButton();
        labelPontosText = new JLabel();
        labelPontos = new JLabel();

        this.setLocationRelativeTo(null);

        GroupLayout jDialog1Layout = new GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
                jDialog1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
                jDialog1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        labelIniciarJogo.setText("Iniciar Novo Jogo");

        buttonSair.setText("Sair");

        labelPontosText.setText("Pontos: ");

        labelPontos.setText("0");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(143, 143, 143)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(labelIniciarJogo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(buttonSair, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addComponent(labelPontosText)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(labelPontos)))
                                .addContainerGap(142, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelPontosText)
                                        .addComponent(labelPontos))
                                .addGap(61, 61, 61)
                                .addComponent(labelIniciarJogo, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonSair)
                                .addContainerGap(151, Short.MAX_VALUE))
        );

        pack();

        this.setVisible(true);
    }

    public JLabel getLabelPontos() {
        return labelPontos;
    }

    public void setLabelPontos(JLabel labelPontos) {
        this.labelPontos = labelPontos;
    }

    public JLabel getLabelPontosText() {
        return labelPontosText;
    }

    public void setLabelPontosText(JLabel labelPontosText) {
        this.labelPontosText = labelPontosText;
    }

    public JDialog getjDialog1() {
        return jDialog1;
    }

    public void setjDialog1(JDialog jDialog1) {
        this.jDialog1 = jDialog1;
    }

    public JButton getButtonSair() {
        return buttonSair;
    }

    public void setButtonSair(JButton buttonSair) {
        this.buttonSair = buttonSair;
    }

    public JButton getLabelIniciarJogo() {
        return labelIniciarJogo;
    }

    public void setLabelIniciarJogo(JButton labelIniciarJogo) {
        this.labelIniciarJogo = labelIniciarJogo;
    }
}
