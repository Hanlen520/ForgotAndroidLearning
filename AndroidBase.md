## Android基础
整理通用基础知识

## Base
- 父类定义过的变量，在子类可以直接使用 而不用声明

## TextView
xml:
- android:inputType="number"
- android:ems="1" 设置TextView为一列
- android:alpha="0.6" 设置透明度
- textView.append("\n" + msg.obj.toString());  追加消息到TextView中
java:
- tv.setError("报错信息");



## EditText
xml:
- android:ems="1" 设置EditText为一列
- android:background="@null" 消除底部横线
- android:inputType="textMultiLine" 多行显示文字
- EditText挡住ListView的问题，在Manifest中设置Activity属性 android:windowSoftInputMode="stateAlwaysHidden|adjustPan"
java:
1. 显示小键盘 ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE)).showSoftInput(editPrivateMsg, 0);
2. 隐藏小键盘 ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE)).
   hideSoftInputFromWindow(editPrivateMsg.getWindowToken(), 0);

## Button
xml:
java:

## String
- %d（表示整数），%f（表示浮点数）， %s （表示字符串）
  例如 <string name="old">我今年%d岁了</string>
  String sAgeFormat = getResources().getString(R.string.old);
  String sFinalAge = String.format(sAgeFormat, 23);

## int
- 十进制转化为十六进制，结果为C8。 Integer.toHexString(200);

- 十六进制转化为十进制，结果140。 Integer.parseInt("8C",16);




