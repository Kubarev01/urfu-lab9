import java.util.LinkedList;
import java.util.Scanner;

public class Task7_2{
    //LinkedList
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите количество человек N: ");
        int n = in.nextInt();

        LinkedList<Integer> people = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            people.add(i);
        }

        int index = 0;

        while (people.size() > 1) {
            index = (index + 1) % people.size();
            System.out.println("Удален человек: " + people.get(index));
            people.remove(index);
        }

        System.out.println("Остался человек под номером: " + people.get(0));

        in.close();
    }
}