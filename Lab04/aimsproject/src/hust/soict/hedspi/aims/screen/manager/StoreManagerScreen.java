package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StoreManagerScreen extends JFrame {
    private Store store;

    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setJMenuBar(createMenuBar()); // Set the menu bar for the JFrame

        setTitle("AIMS Store Manager");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
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

    // New method to create menu items with action listeners
    protected JMenuItem createMenuItem(final String name) {
        JMenuItem item = new JMenuItem(name);
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current window
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

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel subTitle = new JLabel("Store Manager");
        subTitle.setFont(new Font(subTitle.getFont().getName(), Font.ITALIC, 20));
        subTitle.setAlignmentX(CENTER_ALIGNMENT);

        header.add(Box.createVerticalStrut(10));
        header.add(title);
        header.add(subTitle);
        header.add(Box.createVerticalStrut(10));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        for (Media media : store.getItemsInStore()) {
            MediaStore cell = new MediaStore(media);
            center.add(cell);
        }

        return center;
    }

    public static void main(String[] args) {
        Store store = new Store();
        store.addMedia(new Book("Test Book", "Fiction", 10.0f));
        store.addMedia(new CompactDisc("Test CD", "Music", 15.0f));
        store.addMedia(new DigitalVideoDisc("Test DVD", "Movie", "Director", 120, 20.0f));
        new StoreManagerScreen(store);
    }
}
