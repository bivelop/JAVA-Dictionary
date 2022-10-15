import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    private final Vector<String> word = new Vector<>();
    int count = 0;

    private boolean readdic() {
        try {
            Scanner fScanner = new Scanner(new FileInputStream("C:\\words.txt"));
            while (fScanner.hasNext())
                word.add(fScanner.nextLine());
            fScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("단어 파일이 없습니다.");
            return false;
        }
        System.out.println("단어 파일 : word.txt.를 읽었습니다.");
        return true;
    }

    private void search() {
        Scanner sc = new Scanner(System.in);
        boolean match = false;

        while (true) {
            System.out.print("단어>>");
            String input = sc.nextLine();

            if (input.equals("그만")) {
                break;
            }

            for (String word : word) {
                if (word.length() <input.length())
                    continue;

                String cut = word.substring(0, input.length());

                if (cut.equals(input)) {
                    System.out.println(word);
                    count++;
                    match = true;
                }
            }
            System.out.println("검색된 단어의 개수 : "+count);

            if (!match) {
                System.out.println("없는 단어입니다.");
            }
        }//while

    }

    public void run () {
        boolean readresult = readdic();
        if (readresult) {
            search();
            System.out.println("사전을 종료합니다.");
        }
    }
    public static void main (String[]args){
        Main m = new Main();
        m.run();
    }
}