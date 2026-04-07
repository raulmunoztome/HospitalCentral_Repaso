import java.time.LocalDate;

public class Doctor extends Persona {
	private Especialitat especialitat;
	private int codi;
	private static int doctoresCreados;

	public Doctor(String nom, String dni, LocalDate naixement, String telefon, Especialitat especialitat,
			int codiAutomatic) {
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

}
