# Mac命令

-- 显示隐藏文件
defaults write com.apple.finder AppleShowAllFiles -bool true
-- 不显示隐藏文件
defaults write com.apple.finder AppleShowAllFiles -bool false

使用chflags命令隐藏文件或文件夹

1. chflags hidden ~/Desktop/macx


hidden-nohidden


创建有密码保护的压缩文件


1. zip -e protected.zip ~/Desktop/macx.txt

4.在Finder标题栏显示完整路径
在“终端”中输入下面的命令：
defaults write com.apple.finder _FXShowPosixPathInTitle -bool YES
killall Finder