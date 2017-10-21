# MacOS 使用


@(Mac)


## .DS_store

禁止.DS_store生成:

```
defaults write com.apple.desktopservices DSDontWriteNetworkStores -bool TRUE
```

恢复.DS_store生成：

```
defaults delete com.apple.desktopservices DSDontWriteNetworkStores
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



