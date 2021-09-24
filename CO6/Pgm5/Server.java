import java.net.*;
import java.io.*;

class Server {
	public static void main(String[] args) throws Exception{
		try {
			ServerSocket ss = new ServerSocket(3000);
			Socket s = ss.accept();
			DataInputStream din = new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str1 = "", str2 = "";
			while (!str1.equals("stop")) {
					str1 = din.readUTF();
					System.out.println("Client says: " + str1);
					str2 = br.readLine();
					dout.writeUTF(str2);
					dout.flush();
			}
			din.close();
			s.close();
			ss.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}