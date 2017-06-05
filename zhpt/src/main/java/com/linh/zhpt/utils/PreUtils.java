package com.linh.zhpt.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ASUS on 2017/5/14.
 * SharePreference封装
 */

public class PreUtils {

    private final static String mPreConfig = "config";

    public static boolean getBoolean(Context ctx,String key,boolean defValue){
        SharedPreferences sp = ctx.getSharedPreferences(mPreConfig,Context.MODE_PRIVATE);
        return sp.getBoolean(key,defValue);
    }

    public static void setBoolean(Context ctx,String key,boolean value){
        SharedPreferences sp = ctx.getSharedPreferences(mPreConfig,Context.MODE_PRIVATE);
         sp.edit().putBoolean(key,value).commit();
    }

    public static String getString(Context ctx,String key,String defValue){
        SharedPreferences sp = ctx.getSharedPreferences(mPreConfig,Context.MODE_PRIVATE);
        return sp.getString(key,defValue);
    }

    public static void setString(Context ctx,String key,String value){
        SharedPreferences sp = ctx.getSharedPreferences(mPreConfig,Context.MODE_PRIVATE);
        sp.edit().putString(key,value).commit();
    }

    public static int getInt(Context ctx,String key,int defValue){
        SharedPreferences sp = ctx.getSharedPreferences(mPreConfig,Context.MODE_PRIVATE);
        return sp.getInt(key,defValue);
    }

    public static void setBoolean(Context ctx,String key,int value){
        SharedPreferences sp = ctx.getSharedPreferences(mPreConfig,Context.MODE_PRIVATE);
        sp.edit().putInt(key,value).commit();
    }
}
