#Android编程权威指南
读书笔记,主要做知识积累，查漏补缺用

##第1章 Android开发初体验
- 注意xml中控件命名时，android:id属性前有一个+标志，而android:text则没有，
因为我们在创建资源id，而对字符串资源只是做引用

##第2章 Android与MVC设计模式
- 在Android的世界里，控制器通常是Activity、Fragment或Service的一个子类

##第3章 Activity的生命周期
- 可分为完整生命周期、可见生命周期和前台生命周期
- 千万不要自己去调用生命周期的方法，这与执行普通方法没区别，并不会使生命周期重新走一遍，
但可能会引起生命周期其他问题发生？
- @Override注解，保证是方法覆盖，若拼写错误会发出警告

##第4章 Android应用的调试
- 异常处理与栈跟踪
- 断点调试
- 使用异常断点
- Android Lint工具使用

##第5章 第二个Activity
- Activity之间的数据传递
- 序列化parcelable和serializable，Android中建议中parcelable，Serializable在序列化的时候会产生大量的临时变量，
从而引起频繁的GC。Parcelable不能使用在要将数据存储在磁盘上的情况，此时要用serializable。
- 显示Intent和隐式Intent
- 数据返回，调用startActivityForResult

##第6章 Android SDK版本与兼容
- SDK最低版本，最低兼容版本，当前建议4.0或4.2
- SDK目标版本 ， 大多情况下，目标版本即最新发布的Android版本, 除非最新版有兼容问题
- 编译版本,最佳选择为最新的API级别

##第7章 UI fragment与fragment管理器
- 放弃使用v4库中的fragment，而要使用app包下的fragment

##第8章 使用布局与组件创建用户界面
##第9章
##第10章
##第11章
##第12章
##第13章
##第14章
##第15章
##第16章
##第17章
##第18章
##第19章
##第20章
##第21章
##第22章
##第23章
##第24章
##第25章
##第26章
##第27章
##第28章
##第29章
##第30章
##第31章
##第32章
##第33章
##第34章

