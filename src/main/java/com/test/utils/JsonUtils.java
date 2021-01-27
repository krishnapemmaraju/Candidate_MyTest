package com.test.utils;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import org.apache.commons.codec.Charsets;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonUtils {
	
	private Map<String, Object> map = new HashMap<String, Object>();
    private JsonObject jsonObject;

    @SuppressWarnings("serial")
    @Deprecated
    public JsonUtils(String filePath) {
        try {
            map = new Gson().fromJson(FileUtils.readFileToString
                    (new File(filePath), Charsets.UTF_8), new TypeToken<Map<String, Object>>(){}.getType());
        } catch (JsonSyntaxException | IOException e) {
            e.printStackTrace();
        }
    }


    public void setValue(String fieldName, String fieldValue) {
        jsonObject.addProperty(fieldName, fieldValue);
    }

    public Object getValue(String field) {
        return jsonObject.get(field);
    }

    public JsonArray getJsonArray(String fieldValue) {
        return jsonObject.get(fieldValue).getAsJsonArray();
    }


    public int getTransaction(String parentKey,String key, String value) {
        int index=0;
        for(Map<String, Object> a : getTransactions(parentKey)) {
            if(a.get(key).toString().equals(value)) {
                return	index;
            }
            index++;
        }
        return -1;
    }


    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getTransactions(String parentKey) {
        return (List<Map<String, Object>>) map.get(parentKey);
    }

}
