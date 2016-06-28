package ui.grafico.Views;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.border.*;


public class MainView extends JFrame {

    private JPanel panelComandos;
    private JButton botaoConquistar;
    private JButton botaoExplorarAtacar;
    private JButton botaoPassar;
    private JButton botaoForcaMilitar;
    private JButton botaoTecnologia;
    private JButton botaoTrocar;
    private JPanel panelInfo;
    private JLabel labelTextoQMetal;
    private JLabel labelTextoQRiqueza;
    private JLabel labelTextoForcaMil;
    private JLabel labelTextoProdMetal;
    private JLabel labelTextoProdRiqueza;
    private JLabel labelTextoTecnologias;
    private JScrollPane scrollPane1;
    private JTextArea textAreaTecnologias;
    private JLabel labelTextoSistemas;
    private JScrollPane scrollSistemas;
    private JTextArea textAreaSistemas;
    private JLabel labelQuantidadeMetal;
    private JLabel labelQuantidadeRiqueza;
    private JLabel labelForcaMilitar;
    private JLabel labelProducaoMetal;
    private JLabel labelProducaoRiqueza;
    private JButton botaoInfoTec;
    private JLabel labelTextoEventos;
    private JScrollPane scrollEventos;
    private JTextArea textAreaEventos;
    private JLabel labelTextoAno;
    private JLabel labelTextoDado;
    private JLabel labelAno;
    private JLabel labelDado;
    private JPanel panelOpcoes;
    private JComboBox<String> comboBoxTipoSistema;
    private JLabel labelTextoTipoSys;
    private JScrollPane scrollTecPorComprar;
    private JList<String> listTecnPorComprar;
    private JScrollPane scrollSysPorConq;
    private JList<String> listSistemasPorConquistar;
    private JLabel labelTextoSysPorConq;
    private JLabel labelTextoTecPorComprar;
    private JLabel labelImagemCarta;
    private JPanel panelTroca;
    private JComboBox<String> comboBoxTrocar;

    public MainView()
    {
        initComponents();
    }

