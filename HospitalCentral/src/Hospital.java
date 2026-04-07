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

	public Hospital(String nom, String direc) {

		this.nom = nom;
		this.direc = direc;
		this.pacientes = new HashSet<>();
		this.doctores = new HashSet<>();
		this.especialidades = new HashSet<>();
		this.citas = new TreeSet<>();

	}

}
