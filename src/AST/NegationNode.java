package AST;

import java.util.HashMap;

public class NegationNode extends ASTNode{
    public ASTNode NegationFormula;
    public NegationNode(ASTNode formula){
        super("!(" + formula.text + ")");
        NegationFormula=formula;
        if(formula.isNegation) {
            text=((NegationNode)formula).NegationFormula.text;
        }
        else{
            isNegation = true;
        }
        for (var mp : formula.FormulaValue) {
            HashMap<ASTNode, Boolean> cur_mp = new HashMap<>(mp);
            cur_mp.put(this, !mp.get(formula));
            FormulaValue.add(cur_mp);
        }
    }
}
