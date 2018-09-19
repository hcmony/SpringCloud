package com.hcmony.test;

/**
 * @FileName package com.hcmony.test.SuanFaTest.java
 * @Creator hcmony
 * @Created 2017-10-23 17:03:00
 * @Modifier hcmony
 * @Updated 2017-10-23 17:03:00
 * @Description
 * @Version BUILD1001
 */
public class SuanFaTest {

	public static void main(String[] args) {
		int[] nums = {1,30,26,98,64,53,10};
		nums = getMaoPaoArray(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+",");
		}
	}

	public static int[] getMaoPaoArray(int[] nums){
		for (int i=0;i<nums.length;i++){
			for (int j=0;j<nums.length-i-1;j++){
				int min = nums[j];
				if(min>nums[j+1]){
					nums[j]=nums[j+1];
					nums[j+1]=min;
				}
			}
		}
		return  nums;
	}

	public static int[] getXuanZeArray(int[] nums){
		for (int i=0;i<nums.length;i++){
			for (int j=1+i;j<nums.length;j++){
				int min = nums[i];
				if(min>nums[j]){
					nums[i]=nums[j];
					nums[j]=min;
				}
			}
		}
		return  nums;
	}
}
