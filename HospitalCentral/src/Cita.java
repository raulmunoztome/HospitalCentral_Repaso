import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {
	private Pacient paciente;
	private Doctor doctor;
	private LocalDate data;
	private LocalTime hora;
	private EstadoCita estat;

	public Cita(Pacient paciente, Doctor doctor, LocalDate data, LocalTime hora, EstadoCita estat) {

		this.paciente = paciente;
		this.doctor = doctor;
		this.data = data;
		this.hora = hora;
		this.estat = estat;
	}

	public Pacient getPaciente() {
		return paciente;
	}

	public void setPaciente(Pacient paciente) {
		this.paciente = paciente;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public EstadoCita getEstat() {
		return estat;
	}

	public void setEstat(EstadoCita estat) {
		this.estat = estat;
	}

}
