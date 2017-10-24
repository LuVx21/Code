# -*- coding: utf-8 -*-

'''
'(', ')' and '*'
1.Any left parenthesis '(' must have a corresponding right parenthesis ')'.
2.Any right parenthesis ')' must have a corresponding left parenthesis '('.
3.Left parenthesis '(' must go before the corresponding right parenthesis ')'.
4.'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
5.An empty string is also valid.
The string size will be in the range [1, 100]
'''


class Solution:
    def checkValidString(self, s):
        """
        :type s: str
        :rtype: bool
        """
