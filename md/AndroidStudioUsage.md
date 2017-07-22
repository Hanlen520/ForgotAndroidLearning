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
1. 遇到问题先看日志 ，先看日志，先看日志啊
   录音功能需要权限，然后6.0需要动态获取权限