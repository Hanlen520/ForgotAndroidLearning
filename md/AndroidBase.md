## Android基础
整理通用基础知识

## Base
- 父类定义过的变量，在子类可以直接使用 而不用声明
- String string; 在栈和堆中都没有分配空间
  String string=null; 在栈中分配了空间，在堆中没有分配空间
  String string="";在栈和堆中都分配了空间
- String a="abc";
    String b=new String("abc");
    System.out.println(a==b);
    System.out.println(a.equals(b));
    答案是false true ，  ==比较的是两对象完全相等（值还有hashcode相等），而.equal比较的是值相等
- 像a.equals("Happy new year")这种判断的话如果a为null就会出现异常，但是改成"Happy new year".equals(a)这种写法的话，则即使a为null也不会有问题。所以在Java中进行比较就最好把常量放在左边

- Math.ceil(x/y) 向上取商；Math.floor(x/y) 向下取商
- @Override是伪代码,表示重写(当然不写也可以)，不过写上有如下好处: 
  - 可以当注释用,方便阅读； 
  - 编译器可以给你验证@Override下面的方法名是否是你父类中所有的，如果没有则报错。例如，你如果没写@Override，而你下面的方法名又写错了，这时你的编译器是可以编译通过的，因为编译器以为这个方法是你的子类中自己增加的方法。
- android的xml文件的开头处一般会有 
  xmlns:android=”http://schemas.android.com/apk/res/android” 
  其中xmlns是xml name space的意思。 
  android:id中的android就是在这定义的。可以自己修改，如 
  xmlns:a=”http://schemas.android.com/apk/res/android” 
  然后你就可以放心大胆地写a:id=”@+id/ha”了。  
  
## AndroidManifest.xml
- application 标签内加上  android:supportsRtl="true"属性，然后TargetSDK写成17
  由于布局方向可以是从右到左的，所以在写xml布局的时候，为了防止出现布局混乱的现象，不要使用诸如layout_marginRight这种，而应该是layout_marginEnd这种
  
  这样做是为了兼容阿拉伯文，阿拉伯文是一种从右向左书写的文字, 所谓RTL(Right to Left)文字

- android:stateNotNeeded="true"  不保存state状态，即不保留屏幕临时数据


## TextView
xml:
- android:inputType="number"
- android:ems="1" 设置TextView为一列
- android:alpha="0.6" 设置透明度
- textView.append("\n" + msg.obj.toString());  追加消息到TextView中
- 取消默认大写字母android:textAllCaps="false";

java:
- tv.setError("报错信息");
- txtShow.setBackground("#000");


## EditText
xml:
- android:ems="1" 设置EditText为一列
- android:background="@null" 消除底部横线
- android:inputType="textMultiLine" 多行显示文字
- EditText挡住ListView的问题，在Manifest中设置Activity属性 android:windowSoftInputMode="stateAlwaysHidden|adjustPan"
- 直接在xml布局中限制输入字符串
  android:digits="qwertyuiopasdfghjklzxcvbnm1234567890"
- TextLayout中显示密码的按钮 app:passwordToggleEnabled="true"


java:
-  显示小键盘 ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE)).showSoftInput(editPrivateMsg, 0);
-  隐藏小键盘 ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE)).
   hideSoftInputFromWindow(editPrivateMsg.getWindowToken(), 0);
- 屏蔽EditText的焦点 etCode.setFocusable(false);
- 点击控件时，重新获取焦点，激活软键盘
- 监听输入edtInput.setKeyListener(DigitsKeyListener.getInstance("1234567890."));
  edtInput.setInputType(8194);

```
  etCode.setFocusable(true);
  etCode.setFocusableInTouchMode(true);
  etCode.requestFocus();
```



## Button
xml:
- 普通Button可以用以下风格实现Material
  style="@style/Widget.AppCompat.Button.Colored"
  Widget.AppCompat.Button.Borderless
  Widget.AppCompat.Button.Colored
  Widget.AppCompat.Button
