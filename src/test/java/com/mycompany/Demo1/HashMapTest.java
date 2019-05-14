
package com.mycompany.Demo1;

import java.util.HashMap;
import java.util.Map;
import static org.fest.assertions.api.Assertions.*;
import org.junit.Test;


public class HashMapTest {
    @Test
    public void defultConstructorShouldCreateEmptyMap(){
        Map<String, String> map = new HashMap<>();
        
        assertThat(map).isEmpty();
        assertThat(map).hasSize(0).doesNotContainKey("x");
        
        assertThat(map.entrySet().iterator().hasNext()).isFalse();
    }
      
    @Test
    public void collectionConstructorShouldCopyAllContent(){        
        Map<String, String> originalMap = new HashMap<>();
        originalMap.put("a", "b");
        originalMap.put("c", "d");
        
        Map<String, String> copiedMap = new HashMap<>(originalMap);
        
        assertThat(copiedMap)
                .describedAs("copie map")
                .hasSize(2)
                .isEqualTo(originalMap)
                .isNotSameAs(originalMap);
        
        originalMap.put("e", "f");
        
        assertThat(copiedMap)
                .hasSize(2)
                .doesNotContain(entry("e", "f"))
                //.doesNotContain(entry("a", "b"))
                .isNotEqualTo(originalMap);
        
        
        
    }
}
