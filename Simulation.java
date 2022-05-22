public class Simulation {
    public static void main(String[] args) {
        MyServer fizzBuzzServer = new MyServer();
        MyClient fizzBuzzClient = new MyClient();

        Thread t1 = new Thread(()->{
            fizzBuzzServer.start();
        });
        t1.start();

        Thread t2 = new Thread(()->{
           fizzBuzzClient.runClient();
        });
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
