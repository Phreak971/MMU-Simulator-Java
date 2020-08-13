import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class deallocationTest {

    @Test
    void deallocation() {
        mmu._MAX_MEMORY_ = 100;
        mmu._STRATEGY = 1;
        mmu._MEMORY = new ArrayList<partition>();
        mmu._MEMORY.add(new partition(0, mmu._MAX_MEMORY_, "Free", null));
        partition p = allocation.alloc_memory(50);
        deallocation.deallocation(1);
        assertNull(p.get_process());

    }
}