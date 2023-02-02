package com.ssafy.edu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class SerialTest2 {

	public static void main(String[] args) {
		
		//ArrayList는 내부적으로 Serializable을 구현해놨다.
		List<Grade> grades = new ArrayList<>();
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("grade.dat"));) {
			Object obj = ois.readObject(); //Object return
			grades = (List<Grade>) obj;
			for(Grade g : grades) { //static도 원래 
				System.out.println(g);
			}
		}catch(FileNotFoundException e1) {
			System.out.println(e1);
		}catch(IOException e2) {
			System.out.println(e2);
		}catch(Exception e3) {
			System.out.println(e3);
		}
		
	}
}
