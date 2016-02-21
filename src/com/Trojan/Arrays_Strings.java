package com.Trojan;

/**
 * Created by Ajay on 2/20/2016.
 */
public class Arrays_Strings {

    public static void main(String[] args) {

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
}
