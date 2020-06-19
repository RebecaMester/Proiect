
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;

public class Meniu {

    private JFrame frame;

    /**
     * Launch the apimport java.awt.Font;
     import java.awt.Color;

     public class Meniu {

     private JFrame frame;

     /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Meniu window = new Meniu();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Meniu() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(100, 100, 442, 354);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("ALEGETI DIN URMATOARELE VARIANTE");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        lblNewLabel_1.setBounds(10, 34, 371, 29);
        frame.getContentPane().add(lblNewLabel_1);

        JButton btnNewButton = new JButton("Atualizare Cont");
        btnNewButton.setBounds(189, 88, 144, 23);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Adauga Carte");
        btnNewButton_1.setBounds(189, 122, 144, 23);
        frame.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Imprumut");
        btnNewButton_2.setBounds(189, 156, 144, 23);
        frame.getContentPane().add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("Returnare");
        btnNewButton_3.setBounds(189, 190, 144, 23);
        frame.getContentPane().add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton("Rezervare");
        btnNewButton_4.setBounds(188, 224, 145, 23);
        frame.getContentPane().add(btnNewButton_4);

        JLabel lblNewLabel = new JLabel("");
        Image img = new ImageIcon(this.getClass().getResource("/Books.png")).getImage();
        lblNewLabel.setIcon(new ImageIcon(img));
        lblNewLabel.setBounds(36, 92, 128, 155);
        frame.getContentPane().add(lblNewLabel);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Actualizare();
                frame.setVisible(false);
            }
        });

        frame.setVisible(true);

        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AdaugaCarte();
                frame.setVisible(false);
            }
        });

        frame.setVisible(true);

        frame.setVisible(true);
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Imprumut();
                frame.setVisible(false);
            }
        });




        frame.setVisible(true);
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Returnare();
                frame.setVisible(false);
            }
        });

        frame.setVisible(true);
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Rezervare();
                frame.setVisible(false);
            }
        });












    }
}