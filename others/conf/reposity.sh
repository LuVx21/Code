# 模拟项目的版本库
rm -rf .git && git init
echo 1 > 1 && gaa && gcam '1'
echo 2 >> 1 && gcam '2'
echo 3 >> 1 && gcam '3'
git checkout -b base3
echo '3-1:base3' >> 1 && gcam '3-1:base3'
git branch base3-1
echo '3-2:base3' >> 1 && gcam '3-2:base3'   
git checkout base3-1
echo '3-1-1:base3-1' >> 1 && gcam '3-1-1:base3-1'
echo '3-1-2:base3-1' >> 1 && gcam '3-1-2:base3-1'
git checkout master
echo '4:master' >> 1 && gcam '4:master'
