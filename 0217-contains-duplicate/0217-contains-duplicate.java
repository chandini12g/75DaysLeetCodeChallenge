import java.util.HashSet;
class Solution {
    public boolean containsDuplicate(int[] arr) {
        HashSet<Integer> seenValues = new HashSet<>();
        for(int value : arr){
            if(seenValues.contains(value)){
                return true;
            }
            seenValues.add(value);
        }  
        return false;
    }
}