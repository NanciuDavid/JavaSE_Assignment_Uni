package ro.ase.acs.classes;

public class SummingThread extends  Thread{

    private int startIndex;
    private int endIndex;

    private int [] array;
    public long sum = 0 ;
    public SummingThread(int startIndex, int endIndex, int [] array) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.array = array;
    }

    public long getSum() {
        return sum;
    }

    @Override
    public void run() {
        for(int i=startIndex;i<endIndex;i++)
            sum+=array[i];
    }
}
