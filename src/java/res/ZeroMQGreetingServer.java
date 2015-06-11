/**
   A class that demonstrates ZeroMQ request-reply messaging pattern
   by binding a request-reply ZeroMQ socket that receives a string
   and responds with a greeting.
   Note that this example requires ZeroMQ to be installed, zmq.jar to
   be in the class path, and jzmq.dll, libzmq-v100-mt-3_2_2.dll in the
   current folder.
   Compile by:
      javac -cp .;zmq.jar ZeroMQGreetingServer.java
   and run using a 64-bit JVM by:
      C:"\Program Files"\Java\jre7\bin\java.exe -cp .;zmq.jar -Djava.library.path=. ZeroMQGreetingServer
   @author Andrew Ensor
*/
import org.zeromq.ZMQ;

public class ZeroMQGreetingServer
{
   public static void main(String[] args)
   {  System.out.println("ZeroMQGreetingServer starting"
         + " with ZeroMQ version " + ZMQ.getVersionString());
      ZMQ.Context context = ZMQ.context(1);  // thread pool size 1
      ZMQ.Socket socket = context.socket(ZMQ.REP);
      socket.bind("tcp://*:8890");
      // receive message from socket
      byte[] request = socket.recv(0); // blocking by default
      String name = new String(request);
      System.out.println("ZeroMQGreetingServer received name "+name);
      // send response
      byte[] response = ("Hello " + name).getBytes();
      socket.send(response, 0);  // blocking by default
      socket.close();
      context.term();
      System.out.println("ZeroMQGreetingServer stopping");
   }
}
