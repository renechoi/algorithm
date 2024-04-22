import java.util.stream.IntStream;
import java.util.*;

class Solution {
    public int[] solution(int[] array) {
        
    Element maxElement = IntStream.range(0, array.length)
			.mapToObj(i -> new Element(array[i],i))
		    .max(Comparator.comparingInt(e -> e.element))
			.orElseThrow();
        
        return new int[]{maxElement.element, maxElement.index}; 
    }
    
    public class Element{
        int element;
        int index;
        
        public Element(int element, int index){
            this.element = element;
            this.index =index;
        }
    }
}