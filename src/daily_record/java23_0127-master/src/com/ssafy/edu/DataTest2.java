package com.ssafy.edu;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataTest2 {

	public static void main(String[] args) {
		try(DataOutputStream dot = new DataOutputStream(new FileOutputStream("ccdot.writeInt(40);.txt"));){
			dot.writeInt(35);
			dot.writeInt(40);
			dot.writeInt(80);
			dot.writeDouble(34.7);
			dot.writeUTF("hello");
		}catch(IOException e) {
			System.out.println(e);
		}
	}

}
