# 《Android Studio使用集锦》

## 使用优化
- 优化IDE使用内存，在Help - Edit Custom VM Option 选项，打开studio(64?).vmoptions文件,设置项目
-Xms2g
-Xmx6g
-XX:MaxPermSize=6g
-XX:ReservedCodeCacheSize=2g
-XX:+UseCompressedOops

- 如何确定修改生效了？
在 Settings -> Appearance 页里，打开 Show memory indicator 选项，然后主界面右下角会显示 Heap 总大小以及使用状况。这样操作一下，就可以确认 Heap Size 修改是否生效。

- 出现string等中文乱码，设置语言为微软雅黑。 编码全部改为UTF-8
- 再Settings-Apperance-Override default fonts by 设置为微软雅黑
- 若AndroidStudio上的logcat时间不对，其实这是你虚拟机上的时间，去改虚拟机上的就行了
- IDE工具字体 推荐sourse code pro ， 棱角分明，0和O,1和I l都能分清

- 设置自动导包，Files ->Settings-> IDE Settings-> Editor -> Auto Import ， 选择: Add unambiguous imports on the fly, 即可

- 安装更好看的代码样式，主题下载地址 http://color-themes.com/?view=index

- 在Editor-General-Code Completion
取消代码补全的大小写敏感，在这改为None，不再需要刻意注意大小写

- 分析内存泄漏，点击上方的“Profile app” , 然后进入内存分析，点击"Dump Java Heap" (第一次要设置run configcation, Profiling中勾选即可)

- 设置本地Gradle，减少构建时间
In Android Studio go to File -> Settings -> Build, Execution, Deployment -> Build Tools -> Gradle

Check the 'Offline work' under 'Global Gradle settings'

It will reduce 90% gradle build time.

## 快捷键：
- Ctrl+H  查看该类的继承关系
- Ctrl+O  查看可重写的方法
- ctrl+P 查看方法的参数列表
- ctrl+F7 查看方法引用的地方
- Ctrl + -  方法折叠 展开
- ctrl+J 代码模版
- ctrl+E 查看最近浏览
- Ctrl+Shift+E 查看最近修改
- ctrl+shift+A 弹出操作搜索
- ctrl+alt+T 弹出Surround With功能，包括一些if try catch语句
-  ctrl+alt+H 查看方法调用栈
- F11 添加书签
- ctrl+alt+home,快速打开对应的Activity或layout文件
- ctrl + .   , 快速切换资源id和真实信息，如 R.string.id , 按下ctrl+.  可以快速查看字符串的内容
- Command+Shift+U 切换大小写

## 必装插件
- Android Parcelable Code Generator  生成Parcelable序列化的方法
- ButterKnife Zelezny   简化注入  省略findviewbyid
- ButterKnife插件突然没有注入的选项了，在Build-clean project一下就好了，缓存问题？ 还不行的话就 File-Invalidate Caches and Restart
- CheckStyle 检查代码规范性，自己导入规范文档
- CodeGlance 右边方便预览代码
- DataBase Navigator 查看SQLite数据库，需要导出文件再查看
- FindBugs 找空指针等bug.是一个静态分析工具，它检查类或者 JAR 文件，将字节码与一组缺陷模式进行对比以发现可能的问题。
- GsonFormat 方便用json字符串 一键生成bean类
- InnerBuilder插件，快速用Builder模式创建对象，更加直观
- MarkDown Navigator  写作 github方便，还能配合wakatime统计事件
- Material UI 界面更好看
- WakaTime  统计你使用AS的时间


## 调试
- 尽量减少debug，少用debug，优秀的程序员总是花80%的时间来思考如何解决问题，20%的时间来动手完成代码，而糟糕的程序员总是用20%的时间去写代码，80%的时间去调试代码，动手之前尽量想好如何去做，并且已经为你自己的思路做了充分的实验。
-  遇到问题先看日志 ，先看日志，先看日志啊
-   录音功能需要权限，然后6.0需要动态获取权限
- Can’t bind to local 8601 for debugger
  原因是androidstudio和eclipse一起开了，被eclipse占用，或者是其他ide工具占用了（一般关闭eclipse就好了）
  netstat -ano 查看端口情况，然后ctrl+f搜索8601，查看该端口的PID，然后任务管理器中查看该PID对应的程序。需要在任务管理器中设置 才能查看PID
- Android hierarchyviewer不能使用的解决方法，试下在任务管理器中，结束adb.exe进程，然后新建adb.exe进程即可
- adb shell //进入adb控制台
  adb devices //查看连接设备
  adb install softwareName.apk 安装当前目录下的apk到当前连接设备
- step into/step out/step over的区别
  step into就是单步执行，遇到子函数就进入并且继续单步执行；
  step over是在单步执行时，在函数内遇到子函数时不会进入子函数内单步执行，而是将子函数整个执行完再停止，也就是把子函数整个作为一步。
  step out就是当单步执行到子函数内时，用step out就可以执行完子函数余下部分，并返回到上一层函数。
- 调试开始后，在红箭头指向的区域可以给指定的变量赋值（鼠标左键选择变量，右键弹出菜单选择setValue…）。这个功能可以更加快速的检测你的条件语句和循环语句。
- Android Monitor有截图 和录视频功能，查看CPU 内存等使用情况，和启动layout inspector
- Android手机开发者选项 的实用功能： 不锁定屏幕，跳过锁屏界面，允许模拟位置（代码修改gps定位），显示触摸操作，指针位置，显示布局边界，显示surface更新，动画缩放（可以更好的查看动画效果，进行参考），调试GPU过度绘制
- adb connect 192.168.x.x 直接连上支持局域网调试的设备（adb tcpip 5555  连接上wifi调试机器，不一定要用）
- 有时候调试奔溃时看到不logcat日志，可以换一台手机或模拟器试一下，IDE的原因？


## 单元测试
- 添加新测试 Ctrl+Shift+T


## 其他
- 使用某一个库，但移除它里面的其他依赖,再更新新的库
```
  compile('com.squareup.retrofit2:retrofit:2.1.0') {
  exclude module: 'com.squareup.okhttp3:okhttp:3.4.1'
  }
  compile 'com.squareup.okhttp3:okhttp:3.4.2'
```
- 在Androidstudio 直接从File->New -> Import Sample 总是报错：
  在System Steeints-HTTP Proxy代理这设置一下Auto-detect proxy settings, 自动检测代理，然后在导入Sample就能打开了
  
- 在3.0版本中，compile 指令被标注为过时方法，而新增了两个依赖指令，一个是implement 和api，这两个都可以进行依赖添加，但是有什么区别呢？api 指令
  完全等同于compile指令，没区别，你将所有的compile改成api，完全没有错。implement指令
  这个指令的特点就是，对于使用了该命令编译的依赖，对该项目有依赖的项目将无法访问到使用该命令编译的依赖中的任何程序，也就是将该依赖隐藏在内部，而不对外部公开。

## 配置注释模版
1。在Live Templates中添加模版，并配置快捷单词auth
```
/**
 * 功能:
 * 描述:
 * @author Lin Zongfu
 * @date   $date$
 * @email  jouney90@163.com
 */
 ```
 2。在File and Code Templates中配置File Header
 ```
 /**
  * 功能:
  * 描述:
  * @author Lin Zongfu
  * @date   ${DATE}
  * @email  jouney90@163.com
  */
 ```