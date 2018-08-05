package ch.jmildner.syst.threadpool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
	public static void main(String[] arg) throws IOException {
		String docRoot = ".";
		ThreadPool threadPool = null;
		boolean pooling = false;
		ServerSocket serverSocket = null;
		if (arg.length > 0) {
			docRoot = arg[0];
		}

		if (arg.length > 1) {
			pooling = true;
			int size = Integer.parseInt(arg[1]);
			threadPool = new ThreadPool(size);
		} else {
			pooling = true;
			int size = 10;
			threadPool = new ThreadPool(size);
		}

		try {
			int port = 8081;
			serverSocket = new ServerSocket(port);
			RequestHandler requestHandler = null;

			System.out.println("http-Server gestartet port: " + port);

			while (true) {
				Socket socket = serverSocket.accept();
				requestHandler = new RequestHandler(socket, docRoot);
				System.out.println(pooling);
				if (pooling) {
					threadPool.execute(requestHandler);
				} else {
					Thread handlerThread = new Thread(requestHandler);
					handlerThread.start();
				}
			}
		} catch (java.io.IOException ex) {
			System.err.println(ex);
		} finally {
			serverSocket.close();
		}
	}
}
