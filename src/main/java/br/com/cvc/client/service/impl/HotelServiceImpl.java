package br.com.cvc.client.service.impl;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.cvc.client.service.HotelService;
import br.com.cvc.client.ws.ClienteBroker;
import br.com.cvc.vo.Hotel;
import br.com.cvc.vo.Quarto;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	ClienteBroker clienteBroker;
	 
	@Override
	public List<Hotel> consultaListaHoteis(Long idCidade) {
		try {
			return clienteBroker.getListHotel(idCidade);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Hotel> consultaViagemCalculada(Long idCidade, Long days, Integer adults, Integer childs) {
		List<Hotel> list = null;
		
		try {
			list = consultaListaHoteis(idCidade);
			if(list != null) {
				for(Hotel hotel: list) {
					for(Quarto quarto: hotel.getQuartos()) {
						calculaTaxaViagem(days,adults, childs, quarto);
					}
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	
	private void calculaTaxaViagem(Long days, Integer adults, Integer childs, Quarto quarto) {
		BigDecimal totalPrice = BigDecimal.ZERO;
		
		BigDecimal totalAdults = quarto.getPriceAdult().multiply(new BigDecimal(days)).multiply(new BigDecimal(adults));
		BigDecimal totalChilds = quarto.getPriceChild().multiply(new BigDecimal(days)).multiply(new BigDecimal(childs));
		
		totalPrice = totalAdults.add(totalChilds);
		
		quarto.setTotalPrice(totalPrice);
		
	}
}
