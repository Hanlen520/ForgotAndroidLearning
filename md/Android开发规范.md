# Android 开发规范
# 一、 命名规范（尽量用英文名）
## (一) res 文件命名规范
1. anim 资源命名

2. animation 资源命名

3. color 资源命名
颜色参考这里，取3-6种主颜色，色值分10个阶梯
https://material.io/design/color/the-color-system.html#tools-for-picking-colors

4. drawable 资源命名规范
0. `前缀_大模块名_元素名_状态值`
1. 前缀分为 ic (表示有点击事件的图标） ， bg (背景) ，img(无事件的图片)
2. 大模块名分为：sing, shop , social , encore 等等
3. 元素名如：start,stop 等等
4. 状态值，默认不带；点击变化的状态为 pressed , 获得焦点为 focused 

***例子：*** 
- ic_sing_start 表示欢唱界面 开始图标
- ic_sing_start_pressed 表示欢唱界面 开始图标 ,点击后变化的状态
- bg_sing_start 表示欢唱界面 开始图标的背景图
- img_wallet_pig 表示我的钱包 猪图片，没有点击事件，纯静态

### button和text点击变化的selector命名
1. `前缀_常态颜色_to_按压状态颜色_其他`
2. 前缀为 btn ， txt ， bg (表示单一背景)
3. 颜色如 white , blue 等等
4. 其他字段，如数字或形状等
5. `bg_color_gradient_其他` 表示渐变色的背景

***例子：***
- btn_white_to_blue，     表示按钮背景常态白色，点击切换到蓝色
- btn_white_to_blue02，   同上，可能蓝色值不同
- btn_white_to_blue_circle，  同上，按钮背景圆形
- btn_white_to_blue_solid ，  同上，按钮背景加描边
- txt_blue_to_white，     文字颜色，从蓝色变白色
- bg_blue_gradient 渐变的蓝色背景

5. layout 命名规范
- 总则。全部小写字母，单词间用 _ 隔开，方便看词生义
- 格式：`资源缩写_所属layout简名_所属区域名_其他`
- 资源缩写，如Button缩写为btn , TextView缩写tv,LinearLayout缩写ll
- 所属layout简名，在不影响理解和不怕重复的情况下精简，如activity_account.xml的简名为account, item_favorite.xml仍为item_favorite，否则会与favorite重复
- 所属区域名 ， 如title, content , name , pwd 

***例子：***
- iv_account_avatar，表示activity_account.xml中的头像图片ImageView
- btn_account_record，表示activity_account.xml中的录音按钮Button

6. menu 命名规范

7. mipmap 命名规范

8. value 命名规范
- array 命名规范
- attrs 命名规范
- colors 命名规范
- dimen 资源命名规范
- strings 命名规范
- style 命名规范
命名例如
<dimen name="size_160">160dp</dimen>
<dimen name="font_16">16sp</dimen>
字体大小参考这里
https://material.io/design/typography/the-type-system.html#type-scale
存放字体style 增加复用，如
<style name="TextStyle">
    <item name="android:textSize">@dimen/font_24</item>
    <item name="android:textColor">@color/light_black</item>
</style>

9. xml 命名规范



  ● 所有 VO，DO 只能保存在 Presenter 层内，View 层最多只能保存 VO 的引用！（另外要注意，Adapter 应当放在 Presenter 层内）
  ● View 层不能接触 Model 层的任何数据和接口！
  ● 页面跳转 放到 Presenter 层中。
  ● View 和 Presenter 之间是双向依赖，所以通过接口解藕，便于进行 UI Mock 测试，而 Presenter 和 Model 是单向依赖，可以直接编写单元测试来测试 Model。
  
## (二) Java 文件命名规范
## 类和方法，变量命名
0. 参考本目录下的阿里Java开发命名规范，（阿里巴巴Java开发手册（详尽版）.pdf）
1. 类名用大驼峰命名法，应该是一个如"形容词+名词"，如 SingActivity
2. 方法和名用小驼峰法，应该是一个"动词+形容词/名词"，如getSingerName
3. 变量/对象名用小驼峰法，应该是"形容词+名词",如singerName
4. 接口命名，I开头 ， 如ILogin
5. 接口实现命名，Impl结尾，如LoginImpl

- 成员变量命名前面加m，如User的成员变量为mUser

## (三) 项目命名参照表
1. 通用
- cur 当前这个
- pre 上一个
- next 下一个
- first 第一个
- last 最后一个

2. 项目
- APP名字-已未智家

# 二、 项目结构
项目先按模块来划分，在模块内再按MVP架构来划分文件夹
如下
```
-login  登录模块
 |-model
 |-presenter
 |-view
 |-adapter
-main  主页模块
 |-model
 |-presenter
 |-view
 |-adapter
-scene 情景模块
...
```