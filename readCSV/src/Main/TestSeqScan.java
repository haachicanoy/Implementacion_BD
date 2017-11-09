package Main;

import java.util.List;

public class TestSeqScan {

	public static void main(String[] args) {
		
		SeqScan scan = new SeqScan("A");
		int count = 0;
		while (scan.hasNext()) {
			count++;
			List<Object> list = (List<Object>) scan.next();
			String row = count+":";
			for (Object object : list) {
				row = row+" - "+String.valueOf(object);
				}
			System.out.println(row);
		}
		System.out.println("End: "+count);
	}

}
