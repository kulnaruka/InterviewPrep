package basicprogramsforinterview.designpattern.observerDesignPatternWeatherStation.dataset;

public class DataSets {
    int temp;
    int humidity;

    public int getTemp() {
        return temp;
    }
    public void setTemp(int temp) {
        this.temp = temp;
    }
    public int getHumidity() {
        return humidity;
    }
    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
    public DataSets(int temp, int humidity) {
        this.temp = temp;
        this.humidity = humidity;
    }
    public DataSets() {}
    @Override
    public String toString() {
        return "DataSets{" +
                "temp=" + temp +
                ", humidity=" + humidity +
                '}';
    }
}
