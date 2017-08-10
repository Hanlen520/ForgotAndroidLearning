# 《Android Studio使用》

## 使用优化
- 优化IDE使用内存，在Help - Edit Custom VM Option 选项，打开studio(64?).vmoptions文件,设置项目
-Xms518m
-Xmx4096m
-XX:MaxPermSize=2048m
-XX:ReservedCodeCacheSize=1024m
<br>如何确定修改生效了？
在 Settings -> Appearance 页里，打开 Show memory indicator 选项，然后主界面右下角会显示 Heap 总大小以及使用状况。这样操作一下，就可以确认 Heap Size 修改是否生效。

- 出现string等中文乱码，设置语言为微软雅黑。 编码全部改为UTF-8
<br>再Settings-Apperance-Override default fonts by 设置为微软雅黑
- 若AndroidStudio上的logcat时间不对，其实这是你虚拟机上的时间，去改虚拟机上的就行了
- IDE工具字体 推荐sourse code pro ， 棱角分明，0和O,1和I l都能分清

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


## 必装插件
- ButterKnife Zelezny   简化注入  省略findviewbyid
- WakaTime  统计你使用AS的时间
- MarkDown Navigator  写作 github方便，还能配合wakatime统计事件
- Android Parcelable Code Generator  生成序列化的Bean
- CheckStyle 检查代码规范性，自己导入规范文档
- FindBugs 找空指针等bug.是一个静态分析工具，它检查类或者 JAR 文件，将字节码与一组缺陷模式进行对比以发现可能的问题。
- CodeGlance 右边方便预览代码
- DataBase Navigator 查看SQLite数据库，需要导出文件再查看
- GsonFormat 方便用json字符串 一键生成bean类
- Material UI 界面更好看
- ADB Wifi Connect 无线调试APP

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

## 单元测试
- 添加新测试 Ctrl+Shift+T
