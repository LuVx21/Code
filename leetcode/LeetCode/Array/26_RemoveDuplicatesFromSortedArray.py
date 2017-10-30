#! /usr/bin/env python
# -*- coding: utf-8 -*-


class Solution(object):

    def removeDuplicates(self, nums):
        """
        非重复元素的个数?似乎不完善
        """
        if not nums:
            return 0

        removed_end = 0
        for i in range(1, len(nums)):
            if nums[i] != nums[removed_end]:
                removed_end += 1
                nums[removed_end] = nums[i]
        return removed_end + 1


test = Solution()
arrays = [1, 3, 5, 8, 9, 9, 9, 1, 1, 5, 4, 3, 3, 6]
print test.removeDuplicates(arrays)