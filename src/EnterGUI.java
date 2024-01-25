// Client enter through GUI into chat session.
import javax.swing.JFrame;

public class EnterGUI extends JFrame{
    private JPanel enterPane; // Creating Enter pane
    private JButton enterButton; // Creating Enter button
    private JTextField enterField; // Reading nickname
    private String nickName; // Creating Nickname

    public EnterGUI();{
        enterPane(); // Creating Enter pane
        nicknamelabel(); // Creating Nickname label
        enterButtonEvent(); // Creating Enter button event
        setVisible(true); // Showing GUI
    }
    public void enterPanel(){
        enterPane = new JPanel();
        enterPane.setLayout(null);
        enterPane.setBackground(new Color(128, 255, 255));
        setContentPane(enterPane);
    }
}
