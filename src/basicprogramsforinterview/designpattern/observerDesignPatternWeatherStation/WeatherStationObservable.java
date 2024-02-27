package basicprogramsforinterview.designpattern.observerDesignPatternWeatherStation;

import basicprogramsforinterview.designpattern.observerDesignPatternWeatherStation.dataset.DataSets;

import java.util.List;

public interface WeatherStationObservable {
    List<Observer> getObserverList();
    void addObserver(Observer observer);
    void deleteObserver(Observer observer);
    void notify(List<Observer> list, DataSets dataSets);
}
