package com.kevin.stacker;

public class Output {

	private boolean debug;
	
	public Output() {
		this(true);
	}
	
	public Output(boolean debug) {
		this.setDebug(debug);
	}

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}
	
}
