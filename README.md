# MMU-Simulator-Java
A Simulation of Memory Management Unit in using Java

This is a simulation of a Memory Management unit in Java. Allocation Strategies i.e. Best Fit, First Fit, Worst Fit and Next Fit are implemented in the Simulator.
The user can also see at partition table before and after allocating or deallocating memory


Command Line Arguments / Usage:
  mmu [Total Memory of System in Kbs] [Algorithm for Allocation]
  [Algorithm for Allocation] = 
  1 for First Fit
  2 for Next Fit
  3 for Best Fit
  4 for Worst Fit
  

Commands:
  cr [AMOUNT_OF_REQUESTED_MEMORY]: Create a process and allocate the requested amount of memory(in KB) to it.
  dl [PROCESS_ID]: Delete the specified process and Free the allocated memory.
  cv [PROCESS_ID] [VIRTUAL_ADDRESS]: Make a conversion for the specified process ID from the specified Virtual Address to the Physical Address.
  pm: Print the memory map(Patition Table).
  exit: Exits the Application
