package br.com.cvc.restfull;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cvc.bean.HotelBean;
import br.com.cvc.client.service.HotelService;
import br.com.cvc.util.Utils;
import br.com.cvc.vo.HotelVO;
import br.com.cvc.vo.ResultVO;

@RequestMapping("/v1")
@RestController
public class HotelResource {

	@Autowired
	private HotelService hotelService;
	
	@RequestMapping(value = "/hotels/load/{cityCode}/{checkin}/{checkout}/{adults}/{childs}", method = RequestMethod.GET)
	public ResultVO loadHotels(@PathVariable(value = "cityCode") Long cityCode,
			@PathVariable(value = "checkin") String checkin,
				@PathVariable(value = "checkout") String checkout,
					@PathVariable(value = "adults") Integer adults,
						@PathVariable(value = "childs") Integer childs,
			HttpServletResponse response) {
		ResultVO resultVO = new ResultVO();
		resultVO.setSuccess(true);

		try{
			Long diffD = Utils.getDiffDates(checkin, checkout);
			
			List<HotelVO> listHotel = this.hotelService.consultaViagemCalculada(cityCode, diffD, adults, childs);
			resultVO.setData(listHotel);

		} catch (Exception e) {
			resultVO.setSuccess(false);
			resultVO.setError(e.getMessage());
		}

		return resultVO;
	}
	
	@RequestMapping(value = "/hotels/load/detail/{idHotel}", method = RequestMethod.GET)
	public ResultVO loadHotelsDetail(@PathVariable(value = "idHotel") Long idHotel, HttpServletResponse response) {
		ResultVO resultVO = new ResultVO();
		resultVO.setSuccess(true);
		
		try{
			HotelBean hotel = this.hotelService.consultaHotelDetail(idHotel);
			resultVO.setData(hotel);

		} catch (Exception e) {
			resultVO.setSuccess(false);
			resultVO.setError(e.getMessage());
		}

		return resultVO;
	}
}
