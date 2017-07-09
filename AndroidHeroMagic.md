## 《Android群英传 神兵利器》

*世上没有什么事情是不能通过工具来解决的，如果有，那么就创造一个工具去解决*

## 第一章 程序员的小窝--搭建高效的开发环境
- Mac与Android内核都是Unix\Linux架构，不需要安装驱动就可以直接连接
- Mac设置Fn键用作标准功能键
- 基本开发工具Homebrew和Homebrew Cask
- iTerm2终端工具和oh-my-zsh Shell工具
- 用Homebrew安装Git，Java，AndroidStudio等
- 用hexo来搭建个人博客
- 在gitbook上用Markdown写文章

## 第二章 版本控制神器--Git
- SVN是集中式版本管理，若中央服务器出故障或者网络异常，就麻烦了
- Git是分布式版本管理，可以获取到中央服务器的完整信息，不需要频繁通信，只在提交时才要
- Git的基本使用

## 第三章 Android Studio 技巧
- Project和Structure面板
- 在设置的Android Logcat中设置打印日志颜色
- View-Enter Full Screen 全屏模式 减少外部干扰
- 断点调试，异常断点. 在断点中添加Java Exception断点，发生异常时就会定位
- 多语言处理，点击strings.xml右上角的Open editor
- 输入/** 再按Enter 快速生成注释代码
- 自定义Live Templates, 如author声明, 也可以在File and Code Templates设置模版
![debug](./pictures/Debug1.png)
- Theme Editor 主题右上角点击Open Editor进行编辑

AS快捷键：
Ctrl+H  查看该类的继承关系
Ctrl+O  查看可重写的方法
ctrl+P 查看方法的参数列表
ctrl+F7 查看方法引用的地方
Ctrl + -  方法折叠 展开
ctrl+J 代码模版
ctrl+E 查看最近浏览
Ctrl+Shift+E 查看最近修改
ctrl+shift+A 弹出操作搜索
ctrl+alt+T 弹出Surround With功能，包括一些if try catch语句
ctrl+alt+H 查看方法调用栈
F11 添加书签

## 第四章 与Gradle的爱恨情仇
- Gradle基于DSL语言，如何学习Gradle，在终端输入tree 查看项目结构
- 项目全局的build.gradle， Module build.gradle , apply plugin领域，android领域，dependencies领域
- 核心部分 Gradle Task
- 常用Task命令:assemble task , Check, Build, Clean

## 第五章 深藏功与名的开发者工具