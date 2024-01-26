import javax.swing.*;
import java.io.BufferedReader;
import java.io.PrintWriter;

public class ChatGui {
    private JPanel ChatPanel;
    private JTextField textMsg;
    private JTextArea chatLog;

    private BufferedReader reader;
    public PrintWriter writer;

    public ChatGui(String id)
    {   //EnterGUI의 닉네임 값을 매개변수로 받음
        String msg  = "login/" + id;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        chatPanel = new JPanel();
        chatPanel.setLayout(null);
        chatPenal.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(chatPanel);

        //chatLable and ChatLog
        JLabel chatLabel = new JLabel("채팅방");
        chatLabel.setBounds(10, 10, 100, 30);
        chatPanel.add(chatLabel);


    }

}
