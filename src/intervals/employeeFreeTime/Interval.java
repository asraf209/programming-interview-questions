package intervals.employeeFreeTime;

// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
    
    @Override
    public String toString() {
    	return "(" + this.start + ", " + this.end + ")";
    }
}