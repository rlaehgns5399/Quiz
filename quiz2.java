import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.math.BigInteger;

public class quiz2 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int line = 0;
		
		try {
			line = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < line; i++) {
				Stack<String> valid_stack = new Stack<String>();
				String str = br.readLine();
				
				BigInteger score = new BigInteger("0");
				BigInteger shouldMul = new BigInteger("1");
				
				for(int j = 0; j < str.length(); j++) {
					switch(str.charAt(j)) {
						case '(':
							valid_stack.push("(");
							shouldMul = shouldMul.multiply(BigInteger.ONE);
							if(j+1 < str.length() && str.charAt(j+1) == ')') {
								score = score.add(shouldMul);
							}
							break;
						case '{':
							valid_stack.push("{");
							shouldMul = shouldMul.multiply(BigInteger.TWO);
							if(j+1 < str.length() && str.charAt(j+1) == '}') {
								score = score.add(shouldMul);
							}
							break;
						case '[':
							valid_stack.push("[");
							shouldMul = shouldMul.multiply(BigInteger.valueOf(3));
							if(j+1 < str.length() && str.charAt(j+1) == ']') {
								score =score.add(shouldMul);
							}
							break;	
					}
					
					if(!valid_stack.isEmpty()) {
						switch(str.charAt(j)) {
						case ')':
							shouldMul = shouldMul.divide(BigInteger.ONE);
							if(valid_stack.peek().equals("(")) valid_stack.pop();
							break;
						case '}':
							shouldMul = shouldMul.divide(BigInteger.TWO);
							if(valid_stack.peek().equals("{")) valid_stack.pop();
							break;
						case ']':
							shouldMul = shouldMul.divide(BigInteger.valueOf(3));
							if(valid_stack.peek().equals("[")) valid_stack.pop();
							break;
						}
					}

					
				}
				
				if(!valid_stack.empty()) score = BigInteger.valueOf(0);
				System.out.println(score.mod(BigInteger.valueOf(100000000)));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
