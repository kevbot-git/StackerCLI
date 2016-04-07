package com.kevin.stackertest;

import java.util.LinkedList;

import com.kevin.stacker.*;

public class Main {

	private static String DOT = "000";
	private static String NOTDOT = "---";
	private static int GAME_WIDTH = 7;
	
	private static Input in;
	private static Output out;
	private static StackerGame sg;
	private static Player player;
	
	
	public static void main(String[] args) {
		init();
		welcomeMessage();
		play();
		choosePlayer();
	}

	private static void init() {
		in = new Input();
		out = new Output(true);
		sg = new StackerGame(GAME_WIDTH);
	}
	
	private static void play() {
		sg.setTickListener(new TickListener() {
			public void onTick(int index) {
				String line = "";
				
				for(int i = 0; i < sg.getWidth(); i ++) {
					line += ((index == i) ? DOT : NOTDOT);
				}
				
				out.overwrite(line);
			}
		});
		sg.start();
		
		
	}
	
	private static void choosePlayer() {
		
	}

	private static void welcomeMessage() {
		try {
			out.typewriteVertical(StackerGame.welcomeMessage());
			
			Thread.sleep(2000);
			
			out.typewrite("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			
		} catch (InterruptedException e) {
			out.log("interrupted");
		}
	}

}
