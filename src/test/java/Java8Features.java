import org.junit.Test;

import java.util.*;

import static java.util.Comparator.comparing;

public class Java8Features {

    @Test
    public void run() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );


//        Find all transactions in the year 2011 and sort them by value (small to high).
//        transactions.stream()
//                .filter(trx -> trx.getYear() == 2011)
//                .sorted(comparing(Transaction::getValue))
//                .forEach(System.out::print);

//        What are all the unique cities where the traders work?
//        transactions.stream().map(t -> t.getTrader().getCity()).distinct().forEach(System.out::println);

//        Find all traders from Cambridge and sort them by name.
//          transactions.stream()
//                  .map(t -> t.getTrader())
//                  .distinct()
//                  .sorted(comparing(Trader::getName))
//                  .forEach(System.out::println);
//        Return a string of all traders’ names sorted alphabetically.
            transactions.stream()
                    .map(t -> t.getTrader().getName())
                    .distinct()
                    .sorted()
                    .forEach(System.out::println);

//        Are any traders based in Milan?


//        Print all transactions’ values from the traders living in Cambridge.
//
//        What’s the highest value of all the transactions?
//
//        Find the transaction with the smallest value.
            Optional<Transaction> t = transactions.stream()
                    .reduce((t1, t2) -> t1.getValue() < t2.getValue()? t1: t2);
        System.out.println(t.get());


    }

    private static class Trader {

        private final String name;
        private final String city;

        public Trader(String n, String c){
            this.name = n;
            this.city = c;
        }

        public String getName(){
            return this.name;
        }

        public String getCity(){
            return this.city;
        }

        public String toString(){
            return "Trader:"+this.name + " in " + this.city;
        }
    }

    private static class Transaction {

        private final Trader trader;
        private final int year;
        private final int value;

        public Transaction(Trader trader, int year, int value) {
            this.trader = trader;
            this.year = year;
            this.value = value;
        }

        public Trader getTrader() {
            return this.trader;
        }

        public int getYear() {
            return this.year;
        }

        public int getValue() {
            return this.value;
        }

        public String toString() {
            return "{" + this.trader + ", " +
                    "year: " + this.year + ", " +
                    "value:" + this.value + "}";
        }
    }

}
