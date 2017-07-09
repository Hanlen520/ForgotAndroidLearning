## 《Android群英传》
*总结，归纳，演绎。学习者->创造者*
理清知识点之间的联系，综合来认识和理解

## 第1章 Android体系与系统架构
- 谷歌生态系统。
- Android系统架构
- Android App 组件架构。 四大组件
- Android系统源代码目录与系统目录

## 第2章 Android开发工具新接触
- Android开发IDE介绍
- AndroidStudio高级使用技巧
- ADB命令使用技巧。 安装卸载软件，导入导出文件。
- 模拟器使用与配置。Genymotion

## 第3章 Android控件架构与自定义控件详解
- Android控件架构 ViewGroup和View。 ViewGroup作为父控件可以包含多个View，并管理其包含的View控件
- View的测量。
  - EXACTLY:指定dp或是match_parent
  - AT_MOST:wrap_content
  - UNSPECIFIED: 通常自定义View时使用
- View的绘制。onDraw(),Canvas,Paint
- ViewGroup的测量。 在自定义ViewGroup时，通常会去重写onLayout()方法来控制其子View显示位置的逻辑
- ViewGroup的绘制。通常不需要绘制。使用dispatchDraw()方法来绘制其子View
- 自定义View。
  - 对现有控件进行拓展
  - 通过组合来实现新的控件
  - 重写View来实现全新的控件
- 常用回调方法。onFinishInflaste(),onSizeChanged(),onMeasure(),onLayout(),onTouchEvent()
- 自定义ViewGroup
- 事件拦截机制分析。dispatchTouchEvent(),onInterceptTouchEvent(),onTouchEvent()。 onTouchEvent()优先与onClick执行，且如果onTouchEvent()消费事件后返回true，那么onClick也就无法执行了

## 第4章