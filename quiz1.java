import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class quiz1 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<String, Integer> map = new TreeMap<String, Integer>();
		String word = "";
		try {
			while((word = br.readLine()) != null) {
			word = word.trim();
			if(map.get(word) == null){
				map.put(word, 0);
			}
			map.put(word, map.get(word)+1);
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int max = 0;
		for(int entry : map.values()) {
			if(max < entry) max = entry;
		}
		for(String name : map.keySet()) {
			if(map.get(name) == max) System.out.println(name);
		}
		
		
	}
}
