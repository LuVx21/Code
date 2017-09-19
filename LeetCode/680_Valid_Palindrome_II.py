# *-* coding=utf-8 *-*

import math

'''
字符串str
非空,仅含有a-z,最大长度为50000
最多删除一个字符后,判断其是否回文
'''

def validPalindrome(str):
    length = len(str)
    halflength = math.ceil(length / 2)
    if (str == str[::-1]):
        return True
    else:
        for i in range(halflength):
            if(str[i] != str[length - 1 - i]):
                for j in range(i, halflength):
                    if(str[j + 1] != str[length - 1 - j] and str[j] != str[length - j - 2]):
                        return False
                return True

str = 'eabcdedcba'
print(validPalindrome(str))