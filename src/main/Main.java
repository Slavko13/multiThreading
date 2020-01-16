package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    new firstThread().start();
        new secondThread().start();
    }
    private static List<String> nameList = Collections.synchronizedList(new ArrayList<>());


    static class firstThread extends Thread {
        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            while(true) {
                synchronized (nameList) {
                    for (int i = 0; i < 2; i++) {
                        nameList.add(scanner.nextLine());
                    }
                    nameList.notify();
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }
        }
    }

    static class secondThread extends Thread {
        @Override
        public void run() {
            while (nameList.isEmpty()) {
                synchronized (nameList) {
                    try {
                        nameList.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 0; i< 2; i++) {
                    System.out.println(nameList.get(i));
                }
                nameList.clear();
            }
        }
    }
}


