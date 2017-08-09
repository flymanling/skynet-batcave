package com.skynet.batcave.alg.dynamic;

/**
 * 平面上有N＊M个格子，每个格子中放着一定数量的苹果。
 * 你从左上角的格子开始，每一步只能向下走或是向右走，每次走到一个格子上就把格子里的苹果收集起来，这样下去，你最多能收集到多少个苹果。
 * @author admin
 *
 */
public class DP {

	
	public static int run(int apples[][], int sub[][], String[][] dir, int m, int n) {
		if(m==1) {
			int count = 0;
			for(int i=0;i<n;i++) {
				count += apples[0][i];
				sub[0][i] = count;
				dir[0][i] = "-";
			}
			return count;
		} else if(n==1) {
			int count = 0;
			for(int i=0;i<m;i++) {
				count += apples[i][0];
				sub[i][0] = count;
				if(dir[i][0] == null) {
					dir[i][0] = "|";
				}
			}
			return count;
		}
		//左边过来
		int left = 0;
		if(sub[m-2][n-1]==0) {
			left = run(apples, sub, dir, m-1, n) + apples[m-1][n-1];
		} else {
			left = sub[m-2][n-1] + apples[m-1][n-1];
		}
		//上面过来
		int up = 0;
		if(sub[m-1][n-2]==0) {
			up = run(apples, sub, dir, m, n-1) + apples[m-1][n-1];
		} else {
			up = sub[m-1][n-2] + apples[m-1][n-1];
		}
		if(left > up) {
			sub[m-1][n-1] = left;
			dir[m-1][n-1] = "-";
		} else {
			sub[m-1][n-1] = up;
			dir[m-1][n-1] = "|";
		}
		return sub[m-1][n-1];
	}
	
	public static void main(String[] args) {
		int m = 3;
		int n = 5;
		int[][] sub = new int[m][n];
		String[][] dir = new String[m][n];
		int[][] apples = new int[m][n];
		apples[0] = new int[]{1, 2, 3, 1, 9};
		apples[1] = new int[]{1, 1, 13, 2, 1};
		apples[2] = new int[]{1, 2, 3, 6, 1};
//		apples[3] = new int[]{1, 2, 3, 4, 5};
//		apples[4] = new int[]{1, 2, 3, 4, 5};
		
		
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
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(dir[i][j] + " ");
			}
			System.out.println();
		}
	}
}
