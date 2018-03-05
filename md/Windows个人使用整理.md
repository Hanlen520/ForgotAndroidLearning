# 整理日常使用 Windows 的技巧

## Do
- GTD Getting Things Done 
  翻译过来就是“把事情做完”，GTD的核心理念概括就是必须记录下来要做的事，然后整理安排并使自己一一去执行。 
  GTD的五个核心原则是：收集、整理、组织、回顾、执行。 
  GTD的核心理念在于清空大脑，然后一步步按照设定的路线去努力执行。
- 你觉得这个世界上不可能的事情，是因为你没有试着去做。


## Windows
- Chrome插件工具  JsonFormatter
- 接口调试工具 Postman
- 清除txt等文件的默认打开应用：
  在设置-应用-具体应用（如pdf阅读器，html查看器），清除默认行为即可
- 切换输入法 win+空格
- 安装Office时默认安装32位的，最好安装时自己在文件夹内选择64位安装，后面的project等也是手动选64位， 否则Office套件不能同时安装32位和64位的软件
- 遇到win10磁铁挪位置时突然消失的情况，重启explorer.exe就好了 
  重启explorer步骤如下：<br>
  打开任务管理器，在进程里找到explorer.exe，结束进程。
  然后单击左上角文件，新建任务运行，敲入explorer.exe，确定即可。
  
- 遇到无线网卡等驱动突然出错时，试下在设备管理器中删除该硬件，然后点击顶栏的扫描硬件变动情况，就会重新安装了，一般能修复。 实在不行用驱动精灵等重装驱动。

- 双显示器换位置 
  电脑桌面空白处点击右键，选择分辨率，识别一下，比如你上面这张图是左2右1，你可以用鼠标点住左（2）往右边啦！右（1）就会跑到前面去了，点击应用就可以了 
  （即1 2可以直接鼠标拖动来改变前后顺序)
  
- Axure让局域网同事方便看自己原型，只需先生成html，再设置原型文件夹共享，然后查下自己ip，发工程链接就行了 （别人浏览器须安装Axure插件，且看不到音视频文件） 
  如 
  file://192.168.1.35/AxureFiles/sgdTablet1/start.html#p=start_1
  
