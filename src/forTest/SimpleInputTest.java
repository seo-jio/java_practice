package forTest;

import java.io.ByteArrayInputStream;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class SimpleInputTest {

    private String data1 = "hi java world";
    private String data2 = "자바는 객체지향 언어입니다.";

    private void read1() {
        // TODO: data1를 읽어보자.
        try(InputStream input = new ByteArrayInputStream(data1.getBytes())) {
            int read = -1;
            while((read = input.read()) != -1) {  //read는 문장의 마지막에 도달할 경우 -1을 return
                System.out.printf("읽은 값 : %d, %c\n", read, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // END:
    }

    private void read2() {
        // TODO: data1를 읽어보자.
        byte[] buffer = new byte[10];
        try(InputStream input = new ByteArrayInputStream(data2.getBytes())) { //한글은 유니코드를 사용하는므로 byte를 사용하지 않는다. 영문을 포함한 문자는 그냥 char로 받자
            int read = -1;
            while((read = input.read(buffer)) > 0) {  //read는 문장의 마지막에 도달할 경우 -1을 return
                System.out.printf("읽은 값 : %d, %s\n", read, new String(buffer, 0, read));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // END:
    }

    private void read3() {
        // TODO: data1를 읽어보자.
        char buffer[] = new char[10];
        try(Reader reader = new CharArrayReader(data2.toCharArray())){
            int read = -1;
            while((read = reader.read(buffer)) > 0){
                System.out.printf("읽은 값 : %d, %s\n", read, new String(buffer, 0, read));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        SimpleInputTest ns = new SimpleInputTest();
//        ns.read1();
//         ns.read2();
        ns.read3();
    }
}
