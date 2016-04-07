package com.kevin.stacker;

import java.util.Scanner;

public class Input {

	private Scanner kb;
	
	public Input() {
		this.kb = new Scanner(System.in);
	}
	
	public String askString() {
		return kb.nextLine();
	}
	
	public String askString(String question) {
		System.out.print(question);
		return this.askString();
	}
	
	public String askString(int maxChars) {
		String temp = this.askString();
		while(temp.length() > maxChars) {
			System.out.print("! Max " + maxChars + " characters, please re-enter: ");
			temp = this.askString();
		}
		return temp;
	}
	
	public String askString(String message, int maxChars) {
		String temp = this.askString(message);
		while(temp.length() > maxChars) {
			System.out.print("! Max " + maxChars + " characters, please re-enter: ");
			temp = this.askString();
		}
		return temp;
	}
	
	public boolean askYesNo() {
		while(true) {
			String in = kb.nextLine();
			
			if(in.equals("y") || in.equals("Y")) {
				return true;
			}
			else if(in.equals("n") || in.equals("N")) {
				return false;
			} else {
				System.out.print("Unrecognized entry. Please enter Y or n: ");
			}
		}
	}
	
	public boolean askYesNo(String question) {
		System.out.print(question);
		return this.askYesNo();
	}
	
}
