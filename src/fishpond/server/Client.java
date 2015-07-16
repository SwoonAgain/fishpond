package fishpond.server;

import static fishpond.service.ClientService.END_TAG;
import static fishpond.service.ClientService.HEARTBEATorREGISTER;
import static fishpond.service.ClientService.SYNC_TAG;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

import fishpond.service.ClientService;

public class Client{
	/**
	 * 读取数据有误的反馈
	 */

	private Socket mSocket;
	private OutputStream mOutputStream;
	private InputStream mInputStream;

	private ClientService mService;

	private boolean needsGet = false;
	private byte[] pipe = new byte[64];
	private int count = 0;

	private boolean fullBucket = false;

	public Client(Socket socket){
		mSocket = socket;
		initPipe();
		mService = new ClientService(this);
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
				System.arraycopy(pipe, 0, result, 0, count);
				fullBucket = true;
				//处理本次接收到的数据
				mService.handleData(result);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("接到的数据太长或没有结尾标识！count="+count);
		}
	}

	private void progressData(byte data){
		byte[] expect = mService.getExpect();
		int expectLength = mService.getExpectLength();
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
					fullBucket = true;
				}
			}
		}
	}

	public void work(){
		try {
			mInputStream = mSocket.getInputStream();
			int data = 0;
			while( !Thread.currentThread().isInterrupted()&& data!=-1){
				data = mInputStream.read();
				progressData((byte) data);
				if (fullBucket) {
					byte[] response = new byte[count];
					System.arraycopy(pipe, 0, response, 0, count);
					mService.setResponse(response);
					count = 0;
					fullBucket = false;
				}
			}
		} catch (Exception e) {
//			System.out.println("读错误！");
			e.printStackTrace();

		} finally {
			closeConnection();
		}
	}

	public void closeConnection(){
		try {
			if (mInputStream != null) {
				mInputStream.close();
			}
			if (mOutputStream != null) {
				mOutputStream.close();
			}
			if (mSocket != null) {
				mSocket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			mService.updateStatus(Status.OFFLINE);
			Thread thread = Thread.currentThread();
			if (thread.getName().indexOf("DTU") != -1) {
				System.out.println(thread.getName() + "\t线程销毁");
			}
			thread.interrupt();
		}
	}

	public boolean write(byte[] command){
		if (command != null) {
			try {
				mOutputStream = mSocket.getOutputStream();
				mOutputStream.write(command);
				return true;
			} catch (IOException e) {
//				System.out.println("写错误！");
				e.printStackTrace();
			}
		}
		return false;
	}

	public enum Status{
		ONLINE,OFFLINE;
	}
}
