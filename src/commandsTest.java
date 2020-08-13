import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


class commandsTest {

    @Test
    void _cr() {
        mmu._MAX_MEMORY_ = 100;
        mmu._STRATEGY = 1;
        mmu._MEMORY = new ArrayList<partition>();
        mmu._MEMORY.add(new partition(0, mmu._MAX_MEMORY_, "Free", null));
        String arr[] = {"cr", "50"};
        commands._cr(arr);
        assertEquals(mmu.get_MEMORY().size(), 2);
    }

    @Test
    void _dl() {
        mmu._MAX_MEMORY_ = 100;
        mmu._STRATEGY = 1;
        mmu._MEMORY = new ArrayList<partition>();
        mmu._MEMORY.add(new partition(0, mmu._MAX_MEMORY_, "Free", null));
        String arr[] = {"cr", "50"};
        commands._cr(arr);
        arr[0] = "dl";
        arr[1] = "1";
        commands._dl(arr);
        assertEquals(mmu.get_MEMORY().get(1).get_process(), null);

    }
}