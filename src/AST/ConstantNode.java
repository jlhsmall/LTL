package AST;

import java.util.LinkedHashMap;

import static AST.ASTBuilder.TrueConstant;

public class ConstantNode extends ASTNode{
    public boolean value;
    public ConstantNode(boolean val,String s){
        super(s);
        value = val;
        LinkedHashMap<ASTNode,Boolean>mp=new LinkedHashMap<>();
        mp.put(this,val);
        FormulaValue.add(mp);
    }
}
