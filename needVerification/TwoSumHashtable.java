package needVerification;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TwoSumHashtable {

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    public void store(int value) {
        int count = 0;
        if(map.containsKey(value)) {
            count = map.get(value);
        }
        map.put(value, count);
    }
    
    public boolean test(int target) {
        
        Iterator<Integer> itr = map.keySet().iterator();
        
        while(itr.hasNext()) {
            int num = itr.next();
            if(map.containsKey(target - num)) {
                if((num != target - num) || (num == target - num && map.get(num) > 1)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
