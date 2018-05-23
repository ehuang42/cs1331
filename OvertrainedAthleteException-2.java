/**
 * An Exception that prevents overtraining of an athlete.
 *
 * @author ehuang42
 * @version 9.0.1
 */

public class OvertrainedAthleteException extends RuntimeException {


    /**
     * Public constructor for OvertrainedAthleteException.
     * @param par the String the exception takes in
     */

    public OvertrainedAthleteException(String par) {
        super(par);
    }
}