package fr.afcepf.dja.ws;

import javax.xml.ws.Endpoint;

public class ServerSoapApp {

	public static void main(String[] args) {
		ServiceTvaImpl  serviceTvaImpl = new ServiceTvaImpl();
		//NB: si Endpoint.publish() avec url en localhost , la securité par défaut
		//fait que les appels provenant d'autres machines seront refusés.
		//String wsUrl = "http://" + "192.168.102.116" +":8080/serverSoap/ws/tva";
		String wsUrl = "http://" + "localhost" +":8080/serverSoap/ws/tva";
		//ou bien String wsUrl = "http://localhost:8181/serverSoap/ws/tva";
		System.out.println("démarrage du serveur , url=" +wsUrl);
		Endpoint.publish(wsUrl, serviceTvaImpl);
		//la description WSDL générée automatiquement aura comme URL
		//http://localhost:8080/serverSoap/ws/tva?wsdl (....?wsdl)
		try {
			Thread.sleep(15 * 60 * 1000); //pause de 15 mn
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("arrêt du serveur ");
		System.exit(0);
	}

}
