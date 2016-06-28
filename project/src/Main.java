import logicaJogo.Jogo;
import ui.grafico.Controllers.FinalController;
import ui.grafico.Controllers.InitController;
import ui.grafico.Controllers.MainController;
import ui.grafico.Models.FinalModel;
import ui.grafico.Models.InitModel;
import ui.grafico.Models.MainModel;
import ui.grafico.Views.*;
import ui.grafico.Views.InitView;
import ui.grafico.Views.MainView;
import ui.texto.IUTexto;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
//        IUTexto ui = new IUTexto(new Jogo());
//        ui.corre();
        SwingUtilities.invokeLater(() -> {
            InitModel model = new InitModel(new Jogo());

            InitView view = new InitView();
            view.setVisible(true);
            //view.setBackground(new Color(0, 128, 128));

            InitController controller = new InitController(model,view);

            controller.controllerActionListeners();
        });
    }



}
