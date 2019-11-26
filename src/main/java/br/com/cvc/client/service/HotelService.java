package br.com.cvc.client.service;

import java.util.List;

import br.com.cvc.bean.HotelBean;
import br.com.cvc.vo.HotelVO;

public interface HotelService {

	public abstract List<HotelBean> consultaListaHoteis(Long idCidade) throws Exception;
	
	public HotelBean consultaHotelDetail(Long idHotel) throws Exception;
	
	public abstract List<HotelVO> consultaViagemCalculada(Long idCidade, Long days, Integer adults, Integer childs) throws Exception;
}
