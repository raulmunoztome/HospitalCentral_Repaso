import java.time.LocalDate;

public abstract class Persona {
	protected String nom;
	protected String dni;
	protected LocalDate naixement;
	protected String telefon;

	public Persona(String nom, String dni, LocalDate naixement, String telefon) {

		this.nom = nom;
		this.dni = dni;
		this.naixement = naixement;
		this.telefon = telefon;
	}

}
