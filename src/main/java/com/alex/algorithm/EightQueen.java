package com.alex.algorithm;

/**
 * 八皇后问题是一个古老而著名的问题，是回溯算法的典型例题。该问题是十九世纪著名的数学家高斯1850年提出：在8X8格的国际象棋上摆放八个皇后，
 * 使其不能互相攻击，即任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法。
 * 
 * 高斯认为有76种方案。1854年在柏林的象棋杂志上不同的作者发表了40种不同的解，后来有人用图论的方法解出92种结果。
 * 
 * @author yeohcooller
 *
 */
public class EightQueen {
	private int[] arr = new int[8];// 这个数组的元素的值表示皇后的纵坐标，元素的下标表示第几行
	private int x = 1;// 用来标识每次输出的是第几种方法

	/**
	 * 构造方法
	 */
	public EightQueen() {
		// 从第零个皇后开始放置
		recall(0);
	}

	/**
	 * 显示每一种方法中皇后的放置
	 */
	private void displayQueens() {
		System.out.println("<--第" + x + "种方法开始-->");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (arr[i] != j) {
					System.out.print(" *");
				} else {
					System.out.print(" Q");
				}
			}

			System.out.println();
		}
		System.out.println("<--第" + x++ + "种方法结束-->" + "\n");
	}

	/**
	 * 判断第queenNo个皇后是否能放置
	 * 
	 * @param queenNo
	 *            第queenNo个皇后
	 * @return 是否可放置皇后
	 */
	private boolean canPutQueen(int queenNo) {
		for (int i = 0; i < queenNo; i++) {
			if (((queenNo - i) == Math.abs(arr[queenNo] - arr[i]))// 判断对角线的斜率为1或-1
					|| (arr[i] == arr[queenNo])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 依次将第queenNo个皇后放在第i行，如果可以，放置下一个皇后，如果不可以，回溯，调整上一个皇后放置的行数。
	 * 如果8个皇后都放置妥当，打印出各个皇后位置
	 * 
	 * @param queenNo
	 *            第queenNo个皇后
	 */
	private void recall(int queenNo) {
		if (queenNo == 8) {
			// 八个皇后都放置妥当后打印各个皇后位置
			displayQueens();
			return;
		} else {
			for (int i = 0; i < 8; i++) {
				// 将第queenNo个皇后放在第i行
				arr[queenNo] = i;
				if (canPutQueen(queenNo)) {
					// 第queenNo个皇后放置后，放置下一个皇后
					recall(queenNo + 1);
				}
			}
		}
	}

	/**
	 * 主函数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new EightQueen();
	}
}