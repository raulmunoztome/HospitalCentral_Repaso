import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.Objects;

public class Cita implements Comparable<Cita> {
	private Pacient paciente;
	private Doctor doctor;
	private LocalDate data;
	private LocalTime hora;
	private EstadoCita estat;

	public Cita(Pacient paciente, Doctor doctor, LocalDate data, LocalTime hora) throws Exception {
		LocalDateTime fechaHoraCita = LocalDateTime.of(data, hora);
		this.paciente = paciente;
		this.doctor = doctor;
		if (fechaHoraCita.isBefore(LocalDateTime.now()))
			throw new Exception("Fecha de la cita no válida");
		this.data = data;
		this.hora = hora;
		this.estat = EstadoCita.PENDIENTE;
	}

	/**
	 * 
	 * @return true si era posible cancelar. False si está ya cancelada
	 */
	public boolean anularCita() {

		if (estat != EstadoCita.REALIZADA) {
			this.estat = EstadoCita.CANCELADA;
			return true;

		}
		return false;
	}

	/**
	 * Si la cita NO está cancelada, la marca como realizada
	 */
	public void visitaRealizada() {

		if (estat != EstadoCita.CANCELADA)
			estat = EstadoCita.REALIZADA;
	}

	/**
	 * 
	 * @return true si la edad del paciente corresponde en el rango de edad min o
	 *         max
	 */

	public boolean comprobarEdad() {

		LocalDate cliente = paciente.getNaixement();
		LocalDate ahora = LocalDate.now();
		int edadCliente = Period.between(cliente, ahora).getYears();
		int min = doctor.getEspecialitat().getEdatMin();
		int max = doctor.getEspecialitat().getEdatMax();

		if (edadCliente >= min && edadCliente <= max) {
			return true;
		}
		return false;

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
		if (data.isAfter(LocalDate.now()))
			this.data = data;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		LocalDateTime fechaHoraCita = LocalDateTime.of(data, hora);
		if (fechaHoraCita.isAfter(LocalDateTime.now()))
			this.hora = hora;
	}

	public EstadoCita getEstat() {
		return estat;
	}

	public void setEstat(EstadoCita estat) {
		this.estat = estat;
	}

	@Override
	public int hashCode() {

		return Objects.hash(data, hora, doctor.getDni());

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

		return Objects.equals(data, other.data) && Objects.equals(hora, other.hora)
				&& Objects.equals(doctor.getDni(), other.doctor.getDni());

	}

	@Override
	public int compareTo(Cita c) {

		// Primero por fecha, luego hora, y luego por dni del doctor
		int comparacionData = this.getData().compareTo(c.getData());
		if (comparacionData != 0) {
			return comparacionData;
		}

		int comparacionHora = this.getHora().compareTo(c.getHora());
		if (comparacionHora != 0)
			return comparacionHora;

		return this.doctor.getDni().compareTo(c.getDoctor().getDni());
	}

	@Override
	public String toString() {
		return "Cita (estado: " + estat + ")[paciente=" + paciente + ", doctor=" + doctor + ", data=" + data + ", hora="
				+ hora + "]";
	}

}
