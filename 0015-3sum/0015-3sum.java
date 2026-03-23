import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        
        Arrays.sort(arr); // sort the array
        
        for (int index = 0; index < arr.length - 2; index++) {
            
            // skip duplicate values for index
            if (index > 0 && arr[index] == arr[index - 1]) continue;
            
            int start = index + 1;
            int end = arr.length - 1;
            
            while (start < end) {
                int total = arr[index] + arr[start] + arr[end];
                
                if (total == 0) {
                    ans.add(Arrays.asList(arr[index], arr[start], arr[end]));
                    
                    // skip duplicates for start
                    while (start < end && arr[start] == arr[start + 1]) start++;
                    
                    // skip duplicates for end
                    while (start < end && arr[end] == arr[end - 1]) end--;
                    
                    start++;
                    end--;
                } 
                else if (total < 0) {
                    start++;
                } 
                else {
                    end--;
                }
            }
        }
        
        return ans;
    }
}