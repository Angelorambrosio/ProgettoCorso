package model.dao;

import model.session.Corso;

public class CorsoService extends AbstractService<CorsoDAO, Corso> {

	@Override
	public CorsoDAO createDAO() {
		return new CorsoDAO();
	}	

}