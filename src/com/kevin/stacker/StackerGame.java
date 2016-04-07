package com.kevin.stacker;

import java.util.LinkedList;

public class StackerGame implements Runnable{
	
	private Input in;
	private Output out;
	private int width;
	private LinkedList<Integer> progressIndexes;
	private TickListener tickListener;
	
	private Thread thread;
	
	public StackerGame(int width) {
		this.in = new Input();
		this.out = new Output(true);
		this.setWidth(width);
		this.progressIndexes = new LinkedList<Integer>();
		
		this.thread = new Thread(this);
	}
	
	public static String welcomeMessage() {
		return " 000000  0000000   00000    000000  00  000  0000000  000000 \n00         00     00   00  00       00 00    00       00   00\n 00000     00     0000000  00       000      00000    000000 \n     00    00     00   00  00       00 00    00       00   00\n000000     00     00   00   000000  00  000  0000000  00   00";
	}

	public void start() {
		this.thread.start();
	}
	
	public void stop() {
		this.thread.interrupt();
	}
	
	@Override
	public void run() {
		boolean gameFinished = false;
		if(this.getTickListener() != null) {
			int index = 0;
			boolean returning = false;
			while(!gameFinished) {
				this.getTickListener().onTick(index);
				if(!returning) {
					if(index < this.getWidth() - 1) index ++;
					else {
						returning = true;
						index --;
					}
				}
				else {
					if(index > 0) index --;
					else {
						returning = false;
						index ++;
					}
				}
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					out.log("interrupted");
				}
				gameFinished = false;
				//gameFinished = true;
			}
		}
		else {
			out.log("TickListener not initialized!");
		}
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	protected TickListener getTickListener() {
		return tickListener;
	}

	public void setTickListener(TickListener tickListener) {
		this.tickListener = tickListener;
	}
	
}
