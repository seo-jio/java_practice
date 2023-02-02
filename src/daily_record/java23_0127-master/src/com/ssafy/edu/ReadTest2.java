package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ReadTest2 {

	public static void main(String[] args) {
		//reader는 꼭 close를 부를 필요 없다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //스트림 체이닝
		PrintWriter pw = null;
		
		String msg = "";
		try {
			pw = new PrintWriter(new FileOutputStream("aa.txt", true), true); //첫 번째 true : append, 두 번째 true : auto flush
			while((msg=br.readLine()) != null) {
				pw.println(msg);
			}
		}catch(IOException e) {
			System.out.println(e);
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			System.out.println("bye~~~~~~~~");
			pw.close();
		}
	
	}

}
