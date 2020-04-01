package com.zimpatica.plugins.filtercdts;

import java.util.ArrayList;
import java.util.HashMap;

import com.appiancorp.suiteapi.type.TypedValue;
import com.appiancorp.suiteapi.type.exceptions.InvalidTypeException;

public class HelperFunctions {
	
	public static TypedValue toDictionaryList(ArrayList<HashMap<TypedValue, TypedValue>> toCast) throws InvalidTypeException {
	    try {
	      return new TypedValue(Long.valueOf(194L), toCast.toArray(new HashMap[toCast.size()])); } catch (Exception e) {
	    }
	    throw new InvalidTypeException("Could not cast result to list of dictionary");
	  }
	public static HashMap<String,TypedValue> getKeyMapFromHashMap(HashMap<TypedValue,TypedValue> map){
		HashMap<String,TypedValue> keyMap = new HashMap<String,TypedValue>();

		for(TypedValue key : map.keySet()) {
			String keyString = key.getValue().toString();
			 keyMap.put(keyString, key);
		 }
		return keyMap;
	}
	
}
