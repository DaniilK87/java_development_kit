package org.example.homework5;

public class Philosopher implements Runnable {

    private Object leftFork;
    private Object rightFork;

    public Philosopher(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        int count = 1;
        while (count <= 3) {
            try {
                action(Thread.currentThread().getName() + ": Думает");
                synchronized (leftFork) {
                    action(Thread.currentThread().getName() + ": Берет левую вилку");
                    synchronized (rightFork) {
                        action(Thread.currentThread().getName() + ": Берет правую вилку. Ест" + " " +  count + " " + "раз");
                        action(Thread.currentThread().getName()+ ": Положил правую вилку");
                    }
                    action(Thread.currentThread().getName() + ": Полрожил левую вилку. Вернулся к мыслям");
                }
                count++;
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
        }
    }


    private void action(String action) throws InterruptedException {
        System.out.println(action);
        Thread.sleep((int) (Math.random() * 10));
    }
}
