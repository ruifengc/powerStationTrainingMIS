package util;

import java.util.UUID;

public class CommUtil {
	
	public static String getId(){
		String id = UUID.randomUUID().toString();
		
		return id;
	}

}
