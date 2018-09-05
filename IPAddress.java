package dns_resolver;

/**
 * The IPAddress is using iIPv4 and has dotted-decimal notation, with the network, two subnets, 
 * and host separated by periods. For example, the IP address 130.191.226.146 has 
 * a network of 130, a subnet of 191, the second subnet is 226, and the host address is 146.
 * 
 * Your IPAddress class should accept a string of dotted-decimal IPAddresses in the constructor
 * and separate them into the components. 
 * 
 * @see <a href="https://en.wikipedia.org/wiki/IP_address#IPv4_addresses">Wikipedia IPv4 addresses</a>
 * @author Jonathan Verne
 *
 */

public class IPAddress {

	int network;
	int subnet;
	int subnet2;
	int host;
	String ip;
	/**
	 * The constructor for the IPAddress class
	 * 
	 * @param ip the dotted-decimal IP address
	 */
	public IPAddress(String ip) {
		this.ip = ip;
		String values[] = ip.split("\\.");
		this.network = Integer.parseInt(values[0]);
		this.subnet = Integer.parseInt(values[1]);
		this.subnet2 = Integer.parseInt(values[2]);
		this.host = Integer.parseInt(values[3]);
	}


	@Override
	public int hashCode() {
		return ip.hashCode();
	}
