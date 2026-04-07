import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class Cita {
	private Pacient paciente;
	private Doctor doctor;
	private LocalDate data;
	private LocalTime hora;
	private EstadoCita estat;

	public Cita(Pacient paciente, Doctor doctor, LocalDate data, LocalTime hora) throws Exception {
		LocalDateTime fechaHoraCita = LocalDateTime.of(data, hora);
		this.paciente = paciente;
		this.doctor = doctor;
		if(fechaHoraCita.isBefore(LocalDateTime.now())) throw new Exception("Fecha de la cita no válida");
		this.data = data;
		this.hora = hora;
		this.estat= EstadoCita.PENDIENTE;
	}
	public boolean anularCita() {
		
		if(estat != EstadoCita.REALIZADA) {
			this.estat = EstadoCita.CANCELADA;
			return true;
			
		}
		return false;
	}
	public void visitaRealizada() {
		
		if(estat != EstadoCita.CANCELADA)estat = EstadoCita.REALIZADA;
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
		if(data.isAfter(LocalDate.now()))this.data = data;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		LocalDateTime fechaHoraCita = LocalDateTime.of(data, hora);
		if(fechaHoraCita.isAfter(LocalDateTime.now()))this.hora = hora;
	}

	public EstadoCita getEstat() {
		return estat;
	}

	public void setEstat(EstadoCita estat) {
		this.estat = estat;
	}
	
	@Override
	public int hashCode() {

		return Objects.hash(data, hora, paciente.getDni());

	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Cita other = (Cita) obj;

		return Objects.equals(data, other.data) && Objects.equals(hora, other.hora) && Objects.equals(paciente.getDni(), other.paciente.getDni());

	}
	
	public int compareTo(Cita c) {

		// Primero comprar las clases
		int comparacionData = this.getData().compareTo(c.getData());
		if (comparacionData != 0) {
			return comparacionData;
		}
		
		int comparacionHora = this.getHora().compareTo(c.getHora());
		if(comparacionHora != 0) return comparacionHora;
		
		return this.paciente.getDni().compareTo(c.getPaciente().getDni());
	}

	@Override
	public String toString() {
		return "Cita [paciente=" + paciente + ", doctor=" + doctor + ", data=" + data + ", hora=" + hora + ", estat="
				+ estat + "]";
	}
	
	
}
