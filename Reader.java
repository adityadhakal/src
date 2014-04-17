import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/**
 *@author Aditya Dhakal
 *This program Reads CSV file and pharse it
*into useful and non useful info
**/
public class Reader
{
	String fileName = "geneva_id.csv";
	BufferedReader br = null;
	String line = "";
	String splitter = ",";
	int counter = 0;
	
	//Making the dictionary between the sample number and Geneva ID
	Map<String, String> samp_to_geneva_dic = new HashMap<String, String>();
	public void readCsv() throws IOException
	{
		
		
		// Trying to split the file line by line and then making a dictionary out of it
		
		try{
			
			br = new BufferedReader(new FileReader(fileName));
			
			while((line = br.readLine())!=null){
				
				String[] ids = line.split(splitter); //Splitting the CSV
				samp_to_geneva_dic.put(ids[0], ids[1]); //Putting the value into dictionary, maps sample num (key) to Geneva ID (value)
				counter++;
				
			}
		}
		catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
		
		finally{
				if (br != null){
					try{
					br.close();
					}
					catch(IOException e)
					{
						e.printStackTrace();
					}
				}
			}
	System.out.println("Done with Reading and Printing total rows is "+counter);
	}
	
	//Just to test if the Dictionary is working
	public void testDictionary(String testid)
	{
		String value = samp_to_geneva_dic.get(testid);
		System.out.println("The value for the key "+ testid+" is "+value);
	}
	
}
