package br.com.cvc.client.ws;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.apache.http.client.fluent.Request;
import com.google.gson.Gson;
import br.com.cvc.vo.Hotel;

public class ClienteBroker {
	private static final String URL_GET_HOTELS = 
		    "https://cvcbackendhotel.herokuapp.com/hotels/avail/";
	private static final String URL_GET_HOTEL_DETAIL = "https://cvcbackendhotel.herokuapp.com/hotels/";
	
	private Client client = ClientBuilder.newClient();
	
	public List<Hotel> getListHotel(Long idCidade) throws Exception {
		
		List<Hotel> listHotel = client.target(URL_GET_HOTELS)
									.path(String.valueOf(idCidade))
										.request(MediaType.APPLICATION_JSON)
												.get(List.class);
		
		return listHotel;
	}
	
	public boolean getHotelDetail(Integer idHotel) throws Exception {
		String response = Request
			.Get(URL_GET_HOTEL_DETAIL + idHotel)
			.addHeader("Accept", "application/json")
			.execute()
			.returnContent()
			.asString();

		return loadHotelDetail(response);
	}

	private boolean loadHotelList(String resp){
		List<Hotel> hotelList = new ArrayList<Hotel>();
		
		try {
			Gson gson = new Gson();
			hotelList = gson.fromJson(resp, List.class);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	 
	 	return !hotelList.isEmpty();
	}

	private boolean loadHotelDetail(String resp){
		Hotel hotel = null;
		
		try {
			Gson gson = new Gson();
			hotel = gson.fromJson(resp, Hotel.class);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	 
	 	return hotel != null;
	}

}
