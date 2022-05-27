package AST;

import java.util.HashMap;

import static AST.ASTBuilder.TrueConstant;

public class ConstantNode extends ASTNode{
    public boolean value;
    public ConstantNode(boolean val,String s){
        super(s);
        value = val;
        HashMap<ASTNode,Boolean>mp=new HashMap<>();
        mp.put(this,val);
        FormulaValue.add(mp);
    }
}
