public class Task5_1 {
    //связанный список с головы

    static class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node head = null;

        head = new Node(5, head);
        head = new Node(4, head);
        head = new Node(3, head);
        head = new Node(2, head);
        head = new Node(1, head);

        System.out.println("Список, созданный с головы:");
        Node ref = head;
        while (ref != null) {
            System.out.println("Значение узла: " + ref.value);
            ref = ref.next;
        }
    }
}