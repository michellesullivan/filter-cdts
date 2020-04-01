package com.zimpatica.plugins.filtercdts;

import com.appiancorp.suiteapi.common.Name;
import com.appiancorp.suiteapi.expression.annotations.Category;
import com.appiancorp.suiteapi.expression.annotations.Function;
import com.appiancorp.suiteapi.expression.annotations.Parameter;
import org.apache.log4j.Logger;

import com.appiancorp.suiteapi.type.TypeService;
import com.appiancorp.suiteapi.type.TypedValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

@Category("category.name.LogicalFunctions")
public class FilterCDTByField2{
	private static final Logger LOG = Logger.getLogger(FilterCDTByField2.class);
	
	@Function
	public static TypedValue filtercdtbyfield2(TypeService ts, @Parameter @Name("field") String paramString, @Parameter @Name("cdt") TypedValue dictionary, @Parameter @Name("value") String valueParam) {
	    Long type = dictionary.getInstanceType();
	    
	    Object value = dictionary.getValue();
	    
	    ArrayList<Integer> indices = new ArrayList<Integer>();
	    if ((type.longValue() == 57L) || (value == null) || ("".equals(value))) {
	      return null;
	    }

			ArrayList<HashMap<TypedValue, TypedValue>> a = new ArrayList(Arrays.asList((HashMap[])ts.cast(Long.valueOf(194L), dictionary).getValue()));

			for(int i = 0; i < a.size(); i++) {
				
				 HashMap<TypedValue,TypedValue> map = (HashMap<TypedValue,TypedValue>)a.get(i);
				 
				 HashMap<String,TypedValue> keyMap = HelperFunctions.getKeyMapFromHashMap(map);
				 
				 if(keyMap.containsKey(paramString)) {
					 TypedValue keyTypedValue = keyMap.get(paramString);
					 TypedValue mapValue = map.get(keyTypedValue);
					 if(mapValue.getValue().toString().equals(valueParam)) {
						 indices.add(i);
					 }
				 }

			}
			if(indices.isEmpty()) {
				return null;
			}
			else {
				ArrayList<HashMap<TypedValue, TypedValue>> newMap = new ArrayList<HashMap<TypedValue,TypedValue>>();
				for(int z = 0; z<indices.size(); z++) {
					int index = indices.get(z);
					newMap.add(a.get(index));
				}
				return ts.cast(Long.valueOf(type), HelperFunctions.toDictionaryList(newMap));

			}

	}
}

