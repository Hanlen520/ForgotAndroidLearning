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
- git clone --depth=1 url  只克隆最新的仓库
- git remote -v  查看远程仓库
- git remote add [name] [url] 添加远程仓库
- git remote rm [name] 删除远程仓库
- git remote set-url --push[name][newUrl] 修改远程仓库
- git pull [remoteName] [localBranchName] 拉取远程仓库
- git push [remoteName] [localBranchName] 推送远程仓库
- git push –force origin master 当本地缺少远程仓库部分文件时，可能提示出错，需要用–force 来强制上传


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

## SSH Key的配置

1.Windows下打开Git Bash，创建SSH Key，按提示输入密码，可以不填密码一路回车

$ ssh-keygen -t rsa -C “注册邮箱” 然后用户主目录 (如C:\Users\yourname.ssh) 下有两个文件，idrsa是私钥，idrsa.pub是公钥

2.获取key，打开.ssh下的id_rsa.pub文件，里面的内容就是key的内容，复制下来

3.登录GitHub，打开“SSH Keys”页面，点右下角的“New GPG key ” 粘贴key过去，就能成功生成SSH keys 在github网站了

ssh地址：https://github.com/settings/ssh

4.测试ssh key是否成功，使用命令“ssh -T git@github.com”，如果出现You’ve successfully authenticated, but GitHub does not provide shell access 。这就表示已成功连上github，现在你可以把本地项目提交到github仓库了



## 更多
- git status 查看git当前文件情况
- 有时候网络更换后，github push失败：ssh: Could not resolve hostname github.com: Name or service not known fatal: Could not read from remote repository. Please make sure you have the correct access rights and the repository exists.
  设置静态ip，添加dns解析 8.8.8.8 nameserver 8.8.4.4
- 追加提交commit
  使用 git commit --amend，进行追加，若不需要修改注释，则直接输入:wq 退出， 若要修改，则完成后再 :wq 退出 (这个是修改注释)
- 使用git pull提示refusing to merge unrelated histories
创建了一个origin，两个人分别clone，分别做完全不同的提交，第一个人git push成功，第二个人在执行git pull的时候,提示
fatal: refusing to merge unrelated histories，解决方法:git pull --allow-unrelated-histories
- git ls-files 查看当前目录下，已添加到git管理的文件
- 注意若文件名只是大小写不同，会被git认为是同一个文件，而导致同名文件不会再上传提交
-但有时会出现.gitignore中增加了过滤规则但是不起作用的情况。多半是由于在创建.gitignore文件或添加一些过滤规则之前就track了相应的内容，那么即使在.gitignore文件中写入新的过滤规则，这些规则也不会起作用，Git仍然会对这些文件进行版本管理
 git rm -r --cached .
git add .
git commit -m 'update .gitignore'

- 同步远程origin的dev分支到本地：
$ git checkout -b dev origin/dev

- 报错提示
  　ssh: Could not resolve hostname bitbucket.org: Name or service not known
  　　fatal: Could not read from remote repository.
  　　Please make sure you have the correct access rights
  　　and the repository exists.
  
  除了设置ssh密钥，还可以修改下DNS， 我是改为了114.114.114.114然后就成功了 （一开始是192.168.1.1）
   直接设置dns或用腾讯管家等来设置