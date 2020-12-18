# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
#将以下的代码段添加到  混淆配置文件中
-keep public class * extends android.app.Activity
#保持 Serializable 不被混淆
-keepnames class * implements java.io.Serializable
# 不混淆gson代码
-keep class com.google.gson.* {*;}
# 不混淆医网信所有文件
-dontwarn   cn.org.bjca.**
-keep class cn.org.bjca.*{ *;}
-keep interface cn.org.bjca.*{ *;}