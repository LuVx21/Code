# coding=UTF-8
# Python 8大排序算法


def insert_sort(lists):
    # 直接插入排序
    length = len(lists)
    for i in range(1, length):
        temp = lists[i]
        j = i - 1
        while j >= 0:
            if lists[j] > temp:
                lists[j + 1] = lists[j]
                lists[j] = temp
            j -= 1
    return lists


def shell_sort(lists):
    # 希尔排序(插入排序)
    length = len(lists)
    groupNum = 2
    groupLength = length / groupNum
    while groupLength > 0:
        for i in range(0, groupLength):
            j = i + groupLength
            while j < length:
                k = j - groupLength
                temp = lists[j]
                while k >= 0:
                    if lists[k] > temp:
                        lists[k + groupLength] = lists[k]
                        lists[k] = temp
                    k -= groupLength
                j += groupLength
        groupLength /= groupNum
    return lists


def bubble_sort(lists):
    # 冒泡排序
    length = len(lists)
    for i in range(0, length):
        for j in range(i + 1, length):
            if lists[i] > lists[j]:
                lists[i], lists[j] = lists[j], lists[i]
    return lists


def quick_sort(lists, left, right):
    # 快速排序
    if left > right:
        return lists
    temp = lists[left]
    low = left
    high = right
    while left < right:
        while left < right and lists[right] >= temp:
            right -= 1
        lists[left] = lists[right]
        while left < right and lists[left] <= temp:
            left += 1
        lists[right] = lists[left]
    lists[right] = temp
    quick_sort(lists, low, left - 1)
    quick_sort(lists, left + 1, high)
    return lists


def select_sort(lists):
    # 直接选择排序
    length = len(lists)
    for i in range(0, length):
        min = i
        for j in range(i + 1, length):
            if lists[min] > lists[j]:
                min = j
        lists[min], lists[i] = lists[i], lists[min]
    return lists


# 堆排序 ↓start
# 调整堆
def adjust_heap(lists, i, size):
    lchild = 2 * i + 1
    rchild = 2 * i + 2
    max = i
    if i < size / 2:
        if lchild < size and lists[lchild] > lists[max]:
            max = lchild
        if rchild < size and lists[rchild] > lists[max]:
            max = rchild
        if max != i:
            lists[max], lists[i] = lists[i], lists[max]
            adjust_heap(lists, max, size)


# 创建堆
def build_heap(lists, size):
    for i in range(0, (size / 2))[::-1]:
        adjust_heap(lists, i, size)


# 堆排序
def heap_sort(lists):
    size = len(lists)
    build_heap(lists, size)
    for i in range(0, size)[::-1]:
        lists[0], lists[i] = lists[i], lists[0]
        adjust_heap(lists, 0, i)


# 堆排序 ↑end


# 归并排序 ↓start
def merge(left, right):
    i, j = 0, 0
    result = []
    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1
    result += left[i:]
    result += right[j:]
    return result


def merge_sort(lists):
    if len(lists) <= 1:
        return lists
    num = len(lists) / 2
    left = merge_sort(lists[:num])
    right = merge_sort(lists[num:])
    return merge(left, right)


# 归并排序 ↑end
import math


def radix_sort(lists, radix=10):
    # 基数排序
    k = int(math.ceil(math.log(max(lists), radix)))
    bucket = [[] for i in range(radix)]
    for i in range(1, k + 1):
        for j in lists:
            bucket[j / (radix ** (i - 1)) % (radix ** i)].append(j)
        del lists[:]
        for z in bucket:
            lists += z
            del z[:]
    return lists


aList = [4, 7, 3, 6, 5, 9, 1, 2, 8, 12, 4]
# 调用插入排序
print '插入排序' + str(insert_sort(aList))
# 调用希尔排序
print '希尔排序' + str(shell_sort(aList))
# 调用冒泡排序
print '冒泡排序' + str(bubble_sort(aList))
# 调用快速排序
print '快速排序' + str(quick_sort(aList, 0, len(aList) - 1))
# 调用选择排序
print '选择排序' + str(select_sort(aList))
# 调用堆排序
print '堆排序' + str(heap_sort(aList))
# 调用归并排序
print '归并排序' + str(merge_sort(aList))
# 调用基数排序
print '基数排序' + str(radix_sort(aList))
