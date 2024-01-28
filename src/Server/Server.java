import java.net.ServerSocket;

serverSocket = new ServerSocket(8888);
serverGui.appendMessge("서버가 시작되었습니다");

// 여러 클라이언트연결대기
while(true){
    clientSocket = serverSocket.accept();
    ChatTread chatthread  = new ChatTread();
    chatlist.add(chatthread);
    serverGui.appendMessage("클라이언트가 접속했습니다." + "(IP: " + clientSocket.getInetaddress().toString().substring(1) + +")");
        }
    }chatthread.start();

class ChatThread extends Thread{
    public void run(){
        while(true){

        }
    }
}