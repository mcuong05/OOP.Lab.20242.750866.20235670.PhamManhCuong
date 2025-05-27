package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddItemToStoreScreen extends JFrame {
    protected Store store;

    public AddItemToStoreScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createHeader(), BorderLayout.CENTER);

        // Thiết lập menu bar chính thức cho JFrame
        setJMenuBar(createMenuBar());

        setTitle("Add Item");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    protected JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdate = new JMenu("Update Store");
        smUpdate.add(createMenuItem("Add Book"));
        smUpdate.add(createMenuItem("Add CD"));
        smUpdate.add(createMenuItem("Add DVD"));

        menu.add(smUpdate);
        menu.add(createMenuItem("View Store"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    protected JMenuItem createMenuItem(final String name) {
        JMenuItem item = new JMenuItem(name);
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Đóng cửa sổ hiện tại
                if (name.equals("Add Book")) {
                    new AddBookToStoreScreen(store);
                } else if (name.equals("Add CD")) {
                    new AddCompactDiscToStoreScreen(store);
                } else if (name.equals("Add DVD")) {
                    new AddDigitalVideoDiscToStoreScreen(store);
                } else if (name.equals("View Store")) {
                    new StoreManagerScreen(store);
                }
            }
        });
        return item;
    }

    protected JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel subTitle = new JLabel("Add Item to Store");
        subTitle.setFont(new Font(subTitle.getFont().getName(), Font.ITALIC, 20));
        subTitle.setAlignmentX(CENTER_ALIGNMENT);

        header.add(Box.createVerticalStrut(10));
        header.add(title);
        header.add(subTitle);
        header.add(Box.createVerticalStrut(10));

        return header;
    }
}


