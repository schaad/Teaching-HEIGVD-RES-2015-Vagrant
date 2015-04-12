package ch.heigvd.res.labs.roulette.net.protocol;

/**
 * This class is used to serialize/deserialize the response sent by the server
 * when processing the "LOAD" command defined in the protocol specification. The
 * JsonObjectMapper utility class can use this class.
 * 
 * @author Valentin Schaad
 */
public class LoadCommandResponse {

  private String status;
  private int numberOfStudents;

  public LoadCommandResponse() {}

  public LoadCommandResponse(String status, int numberOfStudents){
     this.status = status;
     this.numberOfStudents = numberOfStudents;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public int getNumberOfStudents() {
    return numberOfStudents;
  }

  public void setNumberOfStudents(int numberOfStudents) {
    this.numberOfStudents = numberOfStudents;
  }
}