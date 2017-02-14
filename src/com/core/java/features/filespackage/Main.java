package com.core.java.features.filespackage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Path dir = null;
		dir = Paths.get("/Users/Thync/Documents/doc.txt");
		try(Stream<String> lines = Files.lines(dir);) {
			
			//Stream<Path> files = Files.list(dir);
			lines.forEach((x) -> System.out.println(x));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
