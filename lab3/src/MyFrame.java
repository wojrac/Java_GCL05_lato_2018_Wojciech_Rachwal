import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.lang.String;
/**
 * Created by wrachwal on 2018-03-20.
 */
public class MyFrame implements  ActionListener {

    private JLabel nameStudent;
    private JLabel passStudent;
    private JTextField loginField;
    private JPasswordField passwordField1;
    private JButton button_close;
    private JPanel MyPanel;
    private JLabel error_login;
    private JLabel error_password;
    private JButton loginbutton;
    private JComboBox comboBox1;
    UserValidator uv = new UserValidator();
    String [] menu = {"Program" , "Zamknij"};

    public MyFrame()
    {

        nameStudent.setText("Nazwa Studenta");
        passStudent.setText("Haslo Studenta");
        button_close.addActionListener(this);
        loginbutton.addActionListener(this);


    }

    /*private void initComponents() {


        JMenuBar jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jMenu1.setText("File");

        jMenuItem1.setText("jMenuItem1");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(260, Short.MAX_VALUE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(226, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>*/





    public String getName()
    {
        return loginField.getText();
    }
    public String getPasswd() {
        String password = "";
        char[] pass = passwordField1.getPassword();
        for(int i=0; i<pass.length; i++) {
            password += pass[i];
        }

        return password;
    }
    public void actionPerformed (ActionEvent e) {
        Object source = e.getSource();
        if (source == button_close) {
            System.exit(0);
        }

        else if (source == loginbutton)
        {
            if (uv.authenticate(loginField.getText(), getPasswd()) && uv.validatelenghtlog(loginField.getText())&& uv.validatelenghtpass(getPasswd()) )
            {
                JFrame frame2 = new JFrame("SecondFrame");
                frame2.setContentPane(new SecondFrame().getDane());
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.pack();
                frame2.setVisible(true);


            } else if (!(uv.validatelenghtlog(loginField.getText()))) {
                error_login.setText("za malo lub za duzo liter");


            }
            else if(!(uv.validatelenghtpass(getPasswd())))
            {
                error_password.setText("za malo lub za duzo liter");
            }

            else {
                error_login.setText("blad logowania");
                error_password.setText("blad logowania");
                JFrame frame3 = new JFrame("Message");
                frame3.setContentPane(new Message().Blad);
                frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame3.pack();
                frame3.setVisible(true);

            }
        }
    }




    public static void main(String[] args) {
        JFrame frame = new JFrame("MyFrame");
        frame.setContentPane(new MyFrame().MyPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}