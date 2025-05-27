package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setAlignmentX(CENTER_ALIGNMENT);
        JLabel cost = new JLabel(media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalStrut(10));

        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.setAlignmentX(CENTER_ALIGNMENT);
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ((Playable) media).play(); // gọi play() trước
                    JOptionPane.showMessageDialog(null, "Playing...", "Playing Media", JOptionPane.INFORMATION_MESSAGE);
                }
            });

            this.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
