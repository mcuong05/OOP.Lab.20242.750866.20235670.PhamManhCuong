package hust.soict.hedspi.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberGrid extends JFrame {
    private JButton[] btnNumbers;
    private JButton btnDelete, btnReset;
    private JTextField tfDisplay;

    public NumberGrid() {
        tfDisplay = new JTextField();
        tfDisplay.setEditable(false);
        tfDisplay.setHorizontalAlignment(JTextField.RIGHT);

        JPanel panelButtons = new JPanel(new GridLayout(4, 3, 5, 5));

        // Khởi tạo các nút số và thêm vào panel
        btnNumbers = new JButton[10];
        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton(i + "");
            panelButtons.add(btnNumbers[i]);
        }

        // Thêm nút Reset, 0 và Delete
        btnReset = new JButton("C");
        panelButtons.add(btnReset);

        btnNumbers[0] = new JButton("0");
        panelButtons.add(btnNumbers[0]);

        btnDelete = new JButton("DEL");
        panelButtons.add(btnDelete);

        // Thêm listener cho tất cả nút
        ButtonListener btnListener = new ButtonListener();
        for (JButton btn : btnNumbers) {
            btn.addActionListener(btnListener);
        }
        btnReset.addActionListener(btnListener);
        btnDelete.addActionListener(btnListener);

        // Thêm display và panel buttons vào content pane
        this.setLayout(new BorderLayout(5, 5));
        this.add(tfDisplay, BorderLayout.NORTH);
        this.add(panelButtons, BorderLayout.CENTER);

        this.setTitle("Number Grid");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    // Inner class xử lý sự kiện 
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String btnLabel = ((JButton) e.getSource()).getText();
            String currentText = tfDisplay.getText();

            if (btnLabel.equals("DEL")) {
                if (!currentText.isEmpty()) {
                    tfDisplay.setText(currentText.substring(0, currentText.length() - 1));
                }
            } else if (btnLabel.equals("C")) {
                tfDisplay.setText("");
            } else {
            	tfDisplay.setText(currentText + btnLabel);
            }

        }
    }

    public static void main(String[] args) {
        new NumberGrid();
    }
}

