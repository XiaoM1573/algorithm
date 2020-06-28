public class Solution {

	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		if (n == 0) {
			return res;
		}
		dfs("", n, n, res);

		return res;
	}

	/**
	 * @param curStr 当前节点
	 * @param left   左括号的剩余个数
	 * @param right  右括号的剩余个数
	 * @param res    用于存储叶子节点，也就是最后的结果
	 */
	public void dfs(String curStr, int left, int right, List<String> res) {
		// 递归出口，遍历到一个叶子节点
		if (left == 0 && right == 0) {
			res.add(curStr);
			return;
		}

		// 剪枝
		if (left > right) {
			return;
		}

		if (left > 0) {
			dfs(curStr + "(", left - 1, right, res);
		}

		if (right > 0) {
			dfs(curStr + ")", left, right - 1, res);
		}
	}
}
