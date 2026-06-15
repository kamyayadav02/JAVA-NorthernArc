package Multithreading3;
public class Main1 {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++)  //here we used lambda
            new Thread(() -> {
                for (int j = 1; j <= 100; j++) {
                    System.out.println(j + " " + Thread.currentThread().getName());
                }
            }).start();
    }
}

//        Runnable r = () -> {
//            for(int i = 1; i <= 100; i++){
//                System.out.println(i + " " + Thread.currentThread().getName());
//            }
//        };
//
//        Thread t1 = new Thread(r, "Thread-1");
//        Thread t2 = new Thread(r, "Thread-2");
//
//        t1.start();
//        t2.start();
//    }
//}