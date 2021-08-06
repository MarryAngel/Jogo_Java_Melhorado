import java.net.*;
import java.io.*;
import java.util.*;

class Servidor {
  public static void main(String[] args) {
    ServerSocket serverSocket=null;
    //Criar servidor na porta 80	
    try {
      serverSocket = new ServerSocket(80);
    } catch (IOException e) {
      System.out.println("Could not listen on port: " + 80 + ", " + e);
      System.exit(1);
    }
    
    for (int i=0; i<3; i++) {
      Socket clientSocket = null;
      try {
        clientSocket = serverSocket.accept();    //recebe o cliente
      } catch (IOException e) {
        System.out.println("Accept failed: " + 80 + ", " + e);
        System.exit(1);
      }

      System.out.println("Accept Funcionou!");

      new Servindo(clientSocket).start();	//começa a servir

    }

    try {
      System.out.println("Fechar server.");
      serverSocket.close();	//fechar o servidor 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}


class Servindo extends Thread {
  Socket clientSocket;
  static PrintStream os[] = new PrintStream[3];
  static int cont=0;

  Servindo(Socket clientSocket) {
    this.clientSocket = clientSocket;
  }

  public void run() {
    try {
      Scanner is = new Scanner(clientSocket.getInputStream());
      os[cont++] = new PrintStream(clientSocket.getOutputStream());
      String inputLine, outputLine;

      do {
        inputLine = is.nextLine();
        for (int i=0; i<cont; i++) {
          os[i].println(inputLine);
          os[i].flush();
        }
      } while (!inputLine.equals(""));
	
      for (int i=0; i<cont; i++)
        os[i].close();
      is.close();
      clientSocket.close();
      System.out.println("Conexacao terminada pelo cliente");	
    } catch (IOException e) {
      e.printStackTrace();
    } catch (NoSuchElementException e) {
      System.out.println("Conexacao terminada pelo cliente");
    }
  }
};
