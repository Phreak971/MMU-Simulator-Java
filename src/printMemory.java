public class printMemory {
    private static final String DASHES =
            "====================================="
                    + "================================="
                    + "=================================";

    public static void print() {

        int usedMemory = 0;
        System.out.println(DASHES);
        System.out.format(" %s%28s%28s%28s\n", "PID", "ammount", "start", "end");
        System.out.println(DASHES);
        for (int i = 0; i < mmu.get_MEMORY().size(); i++) {
            int size = mmu.get_MEMORY().get(i).getSize();
            int start = mmu.get_MEMORY().get(i).getStartAddress();
            String pid = "-";
            if (mmu.get_MEMORY().get(i).get_process() != null) {
                usedMemory += size;
                int id = mmu.get_MEMORY().get(i).get_process().getId();
                pid = Integer.toString(id);
            }
            System.out.format(" %s%28d%28d%30d\n", pid, size,
                    start, (start + size) - 1);
        }
        System.out.println(DASHES);
        System.out.format("%20s%d/%d KB\n\n", "Total Memory Used: ", usedMemory, mmu.getMaxMemory());
    }


}
