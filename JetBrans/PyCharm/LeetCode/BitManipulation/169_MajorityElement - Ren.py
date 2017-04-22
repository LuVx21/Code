#! /usr/bin/env python
# -*- coding: utf-8 -*-


def majorityElement(nums):
    """
    [3,4,4,4,4,5,6],找出出现了一半以上的元素(假定存在)和出现次数
    """
    nums.sort()
    print len(nums)
    print int(len(nums) / 2)
    return nums[len(nums) / 2]


testnum = [3, 4, 4, 4, 4, 5, 4, 6, 4, 4, 4, 4, 4, 4, 5]
middle = majorityElement(testnum)
print middle
"""
    # Boyer–Moore majority vote algorithm. Refer to:
    # https://en.wikipedia.org/wiki/Boyer–Moore_majority_vote_algorithm
    def majorityElement_moore(self, nums):


    # Hash table
    def majorityElement_hash(self, nums):


    # Bit manipulation
    # Pay attention: in python -2147483648 >> 31 = -1
    def majorityElement_bit(self, nums):
"""

"""
[1]
[1]
[1,2,2,2]
[7,6,5,7,7]
[-2147483648]
[-2147483648, 2147483648, -2147483648]
[-1,-1,2147483647]
"""
