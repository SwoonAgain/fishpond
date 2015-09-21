package fishpond.utils;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.util.StringUtils;

public class SQLUtil {

	public static String whereClause(Map<String,Object> filters) {
		if (filters == null || filters.size() == 0) {
			return "";	
		}else {
			StringBuilder sb = new StringBuilder();
			Set<Entry<String, Object>> set = filters.entrySet();
			Iterator<Entry<String, Object>> it = set.iterator();
			int i = 1;
			while (it.hasNext()) {
				if (i == 1) {
					sb.append(" where ");
				}else{
					sb.append(" and ");
				}
				Entry<String, Object> entry  = it.next();
				String key = entry.getKey();
				Object value = entry.getValue();
				if (value instanceof String) {
					value = "'"+value+"'";
				}
				sb.append(key+" = "+value);
				i++;
			}
			return sb.toString();
		}
	}
	
	public static String orderClause(String orderBy,String def) {
		boolean isOrder = StringUtils.isEmpty(orderBy);
		if (isOrder) {
			return " order by "+def;
		}else{
			if (orderBy.endsWith("Desc")) {
				return " order by "+orderBy.substring(0, orderBy.length()-4)+" desc";
			}else{
				return " order by "+orderBy;
			}
		}
	}

	public static String limitClaus(int begin, int count) {
		return " limit "+begin+","+count;
	}
}
