package fishpond.utils;

import org.springframework.util.StringUtils;

public class SQLUtil {

	public static String whereClause(String ...strings) {
		if (strings == null || strings.length == 0) {
			return "";	
		}else {
			boolean has = false;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < strings.length; i++) {
				if (StringUtils.isEmpty(strings[i])) {
					continue;
				}
				String[] strs1 = strings[i].split("-");
				if (! has) {
					sb.append(" where ");
					has = true;
				}else {
					sb.append(" and ");
				}
				sb.append(strs1[0]+" = "+strs1[1]);
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
