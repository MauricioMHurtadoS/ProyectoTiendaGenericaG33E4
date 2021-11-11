package mintic.edu.g33.e4.tgback.model;

import javax.persistence.*;

@Entity
@Table(name= TypeDocument.TABLE_NAME)
public class TypeDocument {
	
	public static final String TABLE_NAME="typedocument";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="tipo")
	private String tipo;

	public TypeDocument() {
	}

	public TypeDocument(Long id, String tipo) {
		this.id = id;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
