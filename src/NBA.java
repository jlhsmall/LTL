import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class NBA {
    public class State {
        GNBA.State q;
        //int j;
        int index;
        ArrayList<LinkedHashSet<State>> Successors = new ArrayList<>();
        ArrayList<LinkedHashSet<String>> labels = new ArrayList<>();
        boolean isInitial;

        public State(GNBA.State q, int j) {
            this.q = q;
            //this.j = j;
            isInitial = q.isInitial && j == 0;
        }

        @Override
        public String toString() {
            return "q_" + index;
        }
    }

    public State[] Q;
    public LinkedHashSet<State> F = new LinkedHashSet<>();

    public NBA(GNBA G) {
        int k = G.F.size();
        if (k == 0) {
            Q = new State[G.Q.size()];
            for (int i = 0; i < Q.length; ++i) Q[i] = new State(G.Q.get(i), 0);
            for (int i = 0; i < Q.length; ++i) {
                for (int j = 0; j < G.Q.get(i).Successors.size(); ++j) {
                    LinkedHashSet<State> SuccessorSet = new LinkedHashSet<>();
                    for (var q : G.Q.get(i).Successors.get(j)) SuccessorSet.add(Q[q.index]);
                    Q[i].Successors.add(SuccessorSet);
                    Q[i].labels.add(G.Q.get(i).labels.get(j));
                }
            }
            return;
        }
        int l = G.Q.size();
        State[][] Q = new State[l][k];
        for (int i = 0; i < l; ++i)
            for (int j = 0; j < k; ++j)
                Q[i][j] = new State(G.Q.get(i), j);
        for (int i = 0; i < l; ++i)
            if (G.F.get(0).contains(Q[i][0].q))
                F.add(Q[i][0]);
        for (int i = 0; i < l; ++i)
            for (int j = 0; j < k; ++j) {
                if (G.F.get(j).contains(Q[i][j].q)) {
                    int jp = (j + 1) % k;
                    for (int h = 0; h < Q[i][j].q.Successors.size(); ++h) {
                        LinkedHashSet<State> SuccessorSet = new LinkedHashSet<>();
                        for (var q : Q[i][j].q.Successors.get(h)) {
                            SuccessorSet.add(Q[q.index][jp]);
                        }
                        Q[i][j].Successors.add(SuccessorSet);
                        Q[i][j].labels.add(Q[i][j].q.labels.get(h));
                    }
                } else {
                    for (int h = 0; h < Q[i][j].q.Successors.size(); ++h) {
                        LinkedHashSet<State> SuccessorSet = new LinkedHashSet<>();
                        for (var q : Q[i][j].q.Successors.get(h)) {
                            SuccessorSet.add(Q[q.index][j]);
                        }
                        Q[i][j].Successors.add(SuccessorSet);
                        Q[i][j].labels.add(Q[i][j].q.labels.get(h));
                    }
                }
            }
        this.Q = new State[k * l];
        for (int i = 0; i < l; ++i)
            for (int j = 0; j < k; ++j) {
                this.Q[i * k + j] = Q[i][j];
                this.Q[i * k + j].index = i * k + j;
            }
    }

    public void Complement() {
        LinkedHashSet<State> newF = new LinkedHashSet<>(Arrays.asList(Q));
        newF.removeAll(F);
        F = newF;
    }

    public void print() {
        for (var q : Q) {
            for (int i = 0; i < q.Successors.size(); ++i)
                System.out.print("(" + q + "," + q.labels.get(i) + "," + q.Successors.get(i) + ");");
            System.out.println();
        }
        System.out.print("F:");
        for (var f : F) System.out.print(f + ",");
        System.out.println();
        System.out.println();
    }
}
