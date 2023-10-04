package task2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine(); // Считываем строку
        scanner.close();

        int[] letterCount = new int[26]; // Массив для подсчета количества каждой буквы (a-z)

        // Заполняем массив letterCount
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            letterCount[c - 'a']++;
        }

        // Буквы в слове "sheriff"
        String word = "sheriff";
        int minCount = Integer.MAX_VALUE;

        // Находим минимальное количество букв для каждой буквы слова "sheriff"
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            minCount = Math.min(minCount, letterCount[index]);
        }

        // Максимальное количество слов "sheriff"
        int maxSheriffWords = minCount;

        System.out.println(maxSheriffWords);
    }
}

