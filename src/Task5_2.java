public class Task5_2{
    //связанный список с хвоста
    static class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1, null);
        Node tail = head;

        tail.next = new Node(2, null);
        tail = tail.next;

        tail.next = new Node(3, null);
        tail = tail.next;

        tail.next = new Node(4, null);
        tail = tail.next;

        tail.next = new Node(5, null);
        tail = tail.next;

        System.out.println("Список, созданный с хвоста:");
        Node ref = head;
        while (ref != null) {
            System.out.println("Значение узла: " + ref.value);
            ref = ref.next;
        }
    }
}