package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    public AddCompactDiscToStoreScreen(Store store) {
        super(store);

        JPanel form = new JPanel(new GridLayout(5, 2, 5, 5));

        JTextField tfTitle = new JTextField(20);
        JTextField tfCategory = new JTextField(20);
        JTextField tfArtist = new JTextField(20);
        JTextField tfCost = new JTextField(20);

        form.add(new JLabel("Title:"));
        form.add(tfTitle);

        form.add(new JLabel("Category:"));
        form.add(tfCategory);

        form.add(new JLabel("Artist:"));
        form.add(tfArtist);

        form.add(new JLabel("Cost (float):"));
        form.add(tfCost);

        JButton btnAdd = new JButton("Add CD");
        btnAdd.addActionListener(e -> {
            try {
                String title = tfTitle.getText();
                String category = tfCategory.getText();
                String artist = tfArtist.getText();
                float cost = Float.parseFloat(tfCost.getText());

                CompactDisc cd = new CompactDisc(title, category, cost);
                cd.setArtist(artist);

                store.addMedia(cd);

                JOptionPane.showMessageDialog(null, "CD added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
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

