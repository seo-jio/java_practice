package forTest;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public class SetTest {
    //TreeSet 사용 시 정렬이 이루어짐
    Set<Object> friends = new HashSet<>();

    private void addMethod() {
        friends.add(Integer.valueOf(1));
        friends.add("Hello");
        friends.add("Hello");      // 동일한 데이터 추가 확인
        friends.add(1);            // 기본형은 자동으로 wrapper를 통해 추가
        friends.add("홍길동");
        friends.add("서지오");


        // TODO: SmartPhone 타입의 객체를 추가해보자.
        friends.add(new SmartPhone("010"));
        friends.add(new SmartPhone("010"));
        //END:
        System.out.println("데이터 추가 결과: " + friends);
    }

    private void retrieveMethod() {
        System.out.println("데이터 개수: " + friends.size());

        for (Object sobj : friends) {
            System.out.println("데이터 조회: " + sobj);
        }
    }

    private void removeMethod() {
        friends.remove("Hello");
        System.out.println("데이터 삭제 결과: " + friends);
    }

    public static void main(String[] args) {
        SetTest test = new SetTest();
        test.addMethod();
        test.retrieveMethod();
        test.removeMethod();
    }
}