## JavvaDoc注释
- {@link #getBoxStateById(String)}  同类下的方法
  不同类下的 {@link OtherClass#getBoxStateById(String)}


## 四大组件
- Android中的四大组件千万不要通过new的方式创建出来。 会内存泄漏


## fragment
- activity获取fragment中的控件： getFragmentManager().findFragmentById(id).getView().findViewById(id)
- 获取v7包中的fragment： getSupportFragmentManager().findFragmentById(id).getView().findViewById(id)
- fragment获取fragment中的控件： getView().findViewById(id)
  fragment中获取activity中的方法


## 自定义View
- Android UI中的View如何刷新。
  在主线程中  拿到view调用Invalide()方法,查看画画板里面更新imageview的方法
  在子线程里面可以通过postInvalide()方法;
  View view;
  view.invalidate();//主线程
  view.postInvalidate();//子线程


## 布局预览
- 在activity布局中预览fragment效果
  tools:layout="@layout/fragment_main"
  在fragment布局中预览效果，顶部
  tools:showIn="@layout/activity_main"

## 调试
1. 遇到问题先看日志 ，先看日志，先看日志啊
   录音功能需要权限，然后6.0需要动态获取权限

## 集合
-
	* Collection：代表一组对象，每一个对象都是它的子元素。
	* Set：不包含重复元素的Collection。
	* List：有顺序的collection，并且可以包含重复元素。
	* Map：可以把键(key)映射到值(value)的对象，键不能重复。
	* 数组(Array)和列表(ArrayList)
	* HashSet和TreeSet有什么区别？
	* HashSet是由一个hash表来实现的，因此，它的元素是无序的。add()，remove()，contains()方法的时间复杂度是O(1)。
	* 另一方面，TreeSet是由一个树形的结构来实现的，它里面的元素是有序的。因此，add()，remove()，contains()方法的时间复杂度是O(logn)。




## 设计模式
- [架构设计](https://github.com/googlesamples/android-architecture)
- MVP：在Android项目中，业务逻辑，数据处理等担任了Model（模型）角色，XML界面显示等担任了View（视图）角色，Activity担任了Contronller（控制器）角色。contronller（控制器）是一个中间桥梁的作用，通过接口通信来协同 View（视图）和Model（模型）工作，起到了两者之间的通信作用。


## 多线程
- Handler中：myReturnHandler.removeCallbacksAndMessages(null)。null表示将所有的Callbacks和Messages全部清除掉，如
- 关于Handler为何不采用Binder， 先总结说一句，Handler完全可以通过BInder，但是杀鸡焉用牛刀。
  Binder用于进程间通信，而Handler消息机制用于同进程的线程间通信

  
## 异常
- 异常的分类：
  Java.lang.Throwable
  1.Error错误：JVM内部的严重问题。无法恢复。程序人员不用处理。
  2.Exception异常：普通的问题。通过合理的处理，程序还可以回到正常执行流程。要求编程人员要进行处理。
  3.RuntimeException:也叫非受检异常(unchecked exception).这类异常是编程人员的逻辑问题。应该承担责任。Java编译器不进行强制要求处理。 也就是说，这类异常再程序中，可以进行处理，也可以不处理。
  4.受检异常(checked exception).这类异常是由一些外部的偶然因素所引起的。Java编译器强制要求处理。也就是说，程序必须进行对这类异常进行处理
常见异常：
1)非受检的：NullPointerException,ClassCastException,ArrayIndexsOutOfBoundsException,ArithmeticException(算术异常，除0溢出)
2)受检：Exception,FileNotFoundException,IOException,SQLException.




## 性能优化
- Java 内存泄露的根本原因就是 保存了不可能再被访问的变量类型的引用



## NDK开发
- 谈谈对Android NDK的理解。
  native develop kit   只是一个交叉编译的工具  .so
      1.什么时候用ndk,  实时性要求高,游戏,图形渲染,  opencv (人脸识别) , ffmpeg , rmvb  mp5 avi 高清解码. ffmpeg, opencore.


## Windows
- 切换输入法 win+空格


## Android Studio使用
- AS快捷键：
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


## Android系统源码

android.googlesource.com：Google官方源码，国内无法直接访问，需要翻墙，对于一个程序员来说具备翻墙的能力是非常有必要的。Android源码中包含的库非常之多，下面列举我在看Android源码过程中涉及较多，也是比较常看的一些库：

android/platform/packages/apps：Android自带的app，比如Email,Camera, Music等，对于应用开发工程师主要关注的目录；
android/platform/frameworks/base： Java framework，这是framework工程师看得最多的目录；
android/platform/frameworks/native：Native framework;
android/platform/art：Art虚拟机;
android/kernel/common：Android内核，这是驱动工程师最关注的模块；
android/platform/system/core ：核心系统;
android/platform/libcore：平台的lib库;


## 其他

- 图片、文字在网络传送中是转换成一定的二进制代码进行传送的。（图片、文字等--→传送端（发出）--→图片数据转换器（把图片和文字转换成0、1代码）--→终端（接收）--→图片数据转换器（将0、1代码转换成图片和文字）--→图片、文字。）
- 传输过程中是二进制的，但物理上表示的方式不同。光纤用光信号的亮与不亮来表示1和0，电信号用高低电平来表示二进制！

- **Applet和普通的Java应用程序有什么区别？**
  applet是运行在启用了java的浏览器中，Java应用程序是可以在浏览器之外运行的独立的Java程序。但是，它们都需要有Java虚拟机。
  进一步来说，Java应用程序需要一个有特定方法签名的main函数来开始执行。Java applet不需要这样的函数来开始执行。
  最后，Java applet一般会使用很严格的安全策略，Java应用一般使用比较宽松的安全策略。
- **数据库连接池是什么意思？**
  像打开关闭数据库连接这种和数据库的交互可能是很费时的，尤其是当客户端数量增加的时候，会消耗大量的资源，成本是非常高的。可以在应用服务器启动的时候建立很多个数据库连接并维护在一个池中。连接请求由池中的连接提供。在连接使用完毕以后，把连接归还到池中，以用于满足将来更多的请求。
- **什么是cookie？session和cookie有什么区别？**
  cookie是Web服务器发送给浏览器的一块信息。浏览器会在本地文件中给每一个Web服务器存储cookie。以后浏览器在给特定的Web服务器发请求的时候，同时会发送所有为该服务器存储的cookie。下面列出了session和cookie的区别：

  	* 无论客户端浏览器做怎么样的设置，session都应该能正常工作。客户端可以选择禁用cookie，但是，session仍然是能够工作的，因为客户端无法禁用服务端的session。
  	* 在存储的数据量方面session和cookies也是不一样的。session能够存储任意的Java对象，cookie只能存储String类型的对象。





## 简称
- SNS，全称Social Networking Services，即社会性网络服务
- HAL（Hardware Abstract Layer硬件抽象层）


输入法推荐bing拼音输入法,能跟随AndroidStudio的光标移动,再切换到暗黑边界主题。 会导致Alt+Tab切换标签失败，不要用
![](./picutres/bing.png)