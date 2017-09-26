# -*- coding: utf-8 -*-

'''
无序int数组,
求其最大连续升序长度
数组长度<=10000
'''


class Solution:
    def findLengthOfLCIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if(nums == []):
            return 0
        i = 0
        count = 1
        temp = 0
        while(i < len(nums) - 1):
            if (nums[i] < nums[i + 1]):
                count += 1
            else:
                if (temp < count):
                    temp = count
                    count = 1
            i += 1
        return max(temp, count)


case = Solution()
alist = [1, 3, 5, 1, 2, 3, 4, 5, -1, -2, 0, 4, 7, 8, 9]
print(case.findLengthOfLCIS(alist))