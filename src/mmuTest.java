import static org.junit.jupiter.api.Assertions.*;

class mmuTest {

    private mmu mmuObj = new mmu(2, 3);

    @org.junit.jupiter.api.Test
    void getMaxMemory() {
        assertEquals(mmu.getMaxMemory(), 2);
    }

    @org.junit.jupiter.api.Test
    void getStrategy() {
        assertEquals(mmu.getStrategy(), 3);
    }

}