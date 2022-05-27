package AST;

import gen.LTLBaseVisitor;
import gen.LTLParser.*;
import AST.*;

import java.util.HashMap;

public class ASTBuilder extends LTLBaseVisitor<ASTNode> {
    static ConstantNode TrueConstant=new ConstantNode(true, "true"),FalseConstant=new ConstantNode(false,"false");
    public ASTNode root;
    public ASTBuilder(FormulaContext ctx) throws Exception {
        if(ctx instanceof NextFormulaContext)
            root = visitNextFormula((NextFormulaContext) ctx);
        else if(ctx instanceof EventuallyFormulaContext)
            root = visitEventuallyFormula((EventuallyFormulaContext) ctx);
        else if(ctx instanceof AlwaysFormulaContext)
            root = visitAlwaysFormula((AlwaysFormulaContext) ctx);
        else if(ctx instanceof AtomFormulaContext)
            root = visitAtomFormula((AtomFormulaContext) ctx);
        else if(ctx instanceof ImplicationFormulaContext)
            root = visitImplicationFormula((ImplicationFormulaContext) ctx);
        else if(ctx instanceof ConjunctionFormulaContext)
            root = visitConjunctionFormula((ConjunctionFormulaContext) ctx);
        else if(ctx instanceof UntilFormulaContext)
            root = visitUntilFormula((UntilFormulaContext) ctx);
        else if(ctx instanceof DisjunctionFormulaContext)
            root = visitDisjunctionFormula((DisjunctionFormulaContext) ctx);
        else
             throw new Exception("No such formula.");
    }
    @Override
    public ASTNode visitNextFormula(NextFormulaContext ctx){
        ASTNode formula = visit(ctx.formula());
        return new NextNode(formula);
    }
    @Override
    public ASTNode visitEventuallyFormula(EventuallyFormulaContext ctx){
        ASTNode right = visit(ctx.formula());
        return new UntilNode(TrueConstant,right);
    }
    @Override
    public ASTNode visitAlwaysFormula(AlwaysFormulaContext ctx){
        ASTNode right = visit(ctx.formula());
        NegationNode nr = new NegationNode(right);
        UntilNode tunr = new UntilNode(TrueConstant,nr);
        return new NegationNode(tunr);
    }
    @Override
    public ASTNode visitAtomFormula(AtomFormulaContext ctx){
        return visit(ctx.atom());
    }
    @Override
    public ASTNode visitImplicationFormula(ImplicationFormulaContext ctx){
        ASTNode left =visit(ctx.formula(0)), right = visit(ctx.formula(1));
        NegationNode nr=new NegationNode(right);
        ConjunctionNode clr = new ConjunctionNode(left,nr);
        return new NegationNode(clr);
    }
    @Override
    public ASTNode visitConjunctionFormula(ConjunctionFormulaContext ctx){
        ASTNode left = visit(ctx.formula(0)),right=visit(ctx.formula(1));
        return new ConjunctionNode(left,right);
    }
    @Override
    public ASTNode visitUntilFormula(UntilFormulaContext ctx){
        ASTNode left = visit(ctx.formula(0)),right=visit(ctx.formula(1));
        return new UntilNode(left,right);
    }
    @Override
    public ASTNode visitDisjunctionFormula(DisjunctionFormulaContext ctx){
        ASTNode left =visit(ctx.formula(0)), right = visit(ctx.formula(1));
        NegationNode nl=new NegationNode(left),nr=new NegationNode(right);
        ConjunctionNode clr = new ConjunctionNode(nl,nr);
        return new NegationNode(clr);
    }
    @Override
    public ASTNode visitNegationAtom(NegationAtomContext ctx){
        ASTNode formula = visit(ctx.formula());
        return new NegationNode(formula);
    }
    @Override
    public ASTNode visitSubformulaAtom(SubformulaAtomContext ctx){
        return visit(ctx.formula());
    }
    @Override
    public ASTNode visitConstantAtom(ConstantAtomContext ctx){
        if (ctx.Constant().getText().equals("true"))
            return TrueConstant;
        else
            return FalseConstant;
    }
    @Override
    public ASTNode visitVariableAtom(VariableAtomContext ctx){
        VariableNode Variable = new VariableNode(ctx.Identifier().getText());
        HashMap<ASTNode,Boolean> mp0=new HashMap<>(), mp1=new HashMap<>();
        mp0.put(Variable,false);
        mp1.put(Variable,true);
        Variable.FormulaValue.add(mp0);
        Variable.FormulaValue.add(mp1);
        return Variable;
    }
}
