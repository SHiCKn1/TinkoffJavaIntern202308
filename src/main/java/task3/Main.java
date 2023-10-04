package task3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] cowboySequence = new int[n];
        int[] winSequence = new int[n];

        for (int i = 0; i < n; i++) {
            cowboySequence[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            winSequence[i] = scanner.nextInt();
        }

        boolean canWin = false;

        // Копируем и сортируем только часть массива cowboySequence

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] sortedCowboy = Arrays.copyOf(cowboySequence, n);
                Arrays.sort(sortedCowboy, i, j); // Сортируем с i-го по j-й элементы
                // Сравниваем отсортированный массив с winSequence
                canWin = Arrays.equals(sortedCowboy, winSequence);
                if (canWin) {
                    //прерываем если Джо победил
                    break;
                }
            }
            if (canWin) {
                //прерываем если Джо победил
                break;
            }
        }

        // Выводим результат
        if (canWin) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

