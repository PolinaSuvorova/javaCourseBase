package multithrading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SumNumbers {
    private static long value = 1_000_000_000L;
    private static long sum = 0;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<Long>> futureResults = new ArrayList<>();
        long valueDividedBy10 = value / 10;
        for (int i = 0; i < 10 ; i++) {
            long from = valueDividedBy10 * i + 1;
            long to = valueDividedBy10 * (i + 1);
            PartialSum task = new PartialSum(from, to);
            Future<Long> futurePartSum = executorService.submit(task);
            futureResults.add(futurePartSum);
        }

        long sum = futureResults.stream().mapToLong(t-> {
            try {
                Long localSum = t.get();
                System.out.println("call t.get() =" + localSum);
                return localSum;
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).sum();
        executorService.shutdown();
        System.out.println("totalSum = " + sum);

    }
}

class PartialSum implements Callable<Long>{
long from;
long to;
long localSum;

    public PartialSum(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Long call() throws Exception {
        for (long i = from; i <= to ; i++) {
            localSum += i;
        }
        System.out.println( from + " + " + to + " = " + localSum);

        return localSum;
    }
}
