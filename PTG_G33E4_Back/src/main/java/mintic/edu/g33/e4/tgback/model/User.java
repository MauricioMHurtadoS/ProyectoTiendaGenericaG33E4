package mintic.edu.g33.e4.tgback.model;

import javax.persistence.*;

@Entity
@Table(name="User.TABLE_NAME")
public class User {
	
	public static final String TABLE_NAME="user";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="idTipoDocumento")
	private TypeDocument idTipoDocumento;
	
	@Column(name="numDocumento")
	private String numDocumento;
	
	@Column(name="name")
	private String name;
	
	@Column(name="psswrd")
	private String psswrd;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="email")
	private String email;

	public User(Long id, TypeDocument idTipoDocumento, String numDocumento, String name, String psswrd,
			String userName, String email) {
		this.id = id;
		this.idTipoDocumento = idTipoDocumento;
		this.numDocumento = numDocumento;
		this.name = name;
		this.psswrd = psswrd;
		this.userName = userName;
		this.email = email;
	}

	public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypeDocument getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(TypeDocument idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPsswrd() {
		return psswrd;
	}

	public void setPsswrd(String psswrd) {
		this.psswrd = psswrd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
