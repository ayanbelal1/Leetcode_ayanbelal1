class Solution {

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

            if(solve(board, word, m, n, i, j, 0, visited))
                return true;
            }
        }

        return false;
    }

    public static boolean solve(char[][] board, String word,int m, int n,int i, int j, int x,boolean[][] visited) {

        if(i < 0 || i >= m || j < 0 || j >= n) return false;

        if(visited[i][j]) return false;

        if(board[i][j] != word.charAt(x)) return false;

        if(x == word.length() - 1) return true;

        visited[i][j] = true;

        boolean a = solve(board, word, m, n, i+1, j, x+1, visited);
        boolean b = solve(board, word, m, n, i, j+1, x+1, visited);
        boolean c = solve(board, word, m, n, i-1, j, x+1, visited);
        boolean d = solve(board, word, m, n, i, j-1, x+1, visited);

        visited[i][j] = false;

        return a || b || c || d;
    }
}