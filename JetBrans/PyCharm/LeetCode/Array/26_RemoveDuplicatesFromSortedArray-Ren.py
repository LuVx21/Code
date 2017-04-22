#! /usr/bin/env python
# -*- coding: utf-8 -*-


class Solution(object):

    def removeDuplicates(self, nums):
        """
                去除无序数组中的重复元素,
                先将重复元素置空,再将非空元素取出
        """
        temp = []
        if not nums:
            print '为空!'
            return nums
        length = len(nums)
        for i in range(length):
            for j in range(i + 1, length):
                if nums[i] == nums[j] and nums[i]:
                    nums[j] = ''
        for i in range(length):
            if nums[i] != '':
                temp.append(nums[i])
        return temp

test = Solution()
arrays = [1, 3, 5, 8, 9, 9, 9, 1, 1, 5, 4, 3, 3, 6]
print test.removeDuplicates(arrays)
