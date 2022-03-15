package Class2.DFS;

import java.util.*;

public class WordSearchII {

    // TC: O(k * l + (m * n) * 4 ^ l)
    //      k * l -- to build Trie tree, k size of dict, l length of word
    //      m * n -- iteration of matrix
    //      4 ^ l -- dfs, 4 direction
    // SC: O(m*n) -- Heap for visited[][]

    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;
        //int count;

        public TrieNode() {
            this.children = new HashMap<Character, TrieNode>();
            this.isWord = false;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        // Write your solution here
        Set<String> result = new HashSet<>();

        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return new ArrayList<>(result);
        }

        TrieNode root = buildDict(words);
        StringBuilder sb = new StringBuilder();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, sb, result, visited);
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, int row, int col, TrieNode node, StringBuilder sb, Set<String> result, boolean[][] visited) {
        // base case
        // overflow
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }

        // visited before
        if (visited[row][col]) {
            return;
        }
        // exists
        char ch = board[row][col];
        if (!node.children.containsKey(ch)) {
            return;
        }

        visited[row][col] = true;
        sb.append(ch);
        node = node.children.get(ch);
        if (node.isWord) {
            result.add(sb.toString());
        }

        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            dfs(board, newRow, newCol, node, sb, result, visited);
        }
        sb.deleteCharAt(sb.length() - 1);
        visited[row][col] = false;
    }


    private TrieNode buildDict(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            char[] wordArray = word.toCharArray();
            for (char ch : wordArray) {
                if (!cur.children.containsKey(ch)){
                    cur.children.put(ch, new TrieNode());
                }
                cur = cur.children.get(ch);
            }
            cur.isWord = true;
        }

        return root;
    }


    public static void main(String[] args) {
        WordSearchII obj = new WordSearchII();

        char[][] board = {{'b','c','e','e','d'},{'b','b','e','a','e'},{'e','b','c','c','a'},{'a','c','e','c','c'},{'a','b','c','d','c'}};
        String[] words = {"accacd","caea","dcd","acede","ceedd","aa","eeacda","bb"};
        char[][] board2 = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words2 = {"oath","pea","eat","rain"};
        char[][] board3 = {{'a','b'},{'c','d'}};
        String[] words3 = {"ab","db","ad"};
        System.out.println(obj.findWords(board, words));
    }


}
