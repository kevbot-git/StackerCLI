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
		if(this.debugging())
			System.out.println(message);
	}
	
	public void print(String message) {
		if(this.debugging())
			System.out.print(message);
	}

	public boolean debugging() {
		return debug;
	}

	public void setDebugging(boolean debug) {
		this.debug = debug;
	}
	
}
