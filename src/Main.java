import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import AST.ASTBuilder;
import AST.ASTNode;
import AST.ConstantNode;
import gen.*;
import org.antlr.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
public class Main {
    public static void main(String[] args) throws Exception {
        //try{
            TransitionSystem TS = new TransitionSystem("ts.txt");
            InputStream formula = new FileInputStream("formula.txt");
            LTLLexer lexer = new LTLLexer(CharStreams.fromStream(formula));
            LTLParser parser = new LTLParser(new CommonTokenStream(lexer));
            ASTBuilder builder = new ASTBuilder(parser.formula());
            System.out.println(builder.root.FormulaValue.size());
            GNBA gnba=new GNBA(builder.root);
            for(var mp : builder.root.FormulaValue){
                for(var entry : mp.entrySet()){
                    System.out.print("("+entry.getKey().text+","+entry.getValue()+") ");
                }
                System.out.println();
            }
        //}
        //catch (Exception e){
        //    System.out.println(e);
        //}
    }
}
