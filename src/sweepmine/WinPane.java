package sweepmine;

import sweepmine.SweepMine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class WinPane extends JDialog implements ActionListener {

/**
 * Created by Lemoxiao  ---2017-10-23
 * This is a WinPane.
 * When user Successes through games ,it will resonper.
 */

    SweepMine frame;
    Font font;
    JButton bon1, bon2;
    JLabel label;
    JPanel panel;
    public WinPane(String s, SweepMine frame) {
        this.frame = frame;
        setTitle(s);
        addPart();
        setBounds(500, 200, 400,200);
        close();
        setModal(true);
        setVisible(true);

    }

    /*
    ** Set the closing mode default
    */
    public void close() {
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.newGame();
                dispose();
            }
        });
    }


    /*
    ** Add some compenent into the container
    ** add content: label\botton1\bontton2\
    */

    public void addPart() {
        panel = new JPanel();
        //panel.setBackground(Color.white);
        panel.setBorder(BorderFactory.createLineBorder(Color.gray, 4));
        panel.setLayout(null);

        font = new Font("微软雅黑", 1, 18);

        label = new JLabel("Congratulation !");
        label.setFont(font);
        label.setBounds(130, 10, 200, 50);
        panel.add(label);

        bon1 = new JButton("New Game");
        bon1.setFont(font);
        bon1.addActionListener(this);
        bon1.setMargin(new Insets(0, 0,0 ,0));
        panel.add(bon1);
        bon1.setBounds(30, 100, 150, 40);

        bon2 = new JButton("Exit");
        bon2.setFont(font);
        bon2.addActionListener(this);
        bon2.setMargin(new Insets(0, 0,0 ,0));
        panel.add(bon2);
        bon2.setBounds(200, 100, 150, 40);

        add(panel, BorderLayout.CENTER);
    }


    /*
    **This is a ActionMonitor for the winpane
    */
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == bon1) {
            frame.newGame();
            dispose();
        }
        if (e.getSource() == bon2) {
            frame.record.writeLevel(frame.level);
            if (frame.level == 3)
                frame.record.writeLevel4(frame.row, frame.column, frame.mine);
            System.exit(0);
        }
    }
}
