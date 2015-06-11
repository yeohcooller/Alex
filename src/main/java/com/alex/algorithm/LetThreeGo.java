package com.alex.algorithm;

import java.util.Arrays;

/**
 * 有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，问最后留下的是原来第几号的那位？
 *
 * @author Alex Yang
 *
 */
public class LetThreeGo {

	public static void main(String[] args) {
		/**** 初始化人员 ***/
		boolean[] per = new boolean[10]; // boolean数组表示站成一圈的人，false表示退出
		for (int i = 0; i < per.length; i++) {
			per[i] = true;
		}

		/**** 报号 ***/
		int t = 0, len = per.length;
		while (len > 1) {
			for (int i = 0; i < per.length; i++) {

				if (per[i]) {
					t++;
					if (t == 3) {
						t = 0;
						per[i] = false;
						len--;
					}
				}
			}
		}
		/***** 结果 *****/
		System.out.println("最后的情况：" + Arrays.toString(per));
		for (int i = 0; i < per.length; i++) {
			if (per[i]) {
				System.out.println("最后剩下的是第" + (i + 1) + "个");
				System.out.println("原来喊的数：" + (i + 1) % 3);
			}
		}
	}

}
