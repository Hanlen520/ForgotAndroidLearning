36. Chrome插件整理
Octotree方便查看github代码
JsonFormatter 查看json格式化数据

35.mac创建txt文本的方法：
先打开“文本编辑器”应用，“新建文稿”，"格式“选择”纯文本“（快捷键command+shift+T），存为文件即可
PS：可直接在“文本编辑器”的“偏好设置”中设置新建时即可“纯文本”格式

34.关闭和退出
⌘ + W 关闭当前的软件窗口（软件并没有真正退出进程），相当于点了左上角的红色叉叉。
⌘ + Q 真正退出软件。
⌘ + option + esc 强制退出某个软件。通常在软件无响应时使用。

33. 安装.json .md等格式的文件预览（安装插件后按空格键即可预览），
a.进入~/Library/文件夹，创建QuickLook文件夹
b.下载插件，在这里https://www.quicklookplugins.com/ 搜索你想要的插件，按说明安装
如json预览 http://www.sagtau.com/quicklookjson.html
c.复制插件到~/Library/QuickLook/文件夹
d.终端进入~/Library/QuickLook/路径，输入qlmanage -r 刷新插件管理器即可
e.这时再空格点一下.json文件，已经可以预览内容了

也可直接用brew来安装插件
预览代码高亮
brew cask install qlcolorcode

显示图片分辨率和大小
brew cask install qlimagesize
PS: 用brew进行安装时，不必连接vpn
https://segmentfault.com/a/1190000010608389

32.在很多应用中，使用 command + A 全选快捷键时，容易误按到 command + Q 退出快捷键，导致应用直接关闭 。
解决方案：
1. 得知自己应用快捷键的名字
2. 在 System Preferences（系统便好设置） - Keyboard（键盘） - Shortcuts（快捷键） - App Shortcuts（应用快捷键） 中新增该名字的快捷键，并将快捷键的按法由 command + Q 改为其他键。
2.1 如果 App Shortcuts 中已经存在以该名字命名的设置项，则不需要自行新增，直接改已有的设置项即可

示例：
1. 以自己常用的 Firefox 浏览器为例，通过屏幕左上角的入口得知退出 Firefox 浏览器的快捷键名字是“Quit Firefox”（如下图1）
2. 在设置里新增名为“Quit Firefox”的快捷键，键为 option + command + Q（如下图2）




31. 安装未知来源的破解软件时，有的会打不开，提示软件损坏请放到trash，此时要在设置的安全设置中勾选全部可打开，如果没有这个选项的话（macOS Sierra 10.12）,打开终端，输入sudo spctl --master-disable然后按回车。然后会看见个password后面还有个钥匙图标，然后不用管他直接再继续输入你自己电脑解锁密码（输入的时候不显示你输入的密码，感觉就是输入不了东西一样，也不用管，凭感觉输入完按回车键）。然后再回到隐私里，就看见任何来源了。


30.Gif图查看，选中git图片，按空格预览即可播放

29.修改zsh后，终端显示某些字符乱码的问题，在iTerm设置修改下字体就好了
Preferences - Profiles - Text - Change Font - All Fonts Meslo LG M


27. 下载完整包来安装macOS的话，文稿文件夹内的文件会消失，所以要备份这个文件夹，其他应用还存在

26.macOS连接win平台的服务器
官方教程。
https://docs.microsoft.com/zh-cn/windows-server/remote/remote-desktop-services/clients/remote-desktop-mac?spm=a2c63.p38356.a3.11.3e7e7302pU6yf8

远程软件下载
https://rink.hockeyapp.net/apps/5e0c144289a51fca2d3bfa39ce7f2b06/https://rink.hockeyapp.net/apps/5e0c144289a51fca2d3bfa39ce7f2b06/

25.将token统一加到header里，postman要在第一栏auth。。bear处添加

24. 在终端输入/usr/libexec/java_home可查看java路径， 后面加-v version可查具体版本号的路径，如
/usr/libexec/java_home -v 1.6

23. 选中qq应用，然后按Command+N 可实现qq多开

