package AST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

abstract public class ASTNode {
    public boolean isNegation = false;
    public String text;
    public HashSet<HashMap<ASTNode,Boolean>> FormulaValue=new HashSet<>();
    @Override
    public boolean equals(Object o){
        return (o instanceof ASTNode) && text.equals(((ASTNode) o).text);
    }
    public ASTNode(String s){
        text = s;
    }
}
