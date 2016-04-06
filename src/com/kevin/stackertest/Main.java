package com.kevin.stackertest;

import com.kevin.stacker.*;

public class Main {

	private static Input in;
	private static Output out;
	
	public static void main(String[] args) {
		init();
		welcomeMessage();
		
		StackerGame sg = new StackerGame();
		
		
	}

	private static void init() {
		in = new Input();
		out = new Output(true);
		out.setDebug(true);
	}

	private static void welcomeMessage() {
		//
	}

}
