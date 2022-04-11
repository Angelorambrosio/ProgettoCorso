package model.dao;


import model.session.Docente;

public class DocenteService extends AbstractService<DocenteDAO, Docente> {

	@Override
	public DocenteDAO createDAO() {
		return new DocenteDAO();
	}

}
	

