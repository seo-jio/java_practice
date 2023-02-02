package com.ssafy.edu;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class SerialTest1 {

	public static void main(String[] args) {
		
		//ArrayList는 내부적으로 Serializable을 구현해놨다.
		List<Grade> grades = new ArrayList<>();
		grades.add(new Grade(60, 80, 90));
		grades.add(new Grade(70, 80, 90));
		grades.add(new Grade(80, 90, 100));
		grades.add(new Grade(100, 100, 90));
		grades.add(new Grade(80, 60, 90));
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("grade.dat"));) {
			oos.writeObject(grades);
		}catch(FileNotFoundException e1) {
			System.out.println(e1);
		}catch(IOException e2) {
			System.out.println(e2);
		}catch(Exception e3) {
			System.out.println(e3);
		}
		
	}
}
