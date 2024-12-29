/**
    Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:

    answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
    answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
    Note that the integers in the lists may be returned in any order.

    

    Example 1:

    Input: nums1 = [1,2,3], nums2 = [2,4,6]
    Output: [[1,3],[4,6]]
    Explanation:
    For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
    For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].
    Example 2:

    Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
    Output: [[3],[]]
    Explanation:
    For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
    Every integer in nums2 is present in nums1. Therefore, answer[1] = [].

 */

 class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList();
        HashMap<Integer, Integer> map1 = new HashMap();
        HashMap<Integer, Integer> map2 = new HashMap();

        for(int i = 0; i < nums1.length; i++){
            map1.put(nums1[i], 0);
        }
        for(int i = 0; i < nums2.length; i++){
            map2.put(nums2[i], 0);
        }
        HashMap<Integer,Integer > l1 =new HashMap();
        for(int i = 0; i < nums1.length; i++){
            if(!map2.containsKey(nums1[i])){
                l1.put(nums1[i], 0);
            }
        }
        HashMap<Integer, Integer> l2 =new HashMap();
        for(int i = 0; i < nums2.length; i++){
            if(!map1.containsKey(nums2[i])){
                l2.put(nums2[i], 0);
            }
        }
        List<Integer> r1 = new ArrayList<>(l1.keySet());
        List<Integer> r2 = new ArrayList<>(l2.keySet());
        result.add(r1);
        result.add(r2);
        return result;
    }
}