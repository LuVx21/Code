package org.luvx;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

/**
 * 线程池测试用例
 * 
 * @author yangyong
 */
public class TestThreadPool {
	// 线程池维护线程的最少数量
	private static final int						COREPOOLSIZE	= 2;
	// 线程池维护线程的最大数量
	private static final int						MAXINUMPOOLSIZE	= 5;
	// 线程池维护线程所允许的空闲时间
	private static final long						KEEPALIVETIME	= 4;
	// 线程池维护线程所允许的空闲时间的单位
	private static final TimeUnit					UNIT			= TimeUnit.SECONDS;
	// 线程池所使用的缓冲队列,这里队列大小为3
	private static final BlockingQueue<Runnable>	WORKQUEUE		= new ArrayBlockingQueue<Runnable>(3);
	// 线程池对拒绝任务的处理策略：AbortPolicy为抛出异常；
	// CallerRunsPolicy为重试添加当前的任务，他会自动重复调用execute()方法；
	// DiscardOldestPolicy为抛弃旧的任务，
	// DiscardPolicy为抛弃当前的任务
	private static final AbortPolicy				HANDLER			= new ThreadPoolExecutor.AbortPolicy();

	public static void main(String[] args) {
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(COREPOOLSIZE, MAXINUMPOOLSIZE, KEEPALIVETIME, UNIT, WORKQUEUE, HANDLER);
		for (int i = 1; i < 11; i++) {
			String task = "task@" + i;
			System.out.println("put->" + task);
			// 一个任务通过 execute(Runnable)方法被添加到线程池，任务就是一个 Runnable类型的对象，任务的执行方法就是
			// Runnable类型对象的run()方法
			// 处理任务的优先级为：核心线程corePoolSize、任务队列workQueue、最大线程maximumPoolSize，如果三者都满了，使用handler处理被拒绝的任务
			// 设此时线程池中的数量为currentPoolSize,若currentPoolSize>corePoolSize,则创建新的线程执行被添加的任务,
			// 当corePoolSize+workQueue>currentPoolSize>=corePoolSize,新增任务被放入缓冲队列,
			// 当maximumPoolSize>currentPoolSize>=corePoolSize+workQueue,建新线程来处理被添加的任务,
			// 当currentPoolSize>=maximumPoolSize,通过 handler所指定的策略来处理新添加的任务
			// 本例中可以同时可以被处理的任务最多为maximumPoolSize+WORKQUEUE=8个，其中最多5个在线程中正在处理，3个在缓冲队列中等待被处理
			// 当currentPoolSize>corePoolSize时，如果某线程空闲时间超过keepAliveTime，线程将被终止。这样，线程池可以动态的调整池中的线程数
			threadPool.execute(new ThreadPoolTask(task));
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		threadPool.shutdown();// 关闭主线程，但线程池会继续运行，直到所有任务执行完才会停止。若不调用该方法线程池会一直保持下去，以便随时添加新的任务
	}
}