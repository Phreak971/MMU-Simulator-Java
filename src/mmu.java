import java.util.ArrayList;
import java.util.Scanner;

public class mmu {

    protected static int _MAX_MEMORY_;      //total memory (first argument from CLI)
    protected static int _STRATEGY;     //allocation algorithm First, Next, Best, Wost
    protected static ArrayList<partition> _MEMORY;  //The Memory

    public mmu(int mm, int s) {
        _MAX_MEMORY_ = mm;
        _STRATEGY = s;
    }

    public mmu() {
        _MAX_MEMORY_ = 0;
        _STRATEGY = 0;
    }

    private static void arrInit() {     //init the memory with user entered size
        _MEMORY = new ArrayList<partition>();
        _MEMORY.add(new partition(0, _MAX_MEMORY_, "Free", null));
    }
    /*initial _MEMORY
      ____________________________________________
    *|                 Status = free              | index = 0
    *|               size = _MAX_MEMORY_          | _MEMORY_.size() = 1
    *|               startAddresss = 0            |
    *|____________________________________________|

    * */
        /*after adding one process of size 50
      ____________________________________________
    *|  status = occupied |    Status = free       | index = 1
    *|    size = 50      | size = _MAX_MEMORY_-50  | _MEMORY_.size() = 2
    *|  startAddress=0   | startAddresss = 50      |
    *|__________________|__________________________|

    * */

    public static void main(String Args[]) {//cli arguments
        if (Args.length == 2) { //check if there are two arguments eg. mmu 1000 1
            try {   //args[0] = 1000, args[1] = 1
                double mm = Double.parseDouble(Args[0]);    //entered memory might have floating point
                _MAX_MEMORY_ = (int) Math.round(mm);    //round off
                _STRATEGY = Integer.parseInt(Args[1]);  //parse to int
            } catch (Exception exception) {
                System.err.println("Invalid command\nUsage: mmu [memory in KB] [strategy]");    //mmu 150 2
            }
            if (_STRATEGY >= 1 && _STRATEGY <= 4) { //1 for first fit to 4 for worst fit
                arrInit();  //init array with user given arguments
                mmu_init(); //start the app's input
            } else {
                System.err.println("Strategy out of Range");
            }
        } else {
            System.err.println("Invalid arguments\nUsage: mmu [memory in KB] [strategy]");
        }
    }

    private static void mmu_init() {    //starting app input
        String algorithm = "";
        switch (_STRATEGY) {        //algorithms for allocation
            case 1:
                algorithm = "First Fit";
                break;
            case 2:
                algorithm = "Next Fit";
                break;
            case 3:
                algorithm = "Best Fit";
                break;
            case 4:
                algorithm = "Worst Fit";
                break;
        }
        System.out.println(String.format("Selected Algorithm : %s\n", algorithm));
        String input = "";
        do {
            System.out.print("> ");
            Scanner myObj = new Scanner(System.in);
            input = myObj.nextLine();   //ask user for command >cr 12 or pm or dl 2 etc
            String[] args = input.trim().split("\\s+"); //trim removes extra spaces in start and end ...
            // then we split on basis of space char like input = "cv 2" args = {"cv", "2"}
            if (args[0].equals("cr")) {
                commands._cr(args);
            } else if (args[0].equals("dl")) {
                commands._dl(args);
            } else if (args[0].equals("cv")) {
                commands._cv(args);
            } else if (args[0].equals("pm")) {
                commands._pm(args);
            } else if (args[0].equals("help")) {
                commands._help();
            } else if (args[0].equals("exit")) {
                System.out.println("Exiting mmu . . . ");
            } else {
                System.err.println(String.format("%s is not recognised as an mmu command.\nTry '%s' for more info",
                        args[0], "help"));
            }

        } while (!input.equals("exit"));
    }

    //getters
    public static ArrayList<partition> get_MEMORY() {
        return _MEMORY;
    }

    public static int getMaxMemory() {
        return _MAX_MEMORY_;
    }

    public static int getStrategy() {
        return _STRATEGY;
    }
}
