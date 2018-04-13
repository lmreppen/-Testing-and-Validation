package exceptions;

public class DuplicateNIFException extends Exception {
	public DuplicateNIFException() {
		super("Duplicate NIF");
	}
}
