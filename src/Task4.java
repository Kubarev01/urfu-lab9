public class Task4 {

    static class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        System.out.println("Создание однонаправленного списка из независимых узлов");

        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);

        Node head = node1;

        System.out.println("Список создан.");
        System.out.println("Вывод значений элементов списка:");

        Node ref = head;
        while (ref != null) {
            System.out.println("Значение узла: " + ref.value);
            ref = ref.next;
        }
    }
}