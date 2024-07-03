package junit.runner;

/**
 * This class defines the current version of JUnit
 */
public class Version {
	private Version() {
		// don't instantiate
	}

	public static String id() {
		return "3.8.2";
	}
	
	public static void main(String[] args) {
		System.out.println(id());
	}
}
