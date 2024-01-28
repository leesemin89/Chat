package Server;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class serverGui {
    private JFrame serverFrame;
    private JPanel contentPane;
    private JTextArea chatTextArea;
    private JList list;
    private JTextField chatTextField;

    public ServerGui(){
        serverFrame = new JFrame("Server");
        serverFrame.setContentPane(contentPane);
        serverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        serverFrame.pack();
        serverFrame.setVisible(true);


        JPanel contentPane = new JPanel();
        contentPane.add(chatTextField);
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(null);

        JTextArea chatTextArea = new JTextArea();
        chatTextArea.setBounds(10, 11, 430, 320);
        chatTextArea.setEditable(false);
        chatTextArea.setLineWrap(true);
        chatTextArea.setWrapStyleWord(true);
        chatTextArea.setBackground(Color.WHITE);
        contentPane.add(chatTextArea);

        chatTextField = new JTextField();
        chatTextField.setBounds(10, 340, 430, 40);
        chatTextField.setColumns(10);
        contentPane.add(chatTextField);

        Label userListLabel = new Label("User List");
        userListLabel.setBounds(450, 11, 100, 20);
        contentPane.add(userListLabel);

        model = new DefaultListModel();

        list = new JList(model);
        list.setBounds(450, 30, 100, 300);
        list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        contentPane.add(list);

        serverFrame.setTitle("채팅프로그램 서버");
        serverFrame.setResizable(false);
        serverFrame.setVisible(true);

        }
        public void setFrameVisible(){
            serverFrame.setVisible(true);
        }
        public void setChatTextFieldBlank()  {
            chatTextField.setText(null);
        }
        public void appendMessage(String message){
        chatTextArea.append(message+ " \n");
        }
        public void appendUserList(String user){
            model.addElement(user);
        }
        public void removeUserList(String user){
            mode.removeElement(user);
        }
        public String getChatMessage(){
            return chatTextField.getText();
        }
}

