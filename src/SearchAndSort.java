import java.util.Arrays;
import java.util.Scanner;

public class SearchAndSort {
    // Linear search algorithm
    public static int linearSearch(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1; // Key not found
    }

    // Binary search algorithm
    public static int[] binarySearch(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;
        int comparisons = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            comparisons++; // Increment the counter each time a comparison is made
            if (array[mid] == key) {
                return new int[] {mid, comparisons};
            } else if (array[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[] {-1, comparisons}; // Key not found
    }

    // Merge sort algorithm
    public static void mergeSort(int[] array) {
        if (array.length < 2) {
            return;
        }

        int mid = array.length / 2;
        int[] leftArray = Arrays.copyOfRange(array, 0, mid);
        int[] rightArray = Arrays.copyOfRange(array, mid, array.length);

        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(array, leftArray, rightArray);
    }

    private static void merge(int[] array, int[] leftArray, int[] rightArray) {
        int i = 0, j = 0, k = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < leftArray.length) {
            array[k++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            array[k++] = rightArray[j++];
        }
    }

    // Bubble sort algorithm
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    // Insertion sort algorithm
    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    // Selection sort algorithm
    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    // Quick sort algorithm
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    // Heap sort algorithm
    public static void heapSort(int[] array) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int n, int i) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < n && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        if (rightChild < n && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            heapify(array, n, largest);
        }
    }

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the number of elements: ");
    int n = scanner.nextInt();
    int[] array = new int[n];

    System.out.println("Enter the elements:");
    for (int i = 0; i < n; i++) {
        array[i] = scanner.nextInt();
    }

    System.out.println("Select an option:");
    System.out.println("1. Linear Search");
    System.out.println("2. Binary Search");
    System.out.println("3. Merge Sort");
    System.out.println("4. Bubble Sort");
    System.out.println("5. Insertion Sort");
    System.out.println("6. Selection Sort");
    System.out.println("7. Quick Sort");
    System.out.println("8. Heap Sort");

    System.out.print("Enter your choice: ");
    int choice = scanner.nextInt();

    long startTime = System.nanoTime();

        switch (choice) {
            case 1:
                System.out.print("Enter the key to search: ");
                int key = scanner.nextInt();
                int linearSearchResult = linearSearch(array, key);
                if (linearSearchResult == -1) {
                    System.out.println("Key not found");
                } else {
                    System.out.println("Key found at index: " + linearSearchResult);
                }
                break;
            case 2:
                Arrays.sort(array);
                System.out.print("Enter the key to search: ");
                int binaryKey = scanner.nextInt();
                int[] binarySearchResult = binarySearch(array, binaryKey);
                if (binarySearchResult[0] == -1) {
                    System.out.println("Key not found");
                } else {
                    System.out.println("Key found at index: " + binarySearchResult[0]);
                }
                System.out.println("Number of comparisons: " + binarySearchResult[1]);
                break;
            case 3:
                mergeSort(array);
                System.out.println("Array after Merge Sort: " + Arrays.toString(array));
                break;
            case 4:
                bubbleSort(array);
                System.out.println("Array after Bubble Sort: " + Arrays.toString(array));
                break;
            case 5:
                insertionSort(array);
                System.out.println("Array after Insertion Sort: " + Arrays.toString(array));
                break;
            case 6:
                selectionSort(array);
                System.out.println("Array after Selection Sort: " + Arrays.toString(array));
                break;
            case 7:
                quickSort(array);
                System.out.println("Array after Quick Sort: " + Arrays.toString(array));
                break;
            case 8:
                heapSort(array);
                System.out.println("Array after Heap Sort: " + Arrays.toString(array));
                break;
            default:
                System.out.println("Invalid choice");
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000; // Duration in milliseconds
        System.out.println("Time taken: " + duration + " milliseconds");

        scanner.close();
    }
}
