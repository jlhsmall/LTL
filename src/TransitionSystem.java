
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class TransitionSystem {
    public class State{
        ArrayList<State> Successors = new ArrayList<>();
        ArrayList<Integer> Actions = new ArrayList<>();
        ArrayList<Integer> L = new ArrayList<>();
        public void addTransition(int a,State t){
            Successors.add(t);
            Actions.add(a);
        }
    }
    int S, T;
    ArrayList<Integer> initial = new ArrayList<>();
    HashMap<Integer,Integer> ActMap = new HashMap<>();
    ArrayList<String> AP=new ArrayList<>();
    ArrayList<State> States=new ArrayList<>();
    private ArrayList<Integer> ReadIntegerLine(BufferedReader br) throws IOException {
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

    private ArrayList<String> ReadStringLine(BufferedReader br) throws IOException {
        ArrayList<String> ret = new ArrayList<>();
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        boolean flg = false;
        for (int i = 0; i < s.length(); ++i) {
            char cur = s.charAt(i);
            if (cur >= 'a' && cur <= 'z' || cur >= 'A' && cur <= 'Z')
                sb.append(cur);
            else if (flg){
                ret.add(sb.toString());
                sb = new StringBuilder();
                flg = false;
            }
        }
        if (flg)
            ret.add(sb.toString());
        return ret;
    }

    public TransitionSystem(String file) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        ArrayList<Integer> line=ReadIntegerLine(br);
        S=line.get(0);T=line.get(1);

        initial = ReadIntegerLine(br);

        line = ReadIntegerLine(br);
        for(int i=0;i<line.size();++i){
            ActMap.put(line.get(i),i);
        }

        AP = ReadStringLine(br);

        for(int i=0;i<S;++i)
            States.add(new State());
        for (int i=0;i<T;++i){
            line = ReadIntegerLine(br);
            State s=States.get(line.get(0)),t=States.get(line.get(2));
            int a = line.get(1);
            s.addTransition(a,t);
        }

        for (int i=0;i<S;++i)
            States.get(i).L = ReadIntegerLine(br);
    }
}
