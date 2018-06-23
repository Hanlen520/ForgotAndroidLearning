# 《ForgotHeadFirstAndroid》
看Head First Android 做的笔记
<br>
## 第一章 初尝(P1~38)
- Android 平台框架图
- 项目文件结构
- Android Studio 基本使用
- 第一个 "Hello World" 应用
- 创建模拟器，用模拟器调试应用
- 编译、打包、部署和运行
- 在 Android Monitor 查看进度
- string 字符串要在 values 下的 strings.xml 声明，一是方便多语言本地化处理，而是方便后期统一修改管理
- 英文value文件夹是 value-en , 中文是 value-zh

## 第二章 构建交互 (P39~72)
- RelativeLayout的各属性应用，如layout_alignLeft , layout_below,layout_alignParentTop
- Spinner的使用,用 getSelectedItem() 来获取当前选项
- arrays.xml的使用  string-array
- List和ArrayList的使用
- StringBuilder的使用
- foreach语句的使用
- Button点击的几种方法：
- xml布局中添加onClick, 匿名内部类方法，Activity中实现OnClickListener接口，自定义内部类方法

## 第三章 活动和意图(P73~114)
- 四大组件需要在AndroidManifest.xml中注册
- Activity的数据传递
- startActivity(intent)时，若没有响应的，会抛出ActivityNotFoundException异常，所以最好先判断是否有响应者，再去执行
- Intent的setAction,setType, putExtra.  MIME类型
- 隐式意图Intent.ACTION_SEND
- AndroidManifest中的<intent-filter使用,<action  <category  <data
- 真机调试
- 选择器的用法，比如一键分享功能可使用 Intent.createChooser(intent,"Share Message...")
没有响应时，则只显示消息，而响应列表为空白（不会奔溃），若隐式意图不用这个的话就可能奔溃了

## 第四章 活动的生命周期(P115~162)
- 字体属性  android:textAppearance="?android:attr/textAppearanceLarge"
- 用Handler做一个秒表计时器
- handler.postDelay(runnable,1000), handler.post()
- 在主进程更新用户界面
- 设置屏幕的代码要放在onCreate()中而不是构造方法中
- 应付用户旋转屏幕的方法：避开重建活动，在Manifest的Activity中设置:android:configChanges="orientation|screenSize"
- 保存当前状态,在onSaveInstanceState方法中保存，然后在onCreate检测不为空时，则载入数据


```
@Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("curSecond",seconds);
        outState.putBoolean("curRun",running);
    }
     @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_chronograph);
            if (savedInstanceState!=null){
                seconds=savedInstanceState.getInt("curSecond");
                running=savedInstanceState.getBoolean("curRun");
            }}
```


- 当前活动不可见时，在onStop中保存当前秒表运行状态，并停止计时（若不停止，秒表将在后台计时），然后在onStart中获取运行状态，继续计时
- 当前活动不在前台时，在onPause中保存运行状态，停止计时，在onResume中获取运行状态
- 生命周期 onCreate()->onStart()->onResume()->onPause()->onStop()->onDestroy()
- 前台生命周期 onStart()->onResume()->onPause()->onStop()
- 再次回到前台 onRestart()->onStart()->onResume()
- 可见生命周期 onResume()->onPause()
- 从A到B：A.onPause()->B.onCreate()->B.onStart()->B.onResume()->A.onStop()
- onCreate代表状态，onStart表示活动可见，onResume表示在前台运行，onPause表示不在前台，onStop表示不可见，onDestroy表示活动销毁

## 第五章 用户界面(P163~P225)
- 所有布局都要有width和height属性，宽和高
- 区分RelativeLayout的margin, padding, alignParent和align属性
- 关注LinearLayout的weight权重属性和orientation方向属性，权重相关的宽高改为0，而不是wrap_content，关注gravity和gravity_layout的区别，前者是在自己内部布局，后者是在父布局的View里的布局
- 网格布局GridLayout,columnCount和rowCount属性. GridLayout中的元素可以没有weight和height属性？
- 所有布局都继承于ViewGroup(包括LinearLayout,Toolbar,ViewPager等)，ViewGroup再继承于View，而一些小控件如Button等则是直接继承与View
- 熟悉getId(),getHeight(),isClickable(),isFocused(),requestFocus()等View属性
- 熟悉事件处理和事件监听
- 状态开关Switch,ToggleButton,单选按钮RadioGroup RadioButton，多选按钮CheckBox
Switch等按钮的监听事件区别，setOnClickListener需要用户再去获取isChecked属性状态，而setOnCheckedChangeListener直接获取了isChecked属性
ScrollView和horizontalScrollView

## 第六章 列表视图和适配器(P226~268)
- ListView的监听要使用setOnItemClickListener，然后用listView.getItemAtPosition(position)来获取点击的对象，注意ListView不是Button的子类，所以无法使用onClickListenter来获取监听
- 关于列表活动ListActivity,用getListView()获得ListView的引用，重写onListItemClick()来编写点击事件
- ListView是典型的MVC设计模式，实体类Bean代表Model，Activity负责View，Adapter负责Control
- 用android:entries 属性给ListView设置固定的内容
- tools:listitem 属性给ListView设置要预览的内容
- ArrayAdapter的简单应用

## 第七章 片段(P269~
- 模块化，适配多屏幕的代码,如平板和手机适配
- Fragment的生命周期
- 导入import android.app.Fragment; 而不是v4库的
- 在onStart()中先用getView来获取视图，然后在fingViewById来找到子view
```
View view = getView();
        if (view!=null){
            TextView title = (TextView) view.findViewById(R.id.workout_detail_title);
            TextView description = (TextView) view.findViewById(R.id.workout_detail_content);}
```
- fragment不需要在manifest中注册，因为四大组件才需要注册

## 第八章 嵌套片段
- fragment嵌套

## 第九章 动作条
动作条ActonBar已淘汰，推荐ToolBar
Android支持库v4,v7,v13,v17,v21
主题设置
Toobar基本使用。 先将主题设置为禁用ActionBar

```
<style name="AppTheme.NoActionbar">
        <item name="windowActionBar">false</item>
        <item name="windowNoTitle">true</item>
</style>
```

然后在使用的Activity中获取
```
Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
setSupportActionBar(toolbar);
```
toolbar.setTitle设置标题
setNavigationIcon(R.drawable.ic)设置左边返回键
toolbar.setNavigationOnClickListener(new View.OnClickListener()来设置返回键事件

## 第十章 导航抽屉
- 左边侧滑栏

## 第十一章 SQLite数据库
- 数据库的创建和增删改查，升级降级数据库版本

## 第十二章 数据库游标和AsyncTask
- 数据库操作时用异步处理，防止线程阻塞，影响用户流畅度
- 多线程的两种方式，Handler和AsyncTask

## 第十三章 服务
- IntentService

## 第十四章 Material设计

# 总结
总的来说很适合入门，比《第一行代码》更适合，不过内容没有后者多，也不够系统。但内容要有趣多了。所以初学者可以先看《HeadFirstAndroid》，再看《第一行代码》