- 设置Material风格的ImageButton， ImageView，TextView也能用，在某些背景下可能看不出下过，则换一个background，如?attr/selectableItemBackground
```
  <ImageButton
      style="@style/Widget.AppCompat.Button"
      android:layout_width="50dp"
      android:layout_height="wrap_content"
      android:src="@drawable/btn_back_normal"
      android:background="?attr/selectableItemBackgroundBorderless"/>
```

java:




## RadioButtn
- 关于RadioGroup实现多行选项，如两排四列，在选择第一列时，把第二列清空选择即可
  mRg2.clearCheck();


## ScrollView
- 配合TextView来打印日志，自动滚到最底部
```
private void scrollToBottom() {
        scroll.post(new Runnable() {
            public void run() {
                scroll.smoothScrollTo(0, tvLog.getBottom());
            }
        });
    }
```


## ListView
- 长按获取listView的某项值
```
   listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
             @Override
             public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
  str=view.getItemAtPosition(position).toString();
                 TextView text=(TextView)view.findViewById(R.id.text2);
                 String strText=text.getText().toString();
                 Toast.makeText(CodeRecordActivity.this, strText, Toast.LENGTH_SHORT).show();
                 return false;
             }
         });
```

## ImageView
- android:tint="@color/sample_green"
  可以直接给ImageView图片src上色

## Toast
- 一般toast显示不出有3个原因： 
  1、在非UI线程中执行，建议使用handler显示提示 
  2、没有执行到，这是逻辑错误 
  3、可能是手机设置-应用通知管理没打开

## String
- %d（表示整数），%f（表示浮点数）， %s （表示字符串）
  例如 <string name="old">我今年%d岁了</string>
  String sAgeFormat = getResources().getString(R.string.old);
  String sFinalAge = String.format(sAgeFormat, 23);
- toString和 强转(String)的区别。toString是一个方法，任何一个对象都可以有自己的toString方法，而强转String是将一个对象转化为String类型，若本身不是String类型则可能奔溃
## int
- 十进制转化为十六进制，结果为C8。 Integer.toHexString(200);

- 十六进制转化为十进制，结果140。 Integer.parseInt("8C",16);

- res-values-integers.xml, 存放整型数据，strings存放字符串数据




