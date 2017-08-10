@doskey c=cd /d C:\Windows
@doskey d=cd /d D:
@doskey e=cd /d E:
@doskey f=cd /d F:

@doskey 1=cd ..
@doskey 2=cd ../..
@doskey 3=cd ../../..

@doskey code="D:\Program Files\VSCode\Code.exe" $*
@doskey subl="D:\Program Files\Sublime Text 3\sublime_text.exe" $*
@doskey npp="D:\Program Files\Notepad++\Notepad++.exe" $*
@doskey diff="D:\Program Files\Beyond Compare\BCompare.exe" $*

@doskey q=exit
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

@doskey g=git $*
@doskey ga=git add $*
@doskey ga.=git add .
@doskey gaa=git add --all
@doskey gamend=git commit -C head -a --amend
@doskey gapa=git add --patch
@doskey gau=git add --update

@doskey gb=git branch $*
@doskey gba=git branch -a $*
@doskey gbd=git branch -d $*

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
@doskey gsb=git status -sb
@doskey gsd=git show $1 $2
@doskey gsf=git show $1:$2
@doskey gsps=git show --pretty=short --show-signature
@doskey gss=git status -s
@doskey gst=git status $*

@rem gbda=git branch --no-color --merged | command grep -vE "^(\*|\s*(master|develop|dev)\s*$)" | command xargs -n 1 git branch -d
@rem gbl=git blame -b -w
@rem gbnm=git branch --no-merged
@rem gbr=git branch --remote
@rem gbs=git bisect
@rem gbsb=git bisect bad
@rem gbsg=git bisect good
@rem gbsr=git bisect reset
@rem gbss=git bisect start
@rem gc=git commit -v
@rem gc!=git commit -v --amend
@rem gca=git commit -v -a
@rem gca!=git commit -v -a --amend
@rem gcam=git commit -a -m
@rem gcan!=git commit -v -a --no-edit --amend
@rem gcans!=git commit -v -a -s --no-edit --amend
@rem gcb=git checkout -b
@rem gcd=git checkout develop
@rem gcf=git config --list
@rem gcl=git clone --recursive
@rem gclean=git clean -fd
@rem gcm=git checkout master
@rem gcmsg=git commit -m
@rem gcn!=git commit -v --no-edit --amend
@rem gco=git checkout
@rem gcount=git shortlog -sn
@rem gcp=git cherry-pick
@rem gcpa=git cherry-pick --abort
@rem gcpc=git cherry-pick --continue
@rem gcs=git commit -S
@rem gcsm=git commit -s -m
@rem gd=git diff
@rem gdca=git diff --cached
@rem gdct=git describe --tags `git rev-list --tags --max-count=1`
@rem gdt=git diff-tree --no-commit-id --name-only -r
@rem gdw=git diff --word-diff
@rem gf=git fetch
@rem gfa=git fetch --all --prune
@rem gfo=git fetch origin
@rem gg=git gui citool
@rem gga=git gui citool --amend
@rem ggpull=git pull origin $(git_current_branch)
@rem ggpush=git push origin $(git_current_branch)
@rem ggsup=git branch --set-upstream-to=origin/$(git_current_branch)
@rem ghh=git help
@rem gignore=git update-index --assume-unchanged
@rem gignored=git ls-files -v | grep "^[[:lower:]]"
@rem git-svn-dcommit-push=git svn dcommit && git push github master:svntrunk
@rem gk=\gitk --all --branches
@rem gke=\gitk --all $(git log -g --pretty=%h)
@rem gl=git pull
@rem glg=git log --stat
@rem glgg=git log --graph
@rem glgga=git log --graph --decorate --all
@rem glgm=git log --graph --max-count=10a
@rem glgp=git log --stat -p
@rem glo=git log --oneline --decorate
@rem globurl=noglob urlglobber 
@rem glog=git log --oneline --decorate --graph
@rem gloga=git log --oneline --decorate --graph --all
@rem glol='git log --graph --pretty='\''%Cred%h%Creset -%C(yellow)%d%Creset %s %Cgreen(%cr) %C(bold blue)<%an>%Creset'\'' --abbrev-commit'
@rem glola='git log --graph --pretty='\''%Cred%h%Creset -%C(yellow)%d%Creset %s %Cgreen(%cr) %C(bold blue)<%an>%Creset'\'' --abbrev-commit --all'
@rem glp=_git_log_prettily
@rem glum=git pull upstream master
@rem gm=git merge
@rem gmom=git merge origin/master
@rem gmt=git mergetool --no-prompt
@rem gmtvim=git mergetool --no-prompt --tool=vimdiff
@rem gmum=git merge upstream/master
@rem gp=git push
@rem gpd=git push --dry-run
@rem gpoat=git push origin --all && git push origin --tags
@rem gpristine=git reset --hard && git clean -dfx
@rem gpsup=git push --set-upstream origin $(git_current_branch)
@rem gpu=git push upstream
@rem gpv=git push -v
@rem gr=git remote
@rem gra=git remote add
@rem grb=git rebase
@rem grba=git rebase --abort
@rem grbc=git rebase --continue
@rem grbi=git rebase -i
@rem grbm=git rebase master
@rem grbs=git rebase --skip
@rem grh=git reset HEAD
@rem grhh=git reset HEAD --hard
@rem grmv=git remote rename
@rem grrm=git remote remove
@rem grset=git remote set-url
@rem grt=cd $(git rev-parse --show-toplevel || echo ".")
@rem gru=git reset --
@rem grup=git remote update
@rem grv=git remote -v
@rem gsd=git svn dcommit
@rem gsi=git submodule init

@rem gsr=git svn rebase
@rem gsta=git stash save
@rem gstaa=git stash apply
@rem gstc=git stash clear
@rem gstd=git stash drop
@rem gstl=git stash list
@rem gstp=git stash pop
@rem gsts=git stash show --text
@rem gsu=git submodule update
@rem gts=git tag -s
@rem gtv=git tag | sort -V
@rem gunignore=git update-index --no-assume-unchanged
@rem gunwip=git log -n 1 | grep -q -c "\-\-wip\-\-" && git reset HEAD~1
@rem gup=git pull --rebase
@rem gupv=git pull --rebase -v
@rem gwch=git whatchanged -p --abbrev-commit --pretty=medium
@rem gwip=git add -A; git rm $(git ls-files --deleted) 2> /dev/null; git commit --no-verify -m "--wip-- [skip ci]"