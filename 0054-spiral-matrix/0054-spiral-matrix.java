class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0, bottom = m ;
        int left = 0, right = n - 1;

        while (top <= bottom && left <= right) {

       
            for (int j = left; j <= right; j++)
                ans.add(matrix[top][j]);
            top++;

            
            for (int i = top; i <= bottom; i++)
                ans.add(matrix[i][right]);
            right--;

           
            if (top <= bottom) {
                for (int j = right; j >= left; j--)
                    ans.add(matrix[bottom][j]);
                bottom--;
            }

            // 4. Bottom -> Top
            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    ans.add(matrix[i][left]);
                left++;
            }
        }

        return ans;
    }
}
