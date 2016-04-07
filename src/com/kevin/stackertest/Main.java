package com.kevin.stackertest;

import com.kevin.stacker.*;

public class Main {

	private static String DOT = "000";
	private static String NOTDOT = "   ";
	private static String BORDER = "||";
	private static char CAP = '-';
	private static int GAME_WIDTH = 7;
	
	private static Input in;
	private static Output out;
	private static StackerGame sg;
	private static Player player;
	
	
	public static void main(String[] args) {
		boolean welcome = true;
		if(args.length > 0) {
			for(String s : args) {
				if(s.equals("-nowelcome")) {
					welcome = false;
				}
			}
		}
		
		init();
		
		if(welcome) welcomeMessage();
		
		play();
		
		quit();
	}

	private static void init() {
		in = new Input();
		out = new Output(false);
	}
	
	private static void play() {
		
		
		do {
			sg = new StackerGame(GAME_WIDTH);
			
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
					printDivider();
					out.println("Game over! Reached level " + level);
				}
			});
			
			printDivider();
			sg.start();
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				out.log("interrupted");
			}
			
			while(sg.isRunning()) {
				in.askString();
				sg.stopPressed();
			}
			
			if(player == null) player = new Player(in.askString("Enter your name: "));
			
		} while(in.askYesNo("Play again? "));
	}
	
	private static void quit() {
		out.println("Goodbye!");
	}

	private static void welcomeMessage() {
		try {
			out.typewriteVertical(StackerGame.welcomeMessage());
			
			Thread.sleep(1000);
			
			out.typewrite("\n\n\nBy Kevin Menhinick\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", 40);
			
		} catch (InterruptedException e) {
			out.log("interrupted");
		}
	}
	
	private static void printDivider() {
		String cap = "";
		
		for(int i = 0; i < ((sg.getWidth() * DOT.length()) + (2 * BORDER.length())); i ++) {
			cap += CAP;
		}
		
		out.println(cap);
	}

}
