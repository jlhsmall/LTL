package gen;// Generated from D:/projects/LTL/src\LTL.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LTLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LTLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code nextFormula}
	 * labeled alternative in {@link LTLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNextFormula(LTLParser.NextFormulaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eventuallyFormula}
	 * labeled alternative in {@link LTLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEventuallyFormula(LTLParser.EventuallyFormulaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alwaysFormula}
	 * labeled alternative in {@link LTLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlwaysFormula(LTLParser.AlwaysFormulaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomFormula}
	 * labeled alternative in {@link LTLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomFormula(LTLParser.AtomFormulaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code implicationFormula}
	 * labeled alternative in {@link LTLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplicationFormula(LTLParser.ImplicationFormulaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conjunctionFormula}
	 * labeled alternative in {@link LTLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjunctionFormula(LTLParser.ConjunctionFormulaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code untilFormula}
	 * labeled alternative in {@link LTLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUntilFormula(LTLParser.UntilFormulaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code disjunctionFormula}
	 * labeled alternative in {@link LTLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisjunctionFormula(LTLParser.DisjunctionFormulaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negationAtom}
	 * labeled alternative in {@link LTLParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegationAtom(LTLParser.NegationAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subformulaAtom}
	 * labeled alternative in {@link LTLParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubformulaAtom(LTLParser.SubformulaAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constantAtom}
	 * labeled alternative in {@link LTLParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantAtom(LTLParser.ConstantAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableAtom}
	 * labeled alternative in {@link LTLParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableAtom(LTLParser.VariableAtomContext ctx);
}