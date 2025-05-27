package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    public AddBookToStoreScreen(Store store) {
        super(store);

        JPanel form = new JPanel(new GridLayout(4, 2, 5, 5));

        JTextField tfTitle = new JTextField(20);
        JTextField tfCategory = new JTextField(20);
        JTextField tfCost = new JTextField(20);
        JTextField tfAuthor = new JTextField(20);

        form.add(new JLabel("Title:"));
        form.add(tfTitle);

        form.add(new JLabel("Category:"));
        form.add(tfCategory);

        form.add(new JLabel("Cost (float):"));
        form.add(tfCost);

        form.add(new JLabel("Author:"));
        form.add(tfAuthor);

        JButton btnAdd = new JButton("Add Book");
        btnAdd.addActionListener(e -> {
            try {
                String title = tfTitle.getText();
                String category = tfCategory.getText();
                float cost = Float.parseFloat(tfCost.getText());
                String author = tfAuthor.getText();

                Book book = new Book(title, category, cost);
                book.addAuthor(author);

                store.addMedia(book);

                JOptionPane.showMessageDialog(null, "Book added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
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


