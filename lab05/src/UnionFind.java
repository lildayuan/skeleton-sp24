public class UnionFind {
    // TODO: Instance variables
    private int[] id;
    private int[] sz;

    /* Creates a UnionFind data structure holding N items. Initially, all
       items are in disjoint sets. */
    public UnionFind(int N) {
        // TODO: YOUR CODE HERE
        id=new int[N];
        sz=new int[N];
        for(int i =0; i<N;i++){
        id[i]=-1;
        sz[i]=1;
        }
    }

    /* Returns the size of the set V belongs to. */
    public int sizeOf(int v) {
        int root = find(v);  // 获取 v 的根节点
        if (root >= 0) {
            return sz[root];  // 返回集合的大小
        }
        return -1;  // 如果 v 是无效的，则返回 -1
    }


    /* Returns the parent of V. If V is the root of a tree, returns the
       negative size of the tree for which V is the root. */
    public int parent(int v) {
    if (v < 0 || v >= id.length) {
        throw new IllegalArgumentException("Index out of bounds");
    }
    if (id[v] < 0) {
        return v;
    }
    else {
        return id[v];
    }
}
    /* Returns true if nodes/vertices V1 and V2 are connected. */
    public boolean connected(int v1, int v2) {
        // TODO: YOUR CODE HERE
        if(find(v1)==find(v2)) return true;
        return false;
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. If invalid items are passed into this
       function, throw an IllegalArgumentException. */
    public int find(int v) {
        // TODO: YOUR CODE HERE
        if (v < 0 || v >= id.length) {
                throw new IllegalArgumentException("Index out of bounds");
        }
        if (id[v] < 0) {
                return v;  // 如果 id[v] 是负数，说明 v 是根节点
            }

            // 递归查找父节点
            id[v] = find(id[v]);  // 路径压缩：让当前节点直接指向根节点
            return id[v];
    }

    /* Connects two items V1 and V2 together by connecting their respective
       sets. V1 and V2 can be any element, and a union-by-size heuristic is
       used. If the sizes of the sets are equal, tie break by connecting V1's
       root to V2's root. Union-ing an item with itself or items that are
       already connected should not change the structure. */
    public void union(int v1, int v2) {
        // TODO: YOUR CODE HERE
        if(v1==v2) return;
        if(v1<0||v2<0)
        throw new IllegalArgumentException("Some comment to describe the reason for throwing.");
        int r1=find(v1);
        int r2=find(v2);
        if(sz[r1]<=sz[r2]){
        id[r1]=r2;
        sz[r2]+=sz[r1];
        }
        else{
        id[r2]=r1;
        sz[r1]+=sz[r2];
        }

    }

}
