class Solution {
    // Define the segment tree node class
    class Node {
        int maxLen;
        int prefLen;
        int suffLen;
        int size;
        char leftChar;
        char rightChar;

        Node(char ch) {
            this.maxLen = 1;
            this.prefLen = 1;
            this.suffLen = 1;
            this.size = 1;
            this.leftChar = ch;
            this.rightChar = ch;
        }

        Node() {
            this.maxLen = 0;
            this.prefLen = 0;
            this.suffLen = 0;
            this.size = 0;
        }
    }

    private Node[] tree;
    private char[] sArr;

    // Helper method to merge left and right child nodes into a parent node
    private Node merge(Node left, Node right) {
        if (left == null) return right;
        if (right == null) return left;

        Node parent = new Node();
        parent.size = left.size + right.size;
        parent.leftChar = left.leftChar;
        parent.rightChar = right.rightChar;

        // Base merge without crossing the boundary
        parent.maxLen = Math.max(left.maxLen, right.maxLen);
        parent.prefLen = left.prefLen;
        parent.suffLen = right.suffLen;

        // Check if characters at the boundary touch and match
        if (left.rightChar == right.leftChar) {
            // Update prefix length if the entire left side can merge with right prefix
            if (left.prefLen == left.size) {
                parent.prefLen = left.size + right.prefLen;
            }
            // Update suffix length if the entire right side can merge with left suffix
            if (right.suffLen == right.size) {
                parent.suffLen = right.size + left.suffLen;
            }
            // Update overall max length considering the combined crossing substring
            parent.maxLen = Math.max(parent.maxLen, left.suffLen + right.prefLen);
        }

        return parent;
    }

    // Build the segment tree initially
    private void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = new Node(sArr[start]);
            return;
        }
        int mid = start + (end - start) / 2;
        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    // Point update to modify a character at a specific index
    private void update(int node, int start, int end, int idx, char ch) {
        if (start == end) {
            tree[node] = new Node(ch);
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, ch);
        } else {
            update(2 * node + 1, mid + 1, end, idx, ch);
        }
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        sArr = s.toCharArray();
        tree = new Node[4 * n];

        // Build the segment tree
        build(1, 0, n - 1);

        int k = queryIndices.length;
        int[] result = new int[k];

        // Process each query
        for (int i = 0; i < k; i++) {
            int idx = queryIndices[i];
            char ch = queryCharacters.charAt(i);
            sArr[idx] = ch; // Keep string representation up to date
            
            update(1, 0, n - 1, idx, ch);
            result[i] = tree[1].maxLen; // The root node always contains the global max length
        }

        return result;
    }
}
