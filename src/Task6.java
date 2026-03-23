import java.util.HashMap;
import java.util.Map;

public class Task6 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(0, "кот");
        map.put(1, "машина");
        map.put(2, "дом");
        map.put(3, "программа");
        map.put(4, "лес");
        map.put(5, "студент");
        map.put(6, "университет");
        map.put(7, "окно");
        map.put(8, "телефон");
        map.put(9, "книга");

        System.out.println("Строки, у которых ключ > 5:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() > 5) {
                System.out.println(entry.getValue());
            }
        }

        System.out.println();

        String result = "";
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() == 0) {
                if (!result.isEmpty()) {
                    result += ", ";
                }
                result += entry.getValue();
            }
        }
        System.out.println("Строки при ключе = 0: " + result);

        int product = 1;
        boolean found = false;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().length() > 5) {
                product *= entry.getKey();
                found = true;
            }
        }

        if (found) {
            System.out.println("Произведение ключей, где длина строки > 5: " + product);
        } else {
            System.out.println("Нет строк длиной больше 5.");
        }
    }
} 
    

