// Generated from D:/projects/LTL/src\LTL.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LTLParser}.
 */
public interface LTLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code nextFormula}
	 * labeled alternative in {@link LTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterNextFormula(LTLParser.NextFormulaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nextFormula}
	 * labeled alternative in {@link LTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitNextFormula(LTLParser.NextFormulaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negationFormula}
	 * labeled alternative in {@link LTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterNegationFormula(LTLParser.NegationFormulaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negationFormula}
	 * labeled alternative in {@link LTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitNegationFormula(LTLParser.NegationFormulaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eventuallyFormula}
	 * labeled alternative in {@link LTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterEventuallyFormula(LTLParser.EventuallyFormulaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eventuallyFormula}
	 * labeled alternative in {@link LTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitEventuallyFormula(LTLParser.EventuallyFormulaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code alwaysFormula}
	 * labeled alternative in {@link LTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterAlwaysFormula(LTLParser.AlwaysFormulaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code alwaysFormula}
	 * labeled alternative in {@link LTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitAlwaysFormula(LTLParser.AlwaysFormulaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomFormula}
	 * labeled alternative in {@link LTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterAtomFormula(LTLParser.AtomFormulaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomFormula}
	 * labeled alternative in {@link LTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitAtomFormula(LTLParser.AtomFormulaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code implicationFormula}
	 * labeled alternative in {@link LTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterImplicationFormula(LTLParser.ImplicationFormulaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code implicationFormula}
	 * labeled alternative in {@link LTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitImplicationFormula(LTLParser.ImplicationFormulaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conjunctionFormula}
	 * labeled alternative in {@link LTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterConjunctionFormula(LTLParser.ConjunctionFormulaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conjunctionFormula}
	 * labeled alternative in {@link LTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitConjunctionFormula(LTLParser.ConjunctionFormulaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code untilFormula}
	 * labeled alternative in {@link LTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterUntilFormula(LTLParser.UntilFormulaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code untilFormula}
	 * labeled alternative in {@link LTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitUntilFormula(LTLParser.UntilFormulaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code disjunctionFormula}
	 * labeled alternative in {@link LTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterDisjunctionFormula(LTLParser.DisjunctionFormulaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code disjunctionFormula}
	 * labeled alternative in {@link LTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitDisjunctionFormula(LTLParser.DisjunctionFormulaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subformulaAtom}
	 * labeled alternative in {@link LTLParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterSubformulaAtom(LTLParser.SubformulaAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subformulaAtom}
	 * labeled alternative in {@link LTLParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitSubformulaAtom(LTLParser.SubformulaAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constantAtom}
	 * labeled alternative in {@link LTLParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterConstantAtom(LTLParser.ConstantAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constantAtom}
	 * labeled alternative in {@link LTLParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitConstantAtom(LTLParser.ConstantAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableAtom}
	 * labeled alternative in {@link LTLParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterVariableAtom(LTLParser.VariableAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableAtom}
	 * labeled alternative in {@link LTLParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitVariableAtom(LTLParser.VariableAtomContext ctx);
}