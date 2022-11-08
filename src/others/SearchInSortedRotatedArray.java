package others;

public class SearchInSortedRotatedArray {

    public int search(int[] nums, int target) {
        //min will have index of  minimum element of nums
        int pivot = findIndex(nums);
        //find in sorted left
        if(nums[pivot] <= target && target <= nums[nums.length-1]){
            return search(nums,pivot,nums.length-1,target);
        }
        //find in sorted right
        else{
            return search(nums,0,pivot,target);
        }
    }

    //binary search to find target in left to right boundary
    public int search(int[] nums,int left,int right,int target){
        int l = left;
        int r = right;
        // System.out.println(left+" "+right);
        while(l <= r){
            int mid = l + (r - l)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return -1;
    }

    // find pivot index
    public int findIndex(int[] nums){
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(mid > 0 && nums[mid-1] > nums[mid]){
                return mid;
            }
            else if(nums[left] <= nums[mid] && nums[mid] > nums[right]){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return left;
    }
}
