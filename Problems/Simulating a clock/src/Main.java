class Clock {

    Clock() {

    }

    protected int hours = 12;
    int minutes = 0;

    protected void next() {
        minutes++;
        if (minutes == 60) {
            minutes = 0;
            hours++;
            if (hours == 13) {
                hours = 1;
            }
        }
    }
}