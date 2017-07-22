# Git使用技巧

## 初尝
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



## 更多

- 有时候网络更换后，github push失败：ssh: Could not resolve hostname github.com: Name or service not known fatal: Could not read from remote repository. Please make sure you have the correct access rights and the repository exists.
  设置静态ip，添加dns解析 8.8.8.8 nameserver 8.8.4.4

- 追加提交commit
  使用 git commit --amend 进行修改，完成后 :wq 退出 (这个是修改注释)
