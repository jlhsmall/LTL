import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class MyInput {
    static public ArrayList<Integer> ReadIntegerLine(BufferedReader br) throws IOException {
        ArrayList<Integer> ret = new ArrayList<>();
        String s = br.readLine();
        int x=0;
        boolean flg = false;
        for (int i = 0; i < s.length(); ++i) {
            char cur = s.charAt(i);
            if (cur >= '0' && cur <= '9') {
                flg = true;
                x = x * 10 + cur - '0';
            } else if (flg) {
                ret.add(x);
                x = 0;
                flg = false;
            }
        }
        if(flg)
            ret.add(x);
        return ret;
    }

    static public ArrayList<String> ReadStringLine(BufferedReader br) throws IOException {
        ArrayList<String> ret = new ArrayList<>();
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        boolean flg = false;
        for (int i = 0; i < s.length(); ++i) {
            char cur = s.charAt(i);
            if (cur >= 'a' && cur <= 'z' || cur >= 'A' && cur <= 'Z') {
                flg = true;
                sb.append(cur);
            }else if (flg){
                ret.add(sb.toString());
                sb = new StringBuilder();
                flg = false;
            }
        }
        if (flg)
            ret.add(sb.toString());
        return ret;
    }
}
