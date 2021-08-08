package company.baidu;

import javafx.concurrent.Task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolExecTest {

    public void taskExec(ArrayList<Task> task1) throws InterruptedException, ExecutionException {
        /**
         * int corePoolSize,
         *                               int maximumPoolSize,
         *                               long keepAliveTime,
         *                               TimeUnit unit,
         *                               BlockingQueue<Runnable> workQueue
         */
        ExecutorService exs = Executors.newFixedThreadPool(100);
        Long start = System.currentTimeMillis();

        try {
            //结果集
            List<Result> list = new ArrayList<Result>();
            List<Future<Result>> futureList = new ArrayList<Future<Result>>();
            //1.高速提交10个任务，每个任务返回一个Future入list
            for (int i = 0; i < task1.size(); i++) {
                futureList.add((Future<Result>) exs.submit(task1.get(i)));
            }
            Long getResultStart = System.currentTimeMillis();
            System.out.println("结果归集开始时间=" + new Date());
            //2.结果归集，遍历futureList,高速轮询（模拟实现了并发）获取future状态成功完成后获取结果，退出当前循环
            for (Future<Result> future : futureList) {
                while (true) {//CPU高速轮询：每个future都并发轮循，判断完成状态然后获取结果，这一行，是本实现方案的精髓所在。即有10个future在高速轮询，完成一个future的获取结果，就关闭一个轮询
                    if (future.isDone() && !future.isCancelled()) {//获取future成功完成状态，如果想要限制每个任务的超时时间，取消本行的状态判断+future.get(1000*1, TimeUnit.MILLISECONDS)+catch超时异常使用即可。
                        Result i = future.get();//获取结果
                        System.out.println("任务i=" + i + "获取完成!" + new Date());
                        list.add(i);
                        break;//当前future获取结果完毕，跳出while
                    } else {
                        Thread.sleep(1);//每次轮询休息1毫秒（CPU纳秒级），避免CPU高速轮循耗空CPU---》新手别忘记这个
                    }
                }
            }
            System.out.println("list=" + list);
            System.out.println("总耗时=" + (System.currentTimeMillis() - start) + ",取结果归集耗时=" + (System.currentTimeMillis() - getResultStart));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            exs.shutdown();
        }

    }

    static class Result {

    }

}
