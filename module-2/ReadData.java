import java.io.*;

public class ReadData {
    public static void main(String[] args) {
        String fileName = "james_datafile.dat"; 
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please run the WriteData program first.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading from file.");
            e.printStackTrace();
        }
    }
}
