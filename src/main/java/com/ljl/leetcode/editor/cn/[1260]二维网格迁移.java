package com.ljl.leetcode.editor.cn;////////给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
////////
//////// 每次「迁移」操作将会引发下述活动： 
////////
//////// 
//////// 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。 
//////// 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。 
//////// 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。 
//////// 
////////
//////// 请你返回 k 次迁移操作后最终得到的 二维网格。 
////////
//////// 
////////
//////// 示例 1： 
////////
//////// 
////////
//////// 
////////输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
////////输出：[[9,1,2],[3,4,5],[6,7,8]]
//////// 
////////
//////// 示例 2： 
////////
//////// 
////////
//////// 
////////输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
////////输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
//////// 
////////
//////// 示例 3： 
////////
//////// 
////////输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
////////输出：[[1,2,3],[4,5,6],[7,8,9]]
//////// 
////////
//////// 
////////
//////// 提示： 
////////
//////// 
//////// m == grid.length 
//////// n == grid[i].length 
//////// 1 <= m <= 50 
//////// 1 <= n <= 50 
//////// -1000 <= grid[i][j] <= 1000 
//////// 0 <= k <= 100 
//////// 
//////// Related Topics 数组 矩阵 模拟 👍 73 👎 0
//////
////
//


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        // 首先找到list 输出列表的第一个
        List<List<Integer>> ret = new ArrayList<>();
        // -k
        int row = grid.length;
        int array = grid[0].length;
        k = k % (row * array);
        // 通过 -k 方式找到第一个
        for (int i = 0; i < row * array; ) {

            List<Integer> subList = new ArrayList<>();
            for (int j = 0; j < array; j++) {
                int shiftIndex = i - k;
                if (shiftIndex < 0) {
                    shiftIndex += (row * array);
                }
                int rowIndex = shiftIndex / array;
                int arrayIndex = shiftIndex - rowIndex * array;
                subList.add(grid[rowIndex][arrayIndex]);
                i ++;
            }
            ret.add(subList);
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
