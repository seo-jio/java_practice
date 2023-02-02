package com.ssafy.edu;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataTest {

	public static void main(String[] args) {
		try(DataInputStream di = new DataInputStream(new FileInputStream("bb.txt"));){ //하나 일때는 세미콜론 필요 없다.
			int a = di.readInt();
			int b = di.readInt();
			int c = di.readInt();
			double d = di.readDouble();
			String e = di.readUTF();
			System.out.printf("%d %d %d %f %s\n", a, b, c, d, e);
		}catch(IOException e) {
			System.out.println(e);
		}
	}

}
