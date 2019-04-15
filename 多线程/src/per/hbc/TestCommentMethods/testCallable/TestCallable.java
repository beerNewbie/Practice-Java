package per.hbc.TestCommentMethods.testCallable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: Beer
 * @Date: 2019/4/15 13:01
 * @Description: 简单买票
 */
class MyThrea implements Callable<String> {
    private int ticket = 10;

    @Override
    public String call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println("还剩票：" + ticket--);
        }
        return "票已售完！！！";
    }
}

public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = new MyThrea();
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }
}
