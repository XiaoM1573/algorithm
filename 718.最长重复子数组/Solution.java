class Solution {
  // 动态规划法
	public int findLength(int[] A, int[] B) {

		int m = A.length;
		int n = B.length;
		int[][] dp = new int[m + 1][n + 1];
		int max = 0;

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (A[i] == B[j]) 
					dp[i][j] = dp[i + 1][j + 1] + 1;
					max = max > dp[i][j] ? max : dp[i][j];
			}
		}
		return max;
	}
  
  // 滑动窗口法
	public int findLength(int[] A, int[] B) {

		int m = A.length;
		int n = B.length;

		int ans = 0;
		// B不动，滑动A
		for (int i = 0; i < m; i++) {
			int len = Math.min(n, m - i);
			int maxlen = maxLength(A, B, i, 0, len);
			ans = Math.max(ans, maxlen);
		}

		// A不动，滑动B
		for (int i = 0; i < n; i++) {
			int len = Math.min(m, n - i);
			int maxlen = maxLength(A,B,0,i,len);
			ans = Math.max(ans, maxlen);
		}
		return ans;
	}

	public int maxLength(int[] A, int[] B, int offsetA, int offsetB, int len) {

		int ans = 0;
		int k = 0;
		for (int i = 0; i < len; i++) {
			if (A[i + offsetA] == B[i + offsetB]) {
				k++;
			} else {
				k = 0;
			}
			ans = Math.max(ans, k);
		}
		return ans;
	}
}
