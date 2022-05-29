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
        System.out.println(builder.root.FormulaValue.size());
        GNBA G = new GNBA(builder.root);
        NBA A = new NBA(G);
        A.Complement();
        TransitionSystem TSA = new TransitionSystem(TS, A);
        System.out.println(TSA.isNFPersistent() ? "1" : "0");
    }

    public static void main(String[] args) throws Exception {
        TransitionSystem TS = new TransitionSystem("ts.txt");
        FileReader fr = new FileReader("benchmark.txt");
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
            /*for(var mp : builder.root.FormulaValue){
                for(var entry : mp.entrySet()){
                    System.out.print("("+entry.getKey().text+","+entry.getValue()+") ");
                }
                System.out.println();
            }*/
    }
}
