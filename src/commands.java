public class commands {

    public static void _cr(String arg[]) {  //cr [memory]   creates a process and adds in partiton in free memory
        int memory = -1;
        if (arg.length == 2) {//extracts useful stuff from input and calls allocate memory funciton
            try {
                double mm = Double.parseDouble(arg[1]);
                memory = (int) Math.floor(mm);
            } catch (Exception ee) {
                System.err.println("Invalid Arguments\nSee 'help' for more info");
            }
            if (memory > -1) {  //if input is valid
                partition p = allocation.alloc_memory(memory);  //creates a process and adds in partiton in free memory
                if (p == null) {
                    System.out.println("Not Enough Memory");
                } else {
                    System.out.println(String.format("Process Created Successfully with PID: %d  Base: %d  Limit: %d\n"
                            , p.get_process().getId(), p.getStartAddress(), p.getStartAddress() + p.getSize()));
                }
            } else {
                System.err.println("Memory cannot be negetive");
            }
        } else {
            System.err.println("cr takes two arguments. See 'help' for more info.");
        }
    }

    public static void _dl(String arg[]) {
        if (arg.length == 2) {  //validates input
            int id = -1;
            try {
                id = Integer.parseInt(arg[1]);
            } catch (Exception ee) {
                System.err.println("Invalid Arguments\nSee 'help' for more info");
            }
            deallocation.deallocation(id);  //doesnot remove the partition ... marks its status as Free and process as null
        } else {
            System.err.println("dl takes two arguments\nSee 'help' for more info");
        }
    }

    public static void _cv(String arg[]) {
        if (arg.length == 3) {
            int id = -1;
            int vaddr = -1111;
            try {
                id = Integer.parseInt(arg[1]);
                vaddr = Integer.parseInt(arg[2]);//validation
            } catch (Exception ee) {
                System.err.println("Invalid Arguments\nSee 'help' for more info");
            }
            if (id > -1 && vaddr > -1) {
                convert_address.get_virtual(id, vaddr); //startAddress of partiton in which process exists ... then add virtual address and display
            } else {
                System.err.println("Address or PID cannot be negetive");
            }
        } else {
            System.err.println("cv takes two arguments\nSee 'help' for more info");
        }
    }

    public static void _pm(String arg[]) {
        if (arg.length == 1) {
            printMemory.print();    //shows all partitions of memory
        } else {
            System.err.println("pm takes no arguments");
        }
    }

    public static void _help() {
        System.out.println("help: mmu");
        System.out.println(
                "cr [AMOUNT_OF_REQUESTED_MEMORY]:\n\tCreate a process and allocate the requested amount of memory(in KB) to it.");
        System.out.println("dl [PROCESS_ID]:\n\tDelete the specified process and Free the allocated memory.");
        System.out.println(
                "cv [PROCESS_ID] [VIRTUAL_ADDRESS]:\n\tMake a conversion for the specified process ID from the specified Virtual Address to the Physical Address. ");
        System.out.println("pm\n\tPrint the memory map.");
        System.out.println("exit\n\tExits mmu");
    }
}
