package com.redfox.aston.homeworkstream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
//1.  Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей).
        transactions.stream()
                .filter(tr -> tr.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);
        System.out.println();
//2. Вывести список неповторяющихся городов, в которых работают трейдеры.
        transactions.stream()
                .map(original -> original.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
        System.out.println();
//3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(x -> x.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);
        System.out.println();
//4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.
        transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);
        System.out.println();
//5. Выяснить, существует ли хоть один трейдер из Милана.
        transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .filter(m -> m.getCity().equals("Milan"))
                .forEach(System.out::println);
        System.out.println();
//6. Вывести суммы всех транзакций трейдеров из Кембриджа.
        transactions.stream()
                .filter(trk -> trk.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);
        System.out.println();
//7. Какова максимальная сумма среди всех транзакций?
        int max = transactions.stream()
                .map(Transaction::getValue)
                .max(Integer::compare).get();
        System.out.println(max);
        System.out.println();
//8. Найти транзакцию с минимальной суммой.
        int min = transactions.stream()
                .map(Transaction::getValue)
                .min(Integer::compare).get();
        System.out.println(min);
        System.out.println();
    }
}