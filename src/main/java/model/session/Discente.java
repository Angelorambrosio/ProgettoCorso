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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ConstraintMode;


@Entity
@Table(name = "HB_DISCENTE1")
public class Discente {
	
//	public static final String PROPERTY_matricola = "titolo_di_studio";

	
	
	public static final String PROPERTY_cognome = "cognome";
	public static final String PROPERTY_nome = "nome";
	public static final String PROPERTY_matricola = "matricola";

	@Column(name = "matricola")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int matricola;

	@Column(name = "cognome")
	private String cognome;

	@Column(name = "nome")
	private String nome;

	@ManyToMany(fetch = FetchType.LAZY, cascade =
        {
                CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.REFRESH,
                CascadeType.PERSIST
        },targetEntity = Corso.class)
	@JoinTable(
		name = "HB_DISCENTI_CORSO",
		joinColumns = {@JoinColumn(name = "matricola")},
		inverseJoinColumns = {@JoinColumn(name = "id")},
		foreignKey = @javax.persistence.ForeignKey(ConstraintMode.CONSTRAINT),
		inverseForeignKey = @javax.persistence.ForeignKey(ConstraintMode.CONSTRAINT)	
	)
	private Set<Corso> corsi = new HashSet<>();
	
	public Set<Corso> getCorsi() {
		return corsi;
	}

	public void setCorsi(Set<Corso> corsi) {
		this.corsi = corsi;
		}

	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


}