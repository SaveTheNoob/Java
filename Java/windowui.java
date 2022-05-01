
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
// import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;



public class windowui extends Thread implements ActionListener {
    Character[] KeyLists = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','1','2','3','4','5','6','7','8','9','0',' '};
    JFrame d1 = new JFrame();
    ImageIcon icon = new ImageIcon("icon.jpg");
    static JToggleButton d2 = new JToggleButton("AutoClicker: Off");
    static clicker1 d4 = new clicker1();
    JTextField d5 = new JTextField();
    JButton d6 = new JButton();
    JLabel dlabel = new JLabel();
    Font dfont = new Font("Arial", Font.PLAIN,14);
    JComboBox<Character> db = new JComboBox<Character>(KeyLists);
    JLabel dl1 = new JLabel();
    JToggleButton dl2 = new JToggleButton("KeyPresser: Off");

    windowui() {
        d1.setTitle("Click and Press");
        d1.setSize(300, 400);
        d1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        d1.setIconImage(icon.getImage());
        d1.setLayout(null);
        d1.setResizable(false);
        d1.setAlwaysOnTop(true);
        d1.setVisible(true);

        d2.setBounds(65, 140, 160, 40);
        d2.addActionListener(this);

        d5.setBounds(65,110,110,20);
        d6.setBounds(175,110,50,19);
        d6.setText("Ok");
        d6.addActionListener(this);

        dlabel.setText("AutoClicker");
        dlabel.setBounds(65,20,170,60);
        dlabel.setHorizontalAlignment(SwingConstants.CENTER);
        dlabel.setFont(dfont);

        db.addActionListener(this);
        db.setBounds(65, 200, 160, 30);

        dl1.setText("KeyPresser");
        dl1.setBounds(65,40,170,60);
        dl1.setHorizontalAlignment(SwingConstants.CENTER);
        dl1.setFont(dfont);

        dl2.setBounds(65, 240, 160, 40);
        dl2.addActionListener(this);

        d1.add(d2);
        d1.add(d5);
        d1.add(d6);
        d1.add(dlabel);
        d1.add(db);
        d1.add(dl1);
        d1.add(dl2);

    }
    static boolean running = false;
    boolean pressing = false;

    int millisecond; 

    @Override
    public void actionPerformed(ActionEvent e) {
        SwingWorker<Void,Void> worker = new SwingWorker<Void,Void>() {
            @Override       
        protected Void doInBackground() throws Exception {     
            if(e.getSource()==d6) { //Show Speed Of Both Autoclicker and KeyPresser
                millisecond = Integer.parseInt(d5.getText());
                dlabel.setText("AC/KP Millisecond: " + d5.getText());
            }
            if (dl2.isSelected()) {//KeyPresser
                char letters = (char) db.getSelectedItem();
                dl1.setText("KeyPressing : " + db.getSelectedItem());
                dl2.setText("KeyPresser: On");
                pressing = true;    
                d2.setEnabled(false);
                while (pressing) { 
                d4.autopress(millisecond,letters);
                }
            }else{
                pressing = false;
                dl1.setText("KeyPressing: False");
                dl2.setText("KeyPresser: Off");
                d2.setEnabled(true);
            }
            Thread.sleep(100);     
            if (d2.isSelected()) { //AutoClicker
                 d2.setText("AutoClicker: On");
                 dl2.setEnabled(false);
                 db.setEnabled(false);
                     running = true;
            while (running) {
                d4.autoclick(millisecond);
                } 
            } else {
                Thread.sleep(100);  
                dl2.setEnabled(true);
                db.setEnabled(true);
                running = false;
                d2.setText("AutoClicker: Off");
            }
            return null;
            }

            // private void autopress(int millisecond, char letters) {
            // }
        };
        worker.execute();
    }

}
