# Android第三方库使用集锦
放第三方库的简单应用。 包括导入包的方法还有简单用法


- [RxJava](#RxJava)
## [Lottie 动画库](https://github.com/airbnb/lottie-android)
*支持AE导出的json动画*
### 使用方法

1.添加依赖
```
dependencies {
    compile 'com.airbnb.android:lottie:2.1.0'
  }
```
2.在xml中声明或在java使用
json动画文件放在assets文件夹下
```
<com.airbnb.lottie.LottieAnimationView
           android:id="@+id/animation_view"
           android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           app:lottie_fileName="hello-world.json"
           app:lottie_loop="true"
           app:lottie_autoPlay="true" />
```
```
LottieAnimationView animationView = (LottieAnimationView) findViewById(R.id.animation_view);
animationView.setAnimation("hello-world.json");
animationView.loop(true);
animationView.playAnimation();
```
json放在assets/images子文件夹也行
```
<com.airbnb.lottie.LottieAnimationView
        android:id="@+id/animation_view2"
        android:layout_width="80dp"
        android:layout_height="80dp"
        android:background="@color/colorAccent"
        app:lottie_fileName="anim2.json"
        app:lottie_imageAssetsFolder="images"
        app:lottie_autoPlay="true"
        app:lottie_loop="true"
       />
```
直接引用子文件夹路径
```
<com.airbnb.lottie.LottieAnimationView
        android:id="@+id/animation_view2"
        android:layout_width="80dp"
        android:layout_height="80dp"
        android:background="@color/colorAccent"
        app:lottie_fileName="images/anim2.json"
        app:lottie_autoPlay="true"
        app:lottie_loop="true"
       />
```
```
 LottieAnimationView animationView4 = (LottieAnimationView) findViewById(R.id.animation_view4);
        animationView4.loop(true);
        animationView4.setAnimation("images/anim2.json");
        animationView4.playAnimation();
```
### 制作json动画
1. 安装Adobe AE CC 2017版本
2. 安装ZXP installer  一个AE插件与脚本安装工具
3. 安装bodymovin   一个将AE合成转换为记录动画信息的JSON文件的插件
4. 打开AE,制作动画,再用bodymovin插件转换为json格式文件
5. 把json文件放到Android项目中使用


## ButterKnife 依赖注入减少findViewById工作量


## OkHttp 网络请求库，替代HttpURLConnection


## Retrofit OkHttp的封装


## Fresco 图片加载，多级缓存

## Gson

## FastJson 阿里巴巴的fastjson  进行json解析

## Picasso  图片缓存框架


## RxJava 实现异步解耦合


## EventBus 事件总线解除消息耦合

## LeakCanary 检测内存泄漏

## Glide 万能的图片加载库

## greendao  OrmLite 数据库处理

## Realm 数据库
realm使用配置：
根目录下的build.gradle:
buildscript {
    repositories {
        maven {
            url 'http://oss.jfrog.org/artifactory/oss-snapshot-local'
        }
    }
    dependencies {
        classpath "io.realm:realm-gradle-plugin:3.3.1"
    }
}
allprojects {
    repositories {
        maven {
            url 'http://oss.jfrog.org/artifactory/oss-snapshot-local'
        }
    }
}
然后在app的build.gradle下：
顶部添加
apply plugin: 'realm-android'



## tetho fackbook的调试工具，配合OkHttp进行网络请求调试，对db, sharepreference进行查看修改


## MPAndroidChart 一个强大的制作图表的开源库，支持 线图、饼状图、雷达图、气泡图等


##  flexbox-layout ，类似瀑布流布局

## RxJava
Observable.just(1, 2, 3, 4) // IO 线程，由 subscribeOn() 指定
    .subscribeOn(Schedulers.io())
    .observeOn(Schedulers.newThread())
    .map(mapOperator) // 新线程，由 observeOn() 指定
    .observeOn(Schedulers.io())
    .map(mapOperator2) // IO 线程，由 observeOn() 指定
    .observeOn(AndroidSchedulers.mainThread) 
    .subscribe(subscriber);  // Android 主线程，由 observeOn() 指定
如上，通过 observeOn() 的多次调用，程序实现了线程的多次切换。