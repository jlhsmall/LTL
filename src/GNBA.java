import AST.ASTNode;
import AST.NextNode;
import AST.UntilNode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class GNBA {
    public class State{
        public LinkedHashMap<ASTNode,Boolean>B;
        ArrayList<State>Successors=new ArrayList<>();
        public State(LinkedHashMap<ASTNode,Boolean>B){
            this.B=B;
        }
    }
    public LinkedHashSet<State>Q=new LinkedHashSet<>(),Q0=new LinkedHashSet<>();
    public LinkedHashSet<LinkedHashSet<State>>F=new LinkedHashSet<>();
    public GNBA(ASTNode root){
        for (var mp : root.FormulaValue){
            State s=new State(mp);
            Q.add(s);
            if(mp.get(root))Q0.add(s);
        }
        for (var s : Q)for(var t : Q){
            boolean flag = true;
            for (var entry : s.B.entrySet()){
                if (entry.getKey() instanceof NextNode) {
                    if(!entry.getValue().equals(t.B.get(((NextNode)entry.getKey()).NextFormula))) {
                        flag = false;
                        break;
                    }
                }
                else if(entry.getKey() instanceof UntilNode){
                    ASTNode phi1=((UntilNode)entry.getKey()).left,phi2=((UntilNode)entry.getKey()).right;
                    if(!entry.getValue().equals(s.B.get(phi2)||
                            s.B.get(phi1)&&t.B.get(entry.getKey()))){
                        flag=false;
                        break;
                    }
                }
            }
            if(flag)s.Successors.add(t);
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
