class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();

        TrieNode root = new TrieNode();

        // Build Trie
        for (String word : words) {
            insert(word, root);
        }

        // Start DFS from every cell
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, ans);
            }
        }

        return ans;
    }

    private void insert(String word, TrieNode root) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
        }

        node.word = word;
    }

    private void dfs(char[][] board, int i, int j,
                     TrieNode node, List<String> ans) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return;

        char c = board[i][j];

        if (c == '#')
            return;

        if (node.children[c - 'a'] == null)
            return;

        node = node.children[c - 'a'];

        if (node.word != null) {
            ans.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';

        dfs(board, i + 1, j, node, ans);
        dfs(board, i - 1, j, node, ans);
        dfs(board, i, j + 1, node, ans);
        dfs(board, i, j - 1, node, ans);

        board[i][j] = c;
    }
}