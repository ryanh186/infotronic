package edu.ben.homeworks.homework9;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

public class Homework9Test {

	@Test
	public void test() throws FileNotFoundException {
		File f = new File(
				"/Applications/College/CMSC205/CMSC205/lib/monkey");
		
		Homework9.processTranscript(f);
		
		
	}

}
