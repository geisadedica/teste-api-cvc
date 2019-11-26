package br.com.cvc.client.ws;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

import br.com.cvc.bean.HotelBean;

@Service
public class ClienteBroker {
	
	public ClienteBroker() {
		super();
	}

	private static final String URL_GET_HOTELS = 
		    "https://cvcbackendhotel.herokuapp.com/hotels/avail/";
	private static final String URL_GET_HOTEL_DETAIL = "https://cvcbackendhotel.herokuapp.com/hotels/";
	
	private Client client = ClientBuilder.newClient();
	
	public List<HotelBean> getListHotel(Long idCidade) throws Exception {
		
		List<HotelBean> listHotel = client.target(URL_GET_HOTELS)
									.path(String.valueOf(idCidade))
										.request(MediaType.APPLICATION_JSON)
												.get(new GenericType<List<HotelBean>> () {});
		
		return listHotel;
	}
	
	public HotelBean getHotelDetail(Long idHotel) throws Exception {
		List<HotelBean> hotelDetail = client.target(URL_GET_HOTEL_DETAIL)
				.path(String.valueOf(idHotel))
					.request(MediaType.APPLICATION_JSON)
							.get(new GenericType<List<HotelBean>> () {});

			return hotelDetail.get(0);
	}
}