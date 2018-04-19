# Kotlin学习
自google官方支持以来，Kotlin已经开始很多项目在用了，故与时俱进学习之。


## 空安全
Kotlin引入了空安全的概念，并在编译时开展对象是否为空的校验。相关的操作符说明概括如下：
1、声明对象实例时，在类型名称后面加问号，表示该对象可以为空；
2、调用对象方法时，在实例名称后面加问号，表示一旦实例为空就返回null；
3、新引入运算符“?:”，一旦实例为空就返回该运算符右边的表达式；
4、新引入运算符“!!”，通知编译器不做非空校验，运行时一旦发现实例为空就扔出异常；


1.lateinit 和 lazy 是 Kotlin 中的两种不同的延迟初始化技术。
*lateinit 只用于 var，而 lazy 只用于 val *lazy 应用于单例模式(if-null-then-init-else-return)，而且当且仅当变量被第一次调用的时候，委托方法才会执行。 *lateinit 则用于只能生命周期流程中进行获取或者初始化的变量，比如 Android 的 onCreate()

## 构造函数
在 Kotlin 中的一个类可以有一个主构造函数和一个或多个次构造函数。主构造函数是类头的一部分：它跟在类名（和可选的类型参数）后。

## Companion
Companion Objects中定义的成员类似于Java中的静态成员，因为Kotlin中没有static成员
object 可以定义在全局也可以在类的内部使用
object 就是单例模式的化身
object 可以实现 Java 中的匿名类
companion object 就是 Java 中的 static 变量
companion object 只能定义在对应的类中

## data
在 Kotlin 裡面，只要在 class 的前面加上 data 這個關鍵字，你的class就會自動升級為 data class，在變成所謂的 data class之後，Kotlin 的 compiler 便會根據你的 properties 自動幫你 override 掉原先的equals()/hashCode()/toString()這三個 method(當然如果你有自己的規則也是可以自己實作)，並且幫你生成相對應的 getter and setter 以及 copy() 
如
data class User(val name: String, var age: Int)

## val 
 =常數 = 僅提供 getter 

## var 
= 變數 = 提供 getter and setter 