package test.fishPond;

import static fishpond.service.ClientService.END_TAG;
import static fishpond.service.ClientService.HEARTBEATorREGISTER;
import static fishpond.service.ClientService.SYNC_TAG;

import java.util.Arrays;

public class TestClient {

	private boolean needsGet = false;
	private byte[] pipe = new byte[64];
	private int count = 0;
	private boolean fullPipe = false;

	byte[] expect = {0x5a};
	int expectLength = 0;

	public TestClient(){
		initPipe();
	}

	private void initPipe(){
		for (int i = 0; i < pipe.length; i++) {
			pipe[i] = 0x00;
		}
	}

	private void progressHeartbeat(byte data){
		try {
			if (data == SYNC_TAG) {  //开始头
				needsGet = true;
				count = 0;
			}
			if (needsGet) {
				pipe[count] = (byte)data;
				count ++;
			}
			if (data == END_TAG) {  //单次传输结束
				needsGet = false;
				byte[] result = new byte[count];
				fullPipe = true;
				System.arraycopy(pipe, 0, result, 0, count);

				//处理本次接收到的数据
				System.out.println("heartbeatOrRegister :"+Arrays.toString(result));
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("接到的数据太长或没有结尾标识！count="+count);
		}
	}

	private void progressData(byte data){

		if (expectLength == 0 && expect[0] == HEARTBEATorREGISTER[0]) { //heartbeat or register package
			progressHeartbeat(data);
			return;
		}
		if (count < expectLength) {
			if (count < expect.length) {
				if (expect[count] == data) {
					pipe[count] = (byte)data;
					count ++;
				}else{
					count = 0;
				}
			}else{
				pipe[count] = (byte)data;
				count ++;
				if (count == expectLength) {
					fullPipe = true;
				}
			}
		}
	}

	public void work(byte[] bytes){
		for (int i = 0; i < bytes.length; i++) {
			progressData((byte) bytes[i]);
			if (fullPipe) {
				byte[] response = new byte[count];
				System.arraycopy(pipe, 0, response, 0, count);
				System.out.println("response :"+Arrays.toString(response));
				count = 0;
				fullPipe = false;
			}
		}
	}

	public static void main(String[] args) {
		TestClient tc = new TestClient();
		byte[] test = new byte[]{0x5A,0x02,1,2,3,1,1,0x77,1,2,3,1,1};
		tc.work(test);
		byte[] test2 = new byte[]{1,2,4,1,3,4,0x5A,0x02,3,5,1,1,0x77,1,2,3,1,1};
		byte[] b1 = new byte[]{1,3,4};
		tc.expect = b1;
		tc.expectLength = 9;
		tc.work(test2);
	}

}
