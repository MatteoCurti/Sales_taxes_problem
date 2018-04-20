package round;

import java.text.DecimalFormat;

public class Round {
	
	public static String format(double d) {
		DecimalFormat nf = new DecimalFormat("0.00");
        String s = nf.format(d);
        s = s.replace(",", ".");
        return s;
	}
}
