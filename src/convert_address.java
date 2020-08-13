public class convert_address {

    public static void get_virtual(int pid, int vAddr) {
        boolean found = false;
        for (int i = 0; i < mmu.get_MEMORY().size(); i++) {
            if (mmu.get_MEMORY().get(i).get_process() != null) {
                if (mmu.get_MEMORY().get(i).get_process().getId() == pid) {
                    found = true;
                    int limit = (mmu.get_MEMORY().get(i).getStartAddress() + mmu.get_MEMORY().get(i).getSize()) - 1;
                    int pAddr = mmu.get_MEMORY().get(i).getStartAddress() + vAddr;
                    if (pAddr > limit) {
                        System.out.format("Virtual Address %d is out of process %d address space\n\n", vAddr, pid);
                    } else {
                        System.out.format("Physical Address: %d\n\n", pAddr);
                    }
                }
            }
        }
        if (found == false) {
            System.out.println("PID not found\n");
        }
    }
}
