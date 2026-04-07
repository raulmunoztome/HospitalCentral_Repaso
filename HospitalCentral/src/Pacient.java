import java.time.LocalDate;
import java.util.regex.Pattern;

public class Pacient extends Persona {
	private String codi;
	private String historialMedico;
	private static int totalPacientesCreados = 0;

	public Pacient(String nom, String dni, LocalDate naixement, String telefon, String codi, String historial)
			throws Exception {
		this(nom, dni, naixement, telefon, codi);
		this.historialMedico = historial;

	}

	public Pacient(String nom, String dni, LocalDate naixement, String telefon, String codi) throws Exception {
		super(nom, dni, naixement, telefon);
		if (!Pattern.matches("^[A-Za-z]{3}[0-9]{8}$", codi))
			throw new Exception("Error en el codigo del paciente");
		this.codi = codi;
		++totalPacientesCreados;
	}

	public String getCodi() {
		return codi;
	}

	public void setCodi(String codi) {
		this.codi = codi;
	}

	public String getHistorialMedico() {
		return historialMedico;
	}

	public void setHistorialMedico(String historialMedico) {
		this.historialMedico = historialMedico;
	}

	public static int getTotalPacientesCreados() {
		return totalPacientesCreados;
	}

}
