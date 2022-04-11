package model.dao;

import java.util.List;

import model.session.Aula;

public class AulaService extends AbstractService<AulaDAO, Aula> {

@Override
public AulaDAO createDAO() {
return new AulaDAO();
	}

}