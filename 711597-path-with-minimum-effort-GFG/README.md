# [Path With Minimum Effort](https://www.geeksforgeeks.org/problems/path-with-minimum-effort/1)
## Medium
You are given&nbsp;a 2D array&nbsp;mat[][], of size&nbsp;n*m. Your task is to find the&nbsp;minimum&nbsp;possible&nbsp;path cost&nbsp;from the top-left cell (0, 0) to the bottom-right cell (n-1, m-1) by moving up, down, left, or right between adjacent cells.
Note:&nbsp;The cost of a path is defined as the maximum absolute difference&nbsp;between the values of any two consecutive cells along that path.
Examples:
Input: mat[][] = [[7, 2, 6, 5],               [3, 1, 10, 8]]
Output: 4
Explanation: The route of [7, 3, 1, 2, 6, 5, 8] has a minimum value of maximum absolute difference between any two consecutive cells in the route, i.e., 4. &nbsp; 
Input: mat[][] = [[2, 2, 2, 1],               [8, 1, 2, 7],               [2, 2, 2, 8],               [2, 1, 4, 7],               [2, 2, 2, 2]]
Output: 0
Explanation: The route of [2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2] has a minimum value of maximum absolute difference between any two consecutive cells in the route, i.e., 0.    
Constraints:1&nbsp;≤&nbsp;n, m&nbsp;≤&nbsp;1000&nbsp;≤&nbsp;mat[i][j]&nbsp;≤&nbsp;106