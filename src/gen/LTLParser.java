package gen;// Generated from D:/projects/LTL/src\LTL.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LTLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, Constant=11, TRUE=12, FALSE=13, Identifier=14;
	public static final int
		RULE_formula = 0, RULE_atom = 1;
	private static String[] makeRuleNames() {
		return new String[] {
			"formula", "atom"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'/\\'", "'\\/'", "'->'", "'X'", "'G'", "'F'", "'U'", "'!'", "'('", 
			"')'", null, "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "Constant", 
			"TRUE", "FALSE", "Identifier"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "LTL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LTLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class FormulaContext extends ParserRuleContext {
		public FormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formula; }
	 
		public FormulaContext() { }
		public void copyFrom(FormulaContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NextFormulaContext extends FormulaContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public NextFormulaContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).enterNextFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).exitNextFormula(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLVisitor ) return ((LTLVisitor<? extends T>)visitor).visitNextFormula(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EventuallyFormulaContext extends FormulaContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public EventuallyFormulaContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).enterEventuallyFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).exitEventuallyFormula(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLVisitor ) return ((LTLVisitor<? extends T>)visitor).visitEventuallyFormula(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AlwaysFormulaContext extends FormulaContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public AlwaysFormulaContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).enterAlwaysFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).exitAlwaysFormula(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLVisitor ) return ((LTLVisitor<? extends T>)visitor).visitAlwaysFormula(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomFormulaContext extends FormulaContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public AtomFormulaContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).enterAtomFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).exitAtomFormula(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLVisitor ) return ((LTLVisitor<? extends T>)visitor).visitAtomFormula(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ImplicationFormulaContext extends FormulaContext {
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ImplicationFormulaContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).enterImplicationFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).exitImplicationFormula(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLVisitor ) return ((LTLVisitor<? extends T>)visitor).visitImplicationFormula(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConjunctionFormulaContext extends FormulaContext {
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ConjunctionFormulaContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).enterConjunctionFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).exitConjunctionFormula(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLVisitor ) return ((LTLVisitor<? extends T>)visitor).visitConjunctionFormula(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UntilFormulaContext extends FormulaContext {
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public UntilFormulaContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).enterUntilFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).exitUntilFormula(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLVisitor ) return ((LTLVisitor<? extends T>)visitor).visitUntilFormula(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DisjunctionFormulaContext extends FormulaContext {
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public DisjunctionFormulaContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).enterDisjunctionFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).exitDisjunctionFormula(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLVisitor ) return ((LTLVisitor<? extends T>)visitor).visitDisjunctionFormula(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormulaContext formula() throws RecognitionException {
		return formula(0);
	}

	private FormulaContext formula(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FormulaContext _localctx = new FormulaContext(_ctx, _parentState);
		FormulaContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_formula, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				{
				_localctx = new NextFormulaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(5);
				match(T__3);
				setState(6);
				formula(5);
				}
				break;
			case T__4:
				{
				_localctx = new AlwaysFormulaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(7);
				match(T__4);
				setState(8);
				formula(4);
				}
				break;
			case T__5:
				{
				_localctx = new EventuallyFormulaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(9);
				match(T__5);
				setState(10);
				formula(3);
				}
				break;
			case T__7:
			case T__8:
			case Constant:
			case Identifier:
				{
				_localctx = new AtomFormulaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(11);
				atom();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(28);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(26);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new ConjunctionFormulaContext(new FormulaContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(14);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(15);
						match(T__0);
						setState(16);
						formula(9);
						}
						break;
					case 2:
						{
						_localctx = new DisjunctionFormulaContext(new FormulaContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(17);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(18);
						match(T__1);
						setState(19);
						formula(8);
						}
						break;
					case 3:
						{
						_localctx = new ImplicationFormulaContext(new FormulaContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(20);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(21);
						match(T__2);
						setState(22);
						formula(7);
						}
						break;
					case 4:
						{
						_localctx = new UntilFormulaContext(new FormulaContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(23);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(24);
						match(T__6);
						setState(25);
						formula(3);
						}
						break;
					}
					} 
				}
				setState(30);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ConstantAtomContext extends AtomContext {
		public TerminalNode Constant() { return getToken(LTLParser.Constant, 0); }
		public ConstantAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).enterConstantAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).exitConstantAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLVisitor ) return ((LTLVisitor<? extends T>)visitor).visitConstantAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableAtomContext extends AtomContext {
		public TerminalNode Identifier() { return getToken(LTLParser.Identifier, 0); }
		public VariableAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).enterVariableAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).exitVariableAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLVisitor ) return ((LTLVisitor<? extends T>)visitor).visitVariableAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubformulaAtomContext extends AtomContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public SubformulaAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).enterSubformulaAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).exitSubformulaAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLVisitor ) return ((LTLVisitor<? extends T>)visitor).visitSubformulaAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegationAtomContext extends AtomContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public NegationAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).enterNegationAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTLListener ) ((LTLListener)listener).exitNegationAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLVisitor ) return ((LTLVisitor<? extends T>)visitor).visitNegationAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_atom);
		try {
			setState(39);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				_localctx = new NegationAtomContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(31);
				match(T__7);
				setState(32);
				formula(0);
				}
				break;
			case T__8:
				_localctx = new SubformulaAtomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				match(T__8);
				setState(34);
				formula(0);
				setState(35);
				match(T__9);
				}
				break;
			case Constant:
				_localctx = new ConstantAtomContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(37);
				match(Constant);
				}
				break;
			case Identifier:
				_localctx = new VariableAtomContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(38);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return formula_sempred((FormulaContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean formula_sempred(FormulaContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u000e*\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0003\u0000\r\b\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000\u001b\b\u0000\n"+
		"\u0000\f\u0000\u001e\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001(\b"+
		"\u0001\u0001\u0001\u0000\u0001\u0000\u0002\u0000\u0002\u0000\u00001\u0000"+
		"\f\u0001\u0000\u0000\u0000\u0002\'\u0001\u0000\u0000\u0000\u0004\u0005"+
		"\u0006\u0000\uffff\uffff\u0000\u0005\u0006\u0005\u0004\u0000\u0000\u0006"+
		"\r\u0003\u0000\u0000\u0005\u0007\b\u0005\u0005\u0000\u0000\b\r\u0003\u0000"+
		"\u0000\u0004\t\n\u0005\u0006\u0000\u0000\n\r\u0003\u0000\u0000\u0003\u000b"+
		"\r\u0003\u0002\u0001\u0000\f\u0004\u0001\u0000\u0000\u0000\f\u0007\u0001"+
		"\u0000\u0000\u0000\f\t\u0001\u0000\u0000\u0000\f\u000b\u0001\u0000\u0000"+
		"\u0000\r\u001c\u0001\u0000\u0000\u0000\u000e\u000f\n\b\u0000\u0000\u000f"+
		"\u0010\u0005\u0001\u0000\u0000\u0010\u001b\u0003\u0000\u0000\t\u0011\u0012"+
		"\n\u0007\u0000\u0000\u0012\u0013\u0005\u0002\u0000\u0000\u0013\u001b\u0003"+
		"\u0000\u0000\b\u0014\u0015\n\u0006\u0000\u0000\u0015\u0016\u0005\u0003"+
		"\u0000\u0000\u0016\u001b\u0003\u0000\u0000\u0007\u0017\u0018\n\u0002\u0000"+
		"\u0000\u0018\u0019\u0005\u0007\u0000\u0000\u0019\u001b\u0003\u0000\u0000"+
		"\u0003\u001a\u000e\u0001\u0000\u0000\u0000\u001a\u0011\u0001\u0000\u0000"+
		"\u0000\u001a\u0014\u0001\u0000\u0000\u0000\u001a\u0017\u0001\u0000\u0000"+
		"\u0000\u001b\u001e\u0001\u0000\u0000\u0000\u001c\u001a\u0001\u0000\u0000"+
		"\u0000\u001c\u001d\u0001\u0000\u0000\u0000\u001d\u0001\u0001\u0000\u0000"+
		"\u0000\u001e\u001c\u0001\u0000\u0000\u0000\u001f \u0005\b\u0000\u0000"+
		" (\u0003\u0000\u0000\u0000!\"\u0005\t\u0000\u0000\"#\u0003\u0000\u0000"+
		"\u0000#$\u0005\n\u0000\u0000$(\u0001\u0000\u0000\u0000%(\u0005\u000b\u0000"+
		"\u0000&(\u0005\u000e\u0000\u0000\'\u001f\u0001\u0000\u0000\u0000\'!\u0001"+
		"\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000\'&\u0001\u0000\u0000\u0000"+
		"(\u0003\u0001\u0000\u0000\u0000\u0004\f\u001a\u001c\'";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}