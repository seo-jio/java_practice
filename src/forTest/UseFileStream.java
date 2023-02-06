package forTest;

import java.io.*;
import java.net.URL;



public class UseFileStream {
    public static void main(String[] args) throws IOException {
        UseFileStream st = new UseFileStream();
        st.testFile();

        // System.out.printf("buffer size: %d, time: %d%n", 100, st.fileMove(100));
        // System.out.printf("buffer size: %d, time: %d%n", 1000, st.fileMove(1000));
        // System.out.printf("buffer size: %d, time: %d%n", 10000, st.fileMove(10000));
        // System.out.printf("buffer size: %d, time: %d%n", 100000, st.fileMove(100000));
        // System.out.printf("buffer size: %d, time: %d%n", 1000000, st.fileMove(1000000));
    }

    private void testFile() throws IOException {
        // 절대 경로
        File temp = new File("c:\\Temp");
        System.out.printf("존재? %b, 디렉토리? %b%n", temp.exists(), temp.isDirectory());

        // 상대경로
        File current = new File(".");
        System.out.printf("여기는 어디? %s%n", current.getCanonicalPath());

        // 상대경로의 기준은 java program을 실행하는 위치(소스와 무관)
        //d:\>java -cp .;c:\SSAFY\workspace\java\live\bin com.ssafy.live5.io.node.UseFileStream
        //c:\SSAFY\workspace\java\live\bin>java com.ssafy.live5.io.node.UseFileStream

        // TODO: readme.txt에 해당하는 File 객체를 만들어 보자.
        //build해서 배포할 때 폴더가 바뀌기 때문에 절대 경로로 파일을 찾으면 문제 발생
        //애초에 배포할 때는 컴파일 한 실행 파일을 배포하지 src 폴더 내 코드를 배포하지는 않는다. => src를 bin으로 수정해줘야 한다.
        //runtime 때는 src에 있는 코드가 아니라 bin에 있는 코드를 참조한다.
//        File readMe = new File("E:\\ssafy\\workspace\\02_java\\ssafy_java_live\\bin\\com\\ssafy\\h_fileio\\io\\node");

        //위 문제를 해결하기 위해 밑에와 같이 파일을 찾는 게 일반적이다.
        URL url = UseFileStream.class.getResource("/com/ssafy/h_fileio/io/node/readMe.txt");
        URL url2 = UseFileStream.class.getResource("./readMe.txt");
        File readMe = new File(url.getFile());
        System.out.println(readMe.canRead());
        // END:
    }

    public long fileMove(int bufferSize) {
        long start = System.currentTimeMillis();
        // TODO: 본인의 컴퓨터에서 크기가 큰 파일을 선택하세요.
        File src = new File("c:\\ssafy\\eclipse-jee-2018-09-win32-x86_64.zip");
        File target = new File("c:\\Temp\\eclipse.zip");
        // TODO: bufferSize 크기의 byte []을 이용해서 src를 target에 복사하시오.
        byte[] buffer = new byte[bufferSize];
        try(InputStream input = new FileInputStream(src); OutputStream output = new FileOutputStream(target)){
            int read  =1;
            while((read = input.read(buffer)) > 0) {
                output.write(buffer, 0, read);
            }
        }catch(IOException e) {
            e.printStackTrace();
        }
        // END:
        return System.currentTimeMillis() - start;
    }
}

