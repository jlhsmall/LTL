import AST.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class GNBA {
    public class State{
        public LinkedHashMap<ASTNode,Boolean>B;
        public boolean isInitial;
        public int index;
        ArrayList<LinkedHashSet<State>>Successors=new ArrayList<>();
        ArrayList<LinkedHashSet<String>> labels= new ArrayList<>();
        public State(LinkedHashMap<ASTNode,Boolean>B){
            this.B=B;
        }
    }
    public ArrayList<State> Q = new ArrayList<>();
    public ArrayList<LinkedHashSet<State>>F=new ArrayList<>();
    public GNBA(ASTNode root){
        for (var mp : root.FormulaValue){
            State s=new State(mp);
            s.isInitial=mp.get(root);
            Q.add(s);
        }
        for(int i=0;i<Q.size();++i)Q.get(i).index=i;
        for (var s : Q) {
            LinkedHashSet<String>label=new LinkedHashSet<>();
            for(var key : s.B.keySet()){
                if(key instanceof VariableNode)
                    label.add(key.text);
            }
            s.labels.add(label);
            LinkedHashSet<State>SuccessorSet=new LinkedHashSet<>();
            for (var t : Q) {
                boolean flag = true;
                for (var entry : s.B.entrySet()) {
                    if (entry.getKey() instanceof NextNode) {
                        if (!entry.getValue().equals(t.B.get(((NextNode) entry.getKey()).NextFormula))) {
                            flag = false;
                            break;
                        }
                    } else if (entry.getKey() instanceof UntilNode) {
                        ASTNode phi1 = ((UntilNode) entry.getKey()).left, phi2 = ((UntilNode) entry.getKey()).right;
                        if (!entry.getValue().equals(s.B.get(phi2) ||
                                s.B.get(phi1) && t.B.get(entry.getKey()))) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
                    SuccessorSet.add(t);
                }
            }
            s.Successors.add(SuccessorSet);
        }
        for(var formula : root.FormulaValue.iterator().next().keySet()){
            if (formula instanceof UntilNode){
                LinkedHashSet<State>f=new LinkedHashSet<>();
                ASTNode phi2 = ((UntilNode)formula).right;
                for(var s : Q){
                    if(!(s.B.get(formula)&&!s.B.get(phi2)))
                        f.add(s);
                }
                F.add(f);
            }
        }
    }
}
