
# ADB使用技巧
## 最全的在官网 https://developer.android.com/studio/command-line/adb
- adb //查看帮助信息
- adb version //查看adb 版本信息
- adb devices //查看连接的设备
- adb devices -l //查看设备的详细信息
- control+d  //退出adb , 或control+c
- adb install apkPath  //安装电脑上的apk到手机上
- adb uninstall package.name //根据包名卸载手机上的apk

- adb push pcPath phonePath  //推送电脑文件到手机上
- adb pull phonePath pcPath //拉取手机文件到电脑上
- adb logcat //查看设备的日志
- adb bugreport生成adb出错报告

- adb tcpip 5555 //让设备监听5555端口，方便wifi调试
- adb connect device_ip_address //连接设备,如192.168.0.11,不一定能连上, 一定要在同一局域网

- adb kill-server //杀死adb服务
- adb start-server //启动adb服务

- adb shell //进入adb（当只有一个设备连接时）
- adb shell command //运行各种shell指令
- adb shell wm //查看有哪些可用的wm命令
- adb shell wm size  //查看当前连接设备的屏幕分辨率
- adb shell wm density //查看设备的dpi
- adb shell date // 打印或设置当前系统时间
- adb shell cat /proc/meminfo // 查看内存信息
- adb shell cat /proc/cpuinfo // 查看CPU信息 


## Monkey测试
- adb shell monkey  // 使用monkey测试