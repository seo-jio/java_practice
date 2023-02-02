package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ReadTest3 {

	public static void main(String[] args) {
		//reader는 꼭 close를 부를 필요 없다.
		String msg = "";
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter pw = new PrintWriter(new FileOutputStream("bb.txt", true), true);){
			while((msg=br.readLine()) != null) {
				pw.println(msg);
			}
		}catch(IOException e) {
			System.out.println(e);
		}catch(Exception e) {
			System.out.println(e);
		}
	
	}

}
