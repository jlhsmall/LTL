import java.util.ArrayList;
import java.util.LinkedHashSet;

public class NBA {
    public class State {
        GNBA.State q;
        int j;
        ArrayList<State> Successors = new ArrayList<>();
        boolean isInitial;
        public State(GNBA.State q, int j) {
            this.q = q;
            this.j = j;
            isInitial = q.isInitial && j==0;
        }
    }

    public State[][] Q;
    public LinkedHashSet<State> F = new LinkedHashSet<>();
    int k,l;

    public NBA(GNBA G) {
        k = G.F.size();
        l = G.Q.size();
        Q = new State[l][k];
        for (int i=0;i<l;++i)
            for (int j = 0; j < k; ++j)
                Q[i][j]=new State(G.Q.get(i), j);

        for(int i=0;i<l;++i)
            if(G.F.get(0).contains(Q[i][0].q))
                F.add(Q[i][0]);
        for(int i=0;i<l;++i)for(int j=0;j<k;++j){
            if(G.F.get(j).contains(Q[i][j].q)){
                int jp=(j+1)%k;
                for(var qp : Q[i][j].q.Successors){
                    Q[i][j].Successors.add(Q[qp.index][jp]);
                }
            }
            else{
                for(var qp : Q[i][j].q.Successors){
                    Q[i][j].Successors.add(Q[qp.index][j]);
                }
            }
        }
    }
}
