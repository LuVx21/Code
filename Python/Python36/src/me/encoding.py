import chardet
import sys

# http://www.cnblogs.com/weixliu/p/3550642.html
# http://blog.csdn.net/yueguanghaidao/article/details/50612855
# http://www.cnblogs.com/fnng/p/5008884.html

reload(sys)
sys.setdefaultencoding('UTF-8')

str = '転送'

newStr = str.decode('gbk').encode('utf8')

print(newStr)