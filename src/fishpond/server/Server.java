package fishpond.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import fishpond.utils.PropertiesUtil;

public class Server extends HttpServlet{

	private static final long serialVersionUID = 7158844308097516029L;

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("初始化Socket程序...");
		//恢复所有客户端离线状态
		offlineAll();
		//在新线程中创建一个serverSocket
		new Thread(new FishPondMonitor()).start();
	}

	private class FishPondMonitor implements Runnable{

		@Override
		public void run() {
			ServerSocket serSocket = null;
			try {
				String dstPortStr = PropertiesUtil.get("dstPort");
				int dstPort = Integer.valueOf(dstPortStr);
				serSocket = new ServerSocket(dstPort);
				while(true){
					Socket socket = serSocket.accept();
					System.out.println("收到一个连接请求...");
					SocketThread st = new SocketThread(socket);
					st.start();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if (serSocket != null) {
					try {
						serSocket.close();
					} catch (IOException e) {
					}
				}
			}
		}

	}

	/**
	 * 为每个接收到的客户端提供的线程
	 * @author Administrator
	 *
	 */
	private class SocketThread extends Thread{

		private Socket mSocket;
		private Client mClient;

		public SocketThread(Socket socket){
			mSocket = socket;
			mClient = new Client(mSocket);
		}

		@Override
		public void run() {
			mClient.work();
		}
	}

	/**
	 * 服务器意外宕机需要
	 */
	private void offlineAll() {
		String driver = PropertiesUtil.get("jdbc.driver");
		String url = PropertiesUtil.get("jdbc.url");
		String username = PropertiesUtil.get("jdbc.username");
		String password = PropertiesUtil.get("jdbc.password");
		Connection conn = null;
		Statement st = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			st =  conn.createStatement();
			st.execute("update device set online_status = false");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null ) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {

			}
		}
	}
}
