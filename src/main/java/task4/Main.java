package task4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // Необходимая сумма
        int m = scanner.nextInt(); // Количество номиналов

        ArrayList<Integer> denominations = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int sameNominations = scanner.nextInt();
            denominations.add(sameNominations);
            denominations.add(sameNominations);
        }

        // Сортируем номиналы по убыванию
        Collections.sort(denominations, Collections.reverseOrder());

        ArrayList<Integer> stolenDenominations = new ArrayList<>();
        int sum = 0;

        //пробуем получить нужную сумму из купюр и добавляем эти купюры в колекцию
        for (int i = 0; i < (m * 2); i++) {
            if (sum + denominations.get(i) <= n) {
                sum += denominations.get(i);
                stolenDenominations.add(denominations.get(i));
            }
        }

        //сортируем колекцию купюр для Джо
        Collections.sort(stolenDenominations);

        //Если сумма купюр ровна нужной сумме выводим данные согласно условию
        //Иначе -1
        if (sum == n) {
            System.out.println(stolenDenominations.size());
            for (int denomination : stolenDenominations) {
                System.out.print(denomination + " ");
            }
        } else {
            System.out.println(-1);
        }
    }
}
