# 升级Vim

方法1
brew install vim --with-lua --with-override-system-vi
GUI:
brew install macvim --with-lua --with-override-system-vim

with-override-system参数是覆盖系统的vi，因为你自己没有权限覆盖，ln -s也不行
方法2
brew cask install vim --with-lua

旧版位置
/usr/bin/vim
新版位置
/usr/local/bin/vim

## 配置Vim
```
set nocompatible " 关闭 vi 兼容模式
syntax on " 自动语法高亮
"colorscheme molokai " dracula 设定配色方案 molokai
set number " 显示行号
set cursorline " 突出显示当前行
set ruler " 打开状态栏标尺
set shiftwidth=4 " 设定 << 和 >> 命令移动时的宽度为 4
set softtabstop=4 " 使得按退格键时可以一次删掉 4 个空格
set tabstop=4 " 设定 tab 长度为 4
set nobackup " 覆盖文件时不备份
set autochdir " 自动切换当前目录为当前文件所在的目录
filetype plugin indent on " 开启插件
set backupcopy=yes " 设置备份时的行为为覆盖
set ignorecase smartcase " 搜索时忽略大小写，但在有一个或以上大写字母时仍保持对大小写敏感
set nowrapscan " 禁止在搜索到文件两端时重新搜索
set incsearch " 输入搜索内容时就显示搜索结果
set hlsearch " 搜索时高亮显示被找到的文本
set noerrorbells " 关闭错误信息响铃
set novisualbell " 关闭使用可视响铃代替呼叫
set t_vb= " 置空错误铃声的终端代码
" set showmatch " 插入括号时，短暂地跳转到匹配的对应括号
" set matchtime=2 " 短暂跳转到匹配括号的时间
set magic " 设置魔术
set hidden " 允许在有未保存的修改时切换缓冲区，此时的修改由 vim 负责保存
set guioptions-=T " 隐藏工具栏
set guioptions-=m " 隐藏菜单栏
set smartindent " 开启新行时使用智能自动缩进
set backspace=indent,eol,start
" 不设定在插入状态无法用退格键和 Delete 键删除回车符
set cmdheight=1 " 设定命令行的行数为 1
set laststatus=2 " 显示状态栏 (默认值为 1, 无法显示状态栏)
```
set showmatch         " 高亮显示对应的括号
set number            " 显示行号
set cindent           " C风格的对齐方式
set autoindent        " 自动对齐
set confirm           " 在处理未保存或只读文件的时候，弹出确认
set tabstop=4         " Tab键的宽度
syntax on             " 自动语法高亮
set softtabstop=4
set shiftwidth=4      "  统一缩进为4
set hlsearch
set incsearch         " 搜索逐字符高亮
set gdefault          " 行内替换
set encoding=utf-8
set fileencodings=utf-8,ucs-bom,shift-jis,gb18030,gbk,gb2312,cp936,utf-16,big5,euc-jp,latin1      " 编码设置
"colorscheme torte     " 设置颜色主题
"set guifont=Menlo:h16:cANSI      " 设置字体
" set langmenu=zn_CN.UTF-8
" set helplang=cn       " 语言设置
set matchtime=5        " 对应括号高亮的时间（单位是十分之一秒）
set autowrite          " 在切换buffer时自动保存当前文件
set wildmenu            " 增强模式中的命令行自动完成操作
set whichwrap=b,s,<,>,[,]
" 开启Normal或Visual模式下Backspace键，空格键，左方向键，右方向键，Insert或replace模式下左方向键，右方向键跳行的功能。
set wildmenu            " 增强模式中的命令行自动完成操作
set whichwrap=b,s,<,>,[,]
" 开启Normal或Visual模式下Backspace键，空格键，左方向键，右方向键，Insert或replace模式下左方向键，右方向键跳行的功能。
" 设置当文件被改动时自动载入
set autoread
" " quickfix模式
autocmd FileType c,cpp map <buffer> <leader><space> :w<cr>:make<cr>
" "代码补全
set completeopt=preview,menu
" "共享剪贴板
set clipboard+=unnamed
 " 可以在buffer的任何地方使用鼠标（类似office中在工作区双击鼠标定位）
