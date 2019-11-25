package br.com.cvc.test;

import static org.junit.Assert.*;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.junit.Test;
import br.com.cvc.client.ws.ClienteBroker;

public class ClienteBrokerTest {
	
	@Test
	public void getListHotelTest()
	  throws ClientProtocolException, IOException {
	  
		ClienteBroker cb = new ClienteBroker();
		
		try {
			assertEquals(true, cb.getListHotel(1032));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
