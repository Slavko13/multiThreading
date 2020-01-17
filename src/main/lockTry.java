package main;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class lockTry {
    public static void main(String[] args) {
        Resource resource = new Resource();
        resource.setLocalVar(3);
        firstThread thread1 = new firstThread();
        firstThread thread2 = new firstThread();
        thread1.setResource(resource);
        thread2.setResource(resource);
        thread1.start();
        thread2.start();
        System.out.println(resource.getLocalVar());
    }

    static class Resource {
        private int localVar;
        Lock lock = new ReentrantLock();

        int getLocalVar() {
            return localVar;
        }

        void setLocalVar(int localVar) {
            this.localVar = localVar;
        }

        void changeVar(){
            lock.lock();
            localVar++;
            lock.unlock();
        }

    }

    static class firstThread extends Thread {
        private Resource resource;

        public Resource getResource() {
            return resource;
        }

        public void setResource(Resource resource) {
            this.resource = resource;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " Im Started");
            resource.changeVar();
            System.out.println(resource.getLocalVar());
        }
    }


}
