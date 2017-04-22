# coding=utf-8

def bread(func):
    def wrapper():
        print "</''''''\>"
        func()
        print "<\______/>"
    return wrapper


def ingredients(func):
    def wrapper():
        print "#tomatoes#"
        func()
        print "~salad~"
    return wrapper

print '------------------------'
def A(food="--A--"):
    print food

bread(ingredients(A))()

print '------------------------'
@bread
@ingredients
def B(food="--B--"):
    print food
B()
# 装饰器放置的位置
print '------------------------'

@ingredients
@bread
def C(food="--C--"):
    print food
C()