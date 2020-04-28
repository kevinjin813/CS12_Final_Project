package main;
/**
 * This class simulates the railway by building the DDL and plug in the station rider and trains.
 * Known Bugs: None
 * @author Jian Yu;Yiming Zhang
 */
public class Railway {

	public DoubleLinkedList<Station> railway;
	public String[] stationNames=new String[18];
	int k=0;
	/**
	 * This is the constructor of building a railway system.
	 */
	public Railway() {
		railway=new DoubleLinkedList();
	}
	/**
	 * This method add the station in the existing railway station.
	 * @param s   the station that is going to be added to the railway.
	 */
	public void addStation(Station s) {
		railway.insert(s);
	    stationNames[k]=s.name;
	    k++;
	}
	/**
	 * THis method add the rider in the stations that they start traveling.
	 * @param r    the rider that is going to be added to the station.
	 */
	public void addRider(Rider r) {
		setRiderDirection(r);
		Station s=new Station(r.start);
		railway.get(s).addRider(r);
	}
	/**
	 * This method add the train in the stations that they start running.
	 * @param t   the train that is going to be added to the station.
	 */
	public void addTrain(Train t) {
		Station s=new Station(t.cs);
		railway.get(s).addTrain(t);
	}
	
	/**
	 * This method set the riders' direction based on their start and dest.
	 * @param r    the rider that is going to be set direction.
	 */
	public void setRiderDirection(Rider r) {
		int h=0;
		for(int i=0;i<=stationNames.length-1;i++)
		{
			if(r.dest.equals(stationNames[i]))
			{
				r.gonorth=0;
				break;
			}
			if(r.start.equals(stationNames[i]))
			{
				r.gonorth=1;
				break;
			}
		}
	}
	/**
	 * This method simulate one time running of the railway system,.
	 * @return   The traversal of every station and the disembarkpassengers.
	 */
	public String simulate() {
		String result="";
		for(int i=0;i<=stationNames.length-1;i++)
		{
			Station s=new Station(stationNames[i]);
			s=railway.get(s);
			result=result+s.toString()+"\n\n";
			Node location=railway.getlocation(s);
			if(i==stationNames.length-1 && s.southBoundTrains.size()!=0)
			{
				Train north=s.northBoardTrain();
				if(north!=null)
				{
					Node prev=location.prev;
					s=railway.data(prev);
					String m=s.addTrain(north);
					if(m!=null)
					result=result+m;
					
				}
				s=railway.data(location);
				s.moveTrainSouthToNorth();
			}
			else if(i==0 && s.northBoundTrains.size()!=0)
			{				
				Train south=s.southBoardTrain();
				if(south!=null)
				{
					Node next=location.next;
					s=railway.data(next);
					String m=s.addTrain(south);
					if(m!=null)
					result=result+m;			
				}
				s=railway.data(location);
				s.moveTrainNorthToSouth();
			}
			else
			{
				Train south=s.southBoardTrain();
				Train north=s.northBoardTrain();
				if(north!=null)
				{
					Node prev=location.prev;
					if(prev!=null)
					{
						s=railway.data(prev);
						String m=s.addTrain(north);
						if(m!=null)
						{
							result=result+m;
						}

					}	
				}
				if(south!=null)
				{
					Node next=location.next;
					if(next!=null)
					{
						s=railway.data(next);
						String m=s.addTrain(south);
						if(m!=null)
						result=result+m;
					}	
				}	
			}		
		}
		return result;
	}
	@Override
	/**
	 * THis method transfer the system into the printable result.
	 */
	public String toString() {
		String result="";
		Node temp=railway.head;
		while(temp!=null)
		{
			result=result+temp.data.toString()+"\n\n";
			temp=temp.next;
		}
		return result;
	}
}
