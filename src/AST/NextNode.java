package AST;

import java.util.HashMap;

public class NextNode extends ASTNode{
    public ASTNode NextFormula;
    public NextNode(ASTNode formula){
        super("X("+formula.text+")");
        NextFormula=formula;
        for(var mp: formula.FormulaValue){
           HashMap<ASTNode,Boolean>cur_mp0=new HashMap<>(mp),cur_mp1=new HashMap<>(mp);
           cur_mp0.put(this,false);
           FormulaValue.add(cur_mp0);
           cur_mp1.put(this,true);
           FormulaValue.add(cur_mp1);
        }
    }
}
