import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class processTest {

    process p = new process(2);

    @Test
    void getId() {
        assertEquals(p.getId(), 2);
    }
}