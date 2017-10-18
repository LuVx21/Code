# coding=utf-8


class Singleton(object):
    __instance = None

    def __new__(cls, age, name):
        if not cls.__instance:
            cls.__instance = object.__new__(cls)
        return cls.__instance


a = Singleton(18, "dongGe")
b = Singleton(8, "dongGe")

print(id(a))
print(id(b))

a.age = 19  # 给a指向的对象添加一个属性
print(b.age)  # 获取b指向的对象的age属性
