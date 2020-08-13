public class deallocation {
    public static void deallocation(int pid) {
        boolean found = false;
        for (int i = 0; i < mmu.get_MEMORY().size(); i++) { //for all partitions in _MEMORY
            if (mmu.get_MEMORY().get(i).get_process() != null) {    //if there is a process
                if (mmu.get_MEMORY().get(i).get_process().getId() == pid) { //and its id is equal to given id
                    found = true;
                    mmu.get_MEMORY().get(i).set_process(null);  //kill the process
                    if (mmu.get_MEMORY().get(i).getStatus() != "Free") {    //if memory is occupied
                        mmu.get_MEMORY().get(i).setStatus("Free");  //memory is now free for use
                    }
                    System.out.format("Process %d deleted\n\n", pid);
                    ContiguousBlocksDefragmentation(); //if two consective partitions are free then comine them
                }
            }
        }
        if (found == false) {
            System.out.println("PID not found\n");
        }
    }

    private static void ContiguousBlocksDefragmentation() {

        for (int i = 0; i < mmu.get_MEMORY().size() - 1; ++i) {

            if (mmu.get_MEMORY().get(i).getStatus() == "Free"
                    && mmu.get_MEMORY().get(i + 1).getStatus() == "Free") {

                mmu.get_MEMORY().get(i).increaseSize(mmu.get_MEMORY().get(i + 1).getSize());
                mmu.get_MEMORY().remove(i + 1);

                i--;
            }

        }

    }
}

