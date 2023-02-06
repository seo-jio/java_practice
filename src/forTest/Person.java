package forTest;
//Person

import java.io.Serializable;

public class Person implements Serializable{

    //serialVersionUID 설정 시 고정되기 때문에 멤버를 변경해도 역직렬화가 가능하다.
    private static final long serialVersionUID = 11114444666513516L;

    private String id;
    private transient String pass;
//    private int age; //멤버 변수 추가 시 UID가 변경되어 다시 write 해야한다.

    public Person(String id, String pass) {
        super();
        this.id = id;
        this.pass = pass;
    }

//    public Person(String id, String pass, int age) {
//        super();
//        this.id = id;
//        this.pass = pass;
//        this.age = age;
//    }

    @Override
    public String toString() {
        return "Person2 [id=" + id + ", pass=" + pass + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
