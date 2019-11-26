package br.com.cvc.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedHashMap;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import br.com.cvc.bean.QuartoBean;
import br.com.cvc.client.service.impl.HotelServiceImpl;
import br.com.cvc.vo.QuartoVO;

public class ClienteBrokerTest {
	
	@Test
	public void getListHotelTest()
	  throws ClientProtocolException, IOException {
	  
		HotelServiceImpl hotelService = new HotelServiceImpl();
		QuartoVO quartoVo = new QuartoVO();
		QuartoBean bean = new QuartoBean();
		LinkedHashMap<String, BigDecimal> price = new LinkedHashMap<String, BigDecimal>();
		price.put("adult", new BigDecimal(500));
		price.put("child", new BigDecimal(100));
		bean.setPrice(price);	
		try {
			BigDecimal priceF = hotelService.calculaTaxaViagem(new Long(5), 2, 1, bean, quartoVo);
			assertEquals("7857.14", priceF.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
