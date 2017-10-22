



```
brew install hugo
hugo new site hugo
cd hugo
git init
git clone https://github.com/nodejh/hugo-theme-cactus-plus.git themes/cactus
echo 'theme = "cactus"' >> config.toml
# git clone https://github.com/sethmacleod/dimension.git
# echo '# theme = "dimension"' >> config.toml
```

```
# hugo new about.md 在`/在content`内创建
hugo new posts/first.md 在`/content/posts`内创建
hugo undraft content/about.md
hugo server --buildDrafts # 渲染所有,包括`draft=true`的
hugo server -D
```