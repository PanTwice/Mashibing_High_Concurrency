package com.mark.concurrent24;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 有n张火车票，每张票都有一编号
 * 同时有10个窗口在对外售票
 * 写一个模拟程序
 * 
 * 分析下面程序可能产生那些问题?
 * 重复销售， 超量销售
 * @author 18009
 *
 */
public class TicketSeller4 {
	static Queue<String> tickets = new ConcurrentLinkedQueue<String>();  // Queue里面不应该有空值
	
	static {
		for (int i=0; i<1000; i++) tickets.add("票编号:" + i);
	}
	
	public static void main(String[] args) {
		for (int i=0; i<10; i++) {
			new Thread(() -> {
				while(true) {
					String s = tickets.poll();
					if (s == null) break;
					System.out.println("销售了--" + s);
				}
			}).start();
		}
	}
}