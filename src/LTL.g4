grammar LTL;

formula
    : formula '/\\' formula         # conjunctionFormula
    | formula '\\/' formula         # disjunctionFormula
    | formula '->' formula          # implicationFormula
    | 'X' formula                   # nextFormula
    | 'G' formula                   # alwaysFormula
    | 'F' formula                   # eventuallyFormula
    | formula 'U' formula           # untilFormula
    | atom                          # atomFormula
    ;


atom
    : '!' formula                   # negationAtom
    | '(' formula ')'               #subformulaAtom
    | Constant                      #constantAtom
    | Identifier                    #variableAtom
    ;

Constant: TRUE | FALSE;
TRUE : 'true';
FALSE : 'false';

Identifier : [a-zA-Z]+;