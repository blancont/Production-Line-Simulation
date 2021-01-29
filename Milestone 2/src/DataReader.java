import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataReader {
	private static JSONParser parser = new JSONParser();
	
	public static Command generateCommand(String filename) {
		Order order = parseOrder(filename);
		
		// Any type of concrete command could be used
		Command command = new SelectByMachineType(order.getOrderID(), order.getDrinkName());
		command.applyMachineSelection();
		return command;
	}
	
	

	public static Order parseOrder(String orderJSON) {
		try (FileReader reader = new FileReader(orderJSON)) {
			Object obj = parser.parse(new FileReader(orderJSON));
			JSONObject jo = (JSONObject) obj;

			Map order = ((Map) jo.get("order"));
			long orderID = (long) order.get("orderID");
			int orderID_int = (int) orderID;

			Map address = ((Map) order.get("address"));
			String street = ((String) address.get("street"));
			long zip = ((long) address.get("ZIP"));
			int zip_int = (int) zip;

			String drink = ((String) order.get("drink"));

			return new Order(orderID_int, street, zip_int, drink);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static DrinkResponse parseControllerResponse(String con_responseJSON) {
		try (FileReader reader = new FileReader(con_responseJSON)) {
			Object obj = parser.parse(reader);
			JSONObject jo = (JSONObject) obj;
			Map command = (Map) jo.get("drinkresponse");
			int orderID = Math.toIntExact((long) command.get("orderID"));
			int status = Math.toIntExact((long) command.get("status"));
			String desc = ((String) command.get("errordesc"));
			Object code = command.get("orderID");
			if(code != null) {
				code = Math.toIntExact((long) code);
				return new DrinkResponse(orderID, status, desc, (int) code);
			} else {
				return new DrinkResponse(orderID, status, desc, -1);
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
