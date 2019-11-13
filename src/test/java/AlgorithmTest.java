import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author kourosh
 * @since 2019-11-12
 */
public class AlgorithmTest {

    @Test
    public void test() throws FileNotFoundException {
        String fileName = getClass().getResource("addition_sample1_YES.in").getFile();
        BanaeianzadehKourosh10149436.main(new String[]{fileName});

    }

    @Test
    public void test1() {
        Scanner scanner = new Scanner(getClass().getResourceAsStream("addition_sample1_YES.in"));
        BanaeianzadehKourosh10149436 algorithm = new BanaeianzadehKourosh10149436(scanner);
        assertTrue(algorithm.compute());
        algorithm.printArray();
    }

    @Test
    public void test2() {
        Scanner scanner = new Scanner(getClass().getResourceAsStream("addition_sample2_YES.in"));
        BanaeianzadehKourosh10149436 algorithm = new BanaeianzadehKourosh10149436(scanner);
        assertTrue(algorithm.compute());
        algorithm.printArray();
    }

    @Test
    public void test3() {
        Scanner scanner = new Scanner(getClass().getResourceAsStream("addition_sample3_YES.in"));
        BanaeianzadehKourosh10149436 algorithm = new BanaeianzadehKourosh10149436(scanner);
        assertTrue(algorithm.compute());
        algorithm.printArray();
    }

    @Test
    public void test4() {
        Scanner scanner = new Scanner(getClass().getResourceAsStream("addition_sample4_NO.in"));
        BanaeianzadehKourosh10149436 algorithm = new BanaeianzadehKourosh10149436(scanner);
        assertFalse(algorithm.compute());
        algorithm.printArray();
    }

    @Test
    public void test5() {
        Scanner scanner = new Scanner(getClass().getResourceAsStream("addition_sample5_NO.in"));
        BanaeianzadehKourosh10149436 algorithm = new BanaeianzadehKourosh10149436(scanner);
        assertFalse(algorithm.compute());
        algorithm.printArray();
    }

    @Test
    public void test6() {
        Scanner scanner = new Scanner(getClass().getResourceAsStream("addition_sample6_NO.in"));
        BanaeianzadehKourosh10149436 algorithm = new BanaeianzadehKourosh10149436(scanner);
        assertFalse(algorithm.compute());
        algorithm.printArray();
    }

    @Test
    public void test7() {
        Scanner scanner = new Scanner(getClass().getResourceAsStream("addition_sample7_NO.in"));
        BanaeianzadehKourosh10149436 algorithm = new BanaeianzadehKourosh10149436(scanner);
        assertFalse(algorithm.compute());
        algorithm.printArray();
    }

    @Test
    public void test8() {
        Scanner scanner = new Scanner(getClass().getResourceAsStream("addition_sample8_YES.in"));
        BanaeianzadehKourosh10149436 algorithm = new BanaeianzadehKourosh10149436(scanner);
        assertTrue(algorithm.compute());
        algorithm.printArray();
    }
}
