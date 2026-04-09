
public class InvalidCodiPacientException extends Exception {

	public InvalidCodiPacientException(String message) {

		super(message);

	}

	public String getLocalizedMessage() {

		String error = super.getMessage();

		error += "\nMissatge personalitzat ";

		return error;

	}
}
