public class partition {    //each index of _MAX_MEMORY_ arraylist holds a patition
    //partition contains its
    private int StartAddress;   //start address
    private int Size;       //size or limit
    private String Status;  //free or occupied
    private process _process;   //the process that is running in that partition

    public partition() {
        this.StartAddress = -1;
        this.Status = "";
        this.Size = 0;
        _process = null;
    }

    public partition(int StartAddress, int Size, String Status, process procc) {
        this.StartAddress = StartAddress;
        this.Status = Status;
        this.Size = Size;
        _process = procc;
    }

    public partition(int Size, String Status) {
        this.StartAddress = -1;
        this.Status = Status;
        this.Size = Size;
        _process = null;
    }

    //getters and setters
    public void set_process(process New) {
        _process = New;
    }

    public process get_process() {
        return this._process;
    }

    public void setStartAddress(int StartAddress) {
        this.StartAddress = StartAddress;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getStartAddress() {
        return this.StartAddress;
    }

    public String getStatus() {
        return this.Status;
    }

    public void setSize(int Size) {
        this.Size = Size;
    }

    public int getSize() {
        return this.Size;
    }

    public void increaseSize(int additionalSize){
        this.Size += additionalSize;
    }

}
