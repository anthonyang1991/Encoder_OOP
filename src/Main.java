import Controller.DxcController;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



public class Main {
    public static void main(String[] args) {

        DxcController dxcController1 = new DxcController();
        DxcController dxcController2 = new DxcController();
        DxcController dxcController3 = new DxcController();



        dxcController1.setCode('B');
        dxcController2.setCode('F');
        dxcController3.setCode('A');

        String HELLOWORLD_TEXT = "HELLO WORLD";
        String ALL_TEXT = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";


        System.out.println("TEST 1");
        System.out.printf("Encoding " + HELLOWORLD_TEXT + "\n");
        String encodedMsg1= dxcController1.encode(HELLOWORLD_TEXT);
        System.out.printf("This is the encoded message :" + encodedMsg1+"\n");
        System.out.printf("Decoding " + encodedMsg1 + "\n");
        String decodedMsg1 = dxcController1.decode(encodedMsg1);
        System.out.printf("This is the decoded message :" + decodedMsg1+"\n");

        System.out.println("TEST 2");
        System.out.printf("Encoding " + HELLOWORLD_TEXT + "\n");
        String encodedMsg2= dxcController2.encode(HELLOWORLD_TEXT);
        System.out.printf("This is the encoded message :" + encodedMsg2+"\n");
        System.out.printf("Decoding " + encodedMsg2 + "\n");
        String decodedMsg2 = dxcController2.decode(encodedMsg2);
        System.out.printf("This is the decoded message :" + decodedMsg2+"\n");

        System.out.println("TEST 3");
        System.out.printf("Encoding " + ALL_TEXT + "\n");
        String encodedMsg3= dxcController2.encode(ALL_TEXT);
        System.out.printf("This is the encoded message :" + encodedMsg3+"\n");
        System.out.printf("Decoding " + encodedMsg3 + "\n");
        String decodedMsg3 = dxcController2.decode(encodedMsg3);
        System.out.printf("This is the decoded message :" + decodedMsg3+"\n");










    }
}
