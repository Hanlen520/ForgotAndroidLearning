## 开发中遇到的Android问题整理

## Exceptions
- Android Studio 3 Gradle插件报错：AAPT2 error: check logs for details
Android的Gradle 3.0插件默认启动Aapt2，目的是为了改进增量资源的处理。
如果有问题可以退回到之前的版本，打开gradle.properties，添加如下内容
android.enableAapt2=false

- Android: android.content.res.Resources$NotFoundException: String resource ID #0x5
问题可能出在setText()， 因里面的值不是字符串

- android 串口 提示没有权限读写权限
  看一下是不是选错了串口，要选择ttyS01234 ,而不是ttyGS1

- 网络请求报错 Illegal character in query at index 153
  因为存在空格导致？替换为%20
  url.replaceAll(" ","%20");

- 报错Error:Execution failed for task ':app:compileDebugJavaWithJavac'.
  > Compilation failed; see the compiler error output for details.
  解决：找到AndroidStudio右下角的 其中有一个叫GradleConsole,打开之后,会显示本次Gradle编译所有的问题

- Error:(1, 0) Your project path contains non-ASCII characters.
  一般时工程项目路径或者项目名称包含了中文，修改相关的名称就好了！
  别再项目路径名称中去搞另类弄什么中文名

- Error:Execution failed for task ':app:mergeDebugResources'. > Error: java.util.concurrent.ExecutionE
  下面分析一下出现这个问题时的几种情况：
  1、直接在AS中将jpg图片改成png为后缀的图片，所以导致了这种情况的发生
  2、一些点9图不规范，AS中点9图必须四边全部描黑点，而这在eclipse中就比较松懈。所以修改相应的图片就行！
  （直接把.9后缀去掉 测试能运行了 就说明是第二种情况所致）

- com.android.support 包冲突问题
在gradle中设置
configurations.all {
    resolutionStrategy.eachDependency { DependencyResolveDetails details ->
        def requested = details.requested
        if (requested.group == 'com.android.support') {
            if (!requested.name.startsWith("multidex")) {
                details.useVersion '27.0.2'//此处为你需要的版本
            }
        }
    }
}

- Android - Error:Execution failed for task ':app:mergeDebugResources'
  <br>这是因为.9图不规范所致，最好删除不规范的.9图，重新制作,或者再build.gradle中添加如下两句，让IDE不去严格检查png图
  <br>aaptOptions.cruncherEnabled = false
  <br>aaptOptions.useNewCruncher = false

- xml布局报错：The following classes could not be found: - ImageView (Change to android.widget.ImageView, Fix Build Path, Edit XML).
  这问题害的我花了半天时间下载api16，最后发现是一个test.png图片的命名问题了
  更改.9图命名（去掉.9，因为as对.9要求严格，不像eclipse）或标准样式

- android打包提示 checkReleaseBuilds false
  解决办法，在build.gradle里面的buildTypes同级添加如下代码，放在android下面
  lintOptions {
      checkReleaseBuilds false
      abortOnError false
  }

- E/AndroidRuntime(3257): java.lang.RuntimeException: Unable to start activity ComponentInfo{com.example.multbuttontest/com.example.multbuttontest.MultiButtonActivity}: android.view.InflateException: Binary XML file line #16: Error inflating class button
  <br>重点是后面的XML fileline#16 Button
  结果发现是Button的样式，用到的drawable文件，但该文件放错目录了，放在了drawable(hdpi)下，应该放在drawable文件夹的
  这种xml属性文件，应该复制在drawable根文件夹

- 新导入工程时，Error:(46, 0) Could not find method android() for arguments [build_7dhplpj96vqq8rmjgj0gq754l$_run_closure3@5a677175] on root project
<br>检查Setting的gradle设置，选择Use default 而不是local
然后修改root project的build.gradle文件设置，去掉所有buildTools设置，添加
         compileSdkVersion 25
         buildToolsVersion '25.0.2'

- xml布局突然不能预览了，报错如下
  preview timed out while rendering the layout infinite loop or unbounded
  <br>尝试操作： File > Invalidate Caches / Restart...

