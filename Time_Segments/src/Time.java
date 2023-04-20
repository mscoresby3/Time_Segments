
public class Time {

	private int days;
	private int hours;
	private int minutes;
	private double seconds;

	public Time(int days, int hours, int minutes, double seconds) throws Exception {
		boolean throwException = false;
		String exceptionMessage = "";
		if (days < 0) {
			throwException = true;
			exceptionMessage = "Days, ";
		}
		if (hours < 0) {
			throwException = true;
			exceptionMessage += "Hours, ";
		}
		if (minutes < 0) {
			throwException = true;
			exceptionMessage += "Minutes, ";
		}
		if (seconds < 0) {
			throwException = true;
			exceptionMessage += "Seconds, ";
		}
		if (throwException) {
			exceptionMessage = exceptionMessage.substring(0, exceptionMessage.length() - 2)
					+ " Must be Greater than or Equal to Zero";
		} else {
			this.days = days;
			this.hours = hours;
			this.minutes = minutes;
			this.seconds = seconds;
		}
	}

	public double getSeconds() {
		return this.seconds;
	}

	public void setSeconds(double seconds) throws Exception {
		if (seconds >= 0) {
			this.seconds = seconds;
		} else {
			throw new Exception("Seconds Must be Greater than or Equal to Zero");
		}
	}
	
	public int getMinutes() {
		return this.minutes;
	}
	
	public void setMinutes(int minutes) throws Exception {
		if (minutes >= 0) {
			this.minutes = minutes;
		} else {
			throw new Exception("Minutes Must be Greater than or Equal to Zero");
		}
	}

	public void secondsToMinutes() {
		while (this.seconds >= 60) {
			this.seconds -= 60;
			this.minutes++;
		}
	}
	
	public int getHours() {
		return this.hours;
	}
	
	public void setHours(int hours) throws Exception {
		if (hours >= 0) {
			this.hours = hours;
		} else {
			throw new Exception("Hours Must be Greater than or Equal to Zero");
		}
	}

	public void minutesToHours() {
		while (this.minutes >= 60) {
			this.minutes -= 60;
			this.hours++;
		}
	}
	
	public int getDays() {
		return this.days;
	}
	
	public void setDays(int days) throws Exception {
		if (days >= 0) {
			this.days = days;
		} else {
			throw new Exception("Days Must be Greater than or Equal to Zero");
		}
	}

	public void hoursToDays() {
		while (this.hours >= 24) {
			this.hours -= 24;
			this.days++;
		}
	}

	public void allMax() {
		this.secondsToMinutes();
		this.minutesToHours();
		this.hoursToDays();
	}

	public void daysToHours() {
		while (this.days != 0) {
			this.hours += 24;
			this.days--;
		}
	}
	
	/*public String toString() {
	*	return "Days: " + this.days + " Hours: " + this.hours + " Mintues: " + this.minutes + " Seconds" + this.seconds;
	*}
	*/
	
	public String toString() {
		String message = "";
		if (this.days != 0) {
			message = " Days: " + this.days;
		}
		if (this.hours != 0) {
			message += " Hours: " + this.hours;
		}
		if (this.minutes != 0) {
			message += " Minutes: " + this.minutes;
		}
		if (this.seconds != 0) {
			message += " Seconds: " + this.seconds;
		}
		message = message.substring(1, message.length());
		return message;
	}
}
