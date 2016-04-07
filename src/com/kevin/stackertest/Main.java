package com.kevin.stackertest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.kevin.stacker.*;

public class Main {

	private static Input in;
	private static Output out;
	private static StackerGame sg;
	
	public static void main(String[] args) {
		sg = new StackerGame();
		init();
		welcomeMessage();
		
		
		
		
	}

	private static void init() {
		in = new Input();
		out = new Output(true);
	}

	private static void welcomeMessage() {
		try {
			Scanner s = new Scanner(Main.class.getResourceAsStream("/text/welcome.txt"));
			
			while(s.hasNextLine()) {
				out.typewriteVertical(s.nextLine() + "\n");
			}
			
			s.close();
			
			Thread.sleep(1000);
			
			out.typewrite("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			
		} catch (InterruptedException e) {
			// All good
		} catch (NullPointerException e) {
			out.println("unluggy");
		}
	}

}
