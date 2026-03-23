import java.util.Scanner;

public class Task1 {

    // Пример 1
    static void example1(int x) {
        if (x >= 20) {
            return;
        }
        System.out.print(x + " ");
        example1(2 * x + 1);
    }

    // Пример 2
    static void example2(int x) {
        if (x >= 20) {
            return;
        }
        example2(2 * x + 1);
        System.out.print(x + " ");
    }

    // Пример 3
    static void example3(int x) {
        if (x >= 20) {
            return;
        }
        System.out.println("Перед рекурсивным вызовом: x = " + x);
        example3(2 * x + 1);
        System.out.println("После рекурсивного вызова: x = " + x);
    }

    // Пример 4
    static int factorial(int n) {
        if (n == 0 || n == 1) {
            System.out.println("factorial(" + n + ") = 1");
            return 1;
        }
        System.out.println("Вычисляем: " + n + " * factorial(" + (n - 1) + ")");
        return n * factorial(n - 1);
    }

    // Пример 5
    static int fibonacci(int n) {
        System.out.println("Вызов fibonacci(" + n + ")");

        if (n == 0) {
            System.out.println("fibonacci(0) = 0");
            return 0;
        }

        if (n == 1) {
            System.out.println("fibonacci(1) = 1");
            return 1;
        }

        int result = fibonacci(n - 1) + fibonacci(n - 2);
        System.out.println("fibonacci(" + n + ") = " + result);
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Демонстрация рекурсивных алгоритмов");
        System.out.println();

        System.out.print("Введите x для примеров 1-3: ");
        int x = in.nextInt();
        System.out.println();

        System.out.println("Пример 1. Последовательность:");
        example1(x);
        System.out.println();
        System.out.println();

        System.out.println("Пример 2. Та же последовательность в обратном порядке:");
        example2(x);
        System.out.println();
        System.out.println();

        System.out.println("Пример 3. Вывод до и после рекурсивного вызова:");
        example3(x);
        System.out.println();

        System.out.print("Введите n для вычисления факториала: ");
        int n = in.nextInt();
        System.out.println("Пример 4. Факториал числа " + n + ":");
        int fact = factorial(n);
        System.out.println("Итоговый результат: " + n + "! = " + fact);
        System.out.println();

        System.out.print("Введите номер числа Фибоначчи: ");
        int f = in.nextInt();
        System.out.println("Пример 5. Число Фибоначчи:");
        int fib = fibonacci(f);
        System.out.println("Итоговый результат: F(" + f + ") = " + fib);

        in.close();
    }
}