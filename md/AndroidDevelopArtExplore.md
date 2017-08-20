# 《Android开发艺术探索》 任玉刚

## 第1章 Activity的生命周期和启动模式
- Activity的生命周期全面分析，onStart()和onStop()表示前台，而onResume()和onPause()表示可见
- Activity的启动模式，TaskAffinity和allowTaskReparenting. Activity的Flags
- IntentFilter的匹配规则。action，category，data. Schema,Host,Port

## 第2章 IPC机制
- Android IPC简介。 Inter Process Communication
- Android中的主线程又称为UI线程，只能在UI线程操作界面元素。耗时操作放在其他线程中执行，否则易引起ANR响应超时
- Android中的多进程模式。 开启多进程模式，运行机制，存在的问题
- IPC基本概念介绍。Serializable接口，Parcelable接口，Binder
- Android中的IPC机制。 Bundle，文件共享，Messenger,使用AIDL,使用socket

## 第10章 Android的消息机制
- Android的消息机制
- 主线程的消息循环

## 第11章 Android的线程和线程池
- Android中的线程池,ThreadPoolExecutor
-
## 第12章 Bitmap的加载和Cache

## 第13章 综合技术

## 第14章 JNI和NDK编程

## 第15章 Android性能优化
- 布局优化。使用include，merge 和 ViewStub标签
- 绘制优化。一般用LinearLayout和FrameLayout，多层嵌套麻烦时用RelativeLayout
- 内存泄漏优化。 静态变量持有导致的，单例模式持有导致的，动画没释放导致的。
- 线程优化。尽量用线程池，防止创建过多的线程