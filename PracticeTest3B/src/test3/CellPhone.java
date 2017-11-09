package test3;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A class that represents a cell phone. Every cell phone has a cell
 * number. The cell phone and its cell number form a composition. 
 * 
 * <p>
 * Every cell phone has a call log. The cell
 * phone and its call log form a composition. A call log is a list of cell numbers 
 * that have been called using this cell phone. The order of contacts in 
 * the call log are from the oldest call to the most recent call. 
 * 
 */
public class CellPhone {

	/**
	 * The cell number of this phone.
	 */
	private CellNumber number;
		
	/**
	 * The call log of this phone. 
	 */
	private List<CellNumber> callLog;

	/**
	 * Initializes this cell phone to have a valid cell number. Do not
	 * duplicate the code in this constructor; it is here for testing purposes
	 * in case your constructors are not implemented correctly.
	 */
	public CellPhone() {
		try {
			Test3BUtils.initialize(this);
		} catch (Exception x) {
			System.out.println("something went wrong");
			throw new NullPointerException();
		}

		this.number = new CellNumber(416,888,7891);
		callLog = new ArrayList<>();
	}

	/**
	 * Initializes this cell phone given its cell number. The call log for this
	 * cell phone is initialized as an empty list.
	 *  
	 * @param number
	 *            the cell number for this phone 
	 * @pre. number != null
	 */
	public CellPhone(CellNumber number) {
		this.number = new CellNumber(number);
		callLog = new ArrayList<>();
	}

	/**
	 * Initializes this cell phone given a cell number and a call log. This cell
	 * phone makes a deep copy of the call log. If the argument call log is
	 * null, then this cell phone is initialized to have an empty call log.
	 * 
	 * @param number
	 *            the number for this phone
	 * @param callLog
	 *            the call log for this phone 
	 * @pre. number != null
	 */
	public CellPhone(CellNumber number, List<CellNumber> callLog) {
		if(callLog == null)
		{
			this.callLog = new ArrayList<>();
		}
		else
		{
			this.callLog = new ArrayList<>();

			for (int i = 0; i < callLog.size();i++)
			{
				CellNumber temp = callLog.get(i);

				this.callLog.add(new CellNumber(temp.getAreaCode(), temp.getExchangeCode(), temp.getStationCode()));
			}
		}
	}
	
	/**
	 * Returns a new copy of the cell number for this phone.
	 * 
	 * @return a new copy of the cell number for this phone
	 */
	public CellNumber getNumber() {
		return new CellNumber();
	}
	
	/**
	 * Sets the cell number of this phone to a new copy of the
	 * given cell number.
	 * 
	 * @param number the new cell number for this phone
	 */
	public void setNumber(CellNumber number) {
		
	}

	/**
	 * Returns a shallow copy of call log for this phone.
	 * 
	 * @return a shallow copy of the call log for this phone
	 */
	public List<CellNumber> getCallLog() {
		
	}
	
	
	/**
	 * Returns the favorite cell number that has been called using this cell phone.
	 * The favorite number is the one that has been called the most number
	 * of times. For the sake of simplicity, you may assume that there is
	 * a unique favorite phone number (i.e., there is no other cell number
	 * that has been dialed as many times as the favorite).
	 * 
	 * <p>
	 * Returns null if this cell phone has never dialed a cell number.
	 * 
	 * <p>
	 * Hint: Use Collections.frequency
	 *  
	 * @return the favorite cell number that has been called using this cell phone
	 */
	public CellNumber favorite() {
		
	}

	/**
	 * Dial a cell number using this phone. Causes the dialed
	 * number to be added to the end of the call log.
	 * 
	 * @param number a cell number to dial
	 * @throws IllegalArgumentException if number == null
	 */
	public void dial(CellNumber number) {
		
	}

	/**
	 * Returns a string representation of this cell phone. The returned string
	 * is the phone number (as returned by the CellNumber version of toString).
	 * 
	 * @return a string representation of this cell phone
	 */
	@Override
	public String toString() {
		
	}
	
}
