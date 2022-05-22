import org.junit.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MyServerTest {
    @Test
    public void myServerGenerateSequenceTestDefaultLastContent(){
        Integer num = 100;
        MyServer server = new MyServer();
        ArrayList<String> list = server.generateSequenceTest(num);
        assertEquals("Buzz",list.get(list.size()-1));
    }

    @Test
    public void myServerGenerateSequenceTestDefaultSize(){
        Integer num = 100;
        MyServer server = new MyServer();
        ArrayList<String> list = server.generateSequenceTest(num);
        assertEquals(100,list.size());
    }

    @Test
    public void myServerGenerateSequenceTestDefaultNotEmpty(){
        Integer num = 100;
        MyServer server = new MyServer();
        ArrayList<String> list = server.generateSequenceTest(num);
        assertFalse(list.isEmpty());
    }

    @Test
    public void myServerGenerateSequenceTestNullLongSequenceSize(){
        Integer num = 0;
        MyServer server = new MyServer();
        ArrayList<String> list = server.generateSequenceTest(num);
        assertEquals(0,list.size());
    }

    @Test
    public void myServerGenerateSequenceTestNullLongSequenceEmpty(){
        Integer num = 0;
        MyServer server = new MyServer();
        ArrayList<String> list = server.generateSequenceTest(num);
        assertTrue(list.isEmpty());
    }

    @Test
    public void myServerGenerateSequenceTestNullLongSequenceContent(){
        Integer num = 0;
        ArrayList<String> testlist = new ArrayList<>();
        MyServer server = new MyServer();
        ArrayList<String> list = server.generateSequenceTest(num);
        assertEquals(testlist,list);
    }

    @Test
    public void myServerGenerateSequenceTestOneLongSequenceSize(){
        Integer num = 1;
        MyServer server = new MyServer();
        ArrayList<String> list = server.generateSequenceTest(num);
        assertEquals(1,list.size());
    }

    @Test
    public void myServerGenerateSequenceTestOneLongSequenceContent(){
        Integer num = 1;
        MyServer server = new MyServer();
        ArrayList<String> list = server.generateSequenceTest(num);
        assertEquals(1,Integer.parseInt(list.get(list.size()-1)));
    }

    @Test
    public void myServerGenerateSequenceTestFifteenLongSequenceSize(){
        Integer num = 15;
        MyServer server = new MyServer();
        ArrayList<String> list = server.generateSequenceTest(num);
        assertEquals(15,list.size());
    }

    @Test
    public void myServerGenerateSequenceTestFifteenLongSequenceLastContent(){
        Integer num = 15;
        MyServer server = new MyServer();
        ArrayList<String> list = server.generateSequenceTest(num);
        assertEquals("FizzBuzz",list.get(list.size()-1));
    }

    @Test
    public void myServerGenerateSequenceTestAllContent(){
        ArrayList<String> testlist = new ArrayList<>();
        testlist.add("1");
        testlist.add("2");
        testlist.add("Fizz");
        testlist.add("4");
        testlist.add("Buzz");
        testlist.add("Fizz");
        testlist.add("7");
        testlist.add("8");
        testlist.add("Fizz");
        testlist.add("Buzz");
        testlist.add("11");
        testlist.add("Fizz");
        testlist.add("13");
        testlist.add("14");
        testlist.add("FizzBuzz");
        Integer num = 15;
        MyServer server = new MyServer();
        ArrayList<String> list = server.generateSequenceTest(num);
        assertEquals(testlist,list);
    }

    @Test
    public void myServerGenerateSequenceTestDefaultLastContentToFail(){
        Integer num = 100;
        MyServer server = new MyServer();
        ArrayList<String> list = server.generateSequenceTest(num);
        assertNotEquals("Fizz",list.get(list.size()-1));
    }

    @Test
    public void myServerGenerateSequenceTestDefaultSizeToFail(){
        Integer num = 100;
        MyServer server = new MyServer();
        ArrayList<String> list = server.generateSequenceTest(num);
        assertNotEquals(50,list.size());
    }

    @Test
    public void myServerGenerateSequenceTestNullLongSequenceSizeToFail(){
        Integer num = 0;
        MyServer server = new MyServer();
        ArrayList<String> list = server.generateSequenceTest(num);
        assertNotEquals(100,list.size());
    }

    @Test
    public void myServerGenerateSequenceTestNullLongSequenceContentToFail(){
        Integer num = 0;
        MyServer server = new MyServer();
        ArrayList<String> list = server.generateSequenceTest(num);
        assertFalse(!list.isEmpty());
    }

    @Test
    public void myServerGenerateSequenceTestOneLongSequenceSizeToFail(){
        Integer num = 1;
        MyServer server = new MyServer();
        ArrayList<String> list = server.generateSequenceTest(num);
        assertNotEquals(200,list.size());
    }

    @Test
    public void myServerGenerateSequenceTestOneLongSequenceContentToFail(){
        Integer num = 1;
        MyServer server = new MyServer();
        ArrayList<String> list = server.generateSequenceTest(num);
        assertNotEquals(6,Integer.parseInt(list.get(list.size()-1)));
    }

    @Test
    public void myServerGenerateSequenceTestFifteenLongSequenceSizeToFail(){
        Integer num = 15;
        MyServer server = new MyServer();
        ArrayList<String> list = server.generateSequenceTest(num);
        assertNotEquals(0,list.size());
    }

    @Test
    public void myServerGenerateSequenceTestFifteenLongSequenceLastContentToFail(){
        Integer num = 15;
        MyServer server = new MyServer();
        ArrayList<String> list = server.generateSequenceTest(num);
        assertNotEquals("alma",list.get(list.size()-1));
    }

    @Test
    public void myServerGenerateSequenceTestAllContentToFail(){
        ArrayList<String> testlist = new ArrayList<>();
        testlist.add("alma");
        testlist.add("2");
        testlist.add("Fizz");
        testlist.add("4");
        testlist.add("Buzz");
        testlist.add("korte");
        testlist.add("7");
        testlist.add("8");
        testlist.add("Fizz");
        testlist.add("Buzz");
        testlist.add("11");
        testlist.add("Fizz");
        testlist.add("13");
        testlist.add("14");
        testlist.add("szolo");
        Integer num = 15;
        MyServer server = new MyServer();
        ArrayList<String> list = server.generateSequenceTest(num);
        assertNotEquals(testlist,list);
    }
}