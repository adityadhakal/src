import java.io.IOException;


public class Main {

	public static void main(String[] args) throws IOException {
			
		Reader read = new Reader();
		read.readCsv();
		read.testDictionary("4674");//gives out 190006922
		read.testDictionary("4677");//gives out 190029451 190066016
		read.testDictionary("4655");
	}

}
