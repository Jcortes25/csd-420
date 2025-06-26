import java.util.Comparator;

public class GenericBubbleSort {

    // Method 1: Uses Comparable to sort
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        for (int i = 0; i < list.length - 1; ++i) {
            for (int j = 0; j < list.length - 1 - i; ++j) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    // Method 2: Uses Comparator to sort
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        for (int i = 0; i < list.length - 1; ++i) {
            for (int j = 0; j < list.length - 1 - i; ++j) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    // Utility method to print arrays
    public static <E> void printArray(E[] array) {
        System.out.print("array = { ");
        for (E e : array) {
            System.out.print("[" + e + "] ");
        }
        System.out.println("};");
    }

    // Main method for testing
    public static void main(String[] args) {

        // Test with Integers using Comparable
        Integer[] intArray = {5, 3, 4, 9, 0, 1, 2, 7, 6, 8};
        System.out.println("Before sorting with Comparable:");
        printArray(intArray);

        bubbleSort(intArray);
        System.out.println("After sorting with Comparable:");
        printArray(intArray);

        // Test with Strings using Comparator
        String[] stringArray = {"Banana", "Apple", "Mango", "Orange"};
        System.out.println("\nBefore sorting with Comparator:");
        printArray(stringArray);

        // Sort using Comparator (alphabetical order)
        bubbleSort(stringArray, Comparator.naturalOrder());
        System.out.println("After sorting with Comparator:");
        printArray(stringArray);
    }
}
