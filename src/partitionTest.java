import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class partitionTest {

    private partition part = new partition();

    @Test
    void get_process() {
        assertEquals(part.get_process(), null);
    }

    @Test
    void getStartAddress() {
        assertEquals(part.getStartAddress(), -1);
    }

    @Test
    void getStatus() {
        assertEquals(part.getStatus(), "");
    }

    @Test
    void getSize() {
        assertEquals(part.getSize(), 0);
    }

    @Test
    void set_process() {
        process p = new process(4);
        part.set_process(p);
        assertEquals(part.get_process(), p);
    }

    @Test
    void setStartAddress() {
        part.setStartAddress(100);
        assertEquals(part.getStartAddress(), 100);
    }

    @Test
    void setStatus() {
        part.setStatus("free");
        assertEquals(part.getStatus(), "free");
    }

    @Test
    void setSize() {
        part.setSize(500);
        assertEquals(part.getSize(), 500);
    }
}