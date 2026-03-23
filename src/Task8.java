import java.util.Scanner;

public class Task8 {

    static class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    static class List {
        Node head;

        // =========================
        // а) Методы с использованием цикла
        // =========================

        // Ввод с головы
        void createHead(int n, Scanner in) {
            head = null;
            for (int i = 0; i < n; i++) {
                System.out.print("Введите элемент: ");
                int value = in.nextInt();
                head = new Node(value, head);
            }
        }

        // Ввод с хвоста
        void createTail(int n, Scanner in) {
            head = null;
            Node tail = null;

            for (int i = 0; i < n; i++) {
                System.out.print("Введите элемент: ");
                int value = in.nextInt();
                Node newNode = new Node(value, null);

                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    tail.next = newNode;
                    tail = newNode;
                }
            }
        }

        // Вывод списка в строку
        public String toString() {
            String result = "";
            Node ref = head;

            while (ref != null) {
                result += ref.value + " ";
                ref = ref.next;
            }

            return result;
        }

        // Добавление в начало
        void AddFirst(int value) {
            head = new Node(value, head);
        }

        // Добавление в конец
        void AddLast(int value) {
            Node newNode = new Node(value, null);

            if (head == null) {
                head = newNode;
                return;
            }

            Node ref = head;
            while (ref.next != null) {
                ref = ref.next;
            }
            ref.next = newNode;
        }

        // Вставка по номеру
        void Insert(int index, int value) {
            if (index == 0) {
                AddFirst(value);
                return;
            }

            Node ref = head;
            int k = 0;

            while (ref != null && k < index - 1) {
                ref = ref.next;
                k++;
            }

            if (ref != null) {
                Node newNode = new Node(value, ref.next);
                ref.next = newNode;
            }
        }

        // Удаление первого элемента
        void RemoveFirst() {
            if (head != null) {
                head = head.next;
            }
        }

        // Удаление последнего элемента
        void RemoveLast() {
            if (head == null) {
                return;
            }

            if (head.next == null) {
                head = null;
                return;
            }

            Node ref = head;
            while (ref.next.next != null) {
                ref = ref.next;
            }
            ref.next = null;
        }

        // Удаление элемента по номеру
        void Remove(int index) {
            if (head == null) {
                return;
            }

            if (index == 0) {
                RemoveFirst();
                return;
            }

            Node ref = head;
            int k = 0;

            while (ref.next != null && k < index - 1) {
                ref = ref.next;
                k++;
            }

            if (ref.next != null) {
                ref.next = ref.next.next;
            }
        }

        // =========================
        // б) Методы с использованием рекурсии
        // =========================

        // Ввод с головы рекурсивно
        void createHeadRec(int n, Scanner in) {
            head = createHeadRecHelper(n, in);
        }

        Node createHeadRecHelper(int n, Scanner in) {
            if (n == 0) {
                return null;
            }

            System.out.print("Введите элемент: ");
            int value = in.nextInt();

            return new Node(value, createHeadRecHelper(n - 1, in));
        }

        // Ввод с хвоста рекурсивно
        void createTailRec(int n, Scanner in) {
            head = createTailRecHelper(n, in);
        }

        Node createTailRecHelper(int n, Scanner in) {
            if (n == 0) {
                return null;
            }

            System.out.print("Введите элемент: ");
            int value = in.nextInt();

            if (n == 1) {
                return new Node(value, null);
            }

            Node first = new Node(value, null);
            first.next = createTailRecHelper(n - 1, in);
            return first;
        }

        // Вывод списка рекурсивно
        String toStringRec() {
            return toStringRecHelper(head);
        }

        String toStringRecHelper(Node node) {
            if (node == null) {
                return "";
            }
            return node.value + " " + toStringRecHelper(node.next);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List list = new List();

        System.out.print("Введите количество элементов списка: ");
        int n = in.nextInt();

        System.out.println("Создание списка с хвоста:");
        list.createTail(n, in);
        System.out.println("Список: " + list.toString());

        System.out.println("Добавим 100 в начало:");
        list.AddFirst(100);
        System.out.println("Список: " + list.toString());

        System.out.println("Добавим 200 в конец:");
        list.AddLast(200);
        System.out.println("Список: " + list.toString());

        System.out.println("Вставим 300 на позицию 2:");
        list.Insert(2, 300);
        System.out.println("Список: " + list.toString());

        System.out.println("Удалим первый элемент:");
        list.RemoveFirst();
        System.out.println("Список: " + list.toString());

        System.out.println("Удалим последний элемент:");
        list.RemoveLast();
        System.out.println("Список: " + list.toString());

        System.out.println("Удалим элемент с индексом 2:");
        list.Remove(2);
        System.out.println("Список: " + list.toString());

        System.out.println();
        System.out.println("Рекурсивный вывод списка:");
        System.out.println(list.toStringRec());

        in.close();
    }
}