- 远程局域网电脑的方法<br>
  先在需要远程的电脑上打开 远程功能
  在本人电脑的运行输入mstsc 输入需远程电脑的ip 用户名（一般是administrator) 密码(开机密码）
  
  
- 可以去搜一下DNS解析，了解相关知识 
  简单来说，当你访问一个网站时，网络上是只能识别IP地址的（网络地址），为了记忆，创造了域名（名字），你记住名字，问地址薄它在哪里，地址薄告诉你地址，你就能访问了。自家的地址薄就是hosts文件，如果自家没有，就去公众的地址薄DNS服务器问。由于地址需要更新，所以一般人不会用自家地址薄，而是信任公众的 
  如果有人把google在DNS里的地址薄删了，你就会由于获得不到目标地址而访问不了，这个时候你可以修改本地hosts，那么当你访问的时候，你不会问公众的被阉过的DNS服务器，而是先问自家的地址薄hosts，就可以访问了，前提是你获得的hosts关系是正确的。当然，有的时候直接访问IP也是可以的， 
  但是如果有人把去到目标IP的路由也给干掉了，那么你就没有办法了，只有通过VPN
  
  hosts的对应关系还是很明了的，只添加你认识的需要的就行了 
  风险是你拿到的hosts关系可能是假的，如果你完全不看hosts内容，盲目添加了一个把http://qq.com指向私人的地址，那你有可能会被钓鱼 
  假设是真的，因为域名解析会变，所以如果你忘了更新，那么未来有几率会出问题，因为你本职不负责维护它 
  只逐行添加自己认识的信任的，其他就没什么风险，跟病毒没什么关系
  
  
- Git可以用来管理任何文档文件

- 如何按自己想要的顺序拷贝音乐等到U盘
  
  首先选择最后一个需要播放或者存储的音乐
  然后找到第一个需要播放或者存储的音乐，找到后，先按下shift键，然后选择第一个（会出现全选的状态）
  然后复制粘贴到u盘就好了

- 浏览器中，ctrl+d 收藏为书签 ， ctrl+shift+t，恢复最近关闭的页面，ctrl+w，关闭当前页面
- 怎么设置IP让电脑只能上内网不能上外网 
  设置IP和子网掩码不设网关就可以了 
- 小布尔乔亚、克莱因瓶、皮亚诺曲线、莫比乌斯环、 康托尔集、狄利克雷函数、莱洛三角形

- office套件可以内联使用MathType功能，即便MathType 没注册，也能使用精简功能
- 禁用win10自动更新，在系统服务下的windows update,禁用即可 
  
-  关于office work老弹出宏错误<br>
解决方法： 
点击左上角文件——” 选项”——”加载项”——”管理【com加载项】”，点击”转到”——把几个COM加载项勾勾都取消掉——确定，即可。Win7中注意要以管理员身份进行

- CPU要读取一个数据时，首先从Cache中查找，如果找到就立即读取并送给CPU处理；如果没有找到，就用相对慢的速度从内存中读取并送给CPU处理，同时把这个数据所在的数据块调入Cache中，可以使得以后对整块数据的读取都从Cache中进行，不必再调用内存。 
  正是这样的读取机制使CPU读取Cache的命中率非常高（大多数CPU可达90%左右），也就是说CPU下一次要读取的数据90%都在Cache中，只有大约10%需要从内存读取。这大大节省了CPU直接读取内存的时间，也使CPU读取数据时基本无需等待。总的来说，CPU读取数据的顺序是先Cache后内存.

- 有些ubuntu残留的错误文件，在win系统无法删除的，甚至会影响到磁盘的合并，此时除了格式化硬盘，还有别的办法，用系统自带的磁盘修复命令 
  解决方法： 
  在 cmd 命令行窗口中输入如下代码： 
  chkdsk /f /x c:
  
  PS: 其中 “c:” 为需要进行操作的盘符，根据实际盘符修改。
- 默认情况下xmind输入的文字都是水平，且只能一行，如果要多行显示，在编辑文字的时候，请使用CTRL+Enter而不要直接回车！

## win+R 运行命令

-  mstsc： 连接远程win服务器 
-  register： 注册表 
-  msconfig： 打开系统配置，设置启动等配置 
-  dxdiag： 打开DirectX诊断工具 
-  winver： 查看操作系统版本 
-  explorer：打开资源管理器 
-  cmd： 打开命令控制台

## cmd命令

-  ipconfig /all 查看网络ip 
-  ipconfig /flushdns 清理dns缓存 
-  ping www.github.com 查看网络传输数据是否成功 
-  netstat -ano 查看端口占用情况
  
##  浏览器主页被hao123劫持的解决办法
主页被劫持的情况经常出现，有的是装了流氓软件被改主页，有的是用windows激活软件等被改主页，收集了几个解决办法：

1、检查chrome和IE等图标，右键属性-快捷方式- 目标 如果是这样的“C:\Program Files (x86)\Google\Chrome\Application\chrome.exe” www.hao123.com 把后面的删除就可以了

2、看下目录下的chrome是否启动方式后缀名加了hao123 Start Menu下的 C:\ProgramData\Microsoft\Windows\Start Menu\Programs

3、任务栏下的图标，有一次发现就是任务栏下的被改了 ，目录如下 
C:\Users\你的电脑名\AppData\Roaming\Microsoft\Internet Explorer\Quick Launch\User Pinned\TaskBar 
右键查看属性，若目标后面有hao123删了就行了

4、运行msconfig，找到系统自启动项，禁用陌生的自启动项。都陌生的，请禁用全部自启动项，如果解决了再一次解禁一部分自启动项来定位有问题的自启动项。

5、运行taskschd.msc打开任务计划程序，定位问题方法同上。


## 安装Ubuntu的方法
制作镜像U盘

不推荐用网上的U盘PE装系统，有一定几率安装失败。 
推荐工具ImageWriter 
下载地址 
http://pan.baidu.com/s/1mhKngwS 
制作U盘安装系统方法： 
1、要先将系统的ISO文件的后缀名改为raw 
2、直接运行imagewriter.exe ，选择后缀名为raw的系统的安装文件。 
3、选择你的U盘的盘号，点击开始即可，等待导入成功 
4、这时候跟普通U盘装windows系统一样，bios改成U盘启动就能简单安装了
  
## 个人常用软件

***部分软件没有带下载链接，发挥你们的动手能力吧***
日常办公
====


Microsoft Office

微软出品的文档处理软件，有win和mac版  


----------


[LibreOffice][1]         

开源文档处理软件，3种系统都有


----------


PDFshrink           

PDF文档压缩软件，有几种压缩规格选择


----------


[PDFCompressor][2]

PDF压缩软件，能压到1/5


----------


PDFBinder       

 PDF文档合并工具


----------


FreePDFSplit    
PDF文档切割工具


----------


软件开发
====

[Andriod Studio][3]
google旗下的android IDE，强烈推荐（国内可在此下载http://www.android-studio.org/）


----------


[Eclipse][4]
强大的android IDE


----------


[IntelliJ IDEA][5]
jetbrains旗下，Android Studio的原型，也是强大的IDE


----------


[Visual Studio][6]
微软旗下的C# C++等IDE，桌面开发必备


----------


[Xcode][7]
ios软件开发IDE


----------


[JetBrains PyCharm][8]
jetbrains旗下的python开发 IDE，python开发必备


----------


[JetBrains PhpStorm][9]
jetbrains旗下的php开发 IDE，php开发必备


----------


[JetBrains WebStorm][10]
jetbrains旗下的前端开发 IDE，前端开发必备


----------


[HBuilder][11]
国内的前端开发IDE，实时预览很方便，推荐


----------


Dreamweaver
Abode下的前端开发IDE，曾经的网页三剑客之一


----------


[XAMPP][12]
集合了5个布置网站的工具，自己布置网站 用这一个软件就搞定了


----------


IIS (Internet Information Services)
Windows自带的网站布置工具，win系统用这个布置网站也很方便


----------


Beyond Compare
文档对比软件，轻松看出两文档的差异所在


----------


[MySql][13]
免费的数据库软件


----------


[Navicat][14]
强大的数据库管理和设计工具，让你更直观的看到与操作数据库


----------


[SQLite][15]
Android自带的小型数据库，android开发常用到


----------


[SQLite Expert Personal][16]
SQLite 数据库图形操作软件，让你更直观的看到与操作数据库


----------


MS SQL Server
微软出品的数据库软件


----------


[Zend Studio][17]
一款php开发IDE


----------


EasyEclipseForPHP
Eclipse下的PHP IDE


设计软件
====

PhotoShop
Abode下强大的图形处理软件


----------


Abode Flash
flash动画制作软件，曾经的网页三剑客之一


----------


3ds Max
3d图像处理软件，可制作3d动画，游戏等（不是任天堂的游戏机Max版）


----------


Autodesk Maya
被adobe收购的3d图像处理软件，曾经与3dsmax打的不可开交


----------


[XMind][18]
思维导图软件，是个发散思维，总结想法的好帮手


----------


[MindManager][19]
思维导图软件


----------


[Visio][20]
微软旗下的制图软件，画流程图很好用


----------


[Axure RP][21]
产品设计必备，画产品原型的软件


----------


Dorado
腾讯出品标注软件，能标注图片的距离像素，颜色值，设计交付给开发的图片，标注好这些是必须的





文本编辑器
=====
***闻名不如见面，都下载来试试就知道你喜欢哪个了***

[Notepad++][22]
中文的，容量小，打开快

[EditPlus][23]
与Notepad++相近

[Sublime Text][24]
据说团队只有一个人在开发，一个人... （不知现在如何）

[Atom][25]
github新秀

[Visual Studio Code][26]
看名字就知道，微软旗下的

[Brackets][27]
adobe旗下的开源编辑器,工程在github上

[emacs][28]
如果你讨厌中鼠标操作，如果你想提高效率，那么就用这个吧，据说大神都在用

[vim][29]
同上，有中文版

提高生产力的工具
==========

[印象笔记][30]
生活记录，高效协作，多平台同步

[有道云笔记][31]
同上，二选一即可

[Foxmail][32]
工作收发邮件就靠它了，微信之父张小龙的作品

[Project][33]
微软旗下的项目进度管理软件，比用excel要功能丰富多了

[Fiddler][34]
常用的http抓包工具

[Wireshark][35]
一个免费开源的网络数据包分析软件

[Caesium][36]
图片压缩软件，可自己选择压缩品质 大小.图片压缩网站 https://tinypng.com/



[GifCam][37]
gif动画录制软件，作为软件开发的，完成一个功能后，录制效果给别人看很正常吧，这个满足你
若是录制后的gif太大，没关系，压缩一下 http://www.iloveimg.com/zh_cn

[LICEcap][38]
同是gif动画录制软件，最近升级最新版win10后用不了了，暂时无解

[Fraps][39]
电脑屏幕录制软件，许多游戏视频或教程都是用这个录制的

[TeamViewer][40]
强大的远程协作应用，多平台，四大桌面系统与四大手机系统之间都能远程了


其他个人收藏
======

hosts 
各引擎搜索hosts 简单暴力的科学上网

[谷歌服务框架][41]
android手机root，刷第三方recovery之后，再刷如对应系统版本的谷歌服务框架，然后就能正常使用google play等谷歌服务了

[Matlab][42]
数学建模软件

[SPSS][43]
数理统计软件

[Unity3D][44]
一款3D游戏开发引擎

[Udk][45]
虚幻4开发引擎


  [1]: https://zh-cn.libreoffice.org/
  [2]: http://www.pdfcompressor.org/
  [3]: https://developer.android.com/studio/index.html
  [4]: https://eclipse.org/downloads/
  [5]: https://www.jetbrains.com/idea/
  [6]: https://www.visualstudio.com/
  [7]: https://developer.apple.com/xcode/
  [8]: https://www.jetbrains.com/pycharm/
  [9]: https://www.jetbrains.com/phpstorm/
  [10]: https://www.jetbrains.com/webstorm/
  [11]: http://www.dcloud.io/
  [12]: http://www.xampps.com/
  [13]: https://www.mysql.com/
  [14]: https://www.navicat.com.cn/
  [15]: https://sqlite.org/
  [16]: http://www.sqliteexpert.com/
  [17]: http://www.zend.com/en/products/studio
  [18]: http://www.xmindchina.net/
  [19]: https://www.mindjet.com/mindmanager/
  [20]: https://products.office.com/zh-cn/visio
  [21]: http://www.axure.com/
  [22]: https://notepad-plus-plus.org/
  [23]: https://www.editplus.com/
  [24]: https://www.sublimetext.com/
  [25]: https://atom.io/
  [26]: https://code.visualstudio.com/
  [27]: http://brackets.io/
  [28]: https://www.gnu.org/software/emacs/
  [29]: http://www.vim.org/
  [30]: https://www.yinxiang.com/
  [31]: http://note.youdao.com/
  [32]: http://www.foxmail.com/
  [33]: https://products.office.com/zh-cn/Project/
  [34]: http://www.telerik.com/fiddler
  [35]: https://www.wireshark.org/
  [36]: https://saerasoft.com/caesium/
  [37]: http://blog.bahraniapps.com/gifcam/
  [38]: http://www.cockos.com/licecap/
  [39]: http://www.fraps.com/
  [40]: https://www.teamviewer.com/zhCN/
  [41]: http://www.appkg.com/gapps
  [42]: http://cn.mathworks.com/
  [43]: http://www.ibm.com/analytics/us/en/technology/spss/
  [44]: https://unity3d.com/cn
  [45]: https://www.unrealengine.com/zh-CN/what-is-unreal-engine-4
