package task61;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Количество духов
        int m = scanner.nextInt(); // Количество вопросов
        List<List<Integer>> bands = new ArrayList<>();
        Map<Integer, Integer> duhHistory = new HashMap<>();

        // Создаем банды для каждого духа
        for (int i = 1; i <= n; i++) {
            List<Integer> band = new ArrayList<>();
            band.add(i);
            bands.add(band);
            duhHistory.put(i, 1); // Исходно каждый дух в своей банде
        }

        for (int i = 0; i < m; i++) {
            int question = scanner.nextInt();
            if (question == 1) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                if (areInSameBand(bands, x, y) == false) {
                    //объединим банды
                    uniteBands(bands, x, y);
                    //увеличим количество банд в которых побывал дух
                    duhHistory.put(x, duhHistory.get(x) + 1);
                    duhHistory.put(y, duhHistory.get(y) + 1);
                }
            } else if (question == 2) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                if (areInSameBand(bands, x, y)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                int x = scanner.nextInt();
                System.out.println(duhHistory.get(x));
            }
            //printBands(bands);
        }
    }

    // Функция для объединения двух банд
    public static void uniteBands(List<List<Integer>> bands, int x, int y) {

        //Найдем индэкс банды для x
        int  bandXIndex = 0; // Индекс банды, где находится дух x (если найден)
        for (int i = 0; i < bands.size(); i++) {
            if (bands.get(i).contains(x)) {
                bandXIndex = i;
                break;
            }
        }

        //Найдем индэкс банды для x
        int  bandYIndex = 0; // Индекс банды, где находится дух x (если найден)
        for (int i = 0; i < bands.size(); i++) {
            if (bands.get(i).contains(y)) {
                bandYIndex = i;
                break;
            }
        }


        List<Integer> band1 = bands.get(bandXIndex);
        List<Integer> band2 = bands.get(bandYIndex);

        // Объединяем банды
        band1.addAll(band2);

        // Удаляем вторую банду после объединения
        bands.remove(bandYIndex);
    }

    // Функция для проверки, находятся ли духи x и y в одной банде
    public static boolean areInSameBand(List<List<Integer>> bands, int x, int y) {
        for (List<Integer> band : bands) {
            if (band.contains(x) && band.contains(y)) {
                return true;
            }
        }
        return false;
    }

    // Функция для вывода информации о бандах
    public static void printBands(List<List<Integer>> bands) {
        for (int i = 0; i < bands.size(); i++) {
            System.out.print("Банда " + (i + 1) + ": ");
            List<Integer> band = bands.get(i);
            for (int j = 0; j < band.size(); j++) {
                System.out.print(band.get(j));
                if (j < band.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
