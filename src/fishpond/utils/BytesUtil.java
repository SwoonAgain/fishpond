package fishpond.utils;

import java.util.ArrayList;
import java.util.Arrays;

public class BytesUtil {

	/**
	 * 连续的数组拷贝，从source的指定起点开始
	 * <br/>按照目标长度连续、按顺序 拷贝至目标数组
	 * @param source  the source array.
	 * @param begin  starting position in the source array.
	 * @param bs  the destination arrays.
	 */
	public static void arrayscopy(byte[] source,int begin, byte[] ...bs) {
		try {
			for (int i = 0; i < bs.length; i++) {
				System.arraycopy(source, begin, bs[i], 0, bs[i].length);
				begin += bs[i].length;
			}
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("source长度异常："+Arrays.toString(source));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static byte[] composeCommand(byte[] ...bs) {
		ArrayList<Byte> list = new ArrayList<Byte>();
		for (int i = 0; i < bs.length; i++) {
			for (int j = 0; j < bs[i].length; j++) {
				list.add(bs[i][j]);
			}
		}
		int len = list.size();
		byte[] result = new byte[len];
		for (int i = 0; i < len; i++) {
			result[i] = list.get(i);
		}
		return result;
	}
}
