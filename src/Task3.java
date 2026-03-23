import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int n = in.nextInt();

        int[] arr = new int[n];

        System.out.println("Введите элементы массива:");
        inputArray(arr, 0, in);

        System.out.println("Элементы массива:");
        outputArray(arr, 0);

        in.close();
    }

    public static void inputArray(int[] arr, int index, Scanner in) {
        if (index >= arr.length) {
            return;
        }

        System.out.print("arr[" + index + "] = ");
        arr[index] = in.nextInt();

        inputArray(arr, index + 1, in);
    }

    public static void outputArray(int[] arr, int index) {
        if (index >= arr.length) {
            return;
        }

        System.out.print(arr[index] + " ");
        outputArray(arr, index + 1);
    }
}