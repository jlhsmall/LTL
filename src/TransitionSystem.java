
import AST.ASTNode;
import AST.VariableNode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TransitionSystem {
    public class State {
        ArrayList<State> Successors = new ArrayList<>();
        ArrayList<Integer> Actions = new ArrayList<>();
        LinkedHashSet<String> L = new LinkedHashSet<>();
        int index;
        boolean visit1;
        int visit2;
        public void addTransition(int a, State t) {
            Successors.add(t);
            Actions.add(a);
        }
        @Override
        public String toString(){
            return "s_"+index;
        }
    }

    ArrayList<State> initial = new ArrayList<>();
    LinkedHashMap<Integer, Integer> ActMap = new LinkedHashMap<>();
    ArrayList<String> AP = new ArrayList<>();
    State[] States;
    LinkedHashSet<State> F = new LinkedHashSet<>();

    //parser
    public TransitionSystem(String file) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        ArrayList<Integer> line = MyInput.ReadIntegerLine(br);
        int S = line.get(0), T = line.get(1);
        States = new State[S];
        for (int i = 0; i < S; ++i){
            States[i]=new State();
            States[i].index = i;
        }

        line = MyInput.ReadIntegerLine(br);
        for (int i : line) initial.add(States[i]);

        line = MyInput.ReadIntegerLine(br);
        for (int i = 0; i < line.size(); ++i) {
            ActMap.put(line.get(i), i);
        }

        AP = MyInput.ReadStringLine(br);

        for (int i = 0; i < T; ++i) {
            line = MyInput.ReadIntegerLine(br);
            State s = States[line.get(0)], t = States[line.get(2)];
            int a = line.get(1);
            s.addTransition(a, t);
        }

        for (int i = 0; i < S; ++i) {
            line = MyInput.ReadIntegerLine(br);
            for (int j : line)
                States[i].L.add(AP.get(j));
        }
    }

    boolean same(LinkedHashSet<String> s1, LinkedHashSet<String> s2) {
        if (s1.size() != s2.size()) return false;
        for (var s : s1) if (!s2.contains(s)) return false;
        return true;
    }

    //product construction
    public TransitionSystem(TransitionSystem TS, NBA A, ASTNode root) {
        //find correlated variables
        LinkedHashSet<String>curAP=new LinkedHashSet<>();
        for(var v : root.FormulaValue.iterator().next().keySet())
            if(v instanceof VariableNode)
                curAP.add(v.text);
        //S'=S*Q
        int S = TS.States.length, Q = A.Q.length;
        State[][] States = new State[S][Q];
        this.States = new State[S * Q];
        for (int i = 0; i < S; ++i)
            for (int j = 0; j < Q; ++j){
                this.States[i * Q + j] = States[i][j]=new State();
                this.States[i*Q+j].index=i*Q+j;
            }

        ActMap = TS.ActMap;

        //transition
        for (int i = 0; i < S; ++i)
            for (int j = 0; j < Q; ++j) {
                State s = TS.States[i];
                NBA.State q = A.Q[j];
                for (int h = 0; h < s.Successors.size(); ++h) {
                    State t = s.Successors.get(h);
                    for (int k = 0; k < q.Successors.size(); ++k) {
                        LinkedHashSet<String> st=new LinkedHashSet<>(t.L);
                        st.retainAll(curAP);
                        if (same(st, q.labels.get(k))) {
                            for (var p : q.Successors.get(k)) {
                                States[i][j].addTransition(s.Actions.get(h), States[t.index][p.index]);
                            }
                        }
                    }
                }
            }
        for (var s : TS.initial) {
            for (var qp : A.Q)
                if (qp.isInitial) {
                    for (int k = 0; k < qp.Successors.size(); ++k) {
                        LinkedHashSet<String> st=new LinkedHashSet<>(s.L);
                        st.retainAll(curAP);
                        if (same(st, qp.labels.get(k))) {
                            for (var q : qp.Successors.get(k)) {
                                initial.add(States[s.index][q.index]);
                            }
                        }
                    }
                }
        }
        for (var q : A.Q) AP.add(q.toString());
        for (int i = 0; i < S; ++i)
            for (int j = 0; j < Q; ++j) {
                States[i][j].L.add(A.Q[j].toString());
            }
        for (int i = 0; i < S; ++i)
            for (var f : A.F)
                F.add(States[i][f.index]);
    }

    private boolean DFS2(State f, State s) {
        if (s.visit2 >= 0) return s.visit2 == f.index;
        s.visit2 = f.index;
        for (var t : s.Successors) if (DFS2(f, t)) return true;
        return false;
    }
    //Check Persistency
    private boolean DFS1(State s){
        if (s.visit1)return false;
        s.visit1=true;
        if(F.contains(s)){
            if(DFS2(s,s))return true;
        }
        for(var t : s.Successors){
            if(DFS1(t))return true;
        }
        return false;
    }
    public boolean isNFPersistent() {
        for (var s : States){
            s.visit1=false;
            s.visit2 = -1;
        }
        for(var i : initial)if(DFS1(i))return true;
        return false;
    }

    public void print(){
        System.out.print("Transition System:");
        for(var s : initial)System.out.print(s+",");
        System.out.println();
        for(var s : States){
            for(int i=0;i<s.Successors.size();++i){
                System.out.print("("+s+","+s.Actions.get(i)+","+s.Successors.get(i)+");");
            }
            System.out.println();
        }
        System.out.println();
    }
}
