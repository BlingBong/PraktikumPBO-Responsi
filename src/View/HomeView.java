package View;

import Controller.InputController;
import Controller.OutputController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeView extends JFrame implements ActionListener {
    private JPanel panelHome;
    private JButton btnTambah;
    private JButton btnLihat;

    public HomeView() {
        setTitle("HOME");
        btnTambah.addActionListener(this);
        btnLihat.addActionListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelHome);
        this.pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()== btnTambah){
            InputController inputController = new InputController();
            inputController.openInput();
            dispose();
        }
        else if(actionEvent.getSource()== btnLihat){
            OutputController outputController = new OutputController();
            outputController.openOutput();
            dispose();
        }
    }
}
