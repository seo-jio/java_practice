package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadTest4 {

	public static void main(String[] args) {
		//reader는 꼭 close를 부를 필요 없다.
		BufferedReader br = null;
		File f = new File("aa.txt");
		String msg = "";
		try {
			if(f.exists()) {
				br = new BufferedReader(new FileReader(f));
				while((msg=br.readLine()) != null) {
					System.out.println(msg);
				}
			}
		}catch(IOException e) {
			System.out.println(e);
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			System.out.println("bye~~~~~~~~");
		}
	
	}

}
