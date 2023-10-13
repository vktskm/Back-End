package Pattern.AbstractFactory;

public interface AbstractFactory<T> {
	// valRitorno nomeMetodo(Parametri p...)
	// Animal create(String nome);
	T create(String objType);
}
