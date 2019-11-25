package br.com.cvc.client.service;

import java.util.List;
import br.com.cvc.vo.Hotel;

public interface HotelService {

	public abstract List<Hotel> consultaListaHoteis(Long idCidade);
	
	public abstract List<Hotel> consultaViagemCalculada(Long idCidade, Long days, Integer adults, Integer childs);
}
