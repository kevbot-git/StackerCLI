package com.kevin.stackertest;

import com.kevin.stacker.*;

public class Main {

	private static Input in;
	private static Output out;
	private static StackerGame sg;
	
	public static void main(String[] args) {
		init();
		welcomeMessage();
		
		sg = new StackerGame();
		
		
	}

	private static void init() {
		in = new Input();
		out = new Output(true);
	}

	private static void welcomeMessage() {
		out.println("");
	}

}
