package com.kevin.stacker;

import java.util.LinkedList;

public class StackerGame implements Runnable{
	
	private Input in;
	private Output out;
	private int width;
	private int interval;
	private int currentIndex;
	private int level;
	private LinkedList<Integer> progressIndexes;
	private TickListener tickListener;
	private GameListener gameListener;
	private boolean running;
	
	private Thread thread;
	
	public StackerGame(int width) {
		this.in = new Input();
		this.out = new Output(true);
		this.setWidth(width);
		this.progressIndexes = new LinkedList<Integer>();
		this.setRunning(false);
		this.setInterval(200);
		this.setIndex(0);
		
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
	
	public void stopPressed() {
		//long time = System.currentTimeMillis();
		//this.setRunning(false);
		
		boolean matches = false;
		if(!this.progressIndexes.isEmpty())
			matches = (this.progressIndexes.getFirst().intValue() == this.getIndex());
		if(matches || this.progressIndexes.isEmpty()) {
			this.levelUp();
			this.getGameListener().onMatch(this.getLevel());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				out.log("interrupted");
			}
			
		}
		else {
			this.getGameListener().onMiss(this.getLevel());
			this.setRunning(false);
		}
	}
	
	@Override
	public void run() {
		if(this.getTickListener() != null && this.getGameListener() != null) {
			this.setRunning(true);
			
			int index = -1; // only initially!
			boolean returning = false;
			while(this.isRunning()) {
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
				
				this.getTickListener().onTick(index);
				this.setIndex(index);
				
				try {
					Thread.sleep(this.getInterval());
				} catch (InterruptedException e) {
					out.log("interrupted");
				}
			}
		}
		else {
			out.log("TickListener or GameListener not initialized!");
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

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		if(interval > 0)
			this.interval = interval;
	}

	public int getIndex() {
		return currentIndex;
	}

	public void setIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}

	public GameListener getGameListener() {
		return gameListener;
	}

	public void setGameListener(GameListener gameListener) {
		this.gameListener = gameListener;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public void levelUp() {
		this.progressIndexes.add(this.getIndex());
		this.setLevel(this.getLevel() + 1);
		this.setInterval(interval - 8);
	}
}
