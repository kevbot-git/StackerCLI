package com.kevin.stackertest;

import com.kevin.stacker.*;

public class Main {

	private static String DOT = "000";
	private static String NOTDOT = "   ";
	private static String BORDER = "||";
	private static int GAME_WIDTH = 7;
	
	private static Input in;
	private static Output out;
	private static StackerGame sg;
	private static Player player;
	
	
	public static void main(String[] args) {
		init();
		//welcomeMessage();
		play();
		//choosePlayer();
	}

	private static void init() {
		in = new Input();
		out = new Output(false);
		sg = new StackerGame(GAME_WIDTH);
	}
	
	private static void play() {
		sg.setTickListener(new TickListener() {
			@Override
			public void onTick(int index) {
				String line = BORDER;
				
				for(int i = 0; i < sg.getWidth(); i ++) {
					line += ((index == i) ? DOT : NOTDOT);
				}
				line += BORDER;
				
				out.overwrite(line);
			}
		});
		
		sg.setGameListener(new GameListener() {
			@Override
			public void onMatch(int level) {
				out.log("Matched! Level " + level);
			}

			@Override
			public void onMiss(int level) {
				out.println("Fail! Reached level " + level);
			}
		});
		
		sg.start();
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(sg.isRunning()) {
			in.askString();
			sg.stopPressed();
		}
		
	}
	
	private static void choosePlayer() {
		
	}

	private static void welcomeMessage() {
		try {
			out.typewriteVertical(StackerGame.welcomeMessage());
			
			Thread.sleep(3000);
			
			out.typewrite("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			
		} catch (InterruptedException e) {
			out.log("interrupted");
		}
	}

}
