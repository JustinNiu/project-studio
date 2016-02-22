import com.cycling74.max.*;
import java.io.IOException;
import java.net.*;

public class UDPMulticast extends MaxObject
{

	private static final String[] INLET_ASSIST = new String[]{
		"inlet 1 help"
	};
	private static final String[] OUTLET_ASSIST = new String[]{
		"outlet 1 help"
	};
	
	public UDPMulticast(Atom[] args)
	{
		declareInlets(new int[]{DataTypes.ALL});
		declareOutlets(new int[]{DataTypes.ALL});
		
		setInletAssist(INLET_ASSIST);
		setOutletAssist(OUTLET_ASSIST);

	}
    
	public void bang()
	{
	}
    
	public void inlet(int i)
	{
	}
    
	public void inlet(float f)
	{
	}
    
    
	public void list(Atom[] list)
	{
	}

	public void send(String command ){
		InetAddress group;
		int port = 34565;
		

		MulticastSocket s;
		try {
			s = new MulticastSocket(port);
			group = InetAddress.getByName("224.0.80.8");
			String message = "0,1,2,3,"+command;
			byte[] byteArray = message.getBytes();

			DatagramPacket pack = new DatagramPacket(byteArray,message.length(),group, port);
			// Do a send. Note that send takes a byte for the ttl and not an int.
			s.send(pack);
			s.close();
			System.out.println("sent");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void loadWhatUSay(){
		send("WHATYOUSAY");
	}

	public void loadIltur3(){
		send("ILTUR3");
	}

	public void play(){
		send("PLAY");
	}

	public void stop(){

		send("STOP");
	}

	public void tap(){

		send("TAP");
	}

	public void head(){

		send("HEAD");
	}

	public void home(){

		send("HOME");
	}

	public void loadGoogleDemo(){

		send("GOOGLEDEMO");
	}

    
}

