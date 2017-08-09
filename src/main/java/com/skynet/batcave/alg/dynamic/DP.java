package com.skynet.batcave.alg.dynamic;

/**
 * 平面上有N＊M个格子，每个格子中放着一定数量的苹果。
 * 你从左上角的格子开始，每一步只能向下走或是向右走，每次走到一个格子上就把格子里的苹果收集起来，这样下去，你最多能收集到多少个苹果。
 * @author admin
 *
 */
public class DP {

	
	public static int run(int apples[][], int sub[][], String[][] dir, int m, int n) {
		//最小的子问题解答
		if(m==1) {
			int count = 0;
			for(int i=0;i<n;i++) {
				count += apples[0][i];
				sub[0][i] = count;
				dir[0][i] = "右";
			}
			return count;
		} else if(n==1) {
			int count = 0;
			for(int i=0;i<m;i++) {
				count += apples[i][0];
				sub[i][0] = count;
				if(dir[i][0] == null) {
					dir[i][0] = "下";
				}
			}
			return count;
		}
		//如果从上面过来的最优解
		int left = 0;
		if(sub[m-2][n-1]==0) {
			left = run(apples, sub, dir, m-1, n);
		} else {
			left = sub[m-2][n-1] + apples[m-1][n-1];
		}
		//如果从右边过来的最优解
		int up = 0;
		if(sub[m-1][n-2]==0) {
			up = run(apples, sub, dir, m, n-1);
		} else {
			up = sub[m-1][n-2] + apples[m-1][n-1];
		}
		//从两个动作选出最优解
		if(left >= up) {
			sub[m-1][n-1] = left + apples[m-1][n-1];
			dir[m-1][n-1] = "下";
		} else {
			sub[m-1][n-1] = up + apples[m-1][n-1];
			dir[m-1][n-1] = "右";
		}
		return sub[m-1][n-1];
	}
	
	public static void main(String[] args) {
		int m = 5;
		int n = 5;
		int[][] sub = new int[m][n];//存储状态
		String[][] dir = new String[m][n];//存储动作
		int[][] apples = new int[][]{
				{1, 2, 3, 1, 9},
				{1, 1, 13, 2, 1},
				{1, 2, 3, 6, 1},
				{1, 2, 3, 4, 5},
				{1, 2, 3, 4, 5}
		};
		
		
		System.out.println("apples:");
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(apples[i][j] + " ");
			}
			System.out.println();
		}
		
		int len = run(apples, sub, dir, m, n);
		System.out.println("len:" + len);
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(sub[i][j] + " ");
			}
			System.out.println();
		}
		
		int[][] path = new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(dir[i][j] + " ");
			}
			System.out.println();
		}
		
		int mm = m-1;
		int nn = n-1;
		for(int i=m-1+n-1;i>0;i--) {
			if(dir[mm][nn].equals("下")) {
				mm -= 1;
				path[mm][nn] = 1;
			} else {
				nn -= 1;
				path[mm][nn] = 1;
			}
		}
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(path[i][j] + " ");
			}
			System.out.println();
		}
	}
}
