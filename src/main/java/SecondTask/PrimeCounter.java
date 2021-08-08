package SecondTask;

import java.util.List;
import java.util.concurrent.Callable;

public class PrimeCounter implements Callable<Integer> {

    private List<Integer> integerList;

    public PrimeCounter(List<Integer> numbers) {
        this.integerList = numbers;
    }

    @Override
    public Integer call() throws Exception {
        int primeNumber = 0;
        for (int i : integerList) {
            if (isPrime(i)) {
                primeNumber++;
            }
        }
        return primeNumber;
    }


    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        } else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
