@doskey c=cd /d C:\Windows
@doskey d=cd /d D:
@doskey e=cd /d E:
@doskey f=cd /d F:
@doskey code="D:\Program Files\VSCode\Code.exe" $*
@doskey subl="D:\Program Files\Sublime Text 3\sublime_text.exe" $*
@doskey npp="D:\Program Files\Notepad++\Notepad++.exe" $*
@doskey diff="D:\Program Files\Beyond Compare\BCompare.exe" $*


@doskey cp=copy $*
@doskey mv=move $*
@doskey rm=del $*
@doskey grep=findstr /n $*

@doskey e.=explorer .
@doskey open.=explorer .
@doskey pwd=cd
@doskey clear=cls
@doskey cat=type $*
@doskey ls=dir /b $*
@doskey l=dir /od/p/q/tw $*

@doskey g=git $1
@doskey ga=git add $1
@doskey ga.=git add .
@doskey gamend=git commit -C head -a --amend
@doskey gb=git branch
@doskey gc=git checkout $1
@doskey gch.=git checkout head .
@doskey gcl=git config --list
@doskey gcm=git commit -m $1 -a
@doskey gcmf=git commit -m $1 $2
@doskey gcp=git cherry-pick -n $1
@doskey gl=git log --oneline --all --graph --decorate  $*
@doskey glog=git log
@doskey gpl=git pull
@doskey gps=git push origin $1
@doskey gr=git reflog
@doskey gs=git show
@doskey gsd=git show $1 $2>$3
@doskey gsf=git show $1:$2>$3
@doskey gsta=git status