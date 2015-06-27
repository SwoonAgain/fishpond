package fishpond.server;

import static fishpond.server.Server.CLIENT_THREADS;
import static fishpond.service.ClientService.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import fishpond.app.CommandWriter;
import fishpond.service.ClientService;

public class Client{
	/**
	 * 读取数据有误的反馈
	 */
//	public static final byte[] ERROR_FEEDBACK = {0x5A,0x03,0x00,0x01,0x03,0x77};
	
	private Socket mSocket;
	private OutputStream mOutputStream;
	private InputStream mInputStream;
	
	private ClientService mService;

	private boolean needsGet = false;
	private byte[] temp = new byte[64];
	private int count = 0;
	
	public Client(Socket socket){
		mSocket = socket;
		for (int i = 0; i < temp.length; i++) {
			temp[i] = 0x00;
		}
		mService = new ClientService(this);
	}
	
	/**
	 * 将读取的流放如temp中，如果出现错误，替换成一个错误流
	 */
	private void progressData(byte data){
		try {
			if (data == SYNC_TAG) {  //开始头
				needsGet = true;
				count = 0;
			}
			if (needsGet) {
				temp[count] = (byte)data;
				count ++;
			}
			if (data == END_TAG) {  //单次传输结束
				needsGet = false;
				byte[] result = new byte[count];
				System.arraycopy(temp, 0, result, 0, count);
				
				//处理本次接收到的数据
				mService.handleData(result);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("接到的数据太长或没有结尾标识！count="+count);
//			write(ERROR_FEEDBACK);
		}
	}
	
	public void work(){
		try {
			mInputStream = mSocket.getInputStream();
			mOutputStream = mSocket.getOutputStream();
			int data = 0;
			while(data != -1){
				data = mInputStream.read();
				progressData((byte) data);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			closeConnection();
		}
	}
	
	protected void closeConnection(){
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
			//socket关闭后，从线程集合中删除，将线程停止
			Thread thread = CLIENT_THREADS.remove(this);
			System.out.println(thread.getName() + "线程销毁");
			thread.interrupt();
		}
	}
	
	public boolean write(byte[] command){
		if (mOutputStream != null && command != null) {
			try {
				mOutputStream.flush();
				mOutputStream.write(command);
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				closeConnection();
			}
		}
		return false;
	}
	
	public enum Status{
		ONLINE,OFFLINE;
	}
}
