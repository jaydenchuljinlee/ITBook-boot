package com.example.ITBook.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class JsonUtil {
	
	// �깮�꽦�옄
    public JsonUtil()
    {
        // �깮�꽦�옄 Code
    }
    
    /**
     * FuncName : JsonToMap()
     * FuncDesc : Json String -> Map �삎�깭 蹂��솚
     * Param    : param : Json String
     * Return   : Map<String, Object>
    */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> JsonToMap(String param)
    {
        Gson gson = new Gson();

        return gson.fromJson(param, new HashMap<String,Object>().getClass());
    }
    
    /**
     * Json -> List 蹂��솚
     * @param param
     * @return
     */
    @SuppressWarnings("unchecked")
	public static List<Map<String, Object>> JsonToList(String param) {
    	
    	Gson gson = new Gson();
    	
    	return gson.fromJson(param, new ArrayList<Map<String, Object>>().getClass());
    }
    
    
    /**
     * FuncName : JsonToLinkedHashMap()
     * FuncDesc : Json String -> LinkedHashMap �삎�깭 蹂��솚(�뱾�뼱�삩 �닚�꽌��濡�)
     * Param    : param : Json String
     * Return   : Map<String, Object>
    */
    @SuppressWarnings("unchecked")
    public static LinkedHashMap<String, Object> JsonToLinkedHashMap(String param)
    {
        Gson gson = new Gson();

        return gson.fromJson(param, new LinkedHashMap<String,Object>().getClass());
    }


    /**
     * FuncName : ListToJson()
     * FuncDesc : List -> Json String 蹂��솚
     * Param    : res : Json String
     * Return   : Json String
    */
    public static String ListToJson(List<?> jqGridList)
    {
        Gson gson = new Gson();

        return gson.toJson(jqGridList);
    }


    /**
     * FuncName : OneStringToJson()
     * FuncDesc : Json String 蹂��솚
     * Param    : sData : String
     * Return   : String
    */
    public static String OneStringToJson(String sData)
    {
        Gson gson = new Gson();

        return gson.toJson(sData);
    }
    
    
    /**
     * FuncName : HashMapToJson()
     * FuncDesc : Json String 蹂��솚
     * Param    : sData : String
     * Return   : String
    */
    public static String HashMapToJson(HashMap<String, Object> map)
    {
        Gson gson = new Gson();

        return gson.toJson(map);
    }
    
    /**
     * FuncName : MapToJson()
     * FuncDesc : Json String 蹂��솚
     * Param    : sData : String
     * Return   : String
    */
    public static String MapToJson(Map<String, Object> map)
    {
        Gson gson = new Gson();

        return gson.toJson(map);
    }
}
