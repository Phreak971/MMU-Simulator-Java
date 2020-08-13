import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class allocationTest {

    @Test
    void alloc_memory() {
        mmu._MAX_MEMORY_ = 100;
        mmu._STRATEGY = 1;
        mmu._MEMORY = new ArrayList<partition>();
        mmu._MEMORY.add(new partition(0, mmu._MAX_MEMORY_, "Free", null));
        assertEquals(allocation.alloc_memory(50).getSize(), 50);
    }

    @Test
    void bestFit() {
        mmu._MAX_MEMORY_ = 100;
        mmu._MEMORY = new ArrayList<partition>();
        mmu._MEMORY.add(new partition(0, mmu._MAX_MEMORY_, "Free", null));
        partition New = new partition(50, "Occupied");
        assertEquals(allocation.BestFit(New), 0);
        New = new partition(500, "Occupied");
        assertEquals(allocation.BestFit(New), -1);
    }

    @Test
    void worstFit() {
        mmu._MAX_MEMORY_ = 100;
        mmu._MEMORY = new ArrayList<partition>();
        mmu._MEMORY.add(new partition(0, mmu._MAX_MEMORY_, "Free", null));
        partition New = new partition(50, "Occupied");
        assertEquals(allocation.WorstFit(New), 0);
        New = new partition(500, "Occupied");
        assertEquals(allocation.WorstFit(New), -1);
    }

    @Test
    void firstFit() {
        mmu._MAX_MEMORY_ = 100;
        mmu._MEMORY = new ArrayList<partition>();
        mmu._MEMORY.add(new partition(0, mmu._MAX_MEMORY_, "Free", null));
        partition New = new partition(50, "Occupied");
        assertEquals(allocation.FirstFit(New), 0);
        New = new partition(500, "Occupied");
        assertEquals(allocation.FirstFit(New), -1);
    }

    @Test
    void nextFit() {
        mmu._MAX_MEMORY_ = 100;
        mmu._MEMORY = new ArrayList<partition>();
        mmu._MEMORY.add(new partition(0, mmu._MAX_MEMORY_, "Free", null));
        partition New = new partition(50, "Occupied");
        assertEquals(allocation.NextFit(New), 0);
        New = new partition(500, "Occupied");
        assertEquals(allocation.NextFit(New), -1);
    }

}