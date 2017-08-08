package com.skynet.batcave.alg.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 动态规划
 * 硬币问题
 * 假设有1,3,5三种面值的硬币，如何用最少的硬币来凑够11元？
 * @author admin
 *
 */
public class Coin {

	//用来存放每次规划结果
	public static Map<Integer, Integer> statusMap = new HashMap<Integer, Integer>();
	public static List<Integer> keys = Arrays.asList(1, 3, 5);
	
	public static int plan(int value) {
//		System.out.println("plan " + value);
		if(keys.contains(value)) {//最基本的子问题解答
			statusMap.put(value, 1);
			return 1;
		} else {
			List<Integer> statusList = new ArrayList<Integer>();
			for(Integer key : keys) {
				//遍历最后一步可能选择的每种面值，
				if(value >= key) {
					statusList.add(getStatus(value, key));
				}
			}
			//从各种面值中选出最少的一种
			Collections.sort(statusList);
			int status = statusList.get(0);
			statusMap.put(value, status);
			return status;
		}
	}
	
	/**
	 * 获取上一次的结果得出这一次的结果
	 * @param value 当前面值
	 * @param key 最后一步选择的硬币
	 * @return 当前面值凑的硬币数
	 */
	public static int getStatus(int value, int key) {
		Integer lastStatus = statusMap.get(value-key);
		int status = 0;
		if(lastStatus == null) {
			status = plan(value-key) + 1;
		} else {
			status = lastStatus + 1;
		}
		return status;
	}
	
	public static void main(String[] args) {
		int status = plan(100);
		System.out.println("status:" + status);
		System.out.println("size:" +statusMap.size());
		for(Integer value : statusMap.keySet()) {
			System.out.println(value + ":" + statusMap.get(value));
		}
	
	}
}
