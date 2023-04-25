package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    private static JLabel usrLbl;
    private static JTextField usrTxt;
    private static JLabel pwdLbl;
    private static JPasswordField usrPWD;
    private static JButton button;
    private static JLabel sucess;

    public static void main() {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        usrLbl = new JLabel("Username: ");
        usrLbl.setBounds(10, 20, 80, 25);
        panel.add(usrLbl);

        usrTxt = new JTextField(30);
        usrTxt.setBounds(100,20,165,25);
        panel.add(usrTxt);

        pwdLbl = new JLabel("Password: ");
        pwdLbl.setBounds(10,50,80,25);
        panel.add(pwdLbl);

        usrPWD = new JPasswordField(30);
        usrPWD.setBounds(100,50,165,25);
        panel.add(usrPWD);

        button = new JButton("Login");
        button.setBounds(100,100,80,25);
        button.addActionListener(new GUI());
        panel.add(button);

        sucess = new JLabel("");
        sucess.setBounds(10,130,300,25);
        panel.add(sucess);


        frame.setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = usrTxt.getText();
        String password = usrPWD.getText();
        System.out.println(user + " " + password);

        if (user.equals("Alex") && password.equals("123")) {
            sucess.setText("Login Sucessful!");
        }

    }
}
