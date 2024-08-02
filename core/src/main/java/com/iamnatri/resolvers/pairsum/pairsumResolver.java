package com.iamnatri.resolvers.pairsum;

public class pairsumResolver {
    
    public static int[] pairSum(int[] nums, int target) {

        //todo implement the logic to find the pair of numbers that sum up to the target
        //https://www.hello-algo.com/en/chapter_sorting/sorting_algorithm/

        //in place ordenation array 
        if (nums.length == 0) return new int[]{0, 0};
        if (nums.length == 1) return new int[]{0, 0};
        quicksort(nums, 0, nums.length-1);
        int i = 0, j = nums.length-1;

        while(i<j){
            if (nums[i] + nums[j] == target){
                return new int[]{nums[i], nums[j]};
            }else if (nums[i] + nums[j] < target){
                i++;
            }else{
                j--;
            }
        }
        


        return new int[]{0, 0};
    
    }

    static void quicksort(int[] arr, int left, int right){
        while (left< right){
            int pivot = partition(arr,left,right);

            if (pivot - left < right - pivot){
                quicksort(arr,left,pivot-1);
                left = pivot + 1;
            }else{
                quicksort(arr, pivot+1, right);
                right = pivot-1;
            }
        }
    }

    static void swap (int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    
    }
    /*Partition */
    static int partition(int[] arr, int left, int right){
        int i = left, j = right;
        while(i<j){
            while(i<j && arr[j]>=arr[left]) 
                j--;
            while(i<j && arr[i]<=arr[left])
                i++;
            
            swap(arr, i, j);
        }
        swap(arr,i, left);
        return i;
 
    }
}
