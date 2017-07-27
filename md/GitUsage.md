# Git使用技巧

## 新建github项目并同步本地仓库
0. 首先在github新建一个项目
1. git init 在本地初始化git项目
2. git remote add [自定义仓库name] url 关联本地仓库和github项目
3. git pull origin master 取回github项目到本地仓库
4. git status 查看git当前文件情况
5. git add . 添加本地代码改变部分
6. git commit -m "说明文字"  提交本地代码更改 并添加更改说明
7. git push origin master 提交本地仓库到远程github上面




## 同步仓库
- git init 初始化git仓库
- git clone git://github.com/xxx/xxx.git  克隆远程仓库
- git remote -v  查看远程仓库
- git remote add [name] [url] 添加远程仓库
- git remote rm [name] 删除远程仓库
- git remote set-url --push[name][newUrl] 修改远程仓库
- git pull [remoteName] [localBranchName] 拉取远程仓库
- git push [remoteName] [localBranchName] 推送远程仓库



## 关于分支
- git branch 查看当前所有分支
- git branch [branchName]  创建分支
- git checkout [branchName] 切换到分支
- git branch -d [branchName] 删除[branchName]分支
- git merge [branchName] 将名称为[branchName]的分支与当前分支合并
- git branch -a 查看远程分支
- git pull origin [branchName] 下载远程[branchName]分支 到本地
- git push origin [branchName] 传送本地分支[branchName]到仓库origin（会自动合成到仓库的分支中）
- git push origin --delete [branchName] 删除远程[branchName]分支


## 同时关联多个远程仓库
***关联仓库***
git remote add github url;(如果是clone下来的可以省略)
git remote add gitcafe url;

***上传到不同仓库***
git push github master;
git push gitcafe master;
可以考虑自己写个小脚本，一个命令同时执行多个


## 恢复日志
git reflog命令可以对git误操作进行数据恢复。

如不小心用git commit --amend当成git commit覆盖当前的commit，或不小心把当前的commit给搞没了（reset --hard）。 都可以通过git reflog恢复。

Git记录每次修改HEAD的操作，git reflog/git log -g可以查看所有的历史操作记录，然后通过git reset命令进行恢复。

## 更多
- git status 查看git当前文件情况
- 有时候网络更换后，github push失败：ssh: Could not resolve hostname github.com: Name or service not known fatal: Could not read from remote repository. Please make sure you have the correct access rights and the repository exists.
  设置静态ip，添加dns解析 8.8.8.8 nameserver 8.8.4.4
- 追加提交commit
  使用 git commit --amend 进行修改，完成后 :wq 退出 (这个是修改注释)
- 使用git pull提示refusing to merge unrelated histories
创建了一个origin，两个人分别clone，分别做完全不同的提交，第一个人git push成功，第二个人在执行git pull的时候,提示
fatal: refusing to merge unrelated histories，解决方法:git pull --allow-unrelated-histories
