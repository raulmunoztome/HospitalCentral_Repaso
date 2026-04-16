import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
		if (nom.isBlank() || direc.isBlank())
			throw new Exception("Nombre y direccion del hospital son obligatorios");
		this.nom = nom;
		this.direc = direc;
		this.pacientes = new HashSet<>();
		this.doctores = new HashSet<>();
		this.especialidades = new HashSet<>();
		this.citas = new TreeSet<>();

	}

	public Hospital() {

	};

	/**
	 * 
	 * @param p Objeto paciente
	 * @return true si lo ha podido añadir
	 */
	public boolean sumarPaciente(Pacient p) {

		return pacientes.add(p);
	}

	/**
	 * 
	 * @param d Objeto doctor
	 * @return true si lo ha podido añadir
	 */
	public boolean sumarDoctor(Doctor d) {

		return doctores.add(d);

	}

	/**
	 * 
	 * @param e Objeto Especialitat
	 * @return true si se ha podido añadir
	 */
	public boolean sumarEspecialidad(Especialitat e) {

		return especialidades.add(e);
	}

	/**
	 * 
	 * @param c Objeto cita
	 * @return true si se ha podido añadir
	 */
	public boolean sumarCita(Cita c) {

		return citas.add(c);
	}

	/**
	 * Elimina al paciente (si existe) y sus citas registradas
	 * 
	 * @param p Objeto paciente
	 * @return true si estaba en la lista
	 */
	public boolean quitarPaciente(Pacient p) {

		if (pacientes.contains(p)) {

			Iterator<Cita> itr = citas.iterator();
			Cita element;

			while (itr.hasNext()) {
				// itr para quitar las citas
				element = itr.next();
				if (element.getPaciente().equals(p)) {
					itr.remove();
				}

			}
			return pacientes.remove(p);
		}
		return false;
	}

	/**
	 * 
	 * @param d Objeto doctor
	 * @return true si estaba en la lista y se ha eliminado
	 */
	public boolean quitarDoctor(Doctor d) {

		if (doctores.contains(d)) {
			return doctores.remove(d);
		}
		return false;

	}

	/**
	 * 
	 * @param e Objeto Especialidad
	 * @return true si estaba en la lista y se ha podido eliminar
	 */
	public boolean quitarEspecialidad(Especialitat e) {

		if (especialidades.contains(e)) {
			return especialidades.remove(e);
		}
		return false;
	}

	/**
	 * 
	 * @param c Objeto Cita
	 * @return true si estaba en la lista de citas y se ha eliminado
	 */
	public boolean quitarCita(String dni, LocalDate data, LocalTime hora) {

		Iterator<Cita> itr = citas.iterator();
		Cita element;

		while (itr.hasNext()) {
			// itr para quitar las citas
			element = itr.next();
			if (element.getData().equals(data) && element.getPaciente().dni.equals(dni)
					&& element.getHora().equals(hora)) {
				itr.remove();
				return true;
			}

		}
		return false;
	}

	/**
	 * 
	 * @return Devuelve un arrayList de los pacientes actuales
	 */
	public List<Pacient> infoPaciente() {

		List<Pacient> infos = new ArrayList<>(pacientes);
		return infos;
	}

	/**
	 * 
	 * @return ArrayList de los doctores actuales
	 */

	public List<Doctor> infoDoctor() {

		List<Doctor> infoD = new ArrayList<>(doctores);
		return infoD;
	}

	/**
	 * 
	 * @return ArrayList de las especialidades del hospital
	 */
	public List<Especialitat> infoEspecialitat() {

		List<Especialitat> infoE = new ArrayList<>(especialidades);
		return infoE;
	}

	/**
	 * 
	 * @return ArraList de las citas del hospital
	 */
	public List<Cita> infoCitas() {
		List<Cita> infoC = new ArrayList<>(citas);
		return infoC;
	}

	/**
	 * 
	 * @param fecha donde obtener las citas
	 * @return ArrayList con las citas del dia indicado
	 */
	public List<Cita> citasDeHoy(LocalDate fecha) {
		List<Cita> citasFecha = new ArrayList<>();
		for (Cita c : citas) {
			if (c.getData().equals(fecha))
				citasFecha.add(c);
		}
		return citasFecha;
	}

	/**
	 * 
	 * @return Devuelve el size del set de pacientes
	 */
	public int cantidadPacientes() {

		return pacientes.size();

	}

	public boolean modificarEstadoCita(String dni, LocalDate data, LocalTime hora) {
		for (Cita c : citas) {
			if (c.getDoctor().getDni().equals(dni) && c.getData().equals(data) && c.getHora().equals(hora)) {
				if (c.getEstat() != EstadoCita.CANCELADA) {
					c.visitaRealizada();
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Hospital [nom=" + nom + ", direc=" + direc + ", pacientes=" + pacientes + ", doctores=" + doctores
				+ ", especialidades=" + especialidades + ", citas=" + citas + "]";
	}

}
