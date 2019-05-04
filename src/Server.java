import java.net.*;
import java.io.*;

public class Server {
    Socket socket = null;
    ServerSocket serverSocket = null;
    DataInputStream inputStream = null;
    public Server(Integer port){
        try{
            serverSocket = new ServerSocket(port);

            socket = serverSocket.accept();

            inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String line = " ";
            while (!line.equals("END")){
                try{
                    line = inputStream.readUTF();
                    System.out.println(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try{
                inputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Server server = new Server(5000);
    }
}
