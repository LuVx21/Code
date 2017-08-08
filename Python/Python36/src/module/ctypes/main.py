import commands
import os

main = "/Users/renxie/Code/c/callpy/testmain"

if os.path.exists(main):
    rc, out = commands.getstatusoutput(main)
    print('rc = %d, \nout = %s' % (rc, out))

print('*' * 10)

f = os.popen(main)
data = f.readlines()
f.close()

print(data)

print('*' * 10)

os.system(main)
