import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        
        // Build initial adjacency list
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            adj[parent[i]].add(i);
        }
        
        int[] newParent = Arrays.copyOf(parent, n);
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        
        // Step 1: Find the closest matching ancestor for each node
        dfsFindParents(0, adj, s, lastSeen, newParent);
        
        // Build modified adjacency list
        List<Integer>[] newAdj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            newAdj[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            newAdj[newParent[i]].add(i);
        }
        
        // Step 2: Compute subtree sizes on the modified tree
        int[] ans = new int[n];
        dfsSizes(0, newAdj, ans);
        
        return ans;
    }
    
    private void dfsFindParents(int u, List<Integer>[] adj, String s, int[] lastSeen, int[] newParent) {
        int charIdx = s.charAt(u) - 'a';
        int prevAncestor = lastSeen[charIdx];
        
        if (prevAncestor != -1) {
            newParent[u] = prevAncestor;
        }
        
        lastSeen[charIdx] = u;
        for (int v : adj[u]) {
            dfsFindParents(v, adj, s, lastSeen, newParent);
        }
        lastSeen[charIdx] = prevAncestor; // Backtrack
    }
    
    private int dfsSizes(int u, List<Integer>[] newAdj, int[] ans) {
        int size = 1;
        for (int v : newAdj[u]) {
            size += dfsSizes(v, newAdj, ans);
        }
        ans[u] = size;
        return size;
    }
}
