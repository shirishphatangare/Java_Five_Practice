package com.fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TxtFileRead {

	public static void main(String[] args) {
		String line = null;
		BufferedReader bfr = null;
		BufferedWriter bfw = null;
		try {
			//File srcFile = new File("C:\\Java\\JavaFIVE\\temp.txt");
			
			/*if(!srcFile.exists()){  // FileReader do not create a file if it does not exist, whereas FileWriter creates one!!
				srcFile.createNewFile();
			}*/
			
			FileReader fr = new FileReader("C:\\Java\\JavaFIVE\\temp.txt"); // Connection stream - FileReader
			bfr = new BufferedReader(fr);     // Connection stream - BufferedReader
			
			FileWriter fw = new FileWriter("C:\\Java\\JavaFIVE\\temp1.txt"); // Connection stream - FileWriter
			bfw = new BufferedWriter(fw); // Chained stream - BufferedWriter
			
			while((line = bfr.readLine()) != null){
				System.out.println("Reading.." + line);
				writeFile(bfw,line);
			}
			
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}finally{
			try{
				bfr.close();
				bfw.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public static void writeFile(BufferedWriter bfw,String line) throws IOException{
		System.out.println("Writing.." + line);
		bfw.append(line);
		bfw.append(System.lineSeparator());
	}
}
