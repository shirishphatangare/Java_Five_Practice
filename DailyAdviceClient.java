import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class DailyAdviceClient {

	public static void main(String[] args) {
		DailyAdviceClient client = new DailyAdviceClient();
		client.go();
	}
	
	public void go(){
		BufferedReader br = null;
		Socket sock = null;
		try{
			sock = new Socket("127.0.0.1",4200); // ports 0 to 1023 are reserved for well-known services like HTTP,FTP,SMTP etc.
			InputStreamReader isr = new InputStreamReader(sock.getInputStream());
			br = new BufferedReader(isr);
			String advice=br.readLine();
			
			System.out.println("Today's advice is - " + advice);
			/*while((advice = br.readLine()) != null ){
				System.out.println(advice);
			}*/
			
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try {
				br.close();
				sock.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
