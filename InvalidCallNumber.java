import java.util.InputMismatchException;

public class InvalidCallNumber extends InputMismatchException{
	//constructors
		/**
		 * default constructor
		 */
		public InvalidCallNumber() {
			super();
		}
		
		/**
		 * constructor
		 * @param message error message
		 */
		public InvalidCallNumber(String message) {
			super(message);
		}

}
