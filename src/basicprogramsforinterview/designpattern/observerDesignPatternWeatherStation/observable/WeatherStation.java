package basicprogramsforinterview.designpattern.observerDesignPatternWeatherStation.observable;

import basicprogramsforinterview.designpattern.observerDesignPatternWeatherStation.dataset.DataSets;
import basicprogramsforinterview.designpattern.observerDesignPatternWeatherStation.Observer;
import basicprogramsforinterview.designpattern.observerDesignPatternWeatherStation.WeatherStationObservable;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements WeatherStationObservable {

    List<Observer> observerList = new ArrayList<>();
    DataSets dataSets = new DataSets();

    public List<Observer> getObserverList() {
        return observerList;
    }

    public DataSets getDataSets() {
        return dataSets;
    }

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notify(List<Observer> list, DataSets dataSets) {
        this.dataSets  = dataSets;
        list.forEach((observer)->{
            observer.update(dataSets);
        });
    }

    //Below method called by IOT sensors(client) to update the datasets
    void updateDataSets(DataSets dataSets){
        this.dataSets = dataSets;
        notify(this.observerList, dataSets);
        System.out.println("Data sets updated to all the systems");
    }

}
