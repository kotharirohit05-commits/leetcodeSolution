class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        count0 = 0 
        count1 = 0
        count2 = 0
        for i in nums:
            if i == 0:
                count0+= 1
            elif i == 1:
                count1+= 1
            elif i ==2:
                count2 += 2
        for j in range(0,count0):
            nums[j] = 0
        for j in range(count0 , count0 + count1):
            nums[j] = 1
        for j in range(count0 + count1 , len(nums)):
            nums[j] = 2

        return nums
        