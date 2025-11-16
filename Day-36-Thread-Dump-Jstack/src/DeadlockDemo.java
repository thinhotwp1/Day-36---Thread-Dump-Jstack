public class DeadlockDemo {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();


    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: Đã khóa Lock 1. Đang ngủ...");
                try { Thread.sleep(100); } catch (Exception e) {}
                System.out.println("Thread 1: Đang chờ khóa Lock 2...");
                synchronized (lock2) {
                    System.out.println("Thread 1: Đã khóa cả hai.");
                }
            }
        }, "Thread-1-An"); // <-- Đặt tên rõ ràng


        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2: Đã khóa Lock 2. Đang ngủ...");
                try { Thread.sleep(100); } catch (Exception e) {}
                System.out.println("Thread 2: Đang chờ khóa Lock 1...");
                synchronized (lock1) {
                    System.out.println("Thread 2: Đã khóa cả hai.");
                }
            }
        }, "Thread-2-Binh"); // <-- Đặt tên rõ ràng


        thread1.start();
        thread2.start();
        System.out.println("Main: Đã khởi động 2 luồng. Ứng dụng sẽ bị treo.");
    }
}
