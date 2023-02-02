package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadTest1 {

	public static void main(String[] args) {
		//reader는 꼭 close를 부를 필요 없다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //스트림 체이닝
		String msg = "";
		try {
			while((msg=br.readLine()) != null) {
				System.out.println(msg);
			}
		}catch(IOException e) {
			System.out.println(e);
		}catch(Exception e) {
			System.out.println(e);
		}
	
	}

}
