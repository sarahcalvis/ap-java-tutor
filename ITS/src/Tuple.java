
public class Tuple extends Student{
	private int x;	//num correct
	private int y;	//num asked
	
	public Tuple() {
		x=0;
		y=0;
	}	
	public Tuple(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "" + x + " " + y;
	}
	
	
	/**
	 * used to update a categories %accuatage by using a total of correct over asked
	 * @param numCorrect	keeps percentage accurate
	 * @param numAsked		keeps percentage accurate
	 */
	public void updateTuple(int numCorrect, int numAsked) {
		x += numCorrect;
		y += numAsked;
		saveProgress();
	}
	
	
	/**
	 * 
	 * @return double result of x / y *100.0
	 * can be used as a grade or percentage
	 */
	public Double getTuple() {
		if (y != 0) {
			return x / y * 100.0;
		}
		return -1.0;
	}
	
}
