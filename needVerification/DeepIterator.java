package needVerification;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public class DeepIterator implements Iterator<Object>{
	
	private Stack<Iterator<Object>> iteratorStack = new Stack<Iterator<Object>>();
	
	public DeepIterator(Map<String, Object> map) {
		this.iteratorStack.push(map.values().iterator());
	}
	
	public Object next() {
		if(!this.iteratorStack.isEmpty()) {
			if(this.iteratorStack.peek().hasNext()) {
				Object value = this.iteratorStack.peek().next();
				if(value instanceof Map) {
					this.iteratorStack.add(((Map) value).values().iterator());
				} else {
					return value;
				}
			} else {
				this.iteratorStack.pop();
			}
		}
		return null;
	}
}
