package presentation;
import dataSource.Database;
import domain.UserResponse;

public class Main {
	
	static Database db;
	
	public static void main(String[] args) {
		AppCommunicator appComm = new AppCommunicator();
		appComm.receiveJSON(args[0]);
	}
	
	public static void setDatabase(Database database) {
		db = database;
	}
}
