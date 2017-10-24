import random

# 无限猴子理论模拟

RESULT = '121122'

for i in range(100000):
    count = 0
    renxie = ''
    while renxie.find(RESULT) == -1:
        count += 1
        renxie += str(random.randint(1, 2))
    # print(renxie)
    print('%d' % count)

# index=random.choice(['11', '12', '21', '22'])
# print(index)