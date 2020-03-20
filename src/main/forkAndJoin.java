package main;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class forkAndJoin {

    public static void main(String[] args) throws InterruptedException {

        int N = 100000000;


        List<Integer> numbersForTest = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            numbersForTest.add(1 + (int) (Math.random() * 100));
        }

        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        MyThread thread3 = new MyThread();
        MyThread thread4 = new MyThread();

        thread1.numbers = numbersForTest.subList(0, numbersForTest.size() / 4 -1);
        thread2.numbers = numbersForTest.subList(numbersForTest.size() / 4, numbersForTest.size() / 2 - 1);
        thread3.numbers = numbersForTest.subList(numbersForTest.size() / 2, numbersForTest.size() * 3 / 4 - 1 );
        thread4.numbers = numbersForTest.subList(numbersForTest.size() * 3 / 4, numbersForTest.size() - 1);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        Thread.sleep(2000);

        List<Integer> finalResult = new ArrayList<>(thread1.endPoint);
        finalResult.addAll(thread2.endPoint);
        finalResult.addAll(thread3.endPoint);
        finalResult.addAll(thread4.endPoint);

        IntStream workTimeStream = IntStream.of(thread1.workTime, thread2.workTime, thread3.workTime, thread4.workTime);

        System.out.println("Кол-во чисел для теста: " + numbersForTest.size());
        System.out.println("Время выполнения при 4 потоках: " + workTimeStream.max().getAsInt() + " миллисекунд");
    }

    static class MyThread extends  Thread {
        private int workTime;
        private List<Integer> numbers;
        private List<Integer> endPoint;

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            endPoint = numbers.stream()
                    .filter(number -> number * number * number > 10000)
                    .collect(Collectors.toList());
            workTime = (int) (System.currentTimeMillis() - start);
        }
    }

}


