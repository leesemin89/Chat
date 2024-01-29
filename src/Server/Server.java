import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;

///서버 소켓 생성
serverSocket = new ServerSocket(8888);
serverGui.appendMessge("서버가 시작되었습니다"); // 서버 시작 메시지.

// 여러 클라이언트연결대기
while(true){
    clientSocket = serverSocket.accept();
    ChatTread chatthread  = new ChatThread(); // 스레드 생성
    chatlist.add(chatthread); // 어레이 리스트에 스레드추가
    serverGui.appendMessage("클라이언트가 접속했습니다." + "(IP: " + clientSocket.getInetaddress().toString().substring(1) + +")");
        }
    }chatthread.start();

class ChatThread extends Thread{
    public void run(){
        reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        writerToClient = new PrintWriter(clientSocket.getOutputStream(), true);
        writerToClient.println("서버에 연결됨(Server IP: "+serverSocket.getIPaddress().toSting().substring(1)+ ")");
        // 클라이언트에 연결 사실 전송

        while(loginBool){ //클라이언트로 메시지를 반복 읽기
            msg = reader.readLine();

            serverGui.appendMessage(user.getId() + " : " + msg); // 메시지 출력
            sendToAll(user.getId() + " : " + msg); // 모든 클라이언트에게 메시지 전송
        }
        public void sendToAll(String s){
            for(ChatThread thread : chatlist){
                thread.writerToClient.println(s); //서버는 여러 클라이언트로부터 메시지 수신 후 클라이언트에게 재전송
            }
        }
        while(loginBool){
            msg = reader.readLine();
            rmsg = msg.split("/"); //구분자 "/" 로 로그인/id 나누기

            serverGui.appendMessage(user.getId() + " : " + msg);

            if(rmsg[0].equals("login")){ //로그인 처리
                user.setId(rmsg[1]);
                sendToAll("Server : " + user.getId() + "님이 접속했습니다.");
                serverGui.appendMessage("접속한 사용자 : " + user.getId());
                else if(msg.equals(".quit")) // 로그아웃 처리
                    sendToAll("server: " + user.getId() + " 님이 나갔습니다");
                    serverGui.appendMessage("접속 종료한 사용자 : " + user.getId());
                    loginBool = false;
                }
            else{
                sendToAll(user.getId() + " : " + msg); // 모든 클라이언트에게 메시지 전송. 서버는 여러 클라이언트로부터 메시지 수신 후 클라이언트에게 재전송.
                serverGui.appendMessage(user.getId() + " : " + msg); // 메시지 출력. 서버는 여러 클라이언트로부터 메시지 수신 후 클라이언트에게 재전송.
            }
        }
        try(

                )
    }


}