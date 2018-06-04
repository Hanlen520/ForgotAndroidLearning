- 多态

- 动态反射

- Java注解

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