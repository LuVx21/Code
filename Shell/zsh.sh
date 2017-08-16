#! /bin/zsh

echo "hello world"

num=111
func1()
{
local num=222
echo $num
}
echo --------------------------
echo $num
func1
echo --------------------------

str='abcdefg'
echo "str:$str"
echo 'str:$str'
echo str:${str}

echo length:${#str}
echo ${str:2}
echo ${str:1:3}


a=1
1=0
if [ $1=$a ]
then
    echo "you input 1"
elif [ $1=2 ]
then
    echo "you input 2"
else
    echo "you input $1"
fi


input=2
case $input in
0|1)
str='0';;
*)
str=$input;;
esac
echo "----$str"


# for file in *.txt
# do
#     open $file
# done

i=0
while ((i<5));
do
    ((i++))
    echo "i=$i"
done

until ((i==0))
do
    ((i--))
    echo "i=$i"
done


add()
{
    # let "sum=$1+$2"
    sum=$1+$2
    return $sum
}

add 5 6
# $?在shell中保存的是上一条命令的返回值
echo "sum=$?"

echo "$# parameters";
echo "$@";
echo "$0","$1","$2"