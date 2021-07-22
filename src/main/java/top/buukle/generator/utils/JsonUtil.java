package top.buukle.generator.utils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/5.
 * @Description :
 */
public class JsonUtil {

    private static Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);

    private static ObjectMapper mapper = new ObjectMapper();

    public static<T> T parseFromObject(String str,Class<T> clazz) {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (json, typeOfT, context) -> new Date(json.getAsJsonPrimitive().getAsLong()));
        Gson gson = builder.create();
        return gson.fromJson(str,clazz);
    }

    public static<T> List<T> parseArray(String object, Class<T> clazz) {
        JavaType javaType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, clazz);
        try {
             return mapper.readValue(object, javaType);
        } catch (IOException e) {
            LOGGER.error("parseArray 解析失败!");
            e.printStackTrace();
            return null;
        }
    }

    public static String toJSONString(Object obj) {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new DateSerializer()).setDateFormat(DateFormat.LONG);
        Gson gson = builder.create();
        return gson.toJson(obj);
    }

    public static class DateSerializer implements JsonSerializer<Date> {
        public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src.getTime());
        }
    }

//    public static void main(String[] args) {
//
//        System.out.println(toJSONString(new Date()));
//
//    }
}
