package forTest;


import java.util.*;
import java.util.Map.Entry;


public class MapTest {
    Map<String, String> hMap = new HashMap<>();
//    Map<String, Integer> tMap = new TreeMap<>();
    private void addMethod() {
        System.out.println("추가 성공?: " + hMap.put("andy", "1234")); //add
        System.out.println("추가 성공?: " + hMap.put("andy", "4567")); //update
        hMap.put("kate", "9999");
//        기존에 해당 키에 대한 값이 없을 때만 추가하기
        hMap.putIfAbsent("kate", "1234"); //"kate" : 9999 유지

        hMap.put("henry", "4567"); // value는 중복 허용

        hMap.put("hong", "1234");
        System.out.println("추가 결과: " + hMap);
    }

    private void retrieveMethod() {
        // TODO: kate의 전화번호가 있나요?
        //추상 메소드
        System.out.println(hMap.get("kate"));
        //default method 사용
        System.out.println(hMap.getOrDefault("박상진", "1234"));
        // END:

        // TODO: map이 가지고 있는 key와 거기에 연결된 value를 출력하시오.
        Set<String> keys = hMap.keySet();
        for(String key : keys) {
            System.out.print(key + " ");
        }
        System.out.println();

        Set<Entry<String, String>> entries =  hMap.entrySet();
        for(Entry<String, String> entry : entries){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // END:

        // TODO: 값이 4567인 사람의 이름은?
        List<String> people = new ArrayList<>();
        for(Entry<String, String> entry : entries){
            if(entry.getValue().equals("4567")){
                people.add(entry.getKey());
            }
        }

        System.out.println("값이 4567인 사람들 : " + people.toString());
        // END:
    }

    private void removeMethod() {
        // TODO: andy의 자료를 삭제하고 출력하시오.
        hMap.remove("andy");
        System.out.println(hMap);
        // END:
    }

    public static void main(String[] args) {
        MapTest hmt = new MapTest();
        hmt.addMethod();
        hmt.retrieveMethod();
        hmt.removeMethod();
    }
}