- 加载网页时提示错误：net::ERR_CACHE_MISS
  <br>因为没有设置网络权限
  <uses-permission android:name="android.permission.INTERNET" />
  注意：直接用内置浏览器打开时又不会报错，那是因为调用的是手机自带浏览器，而不是你自己应用中的webView。 自己应用中的webView需要设置INTERNET权限才能访问网络


- startActivity没有成功跳转，查看日志，是否AndroidManifest中没有声明Activity
- E/BufferQueue: [com.uma.switcher/com.uma.switcher.background.activity.BackgroundMainActivity] dequeueBuffer: can't dequeue multiple buffers without setting the buffer count
- java.lang.IllegalThreadStateException: Thread already started
  <br>不能重复start同一个线程, 可以重开新线程,或者使用下面的方法
  if (thread.getState() == Thread.State.NEW){
  thread.start();}
- Error:(6, 8) error: Attempt to recreate a file for type io.realm.AdvertisementInfoRealmProxyInterface
  <br>在别的文件夹中有一样名字的bean类，删除一个即可
- INSTALL_FAILED_NO_MATCHING_ABIS is when you are trying to install an app that has native libraries and it doesn't have a native library for your cpu architecture. For example if you compiled an app for armv7 and are trying to install it on an emulator that uses the Intel architecture instead it will not work.
<br>虚拟机安装应用失败,INSTALL_FAILED_NO_MATCHING_ABIS,是因为native库不适配虚拟机
- 使用adb命令时
  adb opendir failed, Permission denied
  执行 adb root shell来进入
  exit退出adb
  如迁移系统文件夹数据
  adb root pull /data/data/tech.fuge.www.forgotfirstlinecode/files C:\Users\forgot\Desktop
  ？？？有问题 倒不出

- .Error:Execution failed for task ':app:transformResourcesWithMergeJavaResForDebug'.
  com.android.build.api.transform.TransformException: com.android.builder.packaging.DuplicateFileException: Duplicate files copied in APK META-INF/rxjava.properties
      File1: C:\Users\forgot\.gradle\caches\modules-2\files-2.1\io.reactivex.rxjava2\rxjava\2.1.0\2fdf84dedcaaeabb9d70cde9dbb8aad4eccb80a1\rxjava-2.1.0.jar
      File2: C:\Users\forgot\.gradle\caches\modules-2\files-2.1\io.reactivex\rxjava\1.1.1\b494968f6050d494de55dc3ce005e59c7eb40012\rxjava-1.1.1.jar
  <br>找到相应目录，删除重复文件即可

- MQTT报错
  java.lang.SecurityException: SHA-256 digest error for org/eclipse/paho/client/mqttv3/internal/ClientState.class
  暂停AS的Instant Run即可

- java.lang.IllegalStateException: Couldn't read row 0, col -1 from CursorWind
  数据库问题，看selectArgs那里是不是没有某个字段
  


-数据库更改数据时报错（Too many bind arguments.  2 arguments were provided but the statement needs 1 arguments.）
 <br>在Where字段中缺少了+ " = ?"
 正确写法：db.update(table, values, whereClause + "=?", whereArgs);

- 旧项目使用的apache网络请求过期了，需要在gradle设置 android｛最后加入以下行｝
  useLibrary 'org.apache.http.legacy'


- WindowManager$BadTokenException: Unable to add window -- token null is not for an application
<br>导致报这个错是在于new AlertDialog.Builder(mcontext)，虽然这里的参数是AlertDialog.Builder(Context context)但我们不能使用getApplicationContext()获得的Context,而必须使用Activity,因为只有一个Activity才能添加一个窗体。 



- java.lang.RuntimeException: Can't create handler inside thread that has not called Looper.prepare()
  Handler若在子线程中运行的话，需要先Looper.prepare()



## Others
- android:allowBackup="true"  有风险，连接数据线可恢复备份数据，应该设置为false. 
  作为一个jar库，不要设置allowback属性
- apk经常装到一半就失败error，可能是连接的口有问题，电脑换一个USB口试试（最后我是加一个USB扩展器才解决了）
- 查看log的额外方法 /Users/<user>/Library/Logs/AndroidStudio2.2/
- EditText挡住ListView的问题，在Manifest中设置Activity属性 android:windowSoftInputMode="stateAlwaysHidden|adjustPan"
- 微信支付调起失败，错误码-1 ， 签名与微信后台记录的不对
