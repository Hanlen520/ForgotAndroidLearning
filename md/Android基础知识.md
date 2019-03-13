# Android基础
整理通用基础知识
- [Base](#base)
- [AndroidManifest.xml](#androidmanifest.xml)
- [TextView](#textview)
- [EditText](#edittext)
- [Button](#button)
- [RadioButton](#radiobutton)
- [CheckBox](#checkbox)
- [Switch](#switch)
- [SeekBar](#seekbar)
- [ScrollView](#scrollview)
- [AlertDialog](#alertdialog)
- [RecyclerView](#recyclerView)
- [ImageView](#imageview)
- [Toast](#toast)
- [ConstraintLayout](#ConstraintLayout)
- [FrameLayout](#FrameLayout)
- [String](#string)
- [ArrayList](#arrayList)
- [Int](#int)
- [JavaDoc注释](#javadoc注释)
- [四大组件](#四大组件)
- [Fragment](#fragment)
- [View](#view)
- [布局预览](#布局预览)
- [命名规范](#命名规范)
- [集合框架](#集合框架)
- [多媒体](#多媒体)
- [设计模式](#设计模式)
- [多线程](#多线程)
- [网络编程](#网络编程)
- [异常](#异常)
- [I/O输入输出流](#输入输出流)
- [SQLite数据库](#sqlite数据库)
- [NDK开发](#ndk开发)
- [性能优化](#性能优化)
- [测试](#测试)
- [Android系统源码](#Android系统源码)
- [签名](#签名)
- [简称](#简称)
- [工具&&网站](#工具&&网站)
- [其他](#其他)


## Base
- 父类定义过的变量，在子类可以直接使用 而不用声明

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
- 在实际开发中LayoutInflater这个类还是非常有用的，它的作用类似于findViewById()。不同点是LayoutInflater是用来找res/layout/下的xml布局文件，并且实例化；而findViewById()是找xml布局文件下的具体widget控件(如Button、TextView等)
- relativelayout 用这个来居中 要先设置Layout为wrap_content才行 
- 在drawable文件夹右键新建VectorDrawable 就能创建vector图标了 
- JAVA7中增强数字的可读性：1000000.0000 —> 1000_000.000_0 编译器会自动省略_
- 类以代码形式保存在文件中（硬盘中），new一个类，则到内存中了，这就是类的实例化 
- Java文件后缀是.java 编译之后是.class 

- 就像每种原始类型都有默认值一样，如int默认值为0，boolean的默认值为false，null是任何引用类型的默认值，不严格的说是所有object类型的默认值。就像你创建了一个布尔类型的变量，它将false作为自己的默认值，Java中的任何引用变量都将null作为默认值。

- 依赖注入：如果 Class B 是 Class A 的 Dependency，B 的赋值不是写死在了类或构造函数中，而是通过构造函数或其他函数的参数传入，这种赋值方式我们称之为依赖注入。

## AndroidManifest.xml
- application 标签内加上  android:supportsRtl="true"属性，然后TargetSDK写成17
  由于布局方向可以是从右到左的，所以在写xml布局的时候，为了防止出现布局混乱的现象，不要使用诸如layout_marginRight这种，而应该是layout_marginEnd这种
  
  这样做是为了兼容阿拉伯文，阿拉伯文是一种从右向左书写的文字, 所谓RTL(Right to Left)文字

- android:stateNotNeeded="true"  不保存state状态，即不保留屏幕临时数据
- activity的主题很重要，有时候用的demo 导入后发现样式 字体等变了，很可能就是因为新工程用的不是demo中的主题
- android theme和style的区别 
  theme一般是整个activity的样式，而style一般是一个小部件的样式，如textView，listView等 
  如果theme跟style样式有冲突，一般是style样式优先级高，就近原则

## TextView
xml:
- android:inputType="number"
- android:ems="1" 设置TextView为一列
- android:alpha="0.6" 设置透明度
- textView.append("\n" + msg.obj.toString());  追加消息到TextView中
- android:textAllCaps="false"; //取消默认大写字母
- 竖向显示文字，固定几个文字可用\n,  android:text="立\n即\n使\n用"
- android:autoLink="web" 设置超链接突出显示
- android:fontFamily="sans-serif"      修改字体
- <string name="your_string_here">This is an <u>underline</u>.</string> 在strings.xml中可以支持html标识符，
或者在java代码中用SpannableString，又或者用tv.setText(Html.fromHtml("htmlStr"))
- android:maxLines = "3"
android:scrollbars = "vertical"
- 实用的点击样式
style="@style/Base.Widget.AppCompat.Button.Borderless"
- android:ellipsize="end"
 android:singleLine="true"
//若是一行有两个TextView显示（标题+内容）， 则还是要套一层LinearLayout，而不要直接在ConstraintLayout中使用，比较难实现功能. 
//不，这样也没多大意义
- 使用autoLink属性识别链接类型


 java代码设置 tv.setSelect(true)
//设置长度超长时的显示效果，后面加省略号. 嫌麻烦的话还是手动算长度加省略号吧，也不好，不同手机上显示长度不一样

java:
- tv.setError("报错信息");
- txtShow.setBackground("#000");
-  textview.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG ); //中间添加删除横线
yourTextView.setMovementMethod(new ScrollingMovementMethod());
设置TextView可固定行数，超出部分可滚动
- 同样一个TextView,如果我们的MainActivity 分别继承Activity，AppCompatActivity，我们打印一下我们的TextView，会发现继承了AppCompatActivity的会变成AppCompatTextView
- 设置段落中部分文字特殊颜色或字体: tvHint.setText(Html.fromHtml("<big>将网关连接电源，并与家庭路由器相连，<br>使手机和网关在<font color='#FF9600'>同一网络下</font>，确定指示灯<br>（绿灯常亮）<big>"));
- 关于TextView设置了drawableStart后无法在xml中设置图片大小的问题，在java代码中可以配置, 但不推荐这样使用，还不如外面再包一个LinearLayout来得简单
 txtZQD = (TextView) findViewById(R.id.txtZQD);  
        Drawable[] drawable = txtZQD.getCompoundDrawables();  
        // 数组下表0~3,依次是:左上右下  
        drawable[1].setBounds(100, 0, 200, 200);  
        txtZQD.setCompoundDrawables(drawable[0], drawable[1], drawable[2],  
                drawable[3]);  

## EditText
xml:
- android:ems="1" 设置EditText为一列
- android:background="@null" 消除底部横线
- android:inputType="textMultiLine" 多行显示文字
- android:inputType="number" 只能输入文字
- EditText挡住ListView的问题，在Manifest中设置Activity属性 android:windowSoftInputMode="stateAlwaysHidden|adjustPan"
- android:digits="qwertyuiopasdfghjklzxcvbnm1234567890" //直接在xml布局中限制输入字符串
- TextLayout中显示密码的按钮 app:passwordToggleEnabled="true"
- 有时候不是edittext没有光标，可能是光标默认白色，那么在白色背景下就看不到了 
  方法一、 
  EditText有一个属性：android:textCursorDrawable，这个属性是用来控制光标颜色的 
  android:textCursorDrawable=”@null”，”@null”作用是让光标颜色和text color一样
- et.setSelection(et.getText().length());  设置弹出时的光标位置
- android:imeOptions
附加功能，设置右下角IME动作与编辑框相关的动作，如actionDone右下角将显示一个“完成”，而不设置默认是一个回车符号。
- 另外EditText还为我们提供了设置英文字母大写类型的属性：android:capitalize 默认none，提供了三个可选值：
sentences：仅第一个字母大写
words：每一个单词首字母大小，用空格区分单词
characters:每一个英文字母都大写
当然我们也可以调用setSelectAllOnFocus(true);让EditText获得焦点时选中全部文本！
另外我们还可以调用setCursorVisible(false);设置光标不显示
还可以调用getSelectionStart()和getSelectionEnd获得当前光标的前后位置
- android:textScaleX="1.5"    //设置字与字的水平间隔
android:textScaleY="1.5"    //设置字与字的垂直间隔

java:
-  显示小键盘 ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE)).showSoftInput(editPrivateMsg, 0);
-  隐藏小键盘 ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE)).
   hideSoftInputFromWindow(editPrivateMsg.getWindowToken(), 0);
- 屏蔽EditText的焦点 etCode.setFocusable(false);
- 点击控件时，重新获取焦点，激活软键盘
- 监听输入edtInput.setKeyListener(DigitsKeyListener.getInstance("1234567890."));
  edtInput.setInputType(8194);
- EditText 在 setText 时不要忘记是否需要 setSelection。在某些情况下是需要设置的。
- 当EditText获取焦点的时候，不弹出软键盘，其实也很简单，代码如下：
// 默认软键盘不弹出 getWindow().setSoftInputMode( WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
```
  etCode.setFocusable(true);
  etCode.setFocusableInTouchMode(true);
  etCode.requestFocus();
```
- dialog中软键盘的弹出和隐藏
隐藏 , view是EditText
```
 protected void hideSoftInput(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
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
- 使用的点击样式
style="@style/Base.Widget.AppCompat.Button.Borderless"

- 对于 Selector 当背景的，可以将 normal 状态的 color 设置为 @android:color/transparent ， 效果简洁
- MaterialButton可以设置圆角等属性
注意：MaterialButton必须设置textAppearance属性，如果没有的话会报错，不知道是不是bug。


java:

## RadioButton
- 关于RadioGroup实现多行选项，如两排四列，在选择第一列时，把第二列清空选择即可
  mRg2.clearCheck();
- 取消选择小圆圈 android:button="@null"
- 设置checked背景变化， 在selector文件中设置checked的样式即可
- - Material中的ChipGroups控件可以实现流式布局的多选

## CheckBox
- 注意，关于CheckBox切换状态触发动作时，需要加一个判断
 if (buttonView.isPressed()) { 否则可能多次触发动作

## Switch
- 关于4.4以下switch自定义样式显示错误的问题，
在track样式中添加size属性，如
```
<size
        android:width="30dp"
        android:height="20dp"/>
```
然后在Switch属性中添加
```
android:thumbTextPadding="10dp"
        android:switchMinWidth="40dp"
        android:textOn=""
        android:textOff=""
        android:thumb="@drawable/switch_thumb_dark"
        android:track="@drawable/switch_track_orange"
```
可达到大致兼容的效果

- 为了更好的Switch样式和配置颜色等，建议高兼容包的SwitchCompact
androidx.appcompat.widget.SwitchCompat

## SeekBar
- 在api19以下，seekBar在scrollView中会出现无法拖动的问题？，解决办法，在新增一个触摸事件处理
```
viewHolder.sbCurtain.setOnTouchListener(new View.OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                v.getParent().requestDisallowInterceptTouchEvent(true);
                break;

            case MotionEvent.ACTION_UP:
                v.getParent().requestDisallowInterceptTouchEvent(false);
                break;
            default:
                break;
        }
        // Handle Seekbar touch events.
        v.onTouchEvent(event);
        return true;
    }
});
```

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
- ScrollView滚到最下面
scrollView.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                    }
                });



## AlertDialog
- 点击外部不会关闭dialog, builder.setCancelable(false); 
- 设置自定义dialog的圆角背景
```
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
       android:shape="rectangle">
    <solid android:color="@color/mainBg"/>
    <corners android:radius="20dp"/>
</shape>
```
然后设置dialog的样式
```
<style name="dialog" parent="@android:style/Theme.Dialog">
        <item name="android:colorBackgroundCacheHint">@null</item>
        <item name="android:windowFrame">@null</item><!--边框-->
        <item name="android:windowIsFloating">true</item><!--是否浮现在activity之上-->
        <item name="android:windowIsTranslucent">true</item><!--半透明-->
        <item name="android:windowNoTitle">true</item><!--无标题-->
        <item name="android:windowBackground">@color/transparent</item><!-- 背景透明 -->
        <item name="android:backgroundDimEnabled">false</item><!--模糊-->
    </style>
```
- 在create()执行之后设置dialog背景透明
```
builder.setView(view);
Dialog dialog = builder.create();
Window window = dialog.getWindow();
window.setBackgroundDrawableResource(R.color.colorTransparent);
dialog.show();
```
- 关于AlertDialog兼容性的问题，背景无法完全透明，只要更换AlertDialog api为appcompat的即可
新版本是 import androidx.appcompat.app.AlertDialog;
- 设置dialog的宽高比例
```
WindowManager windowManager = getWindowManager();
Display d = windowManager.getDefaultDisplay();  //为获取屏幕宽、高
WindowManager.LayoutParams p = window.getAttributes();  //获取对话框当前的参数值
p.height = (int) (d.getHeight() * 0.5);   //高度设置为屏幕的0.5
p.width = (int) (d.getWidth() * 0.8);    //宽度设置为屏幕的0.8
window.setAttributes(p);
```

## RecyclerView
- recyclerView的item ， 布局的宽度一定要match_parent, 否则首次记载时第一个宽度显示不全
- 在adapter的默认构造器中使用
public RepositoryAdapter() {
    this.repositories = Collections.emptyList();
}
- 想要RecyclerVIew中显示平分的两列，只需在item_layout中设置宽度match_content， 然后设置布局两列的GridLayoutManager即可
- 解决与ScrollView嵌套时的内部无法滑动问题。设置内部滑动效果
1.将Scrollview改为NestedScrollView；
2.设置rv属性rvRoom.setNestedScrollingEnabled(true);

- 解决 Recyclerview和 ScrollView的嵌套滑动问题  https://my.oschina.net/caomenglong/blog/747197
设置全部展开滑动效果
  在RecyclerView外面嵌套一层RelativeLayout,在RelativeLayout 中添加 android:descendantFocusability="blocksDescendants">
   mRecyclerView.setNestedScrollingEnabled(false);
  或者
  1.将Scrollview改为NestedScrollView；
2.mRecyclerView.setNestedScrollingEnabled(false);

- viewpager 嵌套fragment时，发现RecycerView数据不更新,
需要在onActivityCreated方法中再次进行关联：adapter和RecyclerView，
如：
```
@Override
public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    RoomCoverAdapter adapter = (RoomCoverAdapter) rvRoom.getAdapter();
    rvRoom.setAdapter(adapter);
} 
```

- 使用RecyclerView时发现item显示不全的问题，在外层都用LinearLayout或者再包一层NestedScrollView即可，使用ConstraintLayout不当，会显示不全
- 取消RecyclerView刷新数据时的闪烁动画效果
((DefaultItemAnimator) rvButton.getItemAnimator()).setSupportsChangeAnimations(false);

### 关于视图预览
- tools:itemCount  //设置显示多少个item
- tools:layoutManager="GridLayoutManager" //要和spanCount一起用才有效
- tools:spanCount="2"
- tools:listitem="@layout/item"
- tools:listheader 
- tools:listfooter
- tools:orientation="horizontal" 设置水平方向
- tools:scrollbars="horizontal"

## ImageView
- android:tint="@color/sample_green"
  可以直接给ImageView图片src上色
- ImageView水波纹效果,android:background="?selectableItemBackgroundBorderless"
- 设置背景图遮罩层颜色  clMode.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY ); 
- ImageView的src属性和blackground的区别；
adjustViewBounds设置图像缩放时是否按长宽比
scaleType设置缩放类型
ImageView为我们提供了adjustViewBounds属性，用于设置缩放时是否保持原图长宽比！ 单独设置不起作用，需要配合maxWidth和maxHeight属性一起使用！而后面这两个属性 也是需要adjustViewBounds为true才会生效的~

## Toast
- 一般toast显示不出有3个原因： 
  1、在非UI线程中执行，建议使用handler显示提示 
  2、没有执行到，这是逻辑错误 
  3、可能是手机设置-应用通知管理没打开
- Toast有可能导致Activity泄漏。在创建Toast时，需要传入Context，如果这个Context是Activity，而Toast是异步弹出，有可能弹出时Activity已经结束。所以正确使用方法，应该是传入ApplicationContext，避免Toast导致内存泄漏。
## ConstraintLayout
- 高宽用0dp wrap_content， 而不能用match_parent
- app:layout_constraintDimensionRatio="30:19"   //设置宽高比例 ，自适应，把固定长度的设为0dp即可
- 实现B在A的底部交叉居中显示
 app:layout_constraintBottom_toBottomOf="@id/tv_top"
  app:layout_constraintTop_toBottomOf="@+id/tv_top"
- layout_constraintHorizontal_chainStyle 属性的应用
- ConstraintLayout+RecyclerView也是可以显示完全的，秘诀是RecyclerVIew需要设置height为0dp, 然后设置layout_constraintBottom_toTopOf等属性

## FrameLayout
- 调整子布局位置，如android:layout_marginTop="-100dp"

## String
- %d（表示整数），%f（表示浮点数）， %s （表示字符串）
  例如 <string name="old">我今年%d岁了</string>
  String sAgeFormat = getResources().getString(R.string.old);
  String sFinalAge = String.format(sAgeFormat, 23);
- toString和强转(String)的区别。toString是一个方法，任何一个对象都可以有自己的toString方法，而强转String是将一个对象转化为String类型，若本身不是String类型则可能奔溃
- 如果用"."作为分隔的话，必须是如下写法：String.split("\\."),这样才能正确的分隔开，不能用String.split(".");
同理若用"|"作为分隔符的话也一样，因为这是转义字符
- String string; 在栈和堆中都没有分配空间
  String string=null; 在栈中分配了空间，在堆中没有分配空间
  String string="";在栈和堆中都分配了空间
- String a="abc";
    String b=new String("abc");
    System.out.println(a==b);
    System.out.println(a.equals(b));
    答案是false true ，  ==比较的是两对象完全相等（值还有hashcode相等），而.equal比较的是值相等
- 像a.equals("Happy new year")这种判断的话如果a为null就会出现异常，但是改成"Happy new year".equals(a)这种写法的话，则即使a为null也不会有问题。所以在Java中进行比较就最好把常量放在左边
- 1、如果用“.”作为分隔的话，必须是如下写法：String.split("\\."),这样才能正确的分隔开，不能用String.split(".");
  2、如果用“|”作为分隔的话，必须是如下写法：String.split("\\|"),这样才能正确的分隔开，不能用String.split("|");
  “.”和“|”都是转义字符，必须得加"\\";
  3、如果在一个字符串中有多个分隔符，可以用“|”作为连字符，比如：“a=1 and b =2 or c=3”,把三个都分隔出来，可以用String.split("and|or");
- String[]转List
  Arrays.asList(abc.split(","));

## ArrayList
- String[] 转化为 List<String>
new ArrayList<>(Arrays.asList(array))

-  List<String>转换为String[]
List<String> list = ..;
String[] array = list.toArray(new String[0]);

## int
- 十进制转化为十六进制，结果为C8。 Integer.toHexString(200);

- 十六进制转化为十进制，结果140。 Integer.parseInt("8C",16);

- res-values-integers.xml, 存放整型数据，strings存放字符串数据




## JavaDoc注释
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
- Android 开发有时需要在一个应用中启动另一个应用，比如Launcher加载所有的已安装的程序的列表，当点击图标时可以启动另一个应用。
  
  一般我们知道了另一个应用的包名和MainActivity的名字之后便可以直接通过如下代码来启动：
```
  Intent intent = newIntent(Intent.ACTION_MAIN);
  intent.addCategory(Intent.CATEGORY_LAUNCHER);          
  ComponentName cn = newComponentName(packageName, className);          
  intent.setComponent(cn);
  startActivity(intent);
```
## Fragment
- activity获取fragment中的控件： getFragmentManager().findFragmentById(id).getView().findViewById(id)
- 推荐使用app包下的fragment，不要再使用v4包的fragment的
- 获取v4包中的fragment： getSupportFragmentManager().findFragmentById(id).getView().findViewById(id)
- fragment获取fragment中的控件： getView().findViewById(id)
  fragment中获取activity中的方法
- 获取fragement中的子管理， getChildFragmentManager();
- fragment每次点击回来 加载数据的时机
  @Override
  public void onHiddenChanged(boolean hidden) {
  super.onHiddenChanged(hidden);
  // 这里的 isResumed() 判断就是为了避免与 onResume() 方法重复发起网络请求
  if (isVisible() && isResumed()){
  Log.e(TAG, "onHiddenChanged可见状态,进行数据加载");
  }
  }
- 详解每个方法的调用场景
```
onAttach方法
Fragment和Activity建立关联的时候调用（获得activity的传递的值）
onCreateView方法
为Fragment创建视图（加载布局）时调用（给当前的fragment绘制UI布局，可以使用线程更新UI）
onActivityCreated方法
当Activity中的onCreate方法执行完后调用（表示activity执行oncreate方法完成了的时候会调用此方法）
onDestroyView方法
Fragment中的布局被移除时调用（表示fragment销毁相关联的UI布局）
onDetach方法
Fragment和Activity解除关联的时候调用（脱离activity）


当这个fragment进入“后台模式”的时候，它会经历以下状态。
onPause()
onStop()
当这个fragment被销毁了（或者持有它的activity被销毁了）：
onPause()
onStop()
onDestroyView()
onDestroy()
onDetach()
就像Activity一样，在以下的状态中，可以使用Bundle对象保存一个fragment的对象。
onCreate()
onCreateView()
onActivityCreated()
其他场景的调用
屏幕灭掉
onPause() onSaveInstanceState() onStop()
屏幕解锁
onStart() onResume()
切换到其他Fragment
onPause() onStop() onDestroyView()
切换回本身的Fragment
onCreateView() onActivityCreated() onStart() onResume()
回到桌面
onPause() onSaveInstanceState() onStop()
回到应用
onStart() onResume()
退出应用
onPause() onStop() onDestroyView() onDestroy() onDetach()
```

## View
- view.bringToFront(); 
  将一个控件放在顶层，如progressbar 
- Android UI中的View如何刷新。
  在主线程中  拿到view调用Invalide()方法,查看画画板里面更新imageview的方法
  在子线程里面可以通过postInvalide()方法;
  View view;
  view.invalidate();//主线程
  view.postInvalidate();//子线程
- 设置控件最大宽高
android:maxHeight="90dp"
android:maxWidth="90dp"
android:adjustViewBounds="true"

- 设置view透明图
  android:alpha="0.7"
- View的滑动冲突一般可以分为三种：
外部滑动和内部滑动方向不一致
外部滑动方向和内部滑动方向一致
嵌套上面两种情况
比如说一个常见的，外部一个ListView，里面一个ScrollView。这个时候该怎么解决呢？其实这里想到了ViewPager，它里面实际上是解决了滑动冲突的，可以借鉴一下它的。


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


## 命名规范
- UI资源命名(最好全用英文命名)
命名规范\
0,大模块名_元素名_状态值
1, 大模块名分为：huanchang, legou , shejiao , xuchang , zhanghu等等
2, 元素名按目前的，如：luyin, bofang , yidian等等
3，状态值， 默认不带；点击变化的状态为 pressed

例子： 
huanchang_yidian 表示欢唱界面 已点图标
huanchang_yidian_pressed 表示欢唱界面 已点图标 ,点击后变化的状态



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
- 设计原则：(重要) 
  a. 
  逻辑代码独立到单独的方法中，注重封装性–易读，易复用。 
  不要在一个方法中，写下上百行的逻辑代码。把各小逻辑代码独立出来，写于其它方法中，易读其可重复调用。 
  b. 
  写类，写方法，写功能时，应考虑其移植性，复用性：防止一次性代码！ 
  是否可以拿到其它同类事物中应该？是否可以拿到其它系统中应该？ 
  c. 
  熟练运用继承的思想： 
  找出应用中相同之处，且不容易发生变化的东西，把它们抽取到抽象类中，让子类去继承它们； 
  继承的思想，也方便将自己的逻辑建立于别人的成果之上。如ImageField extends JTextField； 
  熟练运用接口的思想： 
  找出应用中可能需要变化之处，把它们独立出来，不要和那些不需要变化的代码混在一起。

## 多线程
- ActivityThread被创建时就会自动初始化Looper，所以能直接使用Handler，若在子线程中使用Handler的话，就要先初始化Looper.prepare()或者
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
- 多线程就是一个人同时在做多件事情，比如同时呼吸和写文章，而多进程就是复制一个人来和你一起做事，两个人之间独立 不冲突


- 关于Handler的实现
    - Looper: 一个线程可以产生一个Looper对象，由它来管理此线程里的Message Queue(消息队列)。
 - Handler: 你可以构造Handler对象来与Looper沟通，以便push新消息到Message Queue里;或者接收Looper从Message Queue取出)所送来的消息。
  - Message Queue(消息队列):用来存放线程放入的消息。
  - 线程：UI thread 通常就是main thread，而Android启动程序时会替它建立一个Message Queue。
- 用Message msg = handler.obtainMessage(); 来替代Message msg = new Message()
  
- 线程池。 用四种线程池的方法来实现多线程，而不是用低效的new Thread(new Runnable)...来实现
## 网络编程
- 当我们打开浏览器，在地址栏中输入URL，然后我们就看到了网页。 原理是怎样的呢？ 
  实际上我们输入URL后，我们的浏览器给Web服务器发送了一个Request, Web服务器接到Request后进行处理，生成相应的Response，然后发送给浏览器， 浏览器解析Response中的HTML,这样我们就看到了网页
- HttpURLConnection对象不能直接构造，需要通过URL.openConnection()来获得HttpURLConnection对象，因为HttpURLConnection是抽象类，不能new
- 当用android内的webView打开微博个人页时，显示空白，因为要添加JavaScript脚本支持才行 
  // 得到设置属性的对象 
  WebSettings webSettings = myWeb.getSettings(); 
  // 使能javascript 
  webSettings.setJavaScriptEnabled(true); 
  // 支持中文，否则页面中中文显示乱码 
  webSettings.setDefaultTextEncodingName(“GBK”);
  
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

## I/O输入输出流
- str.getBytes(Charset.forName("UTF-8"))

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

- .help 帮助菜单 
  .databases 显示数据库信息； 
  .tables 显示表名称； 
  .schema 命令可以查看创建数据表时的SQL命令； 
  .schema table_name 查看创建表table_name时的SQL的命令； 
  .exit 退出sqlite操作
- 提示 
  Android: adb: Permission Denied 
  执行一下 
  adb root






## NDK开发
- 谈谈对Android NDK的理解。
  native develop kit   只是一个交叉编译的工具  .so
      1.什么时候用ndk,  实时性要求高,游戏,图形渲染,  opencv (人脸识别) , ffmpeg , rmvb  mp5 avi 高清解码. ffmpeg, opencore.
- 关于NDK开发
0.NDK是一种技术手段，我觉得不能问“NDK学了能做什么”，而应该问“什么情况下应该用NDK而不用Java“。
项目中用NDK无外乎下面几种原因：
1、安全因素。利用NDK编译出的是NativeCode，相比java的代码，本地代码从破解上更难，对破解者技术要求高。
2、系统级编程。不跟jvm打交道，直接跟android系统打交道。
3、性能需求。虽然java很快了，但是c++会更快。
4、跨平台。国内某视频直播客户端支持多个平台，其底层的解码是由c++编写，一套代码用于多个平台，减少维护成本。
所以说你学不学NDK是看项目有没这些需要。
## 性能优化
- Java 内存泄露的根本原因就是 保存了不可能再被访问的变量类型的引用
- 匿名内部类默认持有外部类的引用，有内存泄漏的风险;
- Application对象的生命周期是整个程序中最长的，它的生命周期就等于这个程序的生命周期。因为它是全局的单例的，所以在不同的Activity,Service中获得的对象都是同一个对象。所以可以通过Application来进行一些，如：数据传递、数据共享和数据缓存等操作。
- Java中的卫语句:把嵌套写的if else判断，改为串行的条件判断, return;
- 在BaseActivity中统一开启关闭DEBUG， 还有List<Activity> 管理所有Activity的finish()
- Android oom 1是加载对象过大， 2是相应资源过多，没有来不及释放。
- android new一个类后（如果被context或view等持有的话，会导致无法被GC回收），不用时要手动释放，不然有可能会导致内存泄漏
- Android应用内存泄漏的的原因有以下几个： 
  1查询数据库后没有关闭游标cursor 
  2 构造Adapter时，没有使用 convertView 重用 
  3 Bitmap对象不在使用时调用recycle()释放内存 
  4 对象被生命周期长的对象引用，如activity被静态集合引用导致activity不能释放 
- 资源性对象比如(Cursor，File文件等)往往都用了一些缓冲，我们在不使用的时候，应该及时关闭它们，以便它们的缓冲及时回收内存。它们的缓冲不 仅存在于 java虚拟机内，还存在于java虚拟机外。如果我们仅仅是把它的引用设置为null,而不关闭它们，往往会造成内存泄漏。
- “为什么我们的后台进程/Service会被结束掉？ 
  我想到的是有三个方面： 
  Android系统内存回收机制； 
  各厂商对后台程序的一个管理制度（就是允许程序后台运行那个）； 
  第三方软件的清理(360什么的)。
- 为预防内存泄漏，尽量别把 activity 或 context 设置为静态 static, 对于生命周期长的对象，可以使用 applicationContext
- 布局优化，减少布局层级。功能一样时，优先LinearLayout和FrameLayout
- 使用使用<include>,<merge>和ViewStub
- meger还有另外一个用法，当应用Include或者ViewStub标签从外部导入xml结构时，可以将被导入的xml用merge作为根节点表示，这样当被嵌入父级结构中后可以很好的将它所包含的子集融合到父级结构中，而不会出现冗余的节点。
  另外有两点需要特别注意：
  <merge />只可以作为xml layout的根节点。
  当需要扩充的xml layout本身是由merge作为根节点的话，需要将被导入的xml layout置于 viewGroup中，同时需要设置attachToRoot为True。

## 测试
- 在移动应用上进行的测试包括：
  
  1. 性能测试: 执行测试客户端的应用程序性能，网络性能和服务器性能。
  2. 功能测试: 这是根据需求检查应用程序功能的基本测试。
  3. 内存测试: 与计算机相比，移动设备具有较小的内存，执行该测试以测试任何应用可优化的存储器使用。
  4. 安装测试: 进行安装测试以检查包括卸载和更新的平滑与容易的安装过程。
  5. 中断测试: 它用于检查由于短信或来电，低电量警告，低内存警告等引起的中断。
  6. 可用性测试: 它用于检查应用程序的有效性，效率和满意度。
  
- 编写测试用例，看输入输出是否正确 
测试用例是软件测试的核心 
测试用例制定的原则 
测试用例要包括欲测试的功能、应输入的数据和预期的输出结果。测试数据应该选用少量、高效的测试数据进行尽可能完备的测试；基本目标是：设计一组发现某个错误或某类错误的测试数据，测试用例应覆盖方面： 
1、 正确性测试：输入用户实际数据以验证系统是满足需求规格说明书的要求；测试用 
例中的测试点应首先保证要至少覆盖需求规格说明书中的各项功能，并且正常。 
2、 容错性（健壮性）测试：程序能够接收正确数据输入并且产生正确（预期）的输出， 
输入非法数据（非法类型、不符合要求的数据、溢出数据等），程序应能给出提示 并进行相应处理。把自己想象成一名对产品操作一点也不懂的客户，在进行任意操作。 
3、 完整（安全）性测试：对未经授权的人使用软件系统或数据的企图，系统能够控制的程度，程序的数据处理能够保持外部信息（数据库或文件）的完整。 
4、 接口间测试：测试各个模块相互间的协调和通信情况，数据输入输出的一致性和正确性。 
5、 数据库测试：依据数据库设计规范对软件系统的数据库结构、数据表及其之间的数据调用关系进行测试。 
6、 边界值分析法：确定边界情况（刚好等于、稍小于和稍大于和刚刚大于等价类边界值），针对我们的系统在测试过程中主要输入一些合法数据/非法数据，主要在边界值附近选取。 
7、 压力测试：输入10条记录运行各个功能，输入30条记录运行，输入50条记录运行。。。进行测试。 
8、等价划分：将所有可能的输入数据（有效的和无效的）划分成若干个等价类。 
9、错误推测：主要是根据测试经验和直觉，参照以往的软件系统出现错误之处。 
10、效率：完成预定的功能，系统的运行时间（主要是针对数据库而言）。 
11、可理解（操作）性：理解和使用该系统的难易程度（界面友好性）。 
12、可移植性：在不同操作系统及硬件配置情况下的运行性。 
13、回归测试：按照测试用例将所有的测试点测试完毕，测试中发现的问题开发人员 
已经解决，进行下一轮的测试。 
14、比较测试：将已经发版的类似产品或原有的老产品与测试的产品同时运行比较，或与已往的测试结果比较

14、A/B测试 
长标题还是短标题 
疑问句还是陈述句 


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
- ACK(Acknowledgement):确认字符，确认发来的数据已经接受无误 确认
- AJAX即“Asynchronous javascript And XML”（异步JavaScript和XML），是指一种创建交互式网页应用的网页开发技术。
- AMS:ActivityManagerServices，服务端对象，负责系统中所有Activity的生命周期
- ANR：Application Not Responding
- AOP。AOP是Aspect Oriented Programming的缩写，中译文为面向切向编程
- API（Application Programming Interface,应用程序编程接口）是一些预先定义的函数，目的是提供应用程序与开发人员
基于某软件或硬件得以访问一组例程的能力，而又无需访问源码，或理解内部工作机制的细节。
- APK是AndroidPackage的缩写，即Android安装包(apk)
- APT：(Annotation Process Tool) 在编译时生成辅助类，这些类继承特定父类或实现特定接口
- ARP(Address Resolution Protocol，地址解析协议)是获取物理地址的一个TCP/IP协议 
  ARP欺骗可以导致目标计算机与网关通信失败； 
- BOM:物料清单(Bill of Material)
- DRY:Don’t Repeat Yourself  
- DSL： 即Domain Specific Language，领域相关语言
- GMS全称为Google Mobile Service，即谷歌移动服务。GMS是Google开发并推动Android的动力，也是Android系统的灵魂所在。
- HAL（Hardware Abstract Layer硬件抽象层）
- Hotfix是针对某一个具体的系统漏洞或安全问题而发布的专门解决该漏洞或安全问题的小程序，通常称为修补程序。
- JNI（java native interface java 本地接口）
- JSON(JavaScript Object Notation) 是一种轻量级的数据交换格式 
- LRU， Least Recently Used 近期最少使用算法
- MIME 是multipurpose Internet mail extensions 的缩写。 
它是一种协议，可使电子邮件除包含一般纯文本以外，还可加上彩色图片、视频、声音或二进位格式的文件。 
它要求邮件的发送端和接收端必须有解读MIME 协议的电子邮件程序。
- NPE:No Pointer Exception
- npm: （全称Node Package Manager，即node包管理器）是Node.js默认的、以JavaScript编写的软件包管理系统。
- OA :Office Automation System 办公自动化系统 
- OpenGL（全写Open Graphics Library）是个定义了一个跨编程语言、跨平台的编程接口规格的专业的图形程序接口；
- 位置服务(LBS,Location Based Services)；
- OOM - Out of mana，法力耗尽 
- OOM - Out of Memory，内存溢出
- OOP，即ObjectOriented Programming，面向对象编程
- Rx ReactiveX是Reactive Extensions的缩写，一般简写为Rx
- SaaS:Software as a Service
- SKU:库存单位(Stock Keeping Unit)；单品；最小存货单位
- SNS，全称Social Networking Services，即社会性网络服务
- SSH 为 Secure Shell 的缩写,为建立在应用层和传输层基础上的安全协议。
- SVG 指可伸缩矢量图形 (Scalable Vector Graphics)
- SYN(synchronous):TCP/IP建立连接时使用的握手信号 同步 
- USB-OTG线 接鼠标操作手机
- .so ， shared object，用户层的动态库 。


## 工具&&网站
- 自动获取shape  http://shapes.softartstudio.com/#&ui-state=dialog



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

- 一个 Android 工程最后变成 apk 包大概要做这么几件事儿：
  * 1、生成 R.java 文件
  * 2、将 .java 文件编译成 .class 文件
  * 3、将 .class 文件打包成 .jar 文件
  * 4、将所有 .jar 文件（包括依赖库）编译成 classes.dex 文件
  * 5、将 assets 和 res 文件夹中所有的资源文件打包成一个 apk 包
  * 6、将 classes.dex 文件添加进 apk 包
  * 7、如果有使用 NDK 技术的话，将生成的 .so 文件添加进 apk 包
  * 8、对 apk 包进行签名
  
- android 定义颜色color时6位或8位值的区别 
  6位（#000000）就是RGB值（红绿蓝各自0~255，转换为16进制后，各对应前两位数，0~f）
  8位（#1e000000）头两位是透明度，后6位是RGB值，00是完全透明，ff是完全不透明，比较适中的透明度值是 1e 3e 4e
  
- 如何将一个Activity设置成窗口的样式。 
  答：中配置：android :theme=”@android:style/Theme.Dialog” 
  另外android:theme=”@android:style/Theme.Translucent” 是设置透明
  
- 公钥和私钥是成对的，它们互相解密。 
  公钥加密，私钥解密。 
  私钥数字签名，公钥验证。 
  RSA是目前最有影响力的公钥加密算法，它能够抵抗到目前为止已知的所有密码攻击，已被ISO推荐为公钥数据加密标准。 
  RSA算法基于一个十分简单的数论事实：将两个大素数相乘十分容易，但那时想要对其乘积进行因式分解却极其困难，因此可以将乘积公开作为加密密钥。
  
- 人工画的二维码也能识别的，要分好格子来画，二维码有一定容错性，一般遮住一小部分仍然能识别  

- 在计算机中，整数是以原码的形式存储的，而负数是以补码的形式存储的

- 在安卓系统，我们经常会接触到弹窗，说到弹窗，我们经常接触到的也就dialog或者popupWindow了。而这两者的区别，简单的说就是“一大小二蒙层三阻塞”，如果再简单点说，就是对话框与悬浮框的区别吧。。。还有Dialog样式的Activity

- 骁龙835cpu是arm64-v8a

- Android手机唯一标识，Settings.Secure#ANDROID_ID returns the Android ID as an unique for each user 64-bit hex string.
private String android_id = Settings.Secure.getString(getContext().getContentResolver(),
                                                        Settings.Secure.ANDROID_ID); 

- ActivityManager中的一个方法
/**
 * Returns "true" if the user interface is currently being messed with
 * by a monkey.
 */
public static boolean isUserAMonkey() {
    try {
        return getService().isUserAMonkey();
    } catch (RemoteException e) {
        throw e.rethrowFromSystemServer();
    }
}

- BottomNavigationView 输入以下的就能实现4个以上也能同时显示文字了
app:labelVisibilityMode="labeled"