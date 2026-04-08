import java.time.LocalDate;
import java.util.Objects;

public class Doctor extends Persona {
	private Especialitat especialitat;
	private int codi;
	private static int doctoresCreados;

	public Doctor(String nom, String dni, LocalDate naixement, String telefon, Especialitat especialitat,
			int codiAutomatic) throws Exception {
		super(nom, dni, naixement, telefon);
		this.especialitat = especialitat;
		this.codi = doctoresCreados;

		++doctoresCreados;
	}

	public Especialitat getEspecialitat() {
		return especialitat;
	}

	public void setEspecialitat(Especialitat especialitat) {
		this.especialitat = especialitat;
	}

	public int getCodiAutomatic() {
		return codi;
	}

	public void setCodiAutomatic(int codiAutomatic) {
		this.codi = codiAutomatic;
	}

	public static int getDoctoresCreados() {
		return doctoresCreados;
	}

	@Override
	public int hashCode() {

		return Objects.hash(codi, especialitat);

	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Doctor other = (Doctor) obj;

		return Objects.equals(codi, other.codi) && Objects.equals(especialitat, other.especialitat);

	}

}
