import FirstTask.ThreadRunner;
import SecondTask.PrimeCounter;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainApp {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.out.println("////************************FirstTask************************////");

        ThreadRunner threadRunner = new ThreadRunner();
        threadRunner.runThreads();


        System.out.println("////************************SecondTask************************////");

        List<Integer> integerList = Stream.of(1, 4, 6, 8, 9, 10, 17, 19, 23, 29).collect(Collectors.toList());

        FutureTask<Integer> firstSubList = new FutureTask<>(
                new PrimeCounter(integerList.subList(0, integerList.size() / 2)));
        FutureTask<Integer> secondSubList = new FutureTask<>(
                new PrimeCounter(integerList.subList(integerList.size() / 2, integerList.size())));

        Thread firstThread = new Thread(firstSubList);
        Thread secondThread = new Thread(secondSubList);

        firstThread.start();
        firstThread.join();

        secondThread.start();
        secondThread.join();

        Integer firstSubListResult = firstSubList.get();
        System.out.println("First subList - " + firstSubListResult);

        Integer secondSubListResult = secondSubList.get();
        System.out.println("Second subList - " + secondSubListResult);

        int TotalSum = firstSubListResult + secondSubListResult;
        System.out.println("Total sum of Prime Numbers from Threads is - " + TotalSum);
    }
}
