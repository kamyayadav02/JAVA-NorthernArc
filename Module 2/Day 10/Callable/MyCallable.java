package callable;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep((int)(1000*Math.random()));
        System.out.println("Callable is called by" + Thread.currentThread());
        return (int)Math.random()*10000;
    }
}
