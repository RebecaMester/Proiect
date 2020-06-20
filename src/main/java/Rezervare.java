

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

public class Rezervare {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Rezervare window = new Rezervare();
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
    public Rezervare() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(100, 100, 450, 445);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Rezervare CARTE");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel.setBounds(22, 89, 192, 24);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Introduceti datele cartii:");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 16));
        lblNewLabel_1.setBounds(31, 136, 168, 17);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Titlu");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        lblNewLabel_2.setForeground(Color.BLACK);
        lblNewLabel_2.setBounds(44, 188, 75, 14);
        frame.getContentPane().add(lblNewLabel_2);

        textField = new JTextField();
        textField.setBounds(176, 179, 86, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("INAPOI");
        btnNewButton.setBounds(44, 350, 89, 23);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                frame.setVisible(false);
                new Meniu();
            }

        });
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("REZERVARE");
        btnNewButton_1.setBounds(177, 350, 129, 23);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {


                String titlu=textField.getText();
                String autor=textField_1.getText();
                String categorie=textField_3.getText();
                String data_pub=textField_2.getText();
                String disponibilitate=textField_4.getText();

                ArrayList<Carte> carti=creareJSON3.getDriver();
                Iterator<Carte> it=carti.iterator();
                while(it.hasNext() ) {
                    Carte s=it.next();
                    if(s.getTitlu().equals(titlu) && s.getDisponibilitate().equals("1"))
                    {   carti.remove(s);
                        Carte st = new Carte(null, null, null, null, null);

                        st.setAutor(textField_1.getText());
                        st.setTitlu(textField.getText());
                        st.setCategorie(textField_3.getText());
                        st.setData(textField_2.getText());
                        st.setDisponibilitate("0");
                        carti.add(st);
                        creareJSON3.uppdate2(carti);

                    }
                }
            }
        });
        frame.getContentPane().add(btnNewButton_1);

        JLabel lblNewLabel_3 = new JLabel("");

        Image img = new ImageIcon(this.getClass().getResource("/Books2.png")).getImage();
        lblNewLabel_3.setIcon(new ImageIcon(img));

        lblNewLabel_3.setBounds(257, 38, 135, 131);
        frame.getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Autor");
        lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel_4.setBounds(44, 213, 46, 14);
        frame.getContentPane().add(lblNewLabel_4);

        textField_1 = new JTextField();
        textField_1.setBounds(176, 210, 86, 20);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("Data publicarii");
        lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel_5.setBounds(44, 238, 98, 14);
        frame.getContentPane().add(lblNewLabel_5);

        textField_2 = new JTextField();
        textField_2.setBounds(176, 235, 86, 20);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        JLabel lblCategorie = new JLabel("Categorie");
        lblCategorie.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        lblCategorie.setBounds(44, 263, 75, 14);
        frame.getContentPane().add(lblCategorie);

        textField_3 = new JTextField();
        textField_3.setBounds(176, 260, 86, 20);
        frame.getContentPane().add(textField_3);
        textField_3.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("Disponibilitate");
        lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel_6.setBounds(44, 288, 98, 14);
        frame.getContentPane().add(lblNewLabel_6);

        textField_4 = new JTextField();
        textField_4.setBounds(176, 285, 86, 20);
        frame.getContentPane().add(textField_4);
        textField_4.setColumns(10);
    }
}
