# ForgotHeadFirstAndroid
看Head First Android 做的笔记
<br>
## 第一章 初尝
- Android 平台框架图
- 项目文件结构
- Android Studio 基本使用
- 第一个 "Hello World" 应用
- 创建模拟器，用模拟器调试应用
- 编译、打包、部署和运行
- 在 Android Monitor 查看进度
- string 字符串要在 values 下的 strings.xml 声明，一是方便多语言本地化处理，而是方便后期统一修改管理
- 英文value文件夹是 value-en , 中文是 value-zh
## 第二章 构建交互
- RelativeLayout的各属性应用，如layout_alignLeft , layout_below,layout_alignParentTop
- Spinner的使用,用 getSelectedItem() 来获取当前选项
- arrays.xml的使用  string-array
- List和ArrayList的使用
- StringBuilder的使用
- foreach语句的使用
- Button点击的几种方法：
- xml布局中添加onClick, 匿名内部类方法，Activity中实现OnClickListener接口，自定义内部类方法

## 第三章 活动和意图
- 四大组件需要在AndroidManifest.xml中注册
- Activity的数据传递
- startActivity(intent)时，若没有响应的，会抛出ActivityNotFoundException异常，所以最好先判断是否有响应者，再去执行
- Intent的setAction,setType, putExtra.  MIME类型
- 隐式意图Intent.ACTION_SEND
- AndroidManifest中的<intent-filter使用,<action  <category  <data
- 真机调试
- 选择器的用法，比如一键分享功能可使用 Intent.createChooser(intent,"Share Message...")
没有响应时，则只显示消息，而响应列表为空白（不会奔溃），若隐式意图不用这个的话就可能奔溃了
## 第四章 活动的生命周期

## 第五章 用户界面

## 第六章 列表视图和适配器

