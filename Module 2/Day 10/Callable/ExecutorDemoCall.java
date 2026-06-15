package callable;

import java.util.concurrent.*;

public class ExecutorDemoCall {
    public static void main(String[] args) {
        ExecutorService executor= Executors.newSingleThreadExecutor();
        Future<Integer> futureVal=executor.submit(new MyCallable());
        System.out.println("Future value will be received now");
        try{
            int value=futureVal.get(5, TimeUnit.SECONDS);
            System.out.println("Value: "+ value);
        }catch (InterruptedException e){
            System.out.println("Thread Interrupted");
        }catch(ExecutionException e){
            System.out.println("Execution exception: "+e.getMessage());
        }catch (TimeoutException e){
            System.out.println("Timeout Exception: "+ e.getMessage());
        }
        executor.shutdown();
    }
}
