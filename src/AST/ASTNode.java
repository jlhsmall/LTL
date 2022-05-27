package AST;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

abstract public class ASTNode {
    public boolean isNegation = false;
    public String text;
    public LinkedHashSet<LinkedHashMap<ASTNode,Boolean>> FormulaValue=new LinkedHashSet<>();
    @Override
    public boolean equals(Object o){
        return (o instanceof ASTNode) && text.equals(((ASTNode) o).text);
    }
    @Override
    public int hashCode(){
        return text.hashCode();
    }
    public ASTNode(String s){
        text = s;
    }
}
