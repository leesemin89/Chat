import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;

public class ChatGui {
    private JPanel chatPanel;
    private JTextField textMsg;
    private JTextArea chatLog;
    private JLabel chatLabel;

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

        //chatLabel and ChatLog
        JLabel chatLabel = new JLabel("채팅방");
        chatLabel.setBounds(10, 10, 100, 30);
        chatPanel.add(chatLabel);

        chatLog = new JTextArea(); //chatLog 생성
        chatLog.setBounds(10, 50, 400, 200);
        chatLog.setEditable(false);
        chatLog.setText("채팅 로그입니다.");
        chatPanel.add(chatLog);

        textMsg = new JTextField();
        textMsg.setBounds(10, 250, 300, 30);
        textMsg.setColumns(10);
        textMsg.requestFocus();
        textMsg.setText("메시지를 입력하세요.");
        chatPanel.add(textMsg);

        // 메시지 전송 엔터키 이벤트 처리
        textMsg.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == keyEvent.VK_ENTER)
                {
                    String msg = textMsg.getText();
                    textMsg.setText("");
                    writer.println(msg);
                    writer.flush();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        setVisible(true); //GUI 보이기;
        try{
            //소켓 통신으로 서버로 메세지 전송 코드
            //서버 정보
            String serverIP = "localhost";
            int serverPort = 8888;

            //서버 연결
            Socket socket = new Socket(serverIP, serverPort);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //서버로부터 메세지 수신 쓰레드 시작
            Thread readTread = new Thread(new ServerMessageReader());
            readTread.start();

            //서버로 메세지 전송
            OutputStream outputStream = socket.getOutputStream();
            writer = new PrintWriter(outputStream, true);
            writer.println(msg);
            writer.flush();

        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("서버 연결 실패");
            System.exit(0); //프로그램 종료;
           //메소드 종료;
        }
    }
    // 서버에서 주는 메세지 처리
    private class ServerMessageReader implements Runnable{
        @Override
        public void run() {
            try{
                String message;
                while(message = reader.readLine() != null){
                    chatLog.append("서버 메세지: " + message + "\n");
                    uploadText(message); // 채팅 로그에 추가(메소드 호출)
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }  //run() 메소드 종료;
    }
    public void uploadText(String text){
        chatLog.append(message + "\n");
    }
}
