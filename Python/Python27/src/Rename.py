# coding=UTF-8

import glob, os


# 批量修改文件名为新的格式，例如：将 ZhangSan.png 修改为 boss_ZhangSan.png


def rename(dir, pattern, title_pattern):
    for path_and_filename in glob.iglob(os.path.join(dir, pattern)):
        title, ext = os.path.splitext(os.path.basename(path_and_filename))
        os.rename(path_and_filename, os.path.join(dir, title_pattern % title + ext))

if __name__ == "__main__":
    # 将D盘 bossPng 目录下所有的 png 文件，批量修改文件名为新的格式，其中 %s是原先的文件名（不包括扩展）。
    rename(r'D:\bossPng', r'*.png', r'boss_%s')
