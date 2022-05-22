import org.json.JSONObject;
import java.net.*;
import java.io.*;

public class MyClient {
    private Socket socket;
    private Integer num;
    private JSONObject sequence;

    private static final String HOST = "localhost";
    private static final int PORT = 10000;
    private void startConnection(String ip, int port) {
        try {
            socket = new Socket(ip, port);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void stopConnection() {
        try {
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void readInputs(){
        BufferedReader reader  =
                new BufferedReader(new InputStreamReader(System.in));

        try{
            System.out.println("Enter the last number in a sequence:");
            String input = (reader.readLine());
            num = (Integer.parseInt(input));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void sendData(){
        try {
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            //System.out.println("Kliens:Data kuldese a szervernek!");
            objectOutputStream.writeObject(num);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void getData(){
        try{
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            String answer = (String) objectInputStream.readObject();
            //System.out.println("Kliens:Megjott a valasz!");
            sequence = new JSONObject(answer);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void printAnswer(){
        System.out.println(sequence.get("sequence").toString());
    }
    public void runClient(){
        MyClient fizzBuzzClient = new MyClient();
        fizzBuzzClient.startConnection(HOST,PORT);
        fizzBuzzClient.readInputs();
        fizzBuzzClient.sendData();
        fizzBuzzClient.getData();
        fizzBuzzClient.printAnswer();

        fizzBuzzClient.stopConnection();
    }
}
