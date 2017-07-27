package tech.fuge.www.forgotandroidlearning.base;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lin Zongfu on 2017/6/23.
 * 活动收集器，方便管理活动的工具类
 */

public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity) {
        if (!activities.contains(activity)) {
            activities.add(activity);
        }

    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    /*finish被管理的活动*/
    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

    public static String showAll() {
        StringBuilder sb = new StringBuilder();
        for (Activity a : activities) {
            sb.append(a.getClass().getSimpleName()).append("\n");
        }
        return new String(sb);
    }
}
