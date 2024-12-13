import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Lr_4_2 {
    public static void main(String[] args) {
        // Початок часу виконання
        long startTime = System.currentTimeMillis();

        // Виконання попередньої асинхронної операції
        CompletableFuture.runAsync(() -> System.out.println("Запуск асинхронної програми..."));

        // Генерація послідовності цілих чисел
        CompletableFuture<List<Integer>> generateSequence = CompletableFuture.supplyAsync(() -> {
            System.out.println("Генерація послідовності чисел...");
            List<Integer> sequence = new ArrayList<>();
            Random random = new Random();
            for (int i = 0; i < 20; i++) {
                sequence.add(random.nextInt(100)); // Числа в діапазоні [0, 100)
            }
            System.out.println("Згенерована послідовність: " + sequence);
            return sequence;
        });

        // Обчислення мінімуму непарних індексів
        CompletableFuture<Integer> minOddIndices = generateSequence.thenApplyAsync(sequence -> {
            System.out.println("Обчислення мінімуму чисел на непарних індексах...");
            int min = sequence.stream()
                    .filter(n -> sequence.indexOf(n) % 2 == 0)
                    .mapToInt(Integer::intValue)
                    .min()
                    .orElse(Integer.MAX_VALUE);
            System.out.println("Мінімум на непарних індексах: " + min);
            return min;
        });

        // Обчислення максимуму парних індексів
        CompletableFuture<Integer> maxEvenIndices = generateSequence.thenApplyAsync(sequence -> {
            System.out.println("Обчислення максимуму чисел на парних індексах...");
            int max = sequence.stream()
                    .filter(n -> sequence.indexOf(n) % 2 != 0)
                    .mapToInt(Integer::intValue)
                    .max()
                    .orElse(Integer.MIN_VALUE);
            System.out.println("Максимум на парних індексах: " + max);
            return max;
        });

        // Обчислення результату та вивід
        CompletableFuture<Void> result = minOddIndices.thenCombineAsync(maxEvenIndices, Integer::sum).thenAcceptAsync(sum -> {
            System.out.println("Сума мінімуму та максимуму: " + sum);
        });

        // Виконання дії після завершення всіх операцій
        result.thenRunAsync(() -> {
            long endTime = System.currentTimeMillis();
            System.out.println("Час виконання всіх асинхронних операцій завершено.");
        });

        // Очікування завершення всіх операцій
        try {
            result.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Кінець часу виконання
        long endTime = System.currentTimeMillis();
        System.out.println("Час виконання всіх асинхронних операцій: " + (endTime - startTime) + " мс");
    }
}
