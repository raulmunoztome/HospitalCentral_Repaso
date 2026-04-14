import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Persona {
	protected String nom;
	protected String dni;
	protected LocalDate naixement;
	protected String telefon;

	public Persona(String nom, String dni, String naixement, String telefon) throws Exception {
		LocalDate fecha = LocalDate.parse(naixement, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.nom = nom;
		if (dni.isBlank())
			throw new Exception("Error en el DNI: " + dni);
		this.dni = dni;
		if (naixement == null || fecha.isAfter(LocalDate.now()))
			throw new Exception("error en la fecha de nacimiento: " + naixement);
		this.naixement = fecha;
		if (telefon.isBlank())
			throw new Exception("Error en el número de telefono: " + telefon);
		this.telefon = telefon;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		if (!nom.isBlank())
			this.nom = nom;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		if (!dni.isBlank())
			this.dni = dni;
	}

	public LocalDate getNaixement() {
		return naixement;
	}

	public void setNaixement(LocalDate naixement) {
		if (naixement != null && !LocalDate.now().isAfter(naixement))
			this.naixement = naixement;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		if (!telefon.isBlank())
			this.telefon = telefon;
	}

	@Override
	public int hashCode() {

		return Objects.hash(dni);

	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Persona other = (Persona) obj;

		return Objects.equals(dni, other.dni);

	}

	@Override
	public String toString() {
		return "Persona [nom=" + nom + ", dni=" + dni + ", naixement=" + naixement + ", telefon=" + telefon + "]";
	}

}
