import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
        public static void main(String[] args) throws Exception {
                String sendMsg, receivedMsg;
                Scanner inFromUser = new Scanner(System.in);
                sendMsg = inFromUser.nextLine();
                Socket clientSocket = new Socket("192.168.0.104",4444);
                OutputStream outToServer = clientSocket.getOutputStream();
                Scanner inFromServer = new Scanner(clientSocket.getInputStream());
                outToServer.write((sendMsg+"\n").getBytes());
                receivedMsg = inFromServer.nextLine();
                System.out.println("FROM SERVER: "+receivedMsg);
                clientSocket.close();
        }
}
