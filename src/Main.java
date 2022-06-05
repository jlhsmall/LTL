import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import AST.ASTBuilder;
import AST.ASTNode;
import AST.ConstantNode;
import gen.*;
import org.antlr.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {
    public static void solve(TransitionSystem TS) throws Exception {
        InputStream formula = new FileInputStream("formula.txt");
        LTLLexer lexer = new LTLLexer(CharStreams.fromStream(formula));
        LTLParser parser = new LTLParser(new CommonTokenStream(lexer));
        ASTBuilder builder = new ASTBuilder(parser.formula());
        //builder.printElementarySet();
        GNBA G = new GNBA(builder.root);
        //G.print();
        NBA A = new NBA(G);
        //A.print();
        TransitionSystem TSA = new TransitionSystem(TS, A,builder.root);
        //TSA.print();
        System.out.println(TSA.hasFSCC() ? "0" : "1");
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        TransitionSystem TS = new TransitionSystem("ts.txt");
        FileReader fr = new FileReader("input.txt");
        BufferedReader br = new BufferedReader(fr);
        ArrayList<Integer> arr = MyInput.ReadIntegerLine(br);
        int q0 = arr.get(0), q1 = arr.get(1);
        for (; q0 > 0; --q0) {
            String line;
            do {
                line = br.readLine();
            }while(line.isBlank());
            FileOutputStream out = new FileOutputStream("formula.txt");
            out.write(line.getBytes(StandardCharsets.UTF_8));
            out.close();
            solve(TS);
        }
        for (; q1 > 0; --q1) {
            String line;
            do {
                line = br.readLine();
            }while(line.isBlank());
            int index = 0, i = 0;
            while (true) {
                char ch = line.charAt(i++);
                if (ch >= '0' && ch <= '9')
                    index = index * 10 + ch - '0';
                else
                    break;
            }
            FileOutputStream out = new FileOutputStream("formula.txt");
            while (i < line.length())
                out.write(line.charAt(i++));
            out.close();
            TS.initial.clear();
            TS.initial.add(TS.States[index]);
            solve(TS);
        }

    }
}
