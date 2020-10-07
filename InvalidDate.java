import java.util.InputMismatchException;

public class InvalidDate extends InputMismatchException {
	//constructors
		/**
		 * default constructor
		 */
		public InvalidDate() {
			super();
		}
		
		/**
		 * constructor
		 * @param message error message
		 */
		public InvalidDate(String message) {
			super(message);
		}

}
