package com.kevin.stacker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Player implements Serializable{

	private static final long serialVersionUID = -2199367443976319984L;

	private static String playerFileName = "player.data";
	
	private String name;
	
	public Player(String name) {
		this.setName(name);
	}
	
	public Player() {
		this(null);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
