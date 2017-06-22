#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_tech_fuge_www_forgotheadfirstandroid_activity_NativeActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++,再测试一下Freeline";
    return env->NewStringUTF(hello.c_str());
}
