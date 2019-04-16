# Git使用技巧

## 新建github项目并同步本地仓库
0. 首先在github新建一个项目
1. git init 在本地初始化git项目
2. git remote add [自定义仓库name] url 关联本地仓库和github项目
3. git pull origin master 取回github项目到本地仓库
4. git status 查看git当前文件情况
5. git add . 添加本地代码改变部分
6. git commit -m "说明文字"  提交本地代码更改 并添加更改说明
7. git push -u origin master -- 将本地仓库push远程仓库，并将origin设为默认远程仓库
8. git push origin master 提交本地仓库到远程github上面

## 同步仓库
- git init 初始化git仓库
- git clone git://github.com/xxx/xxx.git  克隆远程仓库
- git clone --depth=1 url  只克隆仓库最新的提交
- git remote -v  查看远程仓库
- git remote add [name] [url] 添加远程仓库
- git remote rm [name] 删除远程仓库
- git remote set-url --push[name][newUrl] 修改远程仓库
- git remote remove origin  取消本地目录下关联的远程库origin
- git pull [remoteName] [localBranchName] 拉取远程仓库
- git push [remoteName] [localBranchName] 推送远程仓库
- git push –force origin master 当本地缺少远程仓库部分文件时，可能提示出错，需要用–force 来强制上传

## 关于分支
- git branch 查看当前所有分支
- git branch [branchName]  创建分支
- git checkout [branchName] 切换到分支
- git branch -d [branchName] 删除[branchName]分支
- git branch -D [branchName] 强制删除[branchName]分支
- git merge [branchName] 将名称为[branchName]的分支与当前分支合并
- git branch -a 查看远程分支
- git pull origin [branchName] 下载远程[branchName]分支 到本地
- git push origin [branchName] 传送本地分支[branchName]到仓库origin（会自动合成到仓库的分支中）
- git push origin --delete [branchName] 删除远程[branchName]分支
- git checkout -b dev origin/dev，作用是checkout远程的dev分支，在本地起名为dev分支，并切换到本地的dev分支
- git checkout -t origin/feature, 类似，它默认会在本地建立一个和远程分支名字一样的分支， 如果远程分支没拉下来，则再git pull origin branchName

## 设置版本标记
相当于发布版本
- git tag tagName # 为当前commit打上TAG
例如： git tag v1.0.0   
- git push origin tagName # 推送tag到仓库
例如：git push origin v1.0.0  
- git tag -d tagName # 删除tag
- git push origin --tags #提交所有tags到仓库

## 多人协作时的Fork和Merge Request
多人协作的项目，往往不会直接commit到总项目，而是由组员各自fork总项目到各自的目录下，然后当有新的commit时，再提交merge request到总项目，由总项目负责人进行文件合并和冲突解决。

git remote add upstream url #添加总仓库
git fetch upstream  #拉取总仓库所有分支下来，但只是存起来，不会合并
git checkout master #切换到你想合并的分支下
git merge upstream/master #合并upstrem下的mater分支到当前master分支


官方教程，如何添加upstream仓库（也就是你fork的项目的总仓库）
https://help.github.com/articles/configuring-a-remote-for-a-fork/

如何拉取最新的总仓库到你本地
https://help.github.com/articles/syncing-a-fork/

## gitignore使用
# a.忽略指定文件/目录
### 忽略指定文件
HelloWrold.class
### 忽略指定文件夹
bin/
bin/gen/

# b.通配符忽略规则
通配符规则如下：
### 忽略.class的所有文件
*.class
### 忽略名称中末尾为ignore的文件夹
*ignore/
### 忽略名称中间包含ignore的文件夹
*ignore*/




## 同时关联多个远程仓库
***关联仓库***
git remote add github url;(如果是clone下来的可以省略)
git remote add gitcafe url;

***上传到不同仓库***
git push github master;
git push gitcafe master;
可以考虑自己写个小脚本，一个命令同时执行多个

## reset使用
git reflog  #查看操作历史
git reset logId #恢复到某次操作
git reset –-soft commitId：回退到某个版本，只回退了commit的信息，不会恢复到index file一级。如果还要提交，直接commit即可；
git reset -–hard commitId：彻底回退到某个版本，本地的源码也会变为上一个版本的内容，撤销的commit中所包含的更改被冲掉；
git revert HEAD~2
相比git reset，它不会改变现在的提交历史。因此，git revert可以用在公共分支上，git reset应该用在私有分支上。

你也可以把git revert当作撤销已经提交的更改，而git reset HEAD用来撤销没有提交的更改。
## SSH Key的配置

1.Windows下打开Git Bash，创建SSH Key，按提示输入密码，可以不填密码一路回车

$ ssh-keygen -t rsa -C “注册邮箱” 然后用户主目录 (如C:\Users\yourname.ssh) 下有两个文件，idrsa是私钥，idrsa.pub是公钥

2.获取key，打开.ssh下的id_rsa.pub文件，里面的内容就是key的内容，复制下来

3.登录GitHub，打开“SSH Keys”页面，点右下角的“New GPG key ” 粘贴key过去，就能成功生成SSH keys 在github网站了

ssh地址：https://github.com/settings/ssh

4.测试ssh key是否成功，使用命令“ssh -T git@github.com”，如果出现You’ve successfully authenticated, but GitHub does not provide shell access 。这就表示已成功连上github，现在你可以把本地项目提交到github仓库了

## 更多
- git help 查看git帮助信息，显示能用的命令
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


- 报错提示
  　ssh: Could not resolve hostname bitbucket.org: Name or service not known
  　　fatal: Could not read from remote repository.
  　　Please make sure you have the correct access rights
  　　and the repository exists.
  
  除了设置ssh密钥，还可以修改下DNS， 我是改为了114.114.114.114然后就成功了 （一开始是192.168.1.1）
   直接设置dns或用腾讯管家等来设置

- fetch和pull的区别
- fetch只会把各分支拉下来，而不会进行合并merge，所以不会产生冲突等
如 git fetch upstream 
- pull除了拉下某分支，还会进行merge操作，有可能会产生冲突
如 git pull upstream/matster

- gitk  查看commit变更日志
- git拉取远程UI文件夹时报错，error: The following untracked working tree files would be overwritten by by merge: gifts/.DS_Store Please move or remove them before you can merge. Aborting
执行一次 git clean -d -fx .  即可
- 当复制 .git或.gitignore文件夹到另一个新目录下是，提示如下：
the item .git can't be replaced because it invisible
需要先把新目录下的.git文件夹或.gitignore删掉，然后就可以了

- 报错 fatal: refusing to merge unrelated histories
在后面加一句 --allow-unrelated-histories
如：git pull origin master --allow-unrelated-histories