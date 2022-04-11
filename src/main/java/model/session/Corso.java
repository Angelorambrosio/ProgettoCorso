package model.session;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.ConstraintMode;
import java.time.LocalDate;


@Entity
@Table(name = "HB_CORSO1")

public class Corso{

// public static final String PROPERTY_matricola = "titolo_di_studio";


public static final String PROPERTY_id = "id";
public static final String PROPERTY_nome = "nome";
public static final String PROPERTY_data = "data";
public static final String PROPERTY_durata = "durata";
public static final String PROPERTY_cod_aula = "cod_aula";
public static final String PROPERTY_cod_doc = "cod_doc";

@Column(name = "id")
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;

@Column(name = "nome")
private String nome;

@Column(name = "data")
private LocalDate data;

@Column(name = "durata")
private int durata;

@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,
		CascadeType.PERSIST }, targetEntity = Aula.class)
private Aula cod_aula;

@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,
		CascadeType.PERSIST }, targetEntity = Docente.class)
private Docente cod_doc;

@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,
		CascadeType.PERSIST }, targetEntity = Discente.class)
@JoinTable(name = "HB_DISCENTI_CORSO", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = {
		@JoinColumn(name = "matricola") }, foreignKey = @javax.persistence.ForeignKey(ConstraintMode.CONSTRAINT), inverseForeignKey = @javax.persistence.ForeignKey(ConstraintMode.CONSTRAINT))
Set<Discente> discenti = new HashSet<>();


public int getId() {
return id;
}

public void setId(int id) {
this.id = id;
}

public int getDurata() {
return durata;
}

public void setDurata(int durata) {
this.durata = durata;
}

public String getNome() {
return nome;
}

public void setNome(String nome) {
this.nome = nome;
}


public Docente getCodDoc() {
return cod_doc;
}

public void setCodDoc (Docente cod_doc) {
this.cod_doc = cod_doc;
}

public LocalDate getData() {
return data;
}

public void setData(LocalDate data) {
	this.data=data;
}

public Aula getCodAula() {
return cod_aula;
}

public void setCodAula (Aula cod_aula) {
this.cod_aula = cod_aula;
}

public Docente getCodDocente() {
return cod_doc;
}

public void setCodDocente (Docente cod_docente) {
this.cod_doc = cod_docente;
}

public Set<Discente> getDiscenti() {
	return discenti;
}

public void setDiscenti(Set<Discente> discenti) {
	this.discenti = discenti;
}



}