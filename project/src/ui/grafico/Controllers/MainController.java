package ui.grafico.Controllers;


import logicaJogo.Sistemas.MSESystem;
import logicaJogo.States.*;
import logicaJogo.Utils;
import ui.grafico.Models.FinalModel;
import ui.grafico.Models.MainModel;
import ui.grafico.Views.FinalView;
import ui.grafico.Views.InfoTecView;
import ui.grafico.Views.MainView;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

public class MainController {

    private MainModel mainModel;
    private MainView mainView;

    ActionListener alExplorar;
    ActionListener alConquistar;
    ActionListener alPassar;
    ActionListener alTrocar;
    ActionListener alAumentarForcaMilitar;
    ActionListener alComprarTecnologia;
    ActionListener alMostrarInfoTec;

    public MainModel getMainModel() {
        return mainModel;
    }

    public void setMainModel(MainModel mainModel) {
        this.mainModel = mainModel;
    }

    public MainView getMainView() {
        return mainView;
    }

    public void setMainView(MainView mainView) {
        this.mainView = mainView;
    }

    public MainController(MainModel model, MainView view)
    {
        this.mainModel = model;
        this.mainView = view;
    }

    public void controllerActionListeners()
    {
        this.mainView.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.mainView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we)
            {
                String ObjButtons[] = {"Gravar e Sair", "Sair", "Cancelar"};

                int PromptResult = JOptionPane.showOptionDialog(null,
                        "Tem a certeza que deseja sair?",
                        "Micro Space Empire",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,
                        ObjButtons,
                        ObjButtons[1]);

                if(PromptResult == 0)
                {
                    Utils.gravarJogo(getMainModel().getJogo().getJogoDados());
                    System.exit(0);
                }
                else if(PromptResult == 1)
                {
                    System.exit(0);
                }
            }
        });

        actualizarLabels();

        this.mainView.getBotaoForcaMilitar().setEnabled(false);
        this.mainView.getBotaoTecnologia().setEnabled(false);
        this.mainView.getBotaoTrocar().setEnabled(false);

        this.alExplorar = actionEvent -> accaoExplorar();
        this.alConquistar = actionEvent -> accaoConquistar();
        this.alPassar = actionEvent -> accaoPassar();
        this.alTrocar = actionEvent -> accaoTrocar();
        this.alAumentarForcaMilitar = actionEvent -> accaoAumentarForcaMilitar();
        this.alComprarTecnologia = actionEvent -> accaoComprarTecnologia();
        this.alMostrarInfoTec = actionEvent -> accaoMostrarInfoTec();

        this.mainView.getBotaoExplorarAtacar().addActionListener(alExplorar);
        this.mainView.getBotaoConquistar().addActionListener(alConquistar);
        this.mainView.getBotaoPassar().addActionListener(alPassar);
        this.mainView.getBotaoTrocar().addActionListener(alTrocar);
        this.mainView.getBotaoForcaMilitar().addActionListener(alAumentarForcaMilitar);
        this.mainView.getBotaoTecnologia().addActionListener(alComprarTecnologia);
        this.mainView.getBotaoInfoTec().addActionListener(alMostrarInfoTec);

        // action listener para JList

        this.mainView.getListSistemasPorConquistar().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()){
                    JList jListSource = (JList)event.getSource();
                    String objSelectionado = jListSource.getSelectedValue().toString();
                    //System.out.println(objSelectionado);
                    try {
                        if(objSelectionado.equals("Canopus"))
                        {
                            getMainView().getLabelImagemCarta().setIcon(new ImageIcon(ImageIO.read(new FileInputStream("imagens/Sistema/Canopus.png"))));
                        }
                        else if(objSelectionado.equals("Cygnus"))
                        {
                            getMainView().getLabelImagemCarta().setIcon(new ImageIcon(ImageIO.read(new FileInputStream("imagens/Sistema/Cygnus.png"))));
                        }
                        else if(objSelectionado.equals("Epsilon Eridani"))
                        {
                            getMainView().getLabelImagemCarta().setIcon(new ImageIcon(ImageIO.read(new FileInputStream("imagens/Sistema/EpsilonEridani.png"))));
                        }
                        else if(objSelectionado.equals("Galaxy's Edge"))
                        {
                            getMainView().getLabelImagemCarta().setIcon(new ImageIcon(ImageIO.read(new FileInputStream("imagens/Sistema/GalaxysEdge.png"))));
                        }
                        else if(objSelectionado.equals("Polaris"))
                        {
                            getMainView().getLabelImagemCarta().setIcon(new ImageIcon(ImageIO.read(new FileInputStream("imagens/Sistema/Polaris.png"))));
                        }
                        else if(objSelectionado.equals("Procyon"))
                        {
                            getMainView().getLabelImagemCarta().setIcon(new ImageIcon(ImageIO.read(new FileInputStream("imagens/Sistema/Procyon.png"))));
                        }
                        else if(objSelectionado.equals("Proxima"))
                        {
                            getMainView().getLabelImagemCarta().setIcon(new ImageIcon(ImageIO.read(new FileInputStream("imagens/Sistema/Proxima.png"))));
                        }
                        else if(objSelectionado.equals("Sirius"))
                        {
                            getMainView().getLabelImagemCarta().setIcon(new ImageIcon(ImageIO.read(new FileInputStream("imagens/Sistema/Sirius.png"))));
                        }
                        else if(objSelectionado.equals("Tau Ceti"))
                        {
                            getMainView().getLabelImagemCarta().setIcon(new ImageIcon(ImageIO.read(new FileInputStream("imagens/Sistema/TauCeti.png"))));
                        }
                        else if(objSelectionado.equals("Wolf 359"))
                        {
                            getMainView().getLabelImagemCarta().setIcon(new ImageIcon(ImageIO.read(new FileInputStream("imagens/Sistema/Wolf359.png"))));
                        }
                    } catch (Exception ignored) {}
                }
            }
        });
    }

    private void iniciaFim()
    {
        if(isFim()) {
            this.getMainView().setVisible(false);
            FinalModel model = new FinalModel(this.mainModel.getJogo());
            FinalView view = new FinalView();
            view.setVisible(true);
            view.setResizable(false);
            FinalController controller = new FinalController(model, view);
            controller.controllerActionListeners();
        }
    }

    private boolean isFim()
    {
        if(Objects.equals(this.getMainModel().getJogo().getJogoDados().getUltimoEvento(), "Revolta")
                && this.getMainModel().getJogo().getJogoDados().getAno() == 2)
            return true;
        else if (this.getMainModel().getJogo().getJogoDados().eventosTodosUsados() &&
                this.getMainModel().getJogo().getJogoDados().getAno() == 2)
            return true;

        else return false;
    }

    private void actualizarLabels()
    {
        this.mainView.getLabelQuantidadeRiqueza().setText(String.valueOf(this.mainModel.getJogo().getJogoDados().getPontosRiqueza()));
        this.mainView.getLabelQuantidadeMetal().setText(String.valueOf(this.mainModel.getJogo().getJogoDados().getPontosMetal()));
        this.mainView.getLabelProducaoRiqueza().setText(String.valueOf(this.mainModel.getJogo().getJogoDados().getProducaoRiqueza()));
        this.mainView.getLabelProducaoMetal().setText(String.valueOf(this.mainModel.getJogo().getJogoDados().getProducaoMetal()));
        this.mainView.getLabelForcaMilitar().setText(String.valueOf(this.mainModel.getJogo().getJogoDados().getPontosMilitar()));
    }

    private void actualizarTecnologias()
    {
        this.mainView.getListTecnPorComprar().setListData(
                this.mainModel.getJogo().getJogoDados().getTecnologiasPossiveisDeComprar()
        );
    }

    private void atualizarSistemasConquistados()
    {
        this.mainView.getTextAreaSistemas().setText(this.mainModel.getJogo().getJogoDados().getSistemasConquistados());
    }

    private void actualizarSistemas()
    {
        this.mainView.getListSistemasPorConquistar().setListData(
                this.mainModel.getJogo().getJogoDados().getArrayNaoConquistados()
        );
    }

    private void actualizarEventos()
    {
        this.mainView.getTextAreaEventos().setText(
            this.mainModel.getJogo().getJogoDados().getUltimoEvento()
        );
    }

    private void accaoMostrarInfoTec()
    {
        InfoTecView infoView = new InfoTecView();
        infoView.setVisible(true);
        infoView.setResizable(false);
        InfoTecController infoController = new InfoTecController(infoView);
        iniciaFim();
    }

    private void accaoExplorar()
    {
        iniciaFim();
        this.mainModel.getJogo().iniciarExplorarAtacar(1);

        if(this.mainView.getComboBoxTipoSistema().getSelectedIndex() == 0)
            this.mainModel.getJogo().iniciarExplorarAtacar(1);
        if(this.mainView.getComboBoxTipoSistema().getSelectedIndex() == 1)
            this.mainModel.getJogo().iniciarExplorarAtacar(2);


        this.mainView.getBotaoExplorarAtacar().setEnabled(false);
        this.mainView.getBotaoConquistar().setEnabled(false);

        if(this.mainModel.getJogo().getJogoDados().existsTecnology("Interspecies Commerce"))
        {
            this.mainView.getBotaoTrocar().setEnabled(true);
        }

        actualizarLabels();
        actualizarTecnologias();
        actualizarSistemas();
        atualizarSistemasConquistados();

    }
    private void accaoConquistar()
    {
        iniciaFim();
        if(this.mainView.getListSistemasPorConquistar().getSelectedIndex() >= 0)
        {
            if(this.mainModel.getJogo().getJogoDados().existsTecnology("Interspecies Commerce"))
            {
                this.mainView.getBotaoTrocar().setEnabled(true);
            }

            String sysName = this.mainView.getListSistemasPorConquistar().getSelectedValue();

            this.mainModel.getJogo().iniciarConquistar(sysName);

            this.mainView.getBotaoExplorarAtacar().setEnabled(false);
            this.mainView.getBotaoConquistar().setEnabled(false);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "ERRO: Tem de seleccionar uma tecnologia da lista.");
        }

        actualizarLabels();
        actualizarTecnologias();
        actualizarSistemas();
        atualizarSistemasConquistados();
    }

    private void accaoTrocar()
    {
        iniciaFim();
        if(this.mainView.getComboBoxTrocar().getSelectedIndex() == 0)
        {
            this.mainModel.getJogo().iniciarTrocar("metal");
        }
        else
        {
            this.mainModel.getJogo().iniciarTrocar("riqueza");
        }

        this.mainView.getBotaoTrocar().setEnabled(false);
        this.mainView.getBotaoForcaMilitar().setEnabled(true);
        this.mainView.getBotaoForcaMilitar().setEnabled(true);

        actualizarLabels();
        actualizarTecnologias();
        actualizarSistemas();
        atualizarSistemasConquistados();
    }

    private void accaoAumentarForcaMilitar()
    {
        iniciaFim();
        this.mainModel.getJogo().iniciarForcaMilitar();

        this.mainView.getBotaoForcaMilitar().setEnabled(false);
        this.mainView.getBotaoTecnologia().setEnabled(false);

        this.mainView.getBotaoExplorarAtacar().setEnabled(true);
        this.mainView.getBotaoConquistar().setEnabled(true);

        System.out.println(this.mainModel.getJogo().getJogoDados().getPontosMilitar());

        actualizarTecnologias();
        actualizarLabels();
        actualizarSistemas();
        actualizarEventos();
        atualizarSistemasConquistados();
    }

    private void accaoComprarTecnologia()
    {
        iniciaFim();
        if(this.mainView.getListTecnPorComprar().getSelectedIndex() >= 0)
        {
            String tecName = this.mainView.getListTecnPorComprar().getSelectedValue();

            this.mainModel.getJogo().iniciarDTecnologia(tecName, false);
            this.mainView.getTextAreaTecnologias().append(tecName + "\n");

            this.mainView.getBotaoForcaMilitar().setEnabled(false);
            this.mainView.getBotaoTecnologia().setEnabled(false);

            this.mainView.getBotaoExplorarAtacar().setEnabled(true);
            this.mainView.getBotaoConquistar().setEnabled(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "ERRO: Tem de seleccionar uma tecnologia da lista.");
        }

        actualizarTecnologias();
        actualizarLabels();
        actualizarSistemas();
        actualizarEventos();
        atualizarSistemasConquistados();
    }

    private void accaoPassar()
    {
        iniciaFim();
        if(this.mainModel.getJogo().getStates() instanceof Trocar) {
            this.mainModel.getJogo().iniciarTrocar("salta");
            this.mainView.getBotaoForcaMilitar().setEnabled(true);
            this.mainView.getBotaoTecnologia().setEnabled(true);
            this.mainView.getBotaoTrocar().setEnabled(false);
        }
        else if(this.mainModel.getJogo().getStates() instanceof ExplorarAtacarConquistarPassar)
        {
            if(this.mainModel.getJogo().getJogoDados().existsTecnology("Interspecies Commerce"))
            {
                this.mainView.getBotaoTrocar().setEnabled(true);
            }
            this.mainView.getBotaoConquistar().setEnabled(false);
            this.mainView.getBotaoExplorarAtacar().setEnabled(false);
            this.mainModel.getJogo().iniciarPassar();
        }
        else if(this.mainModel.getJogo().getStates() instanceof MilitarTecnologia)
        {
            this.mainView.getBotaoForcaMilitar().setEnabled(false);
            this.mainView.getBotaoTecnologia().setEnabled(false);
            this.mainView.getBotaoConquistar().setEnabled(true);
            this.mainView.getBotaoExplorarAtacar().setEnabled(true);
            this.mainModel.getJogo().iniciarDTecnologia(null, true);
        }

        actualizarLabels();
        actualizarTecnologias();
        actualizarSistemas();
        actualizarEventos();
        atualizarSistemasConquistados();
    }

    public ActionListener getAlMostrarInfoTec() {
        return alMostrarInfoTec;
    }

    public void setAlMostrarInfoTec(ActionListener alMostrarInfoTec) {
        this.alMostrarInfoTec = alMostrarInfoTec;
    }

    public ActionListener getAlComprarTecnologia() {
        return alComprarTecnologia;
    }

    public void setAlComprarTecnologia(ActionListener alComprarTecnologia) {
        this.alComprarTecnologia = alComprarTecnologia;
    }

    public ActionListener getAlAumentarForcaMilitar() {
        return alAumentarForcaMilitar;
    }

    public void setAlAumentarForcaMilitar(ActionListener alAumentarForcaMilitar) {
        this.alAumentarForcaMilitar = alAumentarForcaMilitar;
    }

    public ActionListener getAlTrocar() {
        return alTrocar;
    }

    public void setAlTrocar(ActionListener alTrocar) {
        this.alTrocar = alTrocar;
    }

    public ActionListener getAlPassar() {
        return alPassar;
    }

    public void setAlPassar(ActionListener alPassar) {
        this.alPassar = alPassar;
    }

    public ActionListener getAlConquistar() {
        return alConquistar;
    }

    public void setAlConquistar(ActionListener alConquistar) {
        this.alConquistar = alConquistar;
    }

    public ActionListener getAlExplorar() {
        return alExplorar;
    }

    public void setAlExplorar(ActionListener alExplorar) {
        this.alExplorar = alExplorar;
    }
}
