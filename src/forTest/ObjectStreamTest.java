package forTest;

//ObjectStreamTest

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamTest {
    public static void main(String[] args) {
//        write();
        read();
    }

    private static File target = new File("c:/Temp/objPerson.dat");

    private static void write() {
//        Person person = new Person("홍길동3", "pass4567", 12);
        Person person = new Person("홍길동2", "pass1234");
        // TODO: person을 target에 저장하시오.
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(target))){
            oos.writeObject(person);
        }catch(FileNotFoundException fe) {
            fe.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        }

        // END:
    }

    private static void read() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(target))){
            Object obj = ois.readObject();
            if(obj instanceof Person) {
                Person p = (Person) obj;
                System.out.println(p);
            }
        }catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
