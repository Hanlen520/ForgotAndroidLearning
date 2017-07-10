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