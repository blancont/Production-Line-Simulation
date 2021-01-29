
public interface Subject {
	void registerObserver(Observer o);
	void removeObserver(Observer o);
	String notifyObservers(DrinkResponse response);
}
