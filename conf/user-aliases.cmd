;= @echo off
;= rem Call DOSKEY and use this file as the macrofile
;= %SystemRoot%\system32\doskey /listsize=1000 /macrofile=%0%
;= rem In batch mode, jump to the end of the file
;= goto:eof
;= Add aliases below here
e.=explorer .
ls=ls --show-control-chars -F --color $*
pwd=cd
clear=cls
history=cat "%CMDER_ROOT%\config\.history"
h=cat "%CMDER_ROOT%\config\.history"
unalias=alias /d $1
vi=vim $*
cmder=cd /d "%CMDER_ROOT%"
ybwang=sqlplus Z_YBWANG/MX77@MX77
g=git $1
ga=git add $1
ga.=git add .
gamend=git commit -C head -a --amend
gb=git branch
gc=git checkout $1
gch.=git checkout head .
gcl=git config --list
gcm=git commit -m '$1' -a
gcmf=git commit -m '$1' $2
gcp=git cherry-pick -n $1
gl=git log --oneline --all --graph --decorate  $*
glog=git log
gpl=git pull
gps=git push origin $1
gr=git reflog
gs=git show
gsd=git show $1 $2>$3
gsf=git show $1:$2>$3
gsta=git status