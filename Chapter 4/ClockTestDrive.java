class Clock {
    String time;

    void setTime(String t) {
        time = t;
    }

    // returns a non-void type: specify accordingly
    String getTime() {
        return time;
    }
}

public class ClockTestDrive {
    public static void main(String[] args) {
        Clock c = new Clock();
        c.setTime("1245");
        String tod = c.getTime();
        System.out.println("time: " + tod);
    }
}
