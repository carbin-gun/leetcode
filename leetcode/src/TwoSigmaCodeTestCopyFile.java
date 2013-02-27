import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class TwoSigmaCodeTestCopyFile {

	/**
	 * Method to get the copy strategy.
	 * @param dataCenters
	 * @return List of copy stragegy.
	 */
	public static ArrayList<String> copyOperations(String[] dataCenters) {
		ArrayList<String> ret = new ArrayList<String>();
		HashMap<String, Integer> dataOverAll = new HashMap<String, Integer>();
		ArrayList<HashSet<String>> centers = new ArrayList<HashSet<String>>();
		for (int i = 0; i < dataCenters.length; i++) {
			HashSet<String> center = new HashSet<String>();
			String[] datas = dataCenters[i].split("\\s");
			for (int j = 1; j < datas.length; j++) {
				center.add(datas[j]);
				dataOverAll.put(datas[j], i + 1);
			}
			centers.add(center);
		}
		for (String dataSet : dataOverAll.keySet()) {
			for (int i = 0; i < centers.size(); i++) {
				if (!centers.get(i).contains(dataSet)) {
					ret.add(generateCopy(dataSet, dataOverAll.get(dataSet), i + 1));
				}
			}
		}
		return ret;
	}
	
	public static String generateCopy(String dataSet, int from, int to) {
		return dataSet + " " + from + " " + to;
	}

	public static void main(String argvs[]) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int numberOfDataCenter = 0;
		try {
			String line = br.readLine();
			numberOfDataCenter = Integer.valueOf(line.trim());
			String dataCenters[] = new String[numberOfDataCenter];
			for (int i = 0; i < dataCenters.length; i++) {
				dataCenters[i] = br.readLine().trim();
			}
			ArrayList<String> copys = copyOperations(dataCenters);
			for (String copy : copys) {
				System.out.println(copy);
			}
			System.out.println("done");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
