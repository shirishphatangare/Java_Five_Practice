package com.fileio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinFileRead {

	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		int numBytesRead = 0;
		int totalBytesRead = 0;
		
		byte[] buffer = new byte[5000];
		try{
			 	// Instead of wrapping FileInputStream in a buffer, FileInputStream defines a method called read() that lets you fill a buffer with data, 
			    // automatically reading just enough bytes to fill the buffer (or less if there aren't that many bytes left to read). 
			
				fis = new FileInputStream("C:\\Java\\JavaFIVE\\download.jpg");
				fos = new FileOutputStream("C:\\Java\\JavaFIVE\\download1.jpg");
				
				while((numBytesRead = fis.read(buffer)) != -1){
					totalBytesRead += numBytesRead;
				}
				System.out.println("Total bytes read: " + totalBytesRead);
				//fos.write(buffer); // writes whole buffer
				
				// write() writes as many bytes from the buffer
	            // as the length of the buffer. You can also
	            // use
	            // write(buffer, offset, length)
	            // if you want to write a specific number of
	            // bytes, or only part of the buffer.
				fos.write(buffer, 0, totalBytesRead); // writes only required number of bytes
				System.out.println("Wrote " + totalBytesRead + " bytes");
			}catch(Exception e){
				e.printStackTrace();
		}finally{
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
