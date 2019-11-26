package br.com.cvc.client.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cvc.bean.HotelBean;
import br.com.cvc.bean.QuartoBean;
import br.com.cvc.client.service.HotelService;
import br.com.cvc.client.ws.ClienteBroker;
import br.com.cvc.vo.HotelVO;
import br.com.cvc.vo.QuartoVO;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	ClienteBroker clienteBroker;
	 
	public HotelServiceImpl() {
		super();
	}

	@Override
	public List<HotelBean> consultaListaHoteis(Long idCidade) throws Exception{

		return clienteBroker.getListHotel(idCidade);
	}
	
	@Override
	public HotelBean consultaHotelDetail(Long idHotel) throws Exception {

		return clienteBroker.getHotelDetail(idHotel);
	}

	@Override
	public List<HotelVO> consultaViagemCalculada(Long idCidade, Long days, Integer adults, Integer childs) throws Exception {
		List<HotelBean> list = null;
		List<HotelVO> listHotelVo = new ArrayList<HotelVO>();
		List<QuartoVO> listQuartoVo = new ArrayList<QuartoVO>();;

		list = consultaListaHoteis(idCidade);
		if(list != null) {
			for(HotelBean hotel: list) {
				HotelVO hotelVo = new HotelVO();
				hotelVo.setId(hotel.getId());
				hotelVo.setCityName(hotel.getCityName());
				for(QuartoBean quarto: hotel.getRooms()) {
					QuartoVO quartoVo = new QuartoVO();
					calculaTaxaViagem(days, adults, childs, quarto, quartoVo);
					listQuartoVo.add(quartoVo);
				}
				hotelVo.setRooms(listQuartoVo);
				listHotelVo.add(hotelVo);
			}
		}
			
		return listHotelVo;
	}

	
	public BigDecimal calculaTaxaViagem(Long days, Integer adults, Integer childs, 
			QuartoBean quarto, QuartoVO quartoVo) {
		BigDecimal totalPrice = BigDecimal.ZERO;
		
		BigDecimal totalPerDayAdults = quarto.getPrice().get("adult").multiply(new BigDecimal(days));
		BigDecimal totalPerDayChilds = quarto.getPrice().get("child").multiply(new BigDecimal(days));
		
		totalPrice = totalPerDayAdults.multiply(new BigDecimal(adults));
		totalPrice = totalPrice.add(totalPerDayChilds.multiply(new BigDecimal(childs)));
		totalPrice = totalPrice.divide(new BigDecimal("0.7"), 2, RoundingMode.HALF_UP);
		
		quartoVo.setTotalPrice(totalPrice);
		LinkedHashMap<String, BigDecimal> price = new LinkedHashMap<String, BigDecimal>();
		price.put("pricePerDayAdult", totalPerDayAdults);
		price.put("pricePerDayChild", totalPerDayChilds);
		quartoVo.setPriceDetail(price);	
		
		quartoVo.setCategoryName(quarto.getCategoryName());
		quartoVo.setRoomID(quarto.getRoomID());
		
		return totalPrice;
	}
}
