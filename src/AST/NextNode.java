package AST;

import java.util.LinkedHashMap;

public class NextNode extends ASTNode{
    public ASTNode NextFormula;
    public NextNode(ASTNode formula){
        super("X("+formula.text+")");
        NextFormula=formula;
        for(var mp: formula.FormulaValue){
           LinkedHashMap<ASTNode,Boolean>cur_mp0=new LinkedHashMap<>(mp),cur_mp1=new LinkedHashMap<>(mp);
           cur_mp0.put(this,false);
           FormulaValue.add(cur_mp0);
           cur_mp1.put(this,true);
           FormulaValue.add(cur_mp1);
        }
    }
}
