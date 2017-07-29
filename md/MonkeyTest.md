开发 Android 应用，除了写单元测试，还可以用自带的 Monkey 工具进行 UI 自动化测试和脚本测试，本文介绍 UI 自动化测试，而Espresso测试待下一篇介绍。

**Monkey 工具可以发送指定数量的随机事件，帮我们测试应用是否会出现 crash 或 ANR 等 bug，也方便这类 bug 的复现。**

#一、连接测试设备
点击 Terminal 窗口，输入 `adb devices `，可查看当前连接的设备

![Paste_Image.png](http://upload-images.jianshu.io/upload_images/1925935-76545f60ebddb0af.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

若只有一个设备，那再输入 `adb shell `就能进入该设备进行 monkey 测试。
当有多个设备的时候，可以关闭其他设备，或者直接指定设备，如下方是指定了名为 emulator-5554 的设备
`adb -s emulator-5554 shell`
PS：如果实际上当前只有一个设备，但查到有多个offline的状态，这时也是无法monkey测试的，可以选择重启电脑，或者输入以下命令解决，杀掉 adb ，然后重连设备
`adb kill-server`
#二、Monkey工具简单使用
同样在 `Terminal` 中操作，可以先输入 `adb shell` 进入设备再输入 monkey 命令进行测试，也可以每次都输入adb shell monkey 命令进行测试。
如以下两种写法效果是一样的，不过如果先输入 `adb shell` 就会进入到设备的控制台，以后都不用再输 `adb shell` 了， 而退出设备控制台的命令是 `exit` 



![Paste_Image.png](http://upload-images.jianshu.io/upload_images/1925935-bfa77da854226294.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)



![Paste_Image.png](http://upload-images.jianshu.io/upload_images/1925935-409f601f41ab4278.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

##以下开始简单的 monkey 测试##
**最简单的命令**
`adb shell monkey 1000`  发送1000个随机事件，执行后就能看到设备自动操作起来了，这有可能打开设备任意应用来操作，包括一些点击，滑动，各种按键事件，总之跟人手动操作是一样的，只不过操作事件是随机的。



**一般情况下，我们测试的是指定应用，所以需要知道应用的包名**
`adb shell ls data/data`  查看设备安装了哪些应用，将显示应用的包名

![Paste_Image.png](http://upload-images.jianshu.io/upload_images/1925935-58a346ef66503fa3.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

用命令测试一下 calender，顺便在控制台显示操作轨迹，用 -v 
`adb shell monkey -p com.android.calendar -v 1000`


同时测试两个包，并且用 --throttle 100 指定命令执行间隔为 100 ms
`adb shell monkey -p com.android.calendar  -p com.android.calculator2 --throttle 100 -v 1000`

增加一个 -s 数字 记录一个操作轨迹的唯一值，理论上用同一个值的话会执行相同的操作轨迹，可以用来复现 crash 等问题，当然发生 crash 时控制台也会出现一个 seed值，用这个去执行也能复现问题了
`adb shell monkey -p com.android.calculator2 -s 100 -v 1000`

crash 事件复现，比如下图中最后的 seed 0 ， 0就是发生奔溃的 seed 值，我们在 -s 后面的值改为 0 就能复现 crash 了
`adb shell monkey -p com.android.calculator2 -s 0 -v 1000`
![Paste_Image.png](http://upload-images.jianshu.io/upload_images/1925935-e13432ba3f324c6b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

添加一个 `--pct-touch 100` 参数，设置为100%执行应用内点击事件，而不会出现滑动状态栏啊截屏啊按home键等事件
`adb shell monkey -p com.android.calculator2 --pct-touch 100 -v 100`

设置50%点击事件和20%系统按键事件，其余30%为其他事件，并且设置无视 crash 和 ANR 操作超时 ，发生时测试将继续执行
`adb shell monkey  --pct-touch 50 --pct-syskeys 20 --ignore-crashes --ignore-timeouts -v 1000`


**在测试运行时，想要终止测试，按以下步骤**
1、输入 adb shell 进入测试设备
2、输入 ps|grep monkey 获取monkey的进程id
3、输入 kill process_id  来终结 monkey 进程，如下图第一个就是

![](http://upload-images.jianshu.io/upload_images/1925935-ec20588eff168727.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

#三、Monkey 命令小结
`monkey`  查看所有 monkey 命令
`monkey 1000`  直接发1000个随机事件
`monkey -v 1000`  增加Terminal对操作轨迹的显示
`monkey --throttle 1000`  指定事件之间间隔，当前设置为1000ms
`monkey -p com.android.calculator2`  指定要运行的包名
`monkey -s 10` 指定一个随机事件序列的id，下次再用同样的id去执行，可以复现问题
`monkey --pct-touch 100` 设置100%执行点击事件，不执行上下滑，旋转等其他操作
`monkey --ignore-crashes`  忽略异常，继续跑
`monkey --ignore-timeouts` 忽略超时，继续跑

#四、常用 adb 命令
进入设备： `adb shell`
进入指定设备： `adb -s 设备名 shell `
安装软件：  `adb shell install apk名字`
杀掉： `adb  adb kill-server`
启动： `adb  adb start-server`
终止 Terminal 执行：`Ctrl+C`
清空 Terminal 历史：` cls`
从 adb 命令窗口退回 CMD：  `exit `

附上官方的 monkey 测试介绍网页
https://developer.android.google.cn/studio/test/monkey.html

至此Monkey的基本使用介绍完毕，但只能进行一些随机事件操作，如果我们想测试 APP 某些指定的操作的话（比如注册登录），就要自己写测试脚本了
下一篇将介绍 Espresso 脚本来写指定测试操作步骤

**请尊重他人劳动，转载注明出处，谢谢**