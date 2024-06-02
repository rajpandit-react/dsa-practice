package graphdsa;

import java.util.ArrayList;
import java.util.List;

public class DisjointSetDSA {
    List<Integer> rank = new ArrayList();
    List<Integer> parent = new ArrayList();

    public static void main(String[] args) {
        DisjointSetDSA ds = new DisjointSetDSA(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);
        ds.unionByRank(3, 7);
    }

    public DisjointSetDSA(int n) {
        for(int i = 0; i < n; ++i) {
            this.rank.add(0);
            this.parent.add(i);
        }

    }

    public int findUPar(int node) {
        if (node == (Integer)this.parent.get(node)) {
            return node;
        } else {
            int ulp = this.findUPar((Integer)this.parent.get(node));
            this.parent.set(node, ulp);
            return (Integer)this.parent.get(node);
        }
    }

    public void unionByRank(int u, int v) {
        int ulp_u = this.findUPar(u);
        int ulp_v = this.findUPar(v);
        if (ulp_u != ulp_v) {
            if ((Integer)this.rank.get(ulp_u) < (Integer)this.rank.get(ulp_v)) {
                this.parent.set(ulp_u, ulp_v);
            } else if ((Integer)this.rank.get(ulp_v) < (Integer)this.rank.get(ulp_u)) {
                this.parent.set(ulp_v, ulp_u);
            } else {
                this.parent.set(ulp_u, ulp_v);
                int ranku = (Integer)this.rank.get(ulp_u);
                this.rank.set(ulp_u, ranku + 1);
            }

        }
    }
}