## JavvaDoc注释
- {@link #getBoxStateById(String)}  同类下的方法
  不同类下的 {@link OtherClass#getBoxStateById(String)}


## 四大组件
- Android中的四大组件千万不要通过new的方式创建出来。 会内存泄漏
- 界面跳转和服务的启动都会用到Intent，现在介绍Intent Flag是关于Activity的跳转
  　　Intent intent = new Intent(this,xxx.class);
  　　//如果activity在task存在，拿到最顶端,不会启动新的Activity
  　　intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
  　　//如果activity在task存在，将Activity之上的所有Activity结束掉
  　　intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
  　　//默认的跳转类型,将Activity放到一个新的Task中
  　　intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
  　　//如果Activity已经运行到了顶部Task，再次跳转不会在运行这个Activity
  　　intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);


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

- RecyclerView预览item元素情况
  tools:listheader="@layout/demo_header"
  tools:listitem="@layout/demo_item"

- TextView等预览
tools:text="预览文字"
tools:visibility= "visible"

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

## 多媒体
- 摄像头权限要设置三个
```
    <uses-permission android:name ="android.permission.CAMERA"/>
    <uses-feature android:name="android.hardware.camera" />
    <uses-feature android:name="android.hardware.camera.autofocus" />
```


## 设计模式
- [架构设计](https://github.com/googlesamples/android-architecture)
- MVP：在Android项目中，业务逻辑，数据处理等担任了Model（模型）角色，XML界面显示等担任了View（视图）角色，Activity担任了Contronller（控制器）角色。contronller（控制器）是一个中间桥梁的作用，通过接口通信来协同 View（视图）和Model（模型）工作，起到了两者之间的通信作用。


## 多线程
- Handler中：myReturnHandler.removeCallbacksAndMessages(null)。null表示将所有的Callbacks和Messages全部清除掉，如
- 关于Handler为何不采用Binder， 先总结说一句，Handler完全可以通过BInder，但是杀鸡焉用牛刀。
  Binder用于进程间通信，而Handler消息机制用于同进程的线程间通信
- 延迟执行
```
  new Handler().postDelayed(new Runnable() {
      @Override
      public void run() {
          pbInit.setVisibility(View.GONE);
      }
  }, 500);
```

## 网络编程
- 当我们打开浏览器，在地址栏中输入URL，然后我们就看到了网页。 原理是怎样的呢？ 
  实际上我们输入URL后，我们的浏览器给Web服务器发送了一个Request, Web服务器接到Request后进行处理，生成相应的Response，然后发送给浏览器， 浏览器解析Response中的HTML,这样我们就看到了网页
  
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



## SQLite数据库
- 调试数据库
```
adb shell  
cd /data/data/tech.fuge.www.forgotfirstlinecode/databases/
sqlite3 myDatebase.db

SELECT DISTINCT 消除重复记录
select * from Book
```
创建数据表，更新数据表
增删改查

1. table 要操作的表名 
2. columns 要查询显示的列名
3. selection  指定where约束条件的列名+条件， 如 item>=
4. selectionArgs  约束条件的值,3+4. 合并为：where column="value"
5. GROUP BY column  指定列来进行分组，将该列一样名字的合并到一个
6. HAVING column="value" 进一步约束
7. ORDER BY column正序排列 从大到小,ORDER BY columnDESC 逆序排列，从小到大
8. LIMIT 6 显示前面多少个
数据库操作写法，一是用Android自带的工具类
二是用一般的数据库写法exc()

insert into Book(name,pages,price,author)  values("作者",103,600,"书名");







## NDK开发
- 谈谈对Android NDK的理解。
  native develop kit   只是一个交叉编译的工具  .so
      1.什么时候用ndk,  实时性要求高,游戏,图形渲染,  opencv (人脸识别) , ffmpeg , rmvb  mp5 avi 高清解码. ffmpeg, opencore.

## 性能优化
- Java 内存泄露的根本原因就是 保存了不可能再被访问的变量类型的引用
- 匿名内部类默认持有外部类的引用，有内存泄漏的风险;
- Application对象的生命周期是整个程序中最长的，它的生命周期就等于这个程序的生命周期。因为它是全局的单例的，所以在不同的Activity,Service中获得的对象都是同一个对象。所以可以通过Application来进行一些，如：数据传递、数据共享和数据缓存等操作。
- Java中的卫语句:把嵌套写的if else判断，改为串行的条件判断, return;
- 在BaseActivity中统一开启关闭DEBUG， 还有List<Activity> 管理所有Activity的finish()
- Android oom 1是加载对象过大， 2是相应资源过多，没有来不及释放。
- android new一个类后（如果被context或view等持有的话，会导致无法被GC回收），不用时要手动释放，不然有可能会导致内存泄漏



## 调试
- Can’t bind to local 8601 for debugger 
  原因是androidstudio和eclipse一起开了，被eclipse占用，或者是其他ide工具占用了（一般关闭eclipse就好了） 
  netstat -ano 查看端口情况，然后ctrl+f搜索8601，查看该端口的PID，然后任务管理器中查看该PID对应的程序。需要在任务管理器中设置 才能查看PID
- Android hierarchyviewer不能使用的解决方法，试下在任务管理器中，结束adb.exe进程，然后新建adb.exe进程即可


## Android系统源码

android.googlesource.com：Google官方源码，国内无法直接访问，需要翻墙，对于一个程序员来说具备翻墙的能力是非常有必要的。Android源码中包含的库非常之多，下面列举我在看Android源码过程中涉及较多，也是比较常看的一些库：

android/platform/packages/apps：Android自带的app，比如Email,Camera, Music等，对于应用开发工程师主要关注的目录；
android/platform/frameworks/base： Java framework，这是framework工程师看得最多的目录；
android/platform/frameworks/native：Native framework;
android/platform/art：Art虚拟机;
android/kernel/common：Android内核，这是驱动工程师最关注的模块；
android/platform/system/core ：核心系统;
android/platform/libcore：平台的lib库;




## 关于APK签名
- APK签名用处主要有两种 
  a. 使用特殊的key签名可以获取到一些不同的权限。 
  b. APK如果使用一个key签名，发布时另一个key签名的文件将无法安装或覆盖老的版本，这样可以防止你已安装的应用被恶意的第三方覆盖或替换掉
- 包名不同则相当于两个应用，若包名相同而签名不同则无法安装，若包名和签名都相同，则可以覆盖安装
- 包名一般选用自家域名的倒装
- 直接查看签名文件 keytool -list -keystore E:\Trinea\keystore\appsearch.keystore （不够全）
- .推荐：解压APK后 进入META-INF文件夹， cmd输入   keytool -printcert -file CERT.RSA   
- android Your keystore contains 2 entries  一个签名文件可以包含多个别名，不同别名签名后的MD5不同，可以覆盖安装？？（不能，别名不同也不算同一个key），但微信支付就会失败，所以要注意用同一个别名

## 简称
- SNS，全称Social Networking Services，即社会性网络服务
- HAL（Hardware Abstract Layer硬件抽象层）
- OpenGL（全写Open Graphics Library）是个定义了一个跨编程语言、跨平台的编程接口规格的专业的图形程序接口；
- 位置服务(LBS,Location Based Services)；
- OOM - Out of Mana，法力耗尽 
- OOM - Out of Memory，内存溢出
- Hotfix是针对某一个具体的系统漏洞或安全问题而发布的专门解决该漏洞或安全问题的小程序，通常称为修补程序。
- JSON(JavaScript Object Notation) 是一种轻量级的数据交换格式 
- AJAX即“Asynchronous javascript And XML”（异步JavaScript和XML），是指一种创建交互式网页应用的网页开发技术。
- SYN(synchronous):TCP/IP建立连接时使用的握手信号 同步 
- ACK(Acknowledgement):确认字符，确认发来的数据已经接受无误 确认
- SVG 指可伸缩矢量图形 (Scalable Vector Graphics)
- SSH 为 Secure Shell 的缩写,为建立在应用层和传输层基础上的安全协议。
- APK是AndroidPackage的缩写，即Android安装包(apk)
- USB-OTG线 接鼠标操作手机
- API（Application Programming Interface,应用程序编程接口）是一些预先定义的函数，目的是提供应用程序与开发人员基于某软件或硬件得以访问一组例程的能力，而又无需访问源码，或理解内部工作机制的细节。
- GMS全称为Google Mobile Service，即谷歌移动服务。GMS是Google开发并推动Android的动力，也是Android系统的灵魂所在。
- 物料清单(Bill of Material,BOM)
- .so ， shared object，用户层的动态库 。



## 工具&&网站
- 自动获取shape  http://shapes.softartstudio.com/#&ui-state=dialog

- 输入法推荐bing拼音输入法,能跟随AndroidStudio的光标移动,再切换到暗黑边界主题。 会导致Alt+Tab切换标签失败，不要用

![](../pictures/bing.png)

- 『我从不畏惧一个知道一万种踢法的人，但是我害怕一个把一种踢法练习过一万次的对手。』

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

- 三色规律PS：主色占60%，剩余两色分别为30%和10%。 
  就好比男人的西装外套和裤子占了装配的60%，衬衫占30%，剩下的10%留给领带点缀
