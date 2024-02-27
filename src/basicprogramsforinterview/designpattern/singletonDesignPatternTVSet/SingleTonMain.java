package basicprogramsforinterview.designpattern.singletonDesignPatternTVSet;

public class SingleTonMain {

    public static void main(String[] args) {

        Thread t1 = new Thread(()->{
            TVSet.getTVSetObject("Sony");
        }, "Thread1");

        Thread t2 = new Thread(() -> {
            TVSet.getTVSetObject("LG");
        }, "Thread2");

        t1.start();
        t2.start();
        System.out.println(TVSet.getTVSetObject(" ").toString());

    }


}
