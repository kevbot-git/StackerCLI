package com.kevin.stacker;

public class Output {

	private boolean debug;
	
	public Output() {
		this(true);
	}
	
	public Output(boolean debug) {
		this.setDebugging(debug);
	}
	
	public boolean log(String message) {
		if(this.debugging())
			System.out.println("DEBUG: " + message);
		return this.debugging();
	}
	
	public void println(String message) {
		System.out.println(message);
	}
	
	public void print(String message) {
		System.out.print(message);
	}
	
	public void overwrite(String message) {
		System.out.print("\r" + message);
	}
	
	public void typewrite(String message) {
		typewrite(message, 15);
	}
	
	public void typewrite(String message, int millis) {
		for(char c : message.toCharArray()) {
			System.out.print(c);
			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
				this.log("interrupted");
			}
		}
	}
	
	public void typewriteVertical(String message) {
		typewriteVertical(message, 100);
	}
	
	public void typewriteVertical(String message, int millis) {
		for(String s : message.split("\n")) {
			System.out.println(s);
			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
				this.log("interrupted");
			}
		}
	}

	public boolean debugging() {
		return debug;
	}

	public void setDebugging(boolean debug) {
		this.debug = debug;
	}
	
}
