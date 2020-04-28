package main;
/**
 * This class build a rider by plugging the ID, the start, and the dest.
 * Known Bugs: None
 * @author Jian Yu
 * email kevinjin813@brandeis.edu
 * 2/27/2020
 * COSI 21A PA1
 */
public class Rider {
	public String id;
	public String start;
	public String dest;
	public String current;
	public int gonorth=1;
	public boolean onTrain;
	private String[] station= {"Alewife","Davis","Portor","Harvard","Central","Kendall/MIT","Charles/MGH","Park Street","Downtown Crossing","South Station","Broadway","Andrew","JFK/UMass","North Quincy","Wollaston","Quincy Center","Quincy Adams","Braintree"};
	/**
	 * This is the constructor to build a rider.
	 * @param riderID      The id of the rider
	 * @param startingStation       THe start station of the rider
	 * @param destinationStation       The destination of the rider
	 */
	public Rider(String riderID, String startingStation, String destinationStation) {
		id=riderID;
		start=startingStation;
		dest=destinationStation;
		current=startingStation;
	}
	/**
	 * This is the method get the start of the rider
	 * @return   the name of the start station
	 */
	public String getStarting() {
		return start;
	}
	/**
	 * This is the method get the destination of the rider
	 * @return    the name of the dest station
	 */
	public String getDestination() {
		return dest;
	}
	/**
	 * THis method get the ID of the rider
	 * @return   the id of the rider
	 */
	public String getRiderID() {
		return id;
	}
	/**
	 * This method determine whether the rider going north.
	 * @return  true of false
	 */
	public boolean goingNorth() {
		return gonorth==0;
	}
	/**
	 * This method swap the direction of the rider.
	 */
	public void swapDirection() {
		if(gonorth==0)
		{
			gonorth=1;
		}
		else
			gonorth=0;
	}
	
	@Override
	/**
	 * This method get the rider's information.
	 */
	public String toString() {
		return id+", "+current;
	}
	
	@Override
	/**
	 * This method determines whether the rider is the one based on the name.
	 */
	public boolean equals(Object s) {
		if(s instanceof Rider)
		{
			Rider k= (Rider) s;
			if(k.id.equals(this.id))
			{
				return true;
			}
			else
				return false;
		}
		return false;
	}
	
}
