package com.autobid.util;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Description;

import java.io.IOException;
import java.util.Iterator;

/**
 * 实体类和JSON对象之间相互转化（依赖包jackson-all-1.7.6.jar、jsoup-1.5.2.jar）
 * @author Richard Zeng
 *
 */
public class JSONUtil {

/*     * @Method: JSONToObj
     * @Description: JSON String convert to entity object
     * @Param: [jsonStr, obj]
     * @Return: java.lang.Object
     * @Date: 18/1/14 下午5:28*/

    public static <T> Object JSONToObj(String jsonStr, Class<T> obj) {
        T t = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            t = objectMapper.readValue(jsonStr,
                    obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public static JSONObject transFirstLowerObj(JSONObject jsonObj) {
        JSONObject resultObj=new JSONObject();
        Iterator it = jsonObj.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            String transKey = (new StringBuilder()).append(Character.toLowerCase(key.charAt(0))).append(
                    key.substring(1)).toString();
            //Object object = jsonObj.get(key);
            resultObj.put(transKey,jsonObj.get(key));
            //resultObj.accumulate(transKey, jsonObj.get(key));

        }
        return resultObj;
    }


/*     * @Method: objectToJson
     * @Description: Object convert to JSON String
     * @Param: [obj]
     * @Return: net.sf.json.JSONObject
     * @Date: 18/1/14 下午5:27
     */
    public static <T> JSONObject objectToJson(T obj) throws Exception, IOException {

        ObjectMapper mapper = new ObjectMapper();
        // Convert object to JSON string
        String jsonStr = "";
        try {
            jsonStr = mapper.writeValueAsString(obj);
        } catch (IOException e) {
            throw e;
        }
        return JSONObject.parseObject(jsonStr);
    }
}
