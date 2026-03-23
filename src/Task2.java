import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите целое число: ");
        int n = in.nextInt();

        System.out.print("Число в двоичной системе: ");

        if (n == 0) {
            System.out.print(0);
        } else if (n < 0) {
            System.out.print("-");
            convertToBinary(-n);
        } else {
            convertToBinary(n);
        }

        in.close();
    }

    public static void convertToBinary(int n) {
        if (n > 1) {
            convertToBinary(n / 2);
        }
        System.out.print(n % 2);
    }
}