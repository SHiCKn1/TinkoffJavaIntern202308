package task51;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Количество городов
        int m = scanner.nextInt(); // Количество дорог

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Считываем информацию о дорогах и строим граф
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            graph.get(u - 1).add(v - 1); // Уменьшаем индексы на 1
            graph.get(v - 1).add(u - 1); // Добавляем обратное направление
        }

        List<List<Integer>> states = findStates(n, graph);

        // Вывод информации о городах в каждом штате
        for (List<Integer> state : states) {
            for (int i = 0; i < state.size(); i++) {
                System.out.print(state.get(i) + 1); // Увеличиваем индекс на 1, чтобы вернуться к исходным номерам городов
                if (i < state.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    // Копирование графа
    private static List<List<Integer>> copyGraph(List<List<Integer>> graph) {
        List<List<Integer>> copy = new ArrayList<>();
        for (List<Integer> neighbors : graph) {
            copy.add(new ArrayList<>(neighbors));
        }
        return copy;
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
