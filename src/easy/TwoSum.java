class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] tempArr = new int[]{0,0};
        for (int i = 0; i < nums.length - 1; i++){
            for (int j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    tempArr[0] = i;
                    tempArr[1] = j;
                    break;
                }
            }
        }
        return tempArr;
    }
}
## My first answer when i was doing this question. I was thinking like one array, one target. Using two for-loops could be a answer. 
  Example: set at 1st index of array. start adding 2nd, 3rd index value to see if match with the target.

## But this method is quite brutely. I got another mindset after reviewing others solution. Using HASHMAP is a better choice, it requires only 1 for-loop.

code:
HashMap<Integer, Integer> map = new HashMap<>();
for (int i = 0; i < nums.length; i++){
    int complement = target - nums[i];
    if (map.containsKey(diff)){
        return new int[]{map.get{complement}, i};
    }
  map.put(nums[i], i);
}
return new int[]{};

## This method loops through the array and get the value one by one to minus with the target value, if target value in the map, then return them in a new array. Otherwise, put the value in the map and continue next loop.
