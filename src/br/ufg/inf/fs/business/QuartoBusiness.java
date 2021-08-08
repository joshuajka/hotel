package br.ufg.inf.fs.business;

import java.util.List;

import br.ufg.inf.fs.dao.DB;
import br.ufg.inf.fs.dao.QuartoDao;
import br.ufg.inf.fs.entities.Quarto;
import br.ufg.inf.fs.exceptions.QuartoException;

public class QuartoBusiness {

	
	QuartoDao dao = new QuartoDao(DB.getConnection());
	
	public List<Quarto> findAll() throws QuartoException{
		return dao.findAll();
	}
	
	public Quarto findById(Integer id) throws QuartoException{
		return dao.findById(id);
	}
	
	public Quarto insert(Quarto quarto) throws QuartoException {
		return dao.insert(quarto);
	}
	
	public Quarto update(Quarto quarto) throws QuartoException {
		return dao.update(quarto);
	}
	
	public void delete(Integer id) throws QuartoException {
		dao.delete(id);
	}
}
