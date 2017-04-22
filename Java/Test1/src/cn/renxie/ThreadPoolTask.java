package cn.renxie;

import java.io.Serializable;

/**
 * 任务task
 * 
 * @author yangyong
 */
public class ThreadPoolTask implements Runnable, Serializable {
	private static final long	serialVersionUID		= -8568367025140842876L;
	private Object				threadPoolTaskData;
	private static int			produceTaskSleepTime	= 10000;

	public ThreadPoolTask(Object threadPoolTaskData) {
		super();
		this.threadPoolTaskData = threadPoolTaskData;
	}

	public void run() {
		System.out.println("start..." + threadPoolTaskData);
		try {
			// 模拟线程正在执行任务
			Thread.sleep(produceTaskSleepTime);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("stop..." + threadPoolTaskData);
		threadPoolTaskData = null;
	}

	public Object getTask() {
		return this.threadPoolTaskData;
	}
}