package task5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Количество городов
        int m = scanner.nextInt(); // Количество дорог



        int x = 0; //для начала присвоим х максимальную длину дорожки

        //Начальная карта
        int[][] map = new int[m][3];

        for (int i = 0; i < m; i++) {
            //Заполним матрицу входными данными
            map[i][0] = scanner.nextInt(); //начальная точка
            map[i][1] = scanner.nextInt(); //конечная точка
            map[i][2] = scanner.nextInt(); //длина дорожки
            x = Math.max(x, map[i][2]);
        }

        //отсортируем по колонке 2
        Arrays.sort(map, Comparator.comparingInt(arr -> arr[2]));



        int numberOfState = 0;



        for (int j = 0; j <= x; j++) {
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }

           // Считываем информацию о дорогах и строим граф
            for (int i = 0; i < m; i++) {
                if (j < map[i][2]) {
                    int u = map[i][0];
                    int v = map[i][1];

                    graph.get(u - 1).add(v - 1); // Уменьшаем индексы на 1
                    graph.get(v - 1).add(u - 1); // Добавляем обратное направление
                }
            }

            List<List<Integer>> states = findStates(n, graph);

            if (j == 0) {
                //Первая итерация
                //Все дороги на месте
                numberOfState = states.size();
            }

            if (states.size() != numberOfState) {
                x = j;
                break;
            }

        }

        System.out.println(x - 1);

    }

    // Поиск штатов
    private static List<List<Integer>> findStates(int n, List<List<Integer>> graph) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> states = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> state = new ArrayList<>();
                dfs(i, graph, visited, state);
                states.add(state);
            }
        }

        return states;
    }

    // DFS для поиска городов в штате
    private static void dfs(int node, List<List<Integer>> graph, boolean[] visited, List<Integer> state) {
        visited[node] = true;
        state.add(node);

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited, state);
            }
        }
    }
}



