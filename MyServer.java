import java.net.*;
import java.io.*;
import java.util.ArrayList;

import org.json.*;

public class MyServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;

    private static final int PORT = 10000;

    public MyServer(){}

    public void start(){
        try {
            serverSocket = new ServerSocket(PORT);
            clientSocket = serverSocket.accept();

            //System.out.println(clientSocket.getInetAddress()+" csatlakozott a szerverhez!");

            InputStream inputStream = clientSocket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Integer data =  (Integer) objectInputStream.readObject();

            JSONObject sequence = generateSequence(data);
            //System.out.println(sequence.toString());

            OutputStream outputStream = clientSocket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(sequence.toString());
            //System.out.println("Szerver:Sorozat elkuldve!");

            FileWriter file = new FileWriter("output.json");
            file.write(sequence.toString());
            file.flush();
            file.close();

            if(inputStream.read() == -1){
                //System.out.println("Kliens lekapcsolodott! Szerver leall!");
                stop();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void stop(){
        try{
            clientSocket.close();
            serverSocket.close();
        }catch( Exception e){
            e.printStackTrace();
        }
    }

    private JSONObject generateSequence(Integer data){
        JSONObject seq = new JSONObject();
        ArrayList<String> list = new ArrayList<>();
        for(int i = 1;i<= data;++i){
            if( ( i % 3 == 0) && ( i % 5 == 0) ){
                list.add("FizzBuzz");
            } else if ( i % 3 == 0) {
                list.add("Fizz");
            } else if ( i % 5 == 0) {
                list.add("Buzz");
            }else{
                list.add(Integer.toString(i));
            }
        }
        seq.put("sequence",list);
        return seq;
    }

    public ArrayList<String> generateSequenceTest(Integer data){
        ArrayList<String> list = new ArrayList<>();
        for(int i = 1;i<= data;++i){
            if( ( i % 3 == 0) && ( i % 5 == 0) ){
                list.add("FizzBuzz");
            } else if ( i % 3 == 0) {
                list.add("Fizz");
            } else if ( i % 5 == 0) {
                list.add("Buzz");
            }else{
                list.add(Integer.toString(i));
            }
        }
        return list;
    }

}
