public class allocation {

    private static int nextfit_ = 0;

    public static partition alloc_memory(int memory) {
        partition New = new partition(memory, "Occupied");
        int ind = -1;
        if (mmu.getStrategy() == 1) { // First Fit

            ind = FirstFit(New); // get index of Free partition that satisfies the strategy

        } else if (mmu.getStrategy() == 2) { // Next Fit

            ind = NextFit(New);

        } else if (mmu.getStrategy() == 3) { // Best F
            ind = BestFit(New);
        } else if (mmu.getStrategy() == 4) {   //Worst Fit
            ind = WorstFit(New);
        }
        if (ind == -1) { // no Free partition satisfies the policy

            return null;

        } else {
            process p = new process(ind + 1);
            New.set_process(p);
            partition Chosen = mmu.get_MEMORY().get(ind); // get the chosen partition returned from the policy
            int start = Chosen.getStartAddress();
            New.setStartAddress(start);


            mmu.get_MEMORY().remove(ind);
            mmu.get_MEMORY().add(ind, New);

            //eliminating internal fragmentation)

            int remainingSize = Chosen.getSize() - memory;
            if (remainingSize != 0) {
                int startFree = start + memory;
                mmu.get_MEMORY().add(ind + 1, new partition(startFree, remainingSize, "Free", null));
            }
            return New;
        }
    }

    protected static int BestFit(partition New) {   //smallest of fit partitions
        int ind = -1, mn = 1000000;
        for (int i = 0; i < mmu.get_MEMORY().size(); ++i) {
            if (mmu.get_MEMORY().get(i).getStatus().equals("Free")) {
                if (mmu.get_MEMORY().get(i).getSize() >= New.getSize()
                        && mmu.get_MEMORY().get(i).getSize() < mn) {
                    mn = mmu.get_MEMORY().get(i).getSize();
                    ind = i;
                }
            }
        }

        return ind;
    }

    protected static int WorstFit(partition New) {  //biggest of fit partitions
        int ind = -1, mx = 0;
        for (int i = 0; i < mmu.get_MEMORY().size(); ++i) {
            if (mmu.get_MEMORY().get(i).getStatus().equals("Free")) {
                if (mmu.get_MEMORY().get(i).getSize() >= New.getSize()
                        && mmu.get_MEMORY().get(i).getSize() > mx) {
                    mx = mmu.get_MEMORY().get(i).getSize();
                    ind = i;
                }
            }
        }
        return ind;
    }

    protected static int FirstFit(partition New) {  //nearest of fit partitions
        for (int i = 0; i < mmu.get_MEMORY().size(); ++i) {
            if (mmu.get_MEMORY().get(i).getStatus().equals("Free")) {
                if (mmu.get_MEMORY().get(i).getSize() >= New.getSize()) {
                    return i;
                }
            }
        }

        return -1;
    }

    protected static int NextFit(partition New) {   //similar to first fit but does't start from start
        //it starts looking from where it left last time
        for (int i = nextfit_; i < mmu.get_MEMORY().size(); ++i) {
            if (mmu.get_MEMORY().get(i).getStatus().equals("Free")) {
                if (mmu.get_MEMORY().get(i).getSize() >= New.getSize()) {
                    nextfit_ = i;
                    if (nextfit_ == mmu.get_MEMORY().size() - 1) {
                        nextfit_ = 0;
                    }
                    return i;
                }
            }
        }
        return -1;
    }
}
