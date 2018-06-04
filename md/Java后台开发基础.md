- 多态

- 动态反射
- [依赖注入](#依赖注入)
- Java注解

- [Web知识](#Web知识)
- [数据库知识](数据库知识.md)

常用注解：
@IntRange 注解可以验证整型或长整型参数值是否位于指定范围内。下面的示例可以确保 alpha 参数包含 0 至 255 范围内的整数值：
public void setAlpha(@IntRange(from=0,to=255) int alpha) { … }
@FloatRange 注解可以检查浮点或双整型参数值是否位于指定的浮点值范围内。下面的示例可以确保 alpha 参数包含 0.0 至 1.0 的浮点值：
public void setAlpha(@FloatRange(from=0.0, to=1.0) float alpha) {...}

@Size 注解可以检查集合或数组的大小，以及字符串的长度。@Size 注解可用于验证以下质量：
最小大小（例如 @Size(min=2)）
最大大小（例如 @Size(max=2)）
确切大小（例如 @Size(2)）
表示大小必须为此倍数的数字（例如 @Size(multiple=2)）
线程注解
线程注解可以检查某个方法是否从特定类型的线程调用。支持以下线程注解：
@MainThread
@UiThread
@WorkerThread
@BinderThread
@AnyThread
public abstract void setTitle(@StringRes int resId) { … }

添加 @Nullable 和 @NonNull 注解，以检查给定变量、参数或返回值的 nullness。@Nullable 注解指示可以为 null 的变量、参数或返回值，而 @NonNull 则指示不可为 null 的变量、参数或返回值。

## 依赖注入
依赖注入相关概念
依赖(Dependency)：如果在 Class A 中，有个属性是 Class B 的实例，则称 Class B 是 Class A 的依赖，本文中我们将 Class A 称为宿主(Host)，并且全文用 Host 表示；Class B 称为依赖(Dependency)，并且全文用 Dependency 表示。一个 Host 可能是另外一个类的 Dependency。
宿主(Host)：如果 Class B 是 Class A 的 Dependency，则称 Class A 是 Class B 的宿主(Host)。
依赖注入：如果 Class B 是 Class A 的 Dependency，B 的赋值不是写死在了类或构造函数中，而是通过构造函数或其他函数的参数传入，这种赋值方式我们称之为依赖注入。

依赖注入
###1. 依赖 如果在 Class A 中，有 Class B 的实例，则称 Class A 对 Class B 有一个依赖。例如下面类 Human 中用到一个 Father 对象，我们就说类 Human 对类 Father 有一个依赖。
public class Human {
    ...
    Father father;
    ...
    public Human() {
        father = new Father();
    }
}
仔细看这段代码我们会发现存在一些问题：
(1). 如果现在要改变 father 生成方式，如需要用new Father(String name)初始化 father，需要修改 Human 代码；
(2). 如果想测试不同 Father 对象对 Human 的影响很困难，因为 father 的初始化被写死在了 Human 的构造函数中；
(3). 如果new Father()过程非常缓慢，单测时我们希望用已经初始化好的 father 对象 Mock 掉这个过程也很困难。
###2. 依赖注入 上面将依赖在构造函数中直接初始化是一种 Hard init 方式，弊端在于两个类不够独立，不方便测试。我们还有另外一种 Init 方式，如下：
public class Human {
    ...
    Father father;
    ...
    public Human(Father father) {
        this.father = father;
    }
}
上面代码中，我们将 father 对象作为构造函数的一个参数传入。在调用 Human 的构造方法之前外部就已经初始化好了 Father 对象。像这种非自己主动初始化依赖，而通过外部来传入依赖的方式，我们就称为依赖注入。
现在我们发现上面 1 中存在的两个问题都很好解决了，简单的说依赖注入主要有两个好处：
(1). 解耦，将依赖之间解耦。
(2). 因为已经解耦，所以方便做单元测试，尤其是 Mock 测试。
###3. Java 中的依赖注入
依赖注入的实现有多种途径，而在 Java 中，使用注解是最常用的。通过在字段的声明前添加 @Inject 注解进行标记，来实现依赖对象的自动注入。
public class Human {
    ...
    @Inject Father father;
    ...
    public Human() {
    }
}
上面这段代码看起来很神奇：只是增加了一个注解，Father 对象就能自动注入了？这个注入过程是怎么完成的？
实质上，如果你只是写了一个 @Inject 注解，Father 并不会被自动注入。你还需要使用一个依赖注入框架，并进行简单的配置。现在 Java 语言中较流行的依赖注入框架有 Google Guice、Spring 等，而在 Android 上比较流行的有 RoboGuice、Dagger等。其中 Dagger 是我现在正在项目中使用的。如果感兴趣，你可以到 Dagger 实现原理解析 了解更多依赖注入和 Dagger 实现原理相关信息。

## Web知识
- REST -- REpresentational State Transfer
（看Url就知道要什么
看http method就知道干什么
看http status  code就知道结果如何）
首先，之所以晦涩是因为前面主语被去掉了，全称是 Resource Representational State Transfer
资源表现层状态转移


