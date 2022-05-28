import AST.ASTNode;
import AST.NextNode;
import AST.UntilNode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class GNBA {
    public class State{
        public LinkedHashMap<ASTNode,Boolean>B;
        public boolean isInitial;
        public int index;
        ArrayList<State>Successors=new ArrayList<>();
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
