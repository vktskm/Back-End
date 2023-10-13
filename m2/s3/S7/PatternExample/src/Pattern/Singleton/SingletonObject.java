package Pattern.Singleton;

public class SingletonObject {
	
	private static Test instance;

	private SingletonObject() {}
	
	public static Test getInstance() {
		if(instance == null) {
			instance = new Test("Mio Singleton Obj");
		}
		return instance;
	}

}
