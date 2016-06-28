package ui.grafico.Views;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.GroupLayout;

public class InfoTecView extends JFrame {

    private JLabel imageLabel;

    public InfoTecView()
    {
        initComponents();
    }

    private void initComponents()
    {
        imageLabel = new JLabel();

        Container contentPane = getContentPane();

        imageLabel.setText("");

        try {
            imageLabel.setIcon(new ImageIcon(ImageIO.read(new FileInputStream("imagens/back/infotec.png"))));
        } catch (IOException ignore) {}

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(imageLabel, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(imageLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(getOwner());
    }
}
