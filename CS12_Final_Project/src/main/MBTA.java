package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * This class simulates the MBTA system by Times time. And print out every station's status.
 * Known Bugs: None
 * @author Jian Yu
 * email kevinjin813@brandeis.edu
 * 2/27/2020
 * COSI 21A PA1
 */
public class MBTA {

	public static final int SOUTHBOUND = 1;
	public static final int NORTHBOUND = 0;
	
	static final int TIMES = 6;
	static Railway r;
	/**
	 * 
	 * @param args 
	 * @throws FileNotFoundException   throw the file not found case
	 */
	public static void main(String[] args) throws FileNotFoundException {
		r=new Railway();
		initStations("redLine.txt");
		initTrains("trains.txt");
		initRiders("riders.txt");
		System.out.println("INITIATED RED LINE");
		System.out.println();
		runSimulation();
	}
	/**
	 * This method run the simulation by TIMES time.
	 */
	public static void runSimulation() {
		System.out.println(r.toString());
		for(int i=1;i<=TIMES;i++)
		{
			if(i==1)
				System.out.println("BEGINNING RED LINE SIMULATION");
			System.out.println(" ------ "+ i +" ------ ");
			System.out.println(r.simulate());
		}
	}
	/**
	 * THis method scanned the data in trains file and build trains in the stations.
	 * @param trainsFile   The name of the trains file
	 * @throws FileNotFoundException   Throw away the file not found exception.
	 */
			
	public static void initTrains(String trainsFile) throws FileNotFoundException {
		File tf=new File(trainsFile);
		Scanner f=new Scanner(tf);
		while(f.hasNextLine())
		{
			String name=f.nextLine();
			int direction=f.nextInt();
			String x=f.nextLine();
			Station s=new Station(name);
			Train t=new Train(name,direction);
			String init=r.railway.get(s).addTrain(t);
		}
		
	}
	/**
	 * This method scanned the data in the file and build the riders in the station.
	 * @param ridersFile    The name of the riders file
	 * @throws FileNotFoundException      Throw away file not found case
	 */
	public static void initRiders(String ridersFile) throws FileNotFoundException {
		File rf=new File(ridersFile);
		Scanner f=new Scanner(rf);
		while(f.hasNext())
		{
			String id=f.nextLine();
			String start=f.nextLine();
			String dest=f.nextLine();
			Rider x=new Rider(id,start,dest);
			Station s=new Station(start);
			r.addRider(x);
		}
	}
	/**
	 * This method scanned the data in the station file and build the station in the railway system.
	 * @param stationsFile       The name of stations file
	 * @throws FileNotFoundException         Throw away the file not found case
	 */
	public static void initStations(String stationsFile) throws FileNotFoundException {
		File sf=new File(stationsFile);
		Scanner f=new Scanner(sf);
		while(f.hasNext())
		{
			String name=f.nextLine();
			Station s=new Station(name);
			r.addStation(s);
		}
	}
}
