package dns_resolver;

/**
 * A URL Object is a representation of the URL that we have been giving. 
 * It knows how to compare URLs!
 * 
 * @author Jonathan Verne
 *
 */
public class URL implements Comparable<URL> {

	String name;
	
	/**
	 * Constructor for the URL object.
	 * @param The name of the URL.
	 */
	public URL(String s){
		this.name = s;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public int compareTo(URL obj) {
		return (((Comparable<String>)obj.name).compareTo(this.name));
	}
	
	@Override
	public String toString() {
		return name;
	}	
}