set mouse=a
set selection=exclusive
set selectmode=mouse,key
filetype plugin indent on
" 分为三部分命令：file on, file plugin on, file indent on.
" 分别表示自动识别文件类型，用文件类型脚本，使用缩进定义文件。
"==================自定义的键映射======================
vnoremap $1 <esc>`>a)<esc>`<i(<esc>
vnoremap $2 <esc>`>a]<esc>`<i[<esc>
vnoremap $3 <esc>`>a}<esc>`<i{<esc>
vnoremap $$ <esc>`>a"<esc>`<i"<esc>
vnoremap $q <esc>`>a'<esc>`<i'<esc>
vnoremap $e <esc>`>a"<esc>`<i"<esc>
" 括号自动生成
map <F7> :if exists("syntax_on") <BAR>
\    syntax off <BAR><CR>
\  else <BAR>
\syntax enable <BAR>
\  endif
" 单键<F7>控制syntax on/off。原因是有时候颜色太多会妨碍阅读。


map <F5> :call CompileRunGcc()<CR>

func! CompileRunGcc()

exec "w"

exec "!gcc % -o %<"

exec "! ./%<"

endfunc

" <F5>编译和运行C程序


map <F6> :call CompileRunGpp<CR>

func! CompileRunGpp()

exec "w"

exec "!g++ % -o %<"

exec "! ./<"

endfunc

" <F6>编译和运行C++程序




set softtabstop=4

set shiftwidth=4      "  统一缩进为4


set hlsearch

set incsearch         " 搜索逐字符高亮


set gdefault          " 行内替换


set encoding=utf-8

set fileencodings=utf-8,ucs-bom,shift-jis,gb18030,gbk,gb2312,cp936,utf-16,big5,euc-jp,latin1      " 编码设置


"colorscheme torte     " 设置颜色主题



"set guifont=Menlo:h16:cANSI      " 设置字体


" set langmenu=zn_CN.UTF-8

" set helplang=cn       " 语言设置


set matchtime=5        " 对应括号高亮的时间（单位是十分之一秒）


set autowrite          " 在切换buffer时自动保存当前文件


set wildmenu            " 增强模式中的命令行自动完成操作


set whichwrap=b,s,<,>,[,]

" 开启Normal或Visual模式下Backspace键，空格键，左方向键，右方向键，Insert或replace模式下左方向键，右方向键跳行的功能。


set wildmenu            " 增强模式中的命令行自动完成操作


set whichwrap=b,s,<,>,[,]

" 开启Normal或Visual模式下Backspace键，空格键，左方向键，右方向键，Insert或replace模式下左方向键，右方向键跳行的功能。



" 设置当文件被改动时自动载入

set autoread


" " quickfix模式

autocmd FileType c,cpp map <buffer> <leader><space> :w<cr>:make<cr>


" "代码补全

set completeopt=preview,menu


" "共享剪贴板

set clipboard+=unnamed



 " 可以在buffer的任何地方使用鼠标（类似office中在工作区双击鼠标定位）

 set mouse=a

 set selection=exclusive

 set selectmode=mouse,key



filetype plugin indent on

" 分为三部分命令：file on, file plugin on, file indent on.

" 分别表示自动识别文件类型，用文件类型脚本，使用缩进定义文件。


"==================自定义的键映射======================


vnoremap $1 <esc>`>a)<esc>`<i(<esc>

vnoremap $2 <esc>`>a]<esc>`<i[<esc>

vnoremap $3 <esc>`>a}<esc>`<i{<esc>

vnoremap $$ <esc>`>a"<esc>`<i"<esc>

vnoremap $q <esc>`>a'<esc>`<i'<esc>

vnoremap $e <esc>`>a"<esc>`<i"<esc>

" 括号自动生成


map <F7> :if exists("syntax_on") <BAR>

\    syntax off <BAR><CR>

\  else <BAR>

\syntax enable <BAR>

\  endif

" 单键<F7>控制syntax on/off。原因是有时候颜色太多会妨碍阅读。


map <F5> :call CompileRunGcc()<CR>

func! CompileRunGcc()

exec "w"

exec "!gcc % -o %<"

exec "! ./%<"

endfunc

" <F5>编译和运行C程序


map <F6> :call CompileRunGpp<CR>

func! CompileRunGpp()

exec "w"

exec "!g++ % -o %<"

exec "! ./<"

endfunc

" <F6>编译和运行C++程序

