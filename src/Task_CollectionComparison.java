import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.TreeSet;

public class Task_CollectionComparison {

    static final int VARIANT = 15;
    static final int N = VARIANT * 1_000_000;               
    static final long GET_BY_INDEX_COUNT = VARIANT * 1_000_000_000L; // 15 000 000 000

    public static void main(String[] args) {
        System.out.println("Вариант: " + VARIANT);
        System.out.println("Количество элементов в коллекции: " + N);
        System.out.println("Количество операций получения по индексу: " + GET_BY_INDEX_COUNT);
        System.out.println();

        testArrayList();
        System.out.println("--------------------------------------------------");

        testArrayDeque();
        System.out.println("--------------------------------------------------");

        testTreeSet();
    }

    // ===================== ArrayList =====================
    static void testArrayList() {
        System.out.println("=== ArrayList ===");

        ArrayList<Integer> list = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            list.add(i);
        }

        long start, end;

        // Добавление в начало
        start = System.nanoTime();
        list.add(0, -1);
        end = System.nanoTime();
        System.out.println("Добавление в начало: " + (end - start) + " нс");
        list.remove(0);

        // Добавление в середину
        start = System.nanoTime();
        list.add(list.size() / 2, -1);
        end = System.nanoTime();
        System.out.println("Добавление в середину: " + (end - start) + " нс");
        list.remove(list.size() / 2);

        // Добавление в конец
        start = System.nanoTime();
        list.add(-1);
        end = System.nanoTime();
        System.out.println("Добавление в конец: " + (end - start) + " нс");
        list.remove(list.size() - 1);

        // Удаление в начале
        start = System.nanoTime();
        int first = list.remove(0);
        end = System.nanoTime();
        System.out.println("Удаление в начале: " + (end - start) + " нс");
        list.add(0, first);

        // Удаление в середине
        int midIndex = list.size() / 2;
        start = System.nanoTime();
        int midValue = list.remove(midIndex);
        end = System.nanoTime();
        System.out.println("Удаление в середине: " + (end - start) + " нс");
        list.add(midIndex, midValue);

        // Удаление в конце
        start = System.nanoTime();
        int last = list.remove(list.size() - 1);
        end = System.nanoTime();
        System.out.println("Удаление в конце: " + (end - start) + " нс");
        list.add(last);

        // Получение по индексу
        long sum = 0;
        start = System.nanoTime();
        for (long i = 0; i < GET_BY_INDEX_COUNT; i++) {
            sum += list.get((int)(i % list.size()));
        }
        end = System.nanoTime();
        System.out.println("Получение по индексу: " + (end - start) + " нс");
      
    }

    // ===================== ArrayDeque =====================
    static void testArrayDeque() {
        System.out.println("=== ArrayDeque ===");

        ArrayDeque<Integer> deque = new ArrayDeque<>(N);
        for (int i = 0; i < N; i++) {
            deque.addLast(i);
        }

        long start, end;

        // Добавление в начало
        start = System.nanoTime();
        deque.addFirst(-1);
        end = System.nanoTime();
        System.out.println("Добавление в начало: " + (end - start) + " нс");
        deque.removeFirst();

        // Добавление в середину
        System.out.println("Добавление в середину: операция не поддерживается напрямую");

        // Добавление в конец
        start = System.nanoTime();
        deque.addLast(-1);
        end = System.nanoTime();
        System.out.println("Добавление в конец: " + (end - start) + " нс");
        deque.removeLast();

        // Удаление в начале
        start = System.nanoTime();
        int first = deque.removeFirst();
        end = System.nanoTime();
        System.out.println("Удаление в начале: " + (end - start) + " нс");
        deque.addFirst(first);

        // Удаление в середине
        System.out.println("Удаление в середине: операция не поддерживается напрямую");

        // Удаление в конце
        start = System.nanoTime();
        int last = deque.removeLast();
        end = System.nanoTime();
        System.out.println("Удаление в конце: " + (end - start) + " нс");
        deque.addLast(last);

        // Получение по индексу
        System.out.println("Получение по индексу: операция не поддерживается");
    }

    // ===================== TreeSet =====================
    static void testTreeSet() {
        System.out.println("=== TreeSet ===");

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            set.add(i);
        }

        long start, end;

        // Добавление в начало
        System.out.println("Добавление в начало: операция не применяется");

        // Добавление в середину
        System.out.println("Добавление в середину: операция не применяется");

        // Добавление в конец
        System.out.println("Добавление в конец: операция не применяется");

        // Удаление в начале (аналог - удаление минимального элемента)
        Integer first = set.first();
        start = System.nanoTime();
        set.remove(first);
        end = System.nanoTime();
        System.out.println("Удаление минимального элемента (аналог начала): " + (end - start) + " нс");
        set.add(first);

        // Удаление в середине
        System.out.println("Удаление в середине: операция не применяется");

        // Удаление в конце (аналог - удаление максимального элемента)
        Integer last = set.last();
        start = System.nanoTime();
        set.remove(last);
        end = System.nanoTime();
        System.out.println("Удаление максимального элемента (аналог конца): " + (end - start) + " нс");
        set.add(last);

        // Получение по индексу
        System.out.println("Получение по индексу: операция не поддерживается");
    }
}