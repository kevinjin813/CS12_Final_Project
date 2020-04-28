package main;
/**
 * This class build the station by plugging in name. And within this class you could add train and people in it.
 * Known Bugs: None
 * @author Jian Yu;Yiming Zhang
 */
public class Station {

	public Queue<Rider> northBoundRiders;
	public Queue<Rider> southBoundRiders;
	public Queue<Train> northBoundTrains;
	public Queue<Train> southBoundTrains;
	/**
	 * name records the name of the station
	 */
	public String name;
	public Station(String name) {
		this.name=name;
		northBoundRiders=new Queue(20);
		southBoundRiders=new Queue(20);
		northBoundTrains=new Queue(20);
		southBoundTrains=new Queue(20);	
	}
	/**
	 * This method add the rider in side the station.
	 * @param r   the rider that is going to be added
	 * @return    whether the rider could be added or not
	 */
	public boolean addRider(Rider r) { 
		if(!r.start.equals(name))
		{
			return false;
		}
		else
		{
			if(r.gonorth==0)
			{
				northBoundRiders.enqueue(r);
			}
			else
				southBoundRiders.enqueue(r);
			return true;
		}
	}
	/**
	 * This method add the train in the station.	
	 * @param t  the train is added.
	 * @return   The disembark passengers.
	 */
	public String addTrain(Train t) {
		if(t.gonorth==0)
		{
			northBoundTrains.enqueue(t);
			t.cs=name;
		}
		else
		{
			southBoundTrains.enqueue(t);
			t.cs=name;
		}
			
		String h=t.disembarkPassengers();
		String result=name+" Disembarking Passengers:\n";
		result=result+h;
		result=result+"Direction: ";
		if(t.gonorth==0)
		{
			result=result+" Northbound\n";
		}
		else
			result=result+" Southbound\n";
		result=result+t.toString();
		result=result+"Current station: "+name+"\n";
		result=result+"\n";
		return result;
	}
	/**
	 * This method board the riders in the south bound queue into the trains.
	 * @return  the train that the rider gets on.
	 */
	public Train southBoardTrain() {
		if(southBoundTrains.front()!=null)
		{
			Train t=southBoundTrains.front();
			if(southBoundRiders.front()==null)
			{
				southBoundTrains.dequeue();
				return t;
			}
			else
			{
				Rider m=southBoundRiders.front();
				while(t.addPassenger(m)==true)
				{
					southBoundRiders.dequeue();
					m=southBoundRiders.front();
				}
				southBoundTrains.dequeue();
				return t;
			}
		}
		else
			return null;
	}
	/**
	 * This method boards the rider that in the north bound queue
	 * @return  the train that the rider gets on.
	 */
	public Train northBoardTrain() {
		if(northBoundTrains.front()!=null)
		{
			Train t=northBoundTrains.front();
			if(northBoundRiders.front()==null)
			{
				northBoundTrains.dequeue();
				return t;
			}
			else
			{
				Rider m=northBoundRiders.front();
				while(t.addPassenger(m)==true)
				{
					northBoundRiders.dequeue();
					m=northBoundRiders.front();
				}
				northBoundTrains.dequeue();
				return t;
			}
		}
		else return null;
		
	}
	/**
	 * whether the station has the train
	 * @param s   the queue of train
	 * @return    whether the queue has the train
	 */
	public boolean haveTrain(Queue s)
	{
		if(s.numEntries==0)
		{
			return false;
		}
		else
			return true;
	}
	/**
	 * This method move the train in north bound queue to south bound queue
	 */
	public void moveTrainNorthToSouth() {
		Train t=northBoundTrains.front();
		if(t!=null)
		t.gonorth=1;
		northBoundTrains.dequeue();
		southBoundTrains.enqueue(t);
	}
	/**
	 * This method move the train in south bound queue to north bound queue
	 */
	public void moveTrainSouthToNorth() {
		Train t=southBoundTrains.front();
		if(t!=null)
		t.gonorth=0;
		southBoundTrains.dequeue();
		northBoundTrains.enqueue(t);
	}
	
	@Override
	/**
	 * This prints the queues inside the station.
	 */
	public String toString() {
		String result="Station: "+name+"\n";
		result=result+northBoundTrains.num()+" north-bound trains waiting\n";
		result=result+southBoundTrains.num()+" south-bound trains waiting\n";
		result=result+northBoundRiders.num()+" north-bound passengers waiting\n";
		result=result+southBoundRiders.num()+" south-bound passengers waiting\n";
		return result;
	}
	/**
	 * this method gets the name of the station
	 * @return the name of the station
	 */
	public String stationName() {
		return name;
	}
	
	@Override
	/**
	 * whether the station is the same one based on the name.
	 */
	public boolean equals(Object o) {
		if(o instanceof Station)
		{
			Station s=(Station) o;
			if(name.equals(s.name))
			{
				return true;
			}
			else return false;
		}
		return false;
	}
}
