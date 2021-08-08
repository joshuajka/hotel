package br.ufg.inf.fs.business;

import java.util.List;

import br.ufg.inf.fs.dao.DB;
import br.ufg.inf.fs.dao.HotelDao;
import br.ufg.inf.fs.entities.Hotel;
import br.ufg.inf.fs.exceptions.HotelException;

public class HotelBusiness {

	
	HotelDao dao = new HotelDao(DB.getConnection());
	
	public List<Hotel> findAll() throws HotelException{
		return dao.findAll();
	}
	
	public Hotel findById(Integer id) throws HotelException{
		return dao.findById(id);
	}
	
	public Hotel insert(Hotel hotel) throws HotelException {
		return dao.insert(hotel);
	}
	
	public Hotel update(Hotel hotel) throws HotelException {
		return dao.update(hotel);
	}
	
	public void delete(Integer id) throws HotelException {
		dao.delete(id);
	}
}
