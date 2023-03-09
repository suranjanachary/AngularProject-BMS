package com.suranjan.service;

import java.util.Random;

public class RandomNumberService {

  public String RandomNumber() {
		
		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		return String.format("%06d", number);
	
	}
}
