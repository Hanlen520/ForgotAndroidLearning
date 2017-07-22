## 开发中遇到的Android问题整理

## Exceptions
- android:allowBackup="true"  有风险，连接数据线可恢复备份数据，应该设置为false
  作为一个jar库，不要设置allowback属性

- Android - Error:Execution failed for task ':app:mergeDebugResources'
  <br>这是因为.9图不规范所致，最好删除不规范的.9图，重新制作,或者再build.gradle中添加如下两句，让IDE不去严格检查png图
  <br>aaptOptions.cruncherEnabled = false
  <br>aaptOptions.useNewCruncher = false
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

- 使用Parcelable时报错
  Parcel android.os.Parcel@9574c5: Unmarshalling unknown type code'
  原因在Create部分代码
```
  Person person = new Person(in);
  public static final Creator<Person> CREATOR = new Creator<Person>() {
          @Override
          public Person createFromParcel(Parcel in) {
              Person person = new Person();

              //注意不要写成下面的
  //            Person person = new Person(in);
              person.id = in.readInt();
              person.name = in.readString();
              return person;
  //            return new Person(in);
          }
```
-数据库更改数据时报错（Too many bind arguments.  2 arguments were provided but the statement needs 1 arguments.）
 <br>在Where字段中缺少了+ " = ?"
 正确写法：db.update(table, values, whereClause + "=?", whereArgs);




## Others
- apk经常装到一般就失败error，可能是连接的口有问题，电脑换一个USB口试试
- 查看log的额外方法 /Users/<user>/Library/Logs/AndroidStudio2.2/
- EditText挡住ListView的问题，在Manifest中设置Activity属性 android:windowSoftInputMode="stateAlwaysHidden|adjustPan"