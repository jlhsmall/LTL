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
        ArrayList<LinkedHashSet<State>> Successors=new ArrayList<>();
        ArrayList<LinkedHashSet<String>> labels= new ArrayList<>();
        public State(LinkedHashMap<ASTNode,Boolean>B){
            this.B=B;
        }
        @Override
        public String toString(){
            return "q_"+index;
        }
    }
    public ArrayList<State> Q = new ArrayList<>();
    public ArrayList<LinkedHashSet<State>>F=new ArrayList<>();
    //GNBA from LTL
    public GNBA(ASTNode root){
        //Q & Q0
        for (var mp : root.FormulaValue){
            State s=new State(mp);
            s.isInitial=mp.get(root);
            Q.add(s);
        }

        for(int i=0;i<Q.size();++i)Q.get(i).index=i;

        //transition function
        for (var s : Q) {
            //A=B conjunct AP
            LinkedHashSet<String>label=new LinkedHashSet<>();
            for(var entry : s.B.entrySet()){
                if((entry.getKey() instanceof VariableNode)&&entry.getValue())
                    label.add(entry.getKey().text);
            }
            s.labels.add(label);
            //delta(B,A)
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
    public void print(){
        System.out.println("GNBA:");
        for(var q : Q) {
            System.out.print(q+": ");
            for(var entry : q.B.entrySet()){
                System.out.print("("+entry.getKey().text+","+entry.getValue()+") ");
            }
            System.out.println();
        }
        for(var q : Q) {
            for(int i=0;i<q.Successors.size();++i)
                System.out.print("("+q+","+ q.labels.get(i)+","+q.Successors.get(i)+");");
            System.out.println();
        }
        System.out.print("F:");
        for(var f : F)System.out.print(f+",");
        System.out.println();System.out.println();
    }
}
