package com.skynet.batcave.alg.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用贪婪算法解答背包问题
 * 有一个背包，背包容量是M=150。有7个物品，物品可以分割成任意大小。
    要求尽可能让装入背包中的物品总价值最大，但不能超过总容量。
    物品 A B C D E F G
    重量 35 30 60 50 40 10 25
    价值 10 40 30 50 35 40 30
 * @author air
 *
 */
public class Backpack {
	
	public static int M = 150;//背包容量
	public static Map<String, Integer> weightMap = new HashMap<String, Integer>();//物品重量
	public static Map<String, Integer> valueMap = new HashMap<String, Integer>();//物品价值
	
	static {
		weightMap.put("A", 35);
		weightMap.put("B", 30);
		weightMap.put("C", 60);
	}
	
	public static void main(String[] args) {
		
	}
}
