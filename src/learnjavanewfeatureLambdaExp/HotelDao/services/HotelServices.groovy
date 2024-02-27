package learnjavanewfeatureLambdaExp.HotelDao.services

import learnjavanewfeatureLambdaExp.HotelDao.Hotel
import java.util.function.Predicate

class HotelServices {

    List<Hotel> hotels = new ArrayList<>()

    HotelServices(){
        hotels.add(new Hotel(2500,3, HotelType.THREE_Star))
        hotels.add(new Hotel(4500,3, HotelType.THREE_Star))
        hotels.add(new Hotel(6500,2, HotelType.FOUR_Star))
        hotels.add(new Hotel(3500,4, HotelType.FIVE_Star))
        hotels.add(new Hotel(7500,5, HotelType.THREE_Star))
    }

    // Simple filtering where the learnjavanewfeatureLambdaExp.HotelDao.filter is working only with the variable
    List<Hotel> filterHotelByPrice(int price){
        List<Hotel> filteredHotel = new ArrayList<>()
        for(Hotel hotel: hotels){
            if(hotel.getPricePerNight()<=price)
            filteredHotel.add(hotel)
        }
        return filteredHotel
    }

    // Simple filtering where the learnjavanewfeatureLambdaExp.HotelDao.filter is working with the class object as a parameter
    List<Hotel> filterHotel(Predicate<Hotel> filteringLogic){
        List<Hotel> filteredHotel = new ArrayList<>()
        for(Hotel hotel: hotels){
            if(filteringLogic.test(hotel))
                filteredHotel.add(hotel)
        }
        return filteredHotel
    }

    // Comparator

}
