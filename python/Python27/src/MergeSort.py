# coding=UTF-8

def msort1(array):
    length = len(array)
    if(length == 1):
        return array
    else:
        mid = length / 2
        left = msort1(array[0: mid])
        right = msort1(array[mid: length])
        return merge(left, right)

def merge(left, right):
    llen = len(left)
    lcur = 0
    rlen = len(right)
    rcur = 0
    result = []
    while lcur < llen and rcur < rlen:
            lone = left[lcur]
            rone = right[rcur]
            result.append(min(lone, rone))
            if lone < rone:
                lcur += 1
            else:
                rcur += 1
                result += left[lcur:]
                result += right[rcur:]
                return result

def add(num1, num2):
    return num1 + num2

print add(5, 8)
print add(5, 0)

array = ['b', 'a', 'd', 'f', 'e', 'c']
msort1(array)
print array