22.使用锤子科技的HandShaker来连接Android手机传输多媒体文件

21. 有道云笔记的图片丢失看不到了，退出登录，清空本地数据重新登录试试
Mac端：将客户端内容成功同步后，完全退出软件，在电脑本地删除本地数据目录文件后，再重新登录并同步后使用试试。
删除本地数据目录文件方法： 打开Finder，按快捷键shift+command+g，弹出一个“前往文件夹”的框，在框里输入“~/资源库/Containers/com.youdao.note.YoudaoNoteMac/Data/Library/Application Support/com.youdao.note.YoudaoNoteMac”

19. 设置文件默认打开方式
第一步：右键单击该文件，然后选择「显示简介」选项。
第二步：找到「打开方式」项目，点击倒三角选择你想指定的默认应用程序。
第三步：单击「全部更改」按钮即可生效。

18. 切换中英文输入法：快捷键 caps lock

17. 删除右边字符 fn+delete

16. How can I exit a program in the OS X Terminal?
press control + C in your keyboard.
and in some man-page and vim editor write :q and press enter
git是直接按q即可中断该执行

15.mac 右键 启动终端
系统偏好设置 -> 键盘 -> 快捷键 -> 服务，勾选「新建位于文件夹位置的终端窗口」（后面的键盘快捷键可以不选），然后在 Finder 里面选中文件夹--右键菜单的「服务」下面就会有「新建位于文件夹位置的终端窗口」这一子菜单了。


14.创建文件夹桌面快捷方式：
在mac里“快捷方式”是叫做 替身 的 
 选中目标文件夹->右键->制作替身 然后把生成的替身拖放到桌面上 


13. 调整F1 F2等作为标准功能键，调灯光等需要fn+f1 ， 这样方便AndroidStudio使用快捷键


12.剪切功能。
复制后粘贴的时候用   option+command+v   就剪切了（相当于移动文件，删除了原来路径的文件）！
command+v 是粘贴

11.Homebrew安装与使用

10.终端使用zsh？shell？

8. 控制台使用
大多数命令都会包含一个使用指南，会告诉你任何你需要知道的关于这个命令的所有细节，在命令行中输入 man command-name 即可获取。例如，你想知道ls这个命令怎么使用，输入man ls即可进入使用指南页面。
使用指南往往很长，所以你可以使用▲（上箭头）或▼（下箭头）来上下移动，使用　来翻页，输入/和关键字来按照关键字搜索，按Q来退出使用指南页面。

pwd的含义是“print working directory”，会显示当前目录的绝对路径。
ls的含义是“list directory contents”，它会列出当前目录的内容。这个命令还有其他参数可选。
cd的含义是“change directory”，它会改变当前目录到你指定的目录。如果你不指定，则会返回你的 home folder。
cd ..  返回上一级目录

7. Command+Shift+. 可以显示隐藏文件、文件夹，再按一次，恢复隐藏；
finder下使用Command+Shift+G 可以前往任何文件夹，包括隐藏文件夹。
command+⬆️ 返回上一级目录

6.space键
在Mac系统里，几乎所有文件都可以直接用空格键快速查看预览
然后上下箭头可切换到上下一个文件，方便好用。

5.重命名快捷键enter
首先我们要选中一个你需要重命名的文件夹。选中之后我们按下return键，也就是我们熟知的回车键，我们会发现这时候就可以更改文件的名字了

4.
删除文件 command+delete

3.一般默认用户名下的library资源库文件夹是隐藏的，所以看不到AndroidSdk文件夹，需要在finder设置里，自己打开显示“资源库”

2.mac的HDMI接口一般只能连接DVI和HDMI， 而无法转接VGA接口，买转换线时要注意

1.关于win和mac的快捷键区别
win==Command
alt=Option
mission control快捷键ctrl+箭头⬆️    ctrl＋尖头⬇️ 取消
虚拟机 BootCamp  vmware Fusion  VisualBox
在finder－前往， 输入 /private/etc/  进入修改hosts文件
截取任意窗口：快捷键（Shift＋Command＋4）,图片会自动保存在桌面。