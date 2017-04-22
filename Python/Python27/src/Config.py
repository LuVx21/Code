# coding=utf8
import ConfigParser
import sys, os


# 读取ini配置文件

# 相对路径,1个点:当前文件夹,2个点上1层文件夹
path = '../conf/config.ini'

config = ConfigParser.ConfigParser()
# 读取配置文件方式1
# config.readfp(open(path, "rb"))
# 读取配置文件方式2
config.read(path)

print config.get("Address", "host")
print config.get("concurrent", "processor")
print config.get("renxie", "name")

print '-----------------------------------------'

class Db_Connector:
    def __init__(self, config_file_path):
        config = ConfigParser.ConfigParser()
        config.read(config_file_path)
        
        section = config.sections()
        print 'sections:', section
        
        options = config.options("Address")
        print 'options:', options
        
        item = config.items("Address")
        print 'items:', item
        
        db_host = config.get("Address", "host")
        # getboolean() getfloat()
        db_port = config.getint("Address", "port")
        
        print db_host, db_port
        
        # add_section(section)
        config.set("Address", "db_pass", "123456")
        config.write(open("../conf/config.ini", "w"))
if __name__ == "__main__":
    f = Db_Connector("../conf/config.ini")
    
    
print '-----------------------------------------'
# RawCnfigParser是最基础的ini文件读取类，ConfigParser、SafeConfigParser支持对%(value)s变量的 解析
config = ConfigParser.RawConfigParser()

print "use RawConfigParser() read"
config.read("../conf/config2.ini")
print config.get("portal", "url")

print "use RawConfigParser() write"
config.set("portal", "url2", "%(host)s:%(port)s")
config.write(open("../conf/config2.ini", "w"))
print config.get("portal", "url2")

print '-----------------------------------------'
config = ConfigParser.ConfigParser()

print "use ConfigParser() read"
config.read("../conf/config2.ini")
print config.get("portal", "url")

print "use ConfigParser() write"
config.set("portal", "url2", "%(host)s:%(port)s")
config.write(open("../conf/config2.ini", "w"))
print config.get("portal", "url2")

print '-----------------------------------------'
config = ConfigParser.SafeConfigParser()

print "use SafeConfigParser() read"
config.read("../conf/config2.ini")
print config.get("portal", "url")

print "use SateConfigParser() write"
config.set("portal", "url2", "%(host)s:%(port)s")
config.write(open("../conf/config2.ini", "w"))
print config.get("portal", "url2")
