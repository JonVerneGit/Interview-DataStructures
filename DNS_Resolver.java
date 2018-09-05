package dns_resolver;

import java.util.Scanner;

import data_structures.HashI;
import exceptions.FileFormatException;

/**
 * The DNS_Resolver code will ask you to enter a URL and will give you the IP address
 * associated with the URL. In Eclipse, you can type a machine name into the Console window
 * and it will return the IP address. Press the red square or type quit
 * to stop the application running.
 * 
 * @author CS310
 *
 */
public class DNS_Resolver {
  public static void main(String[] args) {
    
    LoadInternetAddresses loader = new LoadInternetAddresses();
    HashI<URL, IPAddress> url2ip = null;
  
      try {
			// Change the two lines below to switch between the small and large
			// data sets. Use the small data set for initial development and testing.
			url2ip = loader.load_addresses("src/data/ips.txt");
			//url2ip = loader.load_addresses("src/data/ips.txt");
		} catch (FileFormatException e) {
			System.err.println("There was a file format exception");
			e.printStackTrace();
		}
    
    
  }
}
