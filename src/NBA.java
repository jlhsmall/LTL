import java.util.ArrayList;
import java.util.LinkedHashSet;

public class NBA {
    public class State {
        GNBA.State q;
        int j;
        ArrayList<LinkedHashSet<State>> Successors = new ArrayList<>();
        ArrayList<LinkedHashSet<String>> labels= new ArrayList<>();
        boolean isInitial;
        public State(GNBA.State q, int j) {
            this.q = q;
            this.j = j;
            isInitial = q.isInitial && j==0;
        }
        @Override
        public String toString(){
            return "q_"+j;
        }
    }

    public State[] Q;
    public LinkedHashSet<State> F = new LinkedHashSet<>();

    public NBA(GNBA G) {
        int k = G.F.size();
        int l = G.Q.size();
        State[][] Q = new State[l][k];
        for (int i=0;i<l;++i)
            for (int j = 0; j < k; ++j)
                Q[i][j]=new State(G.Q.get(i), j);

        for(int i=0;i<l;++i)
            if(G.F.get(0).contains(Q[i][0].q))
                F.add(Q[i][0]);
        for(int i=0;i<l;++i)for(int j=0;j<k;++j){
            if(G.F.get(j).contains(Q[i][j].q)){
                int jp=(j+1)%k;
                for(int h=0;h<Q[i][j].q.Successors.size();++h){
                    LinkedHashSet<State>SuccessorSet=new LinkedHashSet<>();
                    for(var q : Q[i][j].q.Successors.get(h)) {
                        SuccessorSet.add(Q[q.index][jp]);
                    }
                    Q[i][j].Successors.add(SuccessorSet);
                    Q[i][j].labels.add(Q[i][j].q.labels.get(h));
                }
            }
            else{
                for(int h=0;h<Q[i][j].q.Successors.size();++h){
                    LinkedHashSet<State>SuccessorSet=new LinkedHashSet<>();
                    for(var q : Q[i][j].q.Successors.get(h)) {
                        SuccessorSet.add(Q[q.index][j]);
                    }
                    Q[i][j].Successors.add(SuccessorSet);
                    Q[i][j].labels.add(Q[i][j].q.labels.get(h));
                }
            }
        }
        this.Q=new State[k*l];
        for(int i=0;i<l;++i)for(int j=0;j<k;++j)this.Q[i*k+j]=Q[i][j];
    }
}
