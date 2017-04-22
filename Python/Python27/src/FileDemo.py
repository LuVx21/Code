# coding=UTF-8
import os
import time
# 将文件夹下所有图片名称加上'_renxie'
# str.split(string)分割字符串
# '连接符'.join(list) 将列表组成字符串


def change_name(path):
    global i
    if not os.path.isdir(path) and not os.path.isfile(path):
        return False
    # 处理单个文件
    if os.path.isfile(path):
        # 分割出目录与文件,('C:/images', '1.png') <type 'tuple'>
        file_path = os.path.split(path)
        # 分割出文件与文件扩展名,['1', 'png'] <type 'tuple'>
        lists = file_path[1].split('.')
        file_ext = lists[-1]  # 取出后缀名(列表切片操作)
        img_ext = ['bmp', 'jpeg', 'gif', 'psd', 'png', 'jpg']
        if file_ext in img_ext:
            os.rename(
                path, file_path[0] + '/' + lists[0] + '_renxie.' + file_ext)
            i += 1  # 注意这里的i是一个陷阱
    # 处理整个文件夹内所有文件
    elif os.path.isdir(path):
        for x in os.listdir(path):
            change_name(os.path.join(path, x))  # os.path.join()在路径处理上很有用


img_dir = '../resource_images/1.png'
# img_dir = '../resource_images'
img_dir = img_dir.replace('\\', '/')
start = time.time()
i = 0
change_name(img_dir)
end = time.time()
c = end - start
print('程序运行耗时:%0.2f' % (c))
print('总共处理了 %s 张图片' % (i))
