/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.HashSet;

/**
 *
 * @author Ajay
 */
public class Array_Strings {

    public static void main(String[] args) {
        Functions f = new Functions();
        int[] arr = new int[]{1,2};
        f.rotate(arr, 3);
    }
}

class Functions
{
    //https://leetcode.com/problems/increasing-triplet-subsequence/
    //Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
    public boolean increasingTriplet(int[] nums) {
        if(nums.length > 0)
        {
            int min = nums[0];
            int smin = Integer.MAX_VALUE;

            for(int i=1; i<nums.length; i++)
            {
                if(nums[i]<=min)
                    min = nums[i];
                else if(nums[i] <= smin)
                    smin = nums[i];
                else if(nums[i] > smin && nums[i] > min)
                    return true;
            }
            return false;
        }
        else
            return false;
    }

    //https://leetcode.com/problems/remove-duplicates-from-sorted-array/
    //Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
    public int removeDuplicates(int[] nums) {
        int i=0;
        int j=1;
        while(i<nums.length && j<nums.length)
        {
            while(j<nums.length && nums[j] == nums[i])
                j++;
            if(j<nums.length)
                nums[++i] = nums[j++];
        }
        return i+1;
    }
    
    //https://leetcode.com/problems/longest-consecutive-sequence/
    //https://leetcode.com/problems/longest-consecutive-sequence/
    public int longestConsecutive(int[] a) {
        HashSet<Integer> h = new HashSet();
        for(int n: a)
        {
            h.add(n);
        }
        
        int res = 1;
        for(int i=0; i<a.length; i++)
        {
            if(!h.contains(a[i]-1))
            {
                int j = a[i];
                while(h.contains(j))
                    j++;
                if(res < j-a[i])
                    res = j-a[i];
            }
        }
        return res;
    }
    
    //http://www.programcreek.com/2015/03/rotate-array-in-java/
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        // Divide array in 2 parts, nums.length-k and k
        
        // Reverse 1st part.
        reverse(nums, 0, nums.length-k-1);
        
        // Reverse 2nd part
        reverse(nums, nums.length-k, nums.length-1);
        
        // Reverse whole array
        reverse(nums, 0, nums.length-1);
    }
    
    public static void reverse(int[] arr, int left, int right){
	if(arr == null || arr.length == 1) 
		return;
 
	while(left < right)
        {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
		left++;
		right--;
	}	
    }
}
