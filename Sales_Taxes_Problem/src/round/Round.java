package round;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Round {
	
	public static String format(double d) {
		DecimalFormat nf = new DecimalFormat("0.00");
        String s = nf.format(d);
        s = s.replace(",", ".");
        return s;
	}
	
	public static double to05(double d) {
		d = Math.ceil(d / 0.05) * 0.05;
		BigDecimal bd = new BigDecimal(d);
		bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		d = bd.doubleValue();
		return d;
	}

	public static double simple(double d) {
		return ((Math.round(d * 100.0))/100.0);
	}
}
