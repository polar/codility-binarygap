/**
 * Codility Binary Gap Solution
 * @author Dr. Polar Humenn
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	
    public int solution(int N) {
        String binI = Integer.toBinaryString(N);
        String pattern = "10+1";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(binI);
        String max = "";
        if (m.find()) {
        	max = m.group(0);
        	while(m.find(m.end()-1)) {
        		String s = m.group(0);
        		if (s.length() > max.length()) {
        			max = s;
        		}
        	}
        	// subtract the outer 1s
            return max.length()-2;
        }
        
        return 0;
    }
	
    static int cases[] = new int[] {
    	15,
    	1041,
    	Integer.parseInt("101",2),
    	Integer.parseInt("1001",2),
    	Integer.parseInt("100101",2),
    	Integer.parseInt("1010001",2),
    	Integer.parseInt("1010000",2),
    	Integer.parseInt("10100000100000001",2),
    	Integer.parseInt("10000100101010101",2),
    	Integer.parseInt("111111111111111111",2),
    	0,
    	Integer.parseInt("1010101010101010101",2),
    };
    
    static int answers[] = new int[] {
    		0,
    		5,
    		1,
    		2,
    		2,
    		3,
    		1,
    		7,
    		4,
    		0,
    		0,
    		1 		
    };
    
	public static void main(String[] args) {
    	Solution sol = new Solution();
		for(int i = 0; i < cases.length; i++) {
			int ans = sol.solution(cases[i]);
			System.out.format("%s expect %d got %d case %d %s\n", ans == answers[i] ? "pass" : "fail", answers[i], ans, cases[i], Integer.toBinaryString(cases[i])   );
		}
		
	}
}
