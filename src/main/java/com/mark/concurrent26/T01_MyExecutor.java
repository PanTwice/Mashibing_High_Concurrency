package com.mark.concurrent26;

import java.util.concurrent.Executor;

/**
 * 
 * @author 18009
 *
 */
public class T01_MyExecutor implements Executor {

	@Override
	public void execute(Runnable command) {
		// new Thread(command).run();
		command.run();
	}
	
	public static void main(String[] args) {
		new T01_MyExecutor().execute(() -> System.out.println("hello executor"));
	}
	
}