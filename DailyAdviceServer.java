import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class DailyAdviceServer {

	public static void main(String[] args) {
		DailyAdviceServer server = new DailyAdviceServer();
		server.go();

	}
	
	public void go(){
		PrintWriter pw = null;
		ServerSocket servSock = null;
		try{
			servSock = new ServerSocket(4200);// ServerSocket makes this server application 'listen' for client requests on port 4242 on same machine
			while(true){
				Socket s = servSock.accept(); // accept method blocks until a request comes in and then the method returns a Socket (on anonymous port) for communicating with Client
											  // accept method gets request when client says	- new Socket("127.0.0.1",4242)
				System.out.println("server accepted client request");
				pw = new PrintWriter(s.getOutputStream());
				String str = "This is Shirish, How r u?";
				pw.println(str);
				pw.flush();
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			pw.close();
			try {
				servSock.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
