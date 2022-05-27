import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import AST.ConstantNode;
import gen.*;
import org.antlr.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
public class Main {
    public static void main(String[] args) throws IOException {
        try{
            TransitionSystem TS = new TransitionSystem("ts.txt");
            InputStream formula = new FileInputStream("formula.txt");
            LTLLexer lexer = new LTLLexer(CharStreams.fromStream(formula));
            LTLParser parser = new LTLParser(new CommonTokenStream(lexer));


        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
