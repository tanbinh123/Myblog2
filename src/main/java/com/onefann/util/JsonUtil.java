package com.onefann.util;


import com.alibaba.fastjson.JSON;

/**
 * Created by one_fann on 2017/11/1.
 */
public class JsonUtil {
//    public static String toJson(Object o) {
//        GsonBuilder gsonBuilder = new GsonBuilder();
//        gsonBuilder.setPrettyPrinting();
//        Gson gson = gsonBuilder.create();
//        return gson.toJson(o);
//    }
    public static String toJson(Object o) {
        return JSON.toJSONString(o);
    }
}
