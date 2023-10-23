import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Controller.DxcController;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DxcControllerTest {

    private DxcController dxcController;

    @BeforeEach
    public void setUp() {
        dxcController = new DxcController();
    }

    @Test
    public void testEncodeAndDecodeScenario1() {
        String input = "BHELLO WORLD";
        String encodedMsg = dxcController.encode(input);
        String decodedMsg = dxcController.decode(encodedMsg);

        // Display the encoded and decoded messages to the console
        System.out.println("Encoded Message: " + encodedMsg);
        System.out.println("Decoded Message: " + decodedMsg);

        assertEquals(encodedMsg, "BGDKKN VNQKC");
        assertEquals(input, decodedMsg);
    }

    @Test
    public void testEncodeAndDecodeScenario2() {
        String input = "FHELLO WORLD";
        String encodedMsg = dxcController.encode(input);
        String decodedMsg = dxcController.decode(encodedMsg);

        // Display the encoded and decoded messages to the console
        System.out.println("Encoded Message: " + encodedMsg);
        System.out.println("Decoded Message: " + decodedMsg);

        assertEquals(encodedMsg, "FC/GGJ RJMG.");
        assertEquals(input, decodedMsg);
    }
}
