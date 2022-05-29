
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
        int visit;

        public void addTransition(int a, State t) {
            Successors.add(t);
            Actions.add(a);
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
        for (int i = 0; i < S; ++i) States[i].index = i;

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
        for (var s : s1) if (!s2.contains(s1)) return false;
        return true;
    }

    public TransitionSystem(TransitionSystem TS, NBA A) {
        int S = TS.States.length, Q = A.Q.length;
        State[][] States = new State[S][Q];
        this.States = new State[S * Q];
        for (int i = 0; i < S * Q; ++i) this.States[i].index = i;
        for (int i = 0; i < S; ++i) for (int j = 0; j < Q; ++j) this.States[i * Q + j] = States[i][j];
        ActMap = TS.ActMap;
        for (int i = 0; i < S; ++i)
            for (int j = 0; j < Q; ++j) {
                State s = TS.States[i];
                NBA.State q = A.Q[j];
                for (int h = 0; h < s.Successors.size(); ++h) {
                    State t = s.Successors.get(h);
                    for (int k = 0; k < q.Successors.size(); ++k) {
                        if (same(t.L, q.labels.get(k))) {
                            for (var p : q.Successors.get(k)) {
                                States[i][j].addTransition(s.Actions.get(h), States[t.index][p.j]);
                            }
                        }
                    }
                }
            }
        for (var s : TS.initial) {
            for (var qp : A.Q)
                if (qp.isInitial) {
                    for (int k = 0; k < qp.Successors.size(); ++k) {
                        if (same(s.L, qp.labels.get(k))) {
                            for (var q : qp.Successors.get(k)) {
                                initial.add(States[s.index][q.j]);
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
                F.add(States[i][f.j]);
    }

    private boolean DFS(State f, State s) {
        if (s.visit >= 0) return s.visit == f.index;
        s.visit = f.index;
        for (var t : s.Successors) if (DFS(f, t)) return true;
        return false;
    }

    public boolean isNFPersistent() {
        for (var s : States) s.visit = -1;
        for (var f : F) if (DFS(f, f)) return true;
        return false;
    }
}
