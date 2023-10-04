package task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // количество револьверов
        int s = scanner.nextInt(); // количество долларов у Джо
        int maxPrice = 0; // переменная для хранения стоимости самого дорогого револьвера

        // Считываем и обрабатываем цены на револьверы
        for (int i = 0; i < n; i++) {
            int price = scanner.nextInt();
            if (price <= s && price > maxPrice) {
                maxPrice = price;
            }
        }

        System.out.println(maxPrice);
    }
}