    private void initComponents()
    {
        panelComandos = new JPanel();
        botaoConquistar = new JButton();
        botaoExplorarAtacar = new JButton();
        botaoPassar = new JButton();
        botaoForcaMilitar = new JButton();
        botaoTecnologia = new JButton();
        botaoTrocar = new JButton();
        panelInfo = new JPanel();
        labelTextoQMetal = new JLabel();
        labelTextoQRiqueza = new JLabel();
        labelTextoForcaMil = new JLabel();
        labelTextoProdMetal = new JLabel();
        labelTextoProdRiqueza = new JLabel();
        labelTextoTecnologias = new JLabel();
        scrollPane1 = new JScrollPane();
        textAreaTecnologias = new JTextArea();
        labelTextoSistemas = new JLabel();
        scrollSistemas = new JScrollPane();
        textAreaSistemas = new JTextArea();
        labelQuantidadeMetal = new JLabel();
        labelQuantidadeRiqueza = new JLabel();
        labelForcaMilitar = new JLabel();
        labelProducaoMetal = new JLabel();
        labelProducaoRiqueza = new JLabel();
        botaoInfoTec = new JButton();
        labelTextoEventos = new JLabel();
        scrollEventos = new JScrollPane();
        textAreaEventos = new JTextArea();
        labelTextoAno = new JLabel();
        labelTextoDado = new JLabel();
        labelAno = new JLabel();
        labelDado = new JLabel();
        panelOpcoes = new JPanel();
        comboBoxTipoSistema = new JComboBox<>();
        labelTextoTipoSys = new JLabel();
        scrollTecPorComprar = new JScrollPane();
        listTecnPorComprar = new JList<>();
        scrollSysPorConq = new JScrollPane();
        listSistemasPorConquistar = new JList<>();
        labelTextoSysPorConq = new JLabel();
        labelTextoTecPorComprar = new JLabel();
        labelImagemCarta = new JLabel();
        panelTroca = new JPanel();
        comboBoxTrocar = new JComboBox<>();

        Container contentPane = getContentPane();

        panelComandos.setBorder(new CompoundBorder(
                    new TitledBorder("Comandos"),
                    new EmptyBorder(5, 5, 5, 5)));

        botaoConquistar.setText("Conquistar");
        botaoExplorarAtacar.setText("Explorar/Atacar");
        botaoPassar.setText("Passar");
        botaoForcaMilitar.setText("Aumentar Forca Militar");
        botaoTecnologia.setText("Aumentar Tecnologia");
        botaoTrocar.setText("Trocar");

        GroupLayout panelComandosLayout = new GroupLayout(panelComandos);

        panelComandos.setLayout(panelComandosLayout);

        panelComandosLayout.setHorizontalGroup(
                panelComandosLayout.createParallelGroup()
                        .addGroup(panelComandosLayout.createSequentialGroup()
                                .addGroup(panelComandosLayout.createParallelGroup()
                                        .addGroup(panelComandosLayout.createSequentialGroup()
                                                .addComponent(botaoForcaMilitar)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(botaoTecnologia))
                                        .addGroup(panelComandosLayout.createSequentialGroup()
                                                .addComponent(botaoExplorarAtacar, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(botaoConquistar)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(botaoPassar)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(botaoTrocar)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelComandosLayout.setVerticalGroup(
                panelComandosLayout.createParallelGroup()
                        .addGroup(panelComandosLayout.createSequentialGroup()
                                .addGroup(panelComandosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(botaoConquistar)
                                        .addComponent(botaoPassar)
                                        .addComponent(botaoExplorarAtacar, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botaoTrocar))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelComandosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(botaoForcaMilitar)
                                        .addComponent(botaoTecnologia))
                                .addContainerGap(22, Short.MAX_VALUE))
        );



        panelInfo.setBorder(new CompoundBorder(
                new TitledBorder("Informacao"),
                new EmptyBorder(5, 5, 5, 5)));

        labelTextoQMetal.setText("Quantidade Metal:");

        labelTextoQRiqueza.setText("Quantidade Riqueza:");

        labelTextoForcaMil.setText("Forca Militar:");

        labelTextoProdMetal.setText("Producao Metal:");

        labelTextoProdRiqueza.setText("Producao Riqueza:");

        labelTextoTecnologias.setText("Tecnologias:");

        textAreaTecnologias.setEditable(false);
        scrollPane1.setViewportView(textAreaTecnologias);

        labelTextoSistemas.setText("Sistemas:");

        textAreaSistemas.setEditable(false);
        scrollSistemas.setViewportView(textAreaSistemas);

        labelQuantidadeMetal.setText("0");
        labelQuantidadeRiqueza.setText("0");
        labelForcaMilitar.setText("0");
        labelProducaoMetal.setText("0");
        labelProducaoRiqueza.setText("0");
        botaoInfoTec.setText("?");
        labelTextoEventos.setText("Eventos:");

        textAreaEventos.setEditable(false);
        scrollEventos.setViewportView(textAreaEventos);

        labelTextoAno.setText("Ano:");
        labelTextoDado.setText("Dado:");
        labelAno.setText("0");
        labelDado.setText("0");

        GroupLayout panelInfoLayout = new GroupLayout(panelInfo);

        panelInfo.setLayout(panelInfoLayout);

        panelInfoLayout.setHorizontalGroup(
                panelInfoLayout.createParallelGroup()
                        .addGroup(panelInfoLayout.createSequentialGroup()
                                .addGroup(panelInfoLayout.createParallelGroup()
                                        .addComponent(labelTextoQMetal)
                                        .addComponent(labelTextoQRiqueza)
                                        .addComponent(labelTextoForcaMil)
                                        .addComponent(labelTextoProdMetal)
                                        .addComponent(labelTextoProdRiqueza))
                                .addGap(53, 53, 53)
                                .addGroup(panelInfoLayout.createParallelGroup()
                                        .addComponent(labelProducaoRiqueza, GroupLayout.Alignment.TRAILING)
                                        .addComponent(labelProducaoMetal, GroupLayout.Alignment.TRAILING)
                                        .addComponent(labelForcaMilitar, GroupLayout.Alignment.TRAILING)
                                        .addComponent(labelQuantidadeRiqueza, GroupLayout.Alignment.TRAILING)
                                        .addComponent(labelQuantidadeMetal, GroupLayout.Alignment.TRAILING))
                                .addGap(37, 37, 37)
                                .addGroup(panelInfoLayout.createParallelGroup()
                                        .addComponent(labelTextoAno)
                                        .addComponent(labelTextoDado))
                                .addGap(18, 18, 18)
                                .addGroup(panelInfoLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(labelAno)
                                        .addComponent(labelDado))
                                .addContainerGap(65, Short.MAX_VALUE))
                        .addGroup(panelInfoLayout.createSequentialGroup()
                                .addGroup(panelInfoLayout.createParallelGroup()
                                        .addGroup(panelInfoLayout.createSequentialGroup()
                                                .addComponent(labelTextoTecnologias)
                                                .addGap(4, 4, 4)
                                                .addComponent(botaoInfoTec))
                                        .addComponent(labelTextoSistemas)
                                        .addComponent(labelTextoEventos))
                                .addGap(18, 18, 18)
                                .addGroup(panelInfoLayout.createParallelGroup()
                                        .addComponent(scrollEventos, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                                        .addComponent(scrollSistemas)
                                        .addComponent(scrollPane1)))
        );

        panelInfoLayout.setVerticalGroup(
                panelInfoLayout.createParallelGroup()
                        .addGroup(panelInfoLayout.createSequentialGroup()
                                .addGroup(panelInfoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelTextoQMetal)
                                        .addComponent(labelQuantidadeMetal)
                                        .addComponent(labelTextoAno)
                                        .addComponent(labelAno))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelInfoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelTextoQRiqueza)
                                        .addComponent(labelQuantidadeRiqueza)
                                        .addComponent(labelTextoDado)
                                        .addComponent(labelDado))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelInfoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelTextoForcaMil)
                                        .addComponent(labelForcaMilitar))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelInfoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelTextoProdMetal)
                                        .addComponent(labelProducaoMetal))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelInfoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelTextoProdRiqueza)
                                        .addComponent(labelProducaoRiqueza))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelInfoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelTextoTecnologias)
                                        .addComponent(botaoInfoTec)
                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelInfoLayout.createParallelGroup()
                                        .addComponent(labelTextoSistemas)
                                        .addComponent(scrollSistemas, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addGroup(panelInfoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelTextoEventos)
                                        .addComponent(scrollEventos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        );

        panelOpcoes.setBorder(new CompoundBorder(
                new TitledBorder("Opcoes"),
                new EmptyBorder(5, 5, 5, 5)));

        comboBoxTipoSistema.setModel(new DefaultComboBoxModel<>(new String[] {
                "Near",
                "Distant"
        }));

        labelTextoTipoSys.setText("Tipo de Sistema:");

        scrollTecPorComprar.setViewportView(listTecnPorComprar);

        listSistemasPorConquistar.setSelectedIndex(1);
        scrollSysPorConq.setViewportView(listSistemasPorConquistar);

        labelTextoSysPorConq.setText("Sistemas por Conquistar:");

        labelTextoTecPorComprar.setText("Tecnologias por Comprar:");

        try {
            labelImagemCarta.setIcon(new ImageIcon(ImageIO.read(new FileInputStream("imagens/Sistema/Starting.png"))));
        } catch (IOException ignored){}

        {
            panelTroca.setBorder(new CompoundBorder(
                    new TitledBorder("Troca"),
                    new EmptyBorder(5, 5, 5, 5)));

            comboBoxTrocar.setModel(new DefaultComboBoxModel<>(new String[] {
                    "Metal por Riqueza",
                    "Riqueza por Metal"
            }));

            GroupLayout panelTrocaLayout = new GroupLayout(panelTroca);

            panelTroca.setLayout(panelTrocaLayout);
            panelTrocaLayout.setHorizontalGroup(
                    panelTrocaLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panelTrocaLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(comboBoxTrocar, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                    .addContainerGap())
            );
            panelTrocaLayout.setVerticalGroup(
                    panelTrocaLayout.createParallelGroup()
                            .addGroup(panelTrocaLayout.createSequentialGroup()
                                    .addComponent(comboBoxTrocar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
            );
        }

        GroupLayout panelOpcoesLayout = new GroupLayout(panelOpcoes);

        panelOpcoes.setLayout(panelOpcoesLayout);

        panelOpcoesLayout.setHorizontalGroup(
                panelOpcoesLayout.createParallelGroup()
                        .addGroup(panelOpcoesLayout.createSequentialGroup()
                                .addGroup(panelOpcoesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(panelOpcoesLayout.createSequentialGroup()
                                                .addComponent(labelTextoTipoSys)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(comboBoxTipoSistema, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(labelTextoSysPorConq)
                                        .addComponent(scrollSysPorConq, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                        .addComponent(scrollTecPorComprar, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                        .addComponent(labelTextoTecPorComprar)
                                        .addComponent(panelTroca, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                                .addComponent(labelImagemCarta)
                                .addGap(35, 35, 35))
        );

        panelOpcoesLayout.setVerticalGroup(
                panelOpcoesLayout.createParallelGroup()
                        .addGroup(panelOpcoesLayout.createSequentialGroup()
                                .addComponent(labelImagemCarta)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(panelOpcoesLayout.createSequentialGroup()
                                .addGroup(panelOpcoesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelTextoTipoSys)
                                        .addComponent(comboBoxTipoSistema, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelTextoSysPorConq)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollSysPorConq, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelTextoTecPorComprar)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollTecPorComprar, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelTroca, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);

        contentPane.setLayout(contentPaneLayout);

        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(panelInfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(panelComandos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelOpcoes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(panelOpcoes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(panelInfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(panelComandos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(9, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
    }

    public JPanel getPanelComandos() {
        return panelComandos;
    }

    public void setPanelComandos(JPanel panelComandos) {
        this.panelComandos = panelComandos;
    }

    public JButton getBotaoConquistar() {
        return botaoConquistar;
    }

    public void setBotaoConquistar(JButton botaoConquistar) {
        this.botaoConquistar = botaoConquistar;
    }

    public JButton getBotaoExplorarAtacar() {
        return botaoExplorarAtacar;
    }

    public void setBotaoExplorarAtacar(JButton botaoExplorarAtacar) {
        this.botaoExplorarAtacar = botaoExplorarAtacar;
    }

    public JButton getBotaoPassar() {
        return botaoPassar;
    }

    public void setBotaoPassar(JButton botaoPassar) {
        this.botaoPassar = botaoPassar;
    }

    public JButton getBotaoForcaMilitar() {
        return botaoForcaMilitar;
    }

    public void setBotaoForcaMilitar(JButton botaoForcaMilitar) {
        this.botaoForcaMilitar = botaoForcaMilitar;
    }

    public JButton getBotaoTecnologia() {
        return botaoTecnologia;
    }

    public void setBotaoTecnologia(JButton botaoTecnologia) {
        this.botaoTecnologia = botaoTecnologia;
    }

    public JButton getBotaoTrocar() {
        return botaoTrocar;
    }

    public void setBotaoTrocar(JButton botaoTrocar) {
        this.botaoTrocar = botaoTrocar;
    }

    public JPanel getPanelInfo() {
        return panelInfo;
    }

    public void setPanelInfo(JPanel panelInfo) {
        this.panelInfo = panelInfo;
    }

    public JLabel getLabelTextoQMetal() {
        return labelTextoQMetal;
    }

    public void setLabelTextoQMetal(JLabel labelTextoQMetal) {
        this.labelTextoQMetal = labelTextoQMetal;
    }

    public JLabel getLabelTextoQRiqueza() {
        return labelTextoQRiqueza;
    }

    public void setLabelTextoQRiqueza(JLabel labelTextoQRiqueza) {
        this.labelTextoQRiqueza = labelTextoQRiqueza;
    }

    public JLabel getLabelTextoForcaMil() {
        return labelTextoForcaMil;
    }

    public void setLabelTextoForcaMil(JLabel labelTextoForcaMil) {
        this.labelTextoForcaMil = labelTextoForcaMil;
    }

    public JLabel getLabelTextoProdMetal() {
        return labelTextoProdMetal;
    }

    public void setLabelTextoProdMetal(JLabel labelTextoProdMetal) {
        this.labelTextoProdMetal = labelTextoProdMetal;
    }

    public JLabel getLabelTextoProdRiqueza() {
        return labelTextoProdRiqueza;
    }

    public void setLabelTextoProdRiqueza(JLabel labelTextoProdRiqueza) {
        this.labelTextoProdRiqueza = labelTextoProdRiqueza;
    }

    public JLabel getLabelTextoTecnologias() {
        return labelTextoTecnologias;
    }

    public void setLabelTextoTecnologias(JLabel labelTextoTecnologias) {
        this.labelTextoTecnologias = labelTextoTecnologias;
    }

    public JScrollPane getScrollPane1() {
        return scrollPane1;
    }

    public void setScrollPane1(JScrollPane scrollPane1) {
        this.scrollPane1 = scrollPane1;
    }

    public JTextArea getTextAreaTecnologias() {
        return textAreaTecnologias;
    }

    public void setTextAreaTecnologias(JTextArea textAreaTecnologias) {
        this.textAreaTecnologias = textAreaTecnologias;
    }

    public JLabel getLabelTextoSistemas() {
        return labelTextoSistemas;
    }

    public void setLabelTextoSistemas(JLabel labelTextoSistemas) {
        this.labelTextoSistemas = labelTextoSistemas;
    }

    public JScrollPane getScrollSistemas() {
        return scrollSistemas;
    }

    public void setScrollSistemas(JScrollPane scrollSistemas) {
        this.scrollSistemas = scrollSistemas;
    }

    public JTextArea getTextAreaSistemas() {
        return textAreaSistemas;
    }

    public void setTextAreaSistemas(JTextArea textAreaSistemas) {
        this.textAreaSistemas = textAreaSistemas;
    }

    public JLabel getLabelQuantidadeMetal() {
        return labelQuantidadeMetal;
    }

    public void setLabelQuantidadeMetal(JLabel labelQuantidadeMetal) {
        this.labelQuantidadeMetal = labelQuantidadeMetal;
    }

    public JLabel getLabelQuantidadeRiqueza() {
        return labelQuantidadeRiqueza;
    }

    public void setLabelQuantidadeRiqueza(JLabel labelQuantidadeRiqueza) {
        this.labelQuantidadeRiqueza = labelQuantidadeRiqueza;
    }

    public JLabel getLabelForcaMilitar() {
        return labelForcaMilitar;
    }

    public void setLabelForcaMilitar(JLabel labelForcaMilitar) {
        this.labelForcaMilitar = labelForcaMilitar;
    }

    public JLabel getLabelProducaoMetal() {
        return labelProducaoMetal;
    }

    public void setLabelProducaoMetal(JLabel labelProducaoMetal) {
        this.labelProducaoMetal = labelProducaoMetal;
    }

    public JLabel getLabelProducaoRiqueza() {
        return labelProducaoRiqueza;
    }

    public void setLabelProducaoRiqueza(JLabel labelProducaoRiqueza) {
        this.labelProducaoRiqueza = labelProducaoRiqueza;
    }

    public JButton getBotaoInfoTec() {
        return botaoInfoTec;
    }

    public void setBotaoInfoTec(JButton botaoInfoTec) {
        this.botaoInfoTec = botaoInfoTec;
    }

    public JLabel getLabelTextoEventos() {
        return labelTextoEventos;
    }

    public void setLabelTextoEventos(JLabel labelTextoEventos) {
        this.labelTextoEventos = labelTextoEventos;
    }

    public JScrollPane getScrollEventos() {
        return scrollEventos;
    }

    public void setScrollEventos(JScrollPane scrollEventos) {
        this.scrollEventos = scrollEventos;
    }

    public JTextArea getTextAreaEventos() {
        return textAreaEventos;
    }

    public void setTextAreaEventos(JTextArea textAreaEventos) {
        this.textAreaEventos = textAreaEventos;
    }

    public JLabel getLabelTextoAno() {
        return labelTextoAno;
    }

    public void setLabelTextoAno(JLabel labelTextoAno) {
        this.labelTextoAno = labelTextoAno;
    }

    public JLabel getLabelTextoDado() {
        return labelTextoDado;
    }

    public void setLabelTextoDado(JLabel labelTextoDado) {
        this.labelTextoDado = labelTextoDado;
    }

    public JLabel getLabelAno() {
        return labelAno;
    }

    public void setLabelAno(JLabel labelAno) {
        this.labelAno = labelAno;
    }

    public JLabel getLabelDado() {
        return labelDado;
    }

    public void setLabelDado(JLabel labelDado) {
        this.labelDado = labelDado;
    }

    public JPanel getPanelOpcoes() {
        return panelOpcoes;
    }

    public void setPanelOpcoes(JPanel panelOpcoes) {
        this.panelOpcoes = panelOpcoes;
    }

    public JComboBox<String> getComboBoxTipoSistema() {
        return comboBoxTipoSistema;
    }

    public void setComboBoxTipoSistema(JComboBox<String> comboBoxTipoSistema) {
        this.comboBoxTipoSistema = comboBoxTipoSistema;
    }

    public JLabel getLabelTextoTipoSys() {
        return labelTextoTipoSys;
    }

    public void setLabelTextoTipoSys(JLabel labelTextoTipoSys) {
        this.labelTextoTipoSys = labelTextoTipoSys;
    }

    public JScrollPane getScrollTecPorComprar() {
        return scrollTecPorComprar;
    }

    public void setScrollTecPorComprar(JScrollPane scrollTecPorComprar) {
        this.scrollTecPorComprar = scrollTecPorComprar;
    }

    public JList<String> getListTecnPorComprar() {
        return listTecnPorComprar;
    }

    public void setListTecnPorComprar(JList<String> listTecnPorComprar) {
        this.listTecnPorComprar = listTecnPorComprar;
    }

    public JScrollPane getScrollSysPorConq() {
        return scrollSysPorConq;
    }

    public void setScrollSysPorConq(JScrollPane scrollSysPorConq) {
        this.scrollSysPorConq = scrollSysPorConq;
    }

    public JList<String> getListSistemasPorConquistar() {
        return listSistemasPorConquistar;
    }

    public void setListSistemasPorConquistar(JList<String> listSistemasPorConquistar) {
        this.listSistemasPorConquistar = listSistemasPorConquistar;
    }

    public JLabel getLabelTextoSysPorConq() {
        return labelTextoSysPorConq;
    }

    public void setLabelTextoSysPorConq(JLabel labelTextoSysPorConq) {
        this.labelTextoSysPorConq = labelTextoSysPorConq;
    }

    public JLabel getLabelTextoTecPorComprar() {
        return labelTextoTecPorComprar;
    }

    public void setLabelTextoTecPorComprar(JLabel labelTextoTecPorComprar) {
        this.labelTextoTecPorComprar = labelTextoTecPorComprar;
    }

    public JLabel getLabelImagemCarta() {
        return labelImagemCarta;
    }

    public void setLabelImagemCarta(JLabel labelImagemCarta) {
        this.labelImagemCarta = labelImagemCarta;
    }

    public JPanel getPanelTroca() {
        return panelTroca;
    }

    public void setPanelTroca(JPanel panelTroca) {
        this.panelTroca = panelTroca;
    }

    public JComboBox<String> getComboBoxTrocar() {
        return comboBoxTrocar;
    }

    public void setComboBoxTrocar(JComboBox<String> comboBoxTrocar) {
        this.comboBoxTrocar = comboBoxTrocar;
    }
}