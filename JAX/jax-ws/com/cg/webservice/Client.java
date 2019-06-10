package com.cg.webservice;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import java.util.Scanner;

public class Client {

	public static void main(String args[]) throws Exception {
		URL url = new URL("http://localhost:9876/cs?wsdl");

		// Qualified name of the service:
		// 1st arg is the service URI
		// 2nd is the service name published in the WSDL
		QName qname = new QName("http://webservice.cg.com/", "ProductService");

		// Create, in effect, a factory for the service.
		Service service = Service.create(url, qname);

		// Extract the endpoint interface, the service "port".
		ProductServer endPointIntf = service.getPort(ProductServer.class);
		// CalculatorServer endPointIntf =
		// service.getPort(CalculatorServer.class);

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the product name");
		String name = scanner.next();
		System.out.println(""+endPointIntf.searchByName(name));
	}

}
