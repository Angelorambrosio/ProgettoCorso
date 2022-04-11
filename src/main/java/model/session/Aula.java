package model.session;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "HB_AULA1")

public class Aula {

// public static final String PROPERTY_matricola = "titolo_di_studio";


public static final String PROPERTY_id = "id";
public static final String PROPERTY_numero_posti = "numero_posti";
public static final String PROPERTY_descrizione = "descrizione";

@Column(name = "id")
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;

@Column(name = "numero_posti")
private String numero_posti;

@Column(name = "descrizione")
private String descrizione;

public int getId() {
return id;
}

public void setId(int id) {
this.id = id;
}

@OneToMany(mappedBy = "cod_aula", cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = Corso.class)
Set<Aula> aule = new HashSet<>();

public Set<Aula> getAule() {
	return aule;
}

public void setAule(Set<Aula> aule) {
	this.aule = aule;
}

public String getNumeroPosti() {
return numero_posti;
}

public void setNumeroPosti(String numero_posti) {
this.numero_posti = numero_posti;
}


public String getDescrizione() {
return descrizione;
}

public void setDescrizione(String descrizione) {
this.descrizione = descrizione;
}

// public String getTitoloDiStudio() {
// return titoloDiStudio;
// }
//
// public void setTitoloDiStudio(String titoloDiStudio) {
// this.titoloDiStudio = titoloDiStudio;
// }



}