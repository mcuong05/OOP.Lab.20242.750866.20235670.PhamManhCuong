package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);

        JPanel form = new JPanel(new GridLayout(6, 2, 5, 5));

        JTextField tfTitle = new JTextField(20);
        JTextField tfCategory = new JTextField(20);
        JTextField tfDirector = new JTextField(20);
        JTextField tfLength = new JTextField(20);
        JTextField tfCost = new JTextField(20);

        form.add(new JLabel("Title:"));
        form.add(tfTitle);

        form.add(new JLabel("Category:"));
        form.add(tfCategory);

        form.add(new JLabel("Director:"));
        form.add(tfDirector);

        form.add(new JLabel("Length (int):"));
        form.add(tfLength);

        form.add(new JLabel("Cost (float):"));
        form.add(tfCost);

        JButton btnAdd = new JButton("Add DVD");
        btnAdd.addActionListener(e -> {
            try {
                String title = tfTitle.getText();
                String category = tfCategory.getText();
                String director = tfDirector.getText();
                int length = Integer.parseInt(tfLength.getText());
                float cost = Float.parseFloat(tfCost.getText());

                DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
                store.addMedia(dvd);

                JOptionPane.showMessageDialog(null, "DVD added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        form.add(new JLabel());
        form.add(btnAdd);

        this.getContentPane().add(form, BorderLayout.SOUTH);
        setVisible(true);
    }
}
