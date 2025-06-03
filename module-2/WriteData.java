import java.io.*;
import java.util.Random;

public class WriteData {
    public static void main(String[] args) {
        int[] intArray = new int[5];
        double[] doubleArray = new double[5];
        Random rand = new Random();

        // Fill arrays with random values
        for (int i = 0; i < 5; i++) {
            intArray[i] = rand.nextInt(100); // Random integers from 0 to 99
            doubleArray[i] = rand.nextDouble() * 100; // Random doubles from 0.0 to 99.999...
        }

        String fileName = "james_datafile.dat"; 

        try (FileWriter fw = new FileWriter(fileName, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {

            out.println("Integers:");
            for (int num : intArray) {
                out.print(num + " ");
            }
            out.println();

            out.println("Doubles:");
            for (double d : doubleArray) {
                out.printf("%.2f ", d);
            }
            out.println();
            out.println("---"); 

            System.out.println("Data written successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred while writing to file.");
            e.printStackTrace();
        }
    }
}
