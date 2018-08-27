package payload;

public class DeletePayLoad {
	
	public static String deletePayLoad(String placeID)
	{
		String deletePayLoad = "\"place_id\": \""+placeID+"\"";
		
		return deletePayLoad;
	}

}
