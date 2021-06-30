package View;

import Controller.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LemburView extends JFrame implements ActionListener {
    private JPanel panelLembur;
    private JButton btnGaji;
    private JTextField etLembur;
    private JButton btnKembali;
    private JButton btnEdit;
    private JButton btnHapus;
    private JLabel lblNama;
    private JLabel lblUsia;
    private JLabel lblGaji;

    private String[] selected;

    public LemburView(String[] selectedData) {
        setTitle(selectedData[1]);
        btnKembali.addActionListener(this);
        btnGaji.addActionListener(this);
        btnEdit.addActionListener(this);
        btnHapus.addActionListener(this);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelLembur);
        this.pack();
        setLocationRelativeTo(null);

        selected = selectedData;

        lblNama.setText(selectedData[1]);
        lblUsia.setText(selectedData[2]);
        lblGaji.setText(selectedData[3]);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()==btnGaji) {
            if (etLembur.getText().isEmpty()) {
                setMessage("Jam lembur harus diisi");
            }
            else
            {
                try {
                    String jamLembur = etLembur.getText();
                    int lembur = Integer.parseInt(jamLembur);

                    if(lembur < 0){
                        setMessage("Jam lembur harus bernilai positif");
                    }

                    else{
                        String nama = lblNama.getText();
                        String usia = lblUsia.getText();
                        String gajiLembur = lblGaji.getText();

                        StringBuilder sb = new StringBuilder(gajiLembur); //terdapat masalah dimana String tidak bisa menerima input dengan .00
                        sb.deleteCharAt(gajiLembur.length()-2);

                        String gaji = sb.toString();

                        LemburController lemburController = new LemburController();
                        lemburController.jamLembur(lembur, nama, usia, gaji);
                        dispose();
                    }
                }
                catch (NumberFormatException e) {
                    setMessage("Jam lembur harus angka");
                }
            }
        }
        else if(actionEvent.getSource()==btnKembali) {
            OutputController outputController = new OutputController();
            outputController.openOutput();
            dispose();
        }
        else if(actionEvent.getSource()==btnEdit) {
            EditController editController = new EditController();
            editController.edit(selected);
            dispose();
        }
        else if(actionEvent.getSource()==btnHapus) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus?", "Hapus", dialogButton);
            if(dialogResult == 0) {
                EditController editController = new EditController();
                editController.hapus(selected);
                OutputController outputController = new OutputController();
                outputController.openOutput();
                dispose();
            }
        }
    }

    public void setMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }
}
