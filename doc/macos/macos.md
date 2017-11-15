# MacOS 使用


@(Mac)


## 显示`任何来源选项`

```
sudo spctl --master-disable
```

## .DS_store

禁止.DS_store生成:

```
defaults write com.apple.desktopservices DSDontWriteNetworkStores -bool TRUE
```

恢复.DS_store生成：

```
defaults delete com.apple.desktopservices DSDontWriteNetworkStores
```

删除.DS_store文件
```
find . -name '*.DS_Store' -type f -delete
```

## terminal 修改语言

```
sudo languagesetup
```

## 改变Launchpad的应用布局

```
defaults write com.apple.dock springboard-columns -int X;
defaults write com.apple.dock springboard-rows -int X;
defaults write com.apple.dock ResetLaunchPad -bool TRUE;
killall Doc
```
上记`X`替换为行列数目(默认5行7列)

## 快捷键

Home:⌘+←
End:⌘+→
ctrl+Home:⌘+↑
ctrl+End:⌘+↓

PgUp:Fn+↑
PgDn:Fn+↓
ctrl+PgUp:⌘+⌥+←
ctrl+PgDn:

「⌘ + ⇧ + . 」可以显示隐藏Finder文件
Mac的Finder不像Windows的文件浏览器可以很明显的看出当前路径，其实右键Finder的标题栏，路径就一目了然了
「⌃ ＋ ⌘ ＋ space」 可以输入emoji，图片字符，特殊符号（使用率较高）
按住 「⌘」 ，左右拖动状态栏


⌘ ＋ ⌥ + -/+ 放大屏幕
预览中启用放大镜：快捷键 ｀ 

按住「⌥  +  ⇧」，再按功能键调节音量

## 命令

man -t grep | open -f -a Preview


https://www.zhihu.com/question/26379660
