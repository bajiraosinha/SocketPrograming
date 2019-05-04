import java.net.*;
import java.io.*;
public class CilentSocket {


    private Socket socket = null;
    private DataInputStream inputStream = null;
    private DataOutputStream outputStream = null;

    public CilentSocket(String address, Integer port){
        try{
            socket = new Socket(address,port);
            System.out.println("Connection Created");
            inputStream = new DataInputStream(System.in);
            outputStream = new DataOutputStream(socket.getOutputStream());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String line = "";

        while(!line.equals("END")){
            try{
                line = inputStream.readLine();
                System.out.println(line);
                outputStream.writeUTF(line);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        try{
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        CilentSocket cilentSocket = new CilentSocket("127.0.0.1", 5000);
    }
}
