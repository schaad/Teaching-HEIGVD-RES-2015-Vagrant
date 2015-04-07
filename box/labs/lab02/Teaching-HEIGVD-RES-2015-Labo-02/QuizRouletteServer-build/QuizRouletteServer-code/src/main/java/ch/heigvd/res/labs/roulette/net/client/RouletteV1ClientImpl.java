package ch.heigvd.res.labs.roulette.net.client;

import ch.heigvd.res.labs.roulette.data.EmptyStoreException;
import ch.heigvd.res.labs.roulette.data.JsonObjectMapper;
import ch.heigvd.res.labs.roulette.net.protocol.RouletteV1Protocol;
import ch.heigvd.res.labs.roulette.data.Student;
import ch.heigvd.res.labs.roulette.net.protocol.InfoCommandResponse;
import ch.heigvd.res.labs.roulette.net.protocol.RandomCommandResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class implements the client side of the protocol specification (version 1).
 * 
 * @author Olivier Liechti
 */
public class RouletteV1ClientImpl implements IRouletteV1Client {

  private static final Logger LOG = Logger.getLogger(RouletteV1ClientImpl.class.getName());
  private Socket socket;
  private BufferedReader reader;
  private PrintWriter writer;

  @Override
  public void connect(String server, int port) throws IOException {
     socket = new Socket(server, port);
     
     reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
     writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
     
     reader.readLine();
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void disconnect() throws IOException {
     if(!socket.isClosed()){
        writer.println(RouletteV1Protocol.CMD_BYE);
        writer.close();
        reader.close();
        socket.close();
     }
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean isConnected() {
     return socket != null && socket.isConnected();
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void loadStudent(String fullname) throws IOException {
     //writer.println(RouletteV1Protocol.CMD_LOAD);
     /*writer.write(RouletteV1Protocol.CMD_LOAD);
     reader.readLine();
     writer.write(fullname*/
     
     writer.println(RouletteV1Protocol.CMD_LOAD);
     writer.println(fullname);
     writer.println(RouletteV1Protocol.CMD_LOAD_ENDOFDATA_MARKER);
     
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void loadStudents(List<Student> students) throws IOException {
     writer.println(RouletteV1Protocol.CMD_LOAD);
     for(Student s : students){
        writer.println(s.getFullname());
     }
     writer.println(RouletteV1Protocol.CMD_LOAD_ENDOFDATA_MARKER);
     
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Student pickRandomStudent() throws EmptyStoreException, IOException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public int getNumberOfStudents() throws IOException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public String getProtocolVersion() throws IOException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}