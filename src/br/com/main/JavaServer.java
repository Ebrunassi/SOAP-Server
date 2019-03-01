//    package br.com.main;
//
//    import org.apache.xmlrpc.server.PropertyHandlerMapping;
//    import org.apache.xmlrpc.server.XmlRpcServer;
//    import org.apache.xmlrpc.webserver.WebServer;
//
//    public class JavaServer {
//
//    private static JavaServer euMesmo = null;
//
//    private JavaServer() {
//    try {
//	    WebServer server = new WebServer(8185); // Cria um servidor na porta 8185
//	    
//	    XmlRpcServer servidor = server.getXmlRpcServer(); // Pega o servidor XmlRpc
//	    PropertyHandlerMapping phm = new PropertyHandlerMapping();
//	    phm.addHandler("Calc", Calculadora.class); // Adiciona um novo "handler" ao PHM
//	    servidor.setHandlerMapping(phm); // Define o handler no servidor
//	    server.start(); // inicia o servidor.
//	    } catch (Exception exception) {
//	    System.err.println("JavaServer: " + exception);
//	    }
//    }
//
//    public static JavaServer obterInstancia() {
//    if (euMesmo == null)
//    euMesmo = new JavaServer();
//    return euMesmo;
//    }
//    } 

package br.com.main;
import java.util.Map;

import org.apache.xmlrpc.*;

public class JavaServer { 

//	public String bloqueio(String login, String password, String placa, int ticket){
	public String bloqueio(String login, String password, String placa, int ticket){
		System.out.println("Chegou no servidor...");
		return "Caminhão bloqueado!";
	}

   public Integer sum(int x, int y, String nome){
	  System.out.println("X : " + x + " Y : " + y + "nome : " + nome);
      return new Integer(x+y);
   }
   
   public String ola(String nome){
	   System.out.println("Olá " + nome);
	   return nome;
   }

   public static void main (String [] args){
   
      try {

         System.out.println("Attempting to start XML-RPC Server...");
         
         WebServer server = new WebServer(8051);
         server.addHandler("sample", new JavaServer());
         server.start();


         System.out.println("Started successfully.");
         System.out.println("Accepting requests. (Halt program to stop.)");
         
      } catch (Exception exception){
         System.err.println("JavaServer: " + exception);
      }
   }
}