## Android基础
整理通用技巧

## TextView
xml:
- android:inputType="number"
- android:ems="1" 设置TextView为一列
- android:alpha="0.6" 设置透明度
java:
- tv.setError("报错信息");



## EditText
xml:
- android:ems="1" 设置EditText为一列
- android:background="@null" 消除底部横线
- android:inputType="textMultiLine" 多行显示文字
java:
1. 显示小键盘 ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE)).showSoftInput(editPrivateMsg, 0);
2. 隐藏小键盘 ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE)).
   hideSoftInputFromWindow(editPrivateMsg.getWindowToken(), 0);

## Button
xml:
java:



## 其他
- %d（表示整数），%f（表示浮点数）， %s （表示字符串）
例如 <string name="old">我今年%1$d岁了</string>
String sAgeFormat = getResources().getString(R.string.old);
String sFinalAge = String.format(sAgeFormat, 23);
-


## 四大组件
- Android中的四大组件千万不要通过new的方式创建出来。 会内存泄漏

## 调试
1. 遇到问题先看日志 ，先看日志，先看日志啊
   录音功能需要权限，然后6.0需要动态获取权限


## 设计模式
- [架构设计](https://github.com/googlesamples/android-architecture)
- MVP：在Android项目中，业务逻辑，数据处理等担任了Model（模型）角色，XML界面显示等担任了View（视图）角色，Activity担任了Contronller（控制器）角色。contronller（控制器）是一个中间桥梁的作用，通过接口通信来协同 View（视图）和Model（模型）工作，起到了两者之间的通信作用。


## 多线程
- null 表示将所有的Callbacks和Messages全部清除掉，如  myReturnHandler.removeCallbacksAndMessages(null);



## Windows
- 切换输入法 win+空格

关于Handler为何不采用Binder， 先总结说一句，Handler完全可以通过BInder，但是杀鸡焉用牛刀。
Binder用于进程间通信，而Handler消息机制用于同进程的线程间通信

Android系统源码

android.googlesource.com：Google官方源码，国内无法直接访问，需要翻墙，对于一个程序员来说具备翻墙的能力是非常有必要的。Android源码中包含的库非常之多，下面列举我在看Android源码过程中涉及较多，也是比较常看的一些库：

android/platform/packages/apps：Android自带的app，比如Email,Camera, Music等，对于应用开发工程师主要关注的目录；
android/platform/frameworks/base： Java framework，这是framework工程师看得最多的目录；
android/platform/frameworks/native：Native framework;
android/platform/art：Art虚拟机;
android/kernel/common：Android内核，这是驱动工程师最关注的模块；
android/platform/system/core ：核心系统;
android/platform/libcore：平台的lib库;



输入法推荐bing拼音输入法,能跟随AndroidStudio的光标移动,再切换到暗黑边界主题。 会导致Alt+Tab切换标签失败，不要用
![](./picutres/bing.png)