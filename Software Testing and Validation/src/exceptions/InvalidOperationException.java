package exceptions;

public class InvalidOperationException extends Exception {
	public InvalidOperationException() {
		super();
	}
	
	public InvalidOperationException(String msg) {
		super(msg);
	}
}
