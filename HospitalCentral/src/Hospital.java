import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Hospital {
	private String nom;
	private String direc;
	private Set<Pacient> pacientes;
	private Set<Doctor> doctores;
	private Set<Especialitat> especialidades;
	private Set<Cita> citas;

	public Hospital(String nom, String direc) throws Exception {
		if(nom.isBlank() || direc.isBlank()) throw new Exception("Nombre y direccion del hospital son obligatorios");
		this.nom = nom;
		this.direc = direc;
		this.pacientes = new HashSet<>();
		this.doctores = new HashSet<>();
		this.especialidades = new HashSet<>();
		this.citas = new TreeSet<>();

	}

	@Override
	public String toString() {
		return "Hospital [nom=" + nom + ", direc=" + direc + ", pacientes=" + pacientes + ", doctores=" + doctores
				+ ", especialidades=" + especialidades + ", citas=" + citas + "]";
	}
	
}
