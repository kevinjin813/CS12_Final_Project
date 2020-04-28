package main;
/**
 * This class build a train by plugging in its direction and current station. And within this class you could add people on the train and disembark them.
 * Known Bugs: None
 * @author Jian Yu;Yiming Zhang
 */
public class Train {

	public static final int TOTAL_PASSENGERS = 10;
	public Rider[] passengers=new Rider[TOTAL_PASSENGERS];
	public int passengerIndex;
	public String cs;
	public int gonorth;
	/**
	 * This is the constructor of the train by taking in current stations and direction
	 * @param currentStation    where station is 
	 * @param direction      going north or south
	 */
	public Train(String currentStation, int direction) {
		cs=currentStation;
		gonorth=direction;

	}
	/**
	 * THis is the method that determine the trains direction.
	 * @return whether the train going north
	 */
	public boolean goingNorth() {
		if(gonorth==0)
			return true;
		else
			return false;
	}
	
	/**
	 * This method swap the direction of the train.
	 */
	public void swapDirection() {
		if(gonorth==0)
		{
			gonorth=1;
		}
		else
			gonorth=0;
	}
	
	/**
	 * This method shows the passengers that are on the train
	 * @return  the name of the passengers.
	 */
	public String currentPassengers() {
		if(passengerIndex==0)
		{
			return "";
		}
		String result=null;
		for(int i=0;i<=passengerIndex-1;i++)
		{
			result=result + passengers[i].toString()+"\n";
		}
		return null;
	}
	
	/**
	 * This method add passengers in the train.
	 * @param r   the rider will be on the train.
	 * @return   whether the passenger could be on the train or not
	 */
	public boolean addPassenger(Rider r) {
		if(r==null || !hasSpaceForPassengers() || r.gonorth!=this.gonorth || !r.current.equals(cs))
		{
			return false;
		}
		passengers[passengerIndex] = r;
		r.onTrain=true;
		passengerIndex++;	
		return true;
	}
	/**
	 * This method determines whether there's place for passengers
	 * @return whether or not
	 */
	public boolean hasSpaceForPassengers() {
		return passengerIndex<=TOTAL_PASSENGERS;
	}
	/**
	 * This method let the riders who is at dest to get off
	 * @return   This method returns the passenger get off.
	 */
	public String disembarkPassengers() {
		String result="";
		int p=passengerIndex;
		for(int i=0;i<=p-1;i++)
		{
			passengers[i].current=cs;
			if(passengers[i].dest.equals(cs))
			{
				
				result=result+passengers[i].id+"\n";
				passengers[i].onTrain=false;
				remove();
				passengerIndex--;
			}
		}
		return result;
	}
	/**
	 * This method remove the riders who has get off from the queue.
	 */
	public void remove()
	{
		int k=0;
		while(passengers[k]!=null)
		{
			if(passengers[k].onTrain==false)
			{
				int j=k;
				if(j==passengerIndex-1)
				{
					passengers[j]=null;
				}
				while(passengers[j+1]!=null && j<passengerIndex)
				{
					passengers[j]=passengers[j+1];
					j++;
				}
			}
			k++;
		}
		passengerIndex=k;
	}
	/**
	 * This method uptate the current station
	 * @param s  the name of the station.
	 */
	public void updateStation(String s) {
		cs=s;
	}
	/**
	 * This method returns the name of the current station
	 * @return   the name of the station.
	 */
	public String getStation() {
		return cs;
	}
	
	@Override
	/**
	 * This method return the passengers on the train.
	 */
	public String toString() {
		String result="Passengers:\n";
		for(int i=0;i<=passengerIndex-1;i++)
		{
			result=result+passengers[i].id+","+passengers[i].dest+"\n";
		}
		return result;
	}
}
