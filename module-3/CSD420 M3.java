import java.util.ArrayList;
import java.util.Random;

public class Module3Assignment {

    public static void main(String[] args) {
        ArrayList<Integer> originalList = new ArrayList<>();
        Random random = new Random();

        // Fill the list with 50 random integers between 1 and 20
        for (int i = 0; i < 50; i++) {
            originalList.add(random.nextInt(20) + 1);
        }

        // Display original list
        System.out.println("Original List (with duplicates):");
        System.out.println(originalList);

        // Remove duplicates
        ArrayList<Integer> uniqueList = removeDuplicates(originalList);

        // Display unique list
        System.out.println("\nList after removing duplicates:");
        System.out.println(uniqueList);
    }

    // Generic method to remove duplicates
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> result = new ArrayList<>();
        for (E item : list) {
            if (!result.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }
}
