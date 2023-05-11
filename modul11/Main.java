package ua.goit.sergey.modul11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();

        input.add("Max");
        input.add("Kolya");
        input.add("Dog");
        input.add("Shtorm");
        input.add("Ambrela");

        String[] array = {"1, 2, 0", "4, 5"};

        System.out.println("Task 1: " + task1(input));
        System.out.println("Task 2: " + task2(input));
        System.out.println("Task 3: " + task3(array));
        System.out.println("Task 4: \n");
        task4(25_214_903_917L, 11, (int) Math.pow(2, 48)).limit(10).forEach(System.out::println);

    }

    public static String task1 (List <String> input ){
        return IntStream.range(0,input.size())
                .filter(index -> index % 2 == 0)
                .mapToObj(index -> (index + 1) + ". " + input.get(index))
                .collect(Collectors.joining(", "));
    }

    public static String task2 (List <String> input ){
        return input.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining(", "));
    }

    public static String task3 (String[] arr){
         return        Arrays.stream(arr)
                 .flatMap(str-> Arrays.stream(str.split(", ")))
                 .map(Integer::parseInt)
                 .sorted()
                 .map(s->String.valueOf(s))
                 .collect(Collectors.joining(", "));
    }

    public static Stream<Long> task4(long a, int c, int m){
        long seed = 0;
        return Stream.iterate(seed, n -> (a * n + c) % m);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        Stream.Builder<T> builder = Stream.builder();
        while (first.iterator().hasNext() && second.iterator().hasNext()) {
            builder.accept(first.iterator().next());
            builder.accept(second.iterator().next());
        }
        return builder.build();
    }
}
