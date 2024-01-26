import javax.swing.*;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class enterGUI extends JFrame {
    private JPanel enterPane; // 전체 틀
    private JTextField textField; // 텍스트필드
    private JButton enterButton; // 엔터버튼
    private String name; // 닉네임

    public enterGUI() {

        enterPanel(); // 전체틀 생성
        nickNameLabel(); // 닉네임 레이블 생성
        enterButtonEvent(); // 입장버튼 생성 및 이벤트 처리
        setVisible(true); //GUI 켜기

    }
    public void enterPanel()
    {
        enterPane = new JPanel(); // 초기화
        enterPane.setLayout(null); // 레이아웃 설정
        add(enterPane); // 프레임에 틀 추가
        setTitle("Enter"); // 제목 설정
        setSize(400, 400); // 사이즈 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 종료시 프로세스 종료
        setLocationRelativeTo(null);    // 창 중앙에 위치
    }
    public void nickNameLabel()
    {
        JLabel label = new JLabel("닉네임 : ");
        label.setBounds(50, 50, 100, 30); // 위치, 크기 설정
        enterPane.add(label); // 틀에 레이블 추가

        textField = new JTextField(); // 텍스트필드 생성
        textField.setBounds(150, 50, 150, 30);  // 위치, 크기 설정
        textField.setColumns(10); // 글자수 제한 설정
        enterPane.add(textField); // 틀에 텍스트필드 추가
    }
    public void enterButtonEvent()
    {
        enterButton = new JButton("Enter"); // 입장버튼 생성
        enterButton.setBounds(50, 100, 300, 30); // 위치, 크기 설정
        enterPane.add(enterButton); // 틀에 입장버튼 추가
        enterButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
               sendToChatGui();
            }
        });
        TextField.addKeyListener(new KeyAdapter() {
        enterButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendToChatGui();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }
    public void sendToChatGui() {
            name = textField.getText(); // 닉네임 로딩
            setVisible(false); // GUI 닫기;
            new ChatGUI(name); // 채팅GUI 생성
    }
}
