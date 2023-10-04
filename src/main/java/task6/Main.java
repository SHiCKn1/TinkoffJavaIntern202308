package task6;

import java.util.List;
import java.util.Scanner;

public class Main {

    public class Ghost {
        public int number;
        public int countOfGang;

        public Ghost(int number, int countOfGang) {
            this.number = number;
            this.countOfGang = countOfGang;
        }

        public int getCountOfGang() {
            return countOfGang;
        }

        public void setCountOfGang(int countOfGang) {
            this.countOfGang = countOfGang;
        }
    }

    public class GhostsGang {
        public List<Ghost> Ghosts;

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Количество духов
        int m = scanner.nextInt(); // Количество вопросов

        int[] ghost = new int[n];






        for (int i = 0; i < m; i++) {
            //Заполним матрицу входными данными
//            map[i][0] = scanner.nextInt(); //начальная точка
//            map[i][1] = scanner.nextInt(); //конечная точка
//            map[i][2] = scanner.nextInt(); //длина дорожки
//            x = Math.max(x, map[i][2]);
        }
    }
}
