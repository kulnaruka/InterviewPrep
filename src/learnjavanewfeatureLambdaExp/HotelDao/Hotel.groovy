package learnjavanewfeatureLambdaExp.HotelDao

class Hotel {

    int pricePerNight;
    int customerRating;
    HotelType hotelType;

    Hotel(int pricePerNight, int customerRating, HotelType hotelType) {
        this.pricePerNight = pricePerNight
        this.customerRating = customerRating
        this.hotelType = hotelType
    }

    int getPricePerNight() {
        return pricePerNight
    }

    void setPricePerNight(int pricePerNight) {
        this.pricePerNight = pricePerNight
    }

    void setCustomerRating(int customerRating) {
        this.customerRating = customerRating
    }

    void setHotelType(HotelType hotelType) {
        this.hotelType = hotelType
    }

    int getCustomerRating() {
        return customerRating
    }

    HotelType getHotelType() {
        return hotelType
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "pricePerNight=" + pricePerNight +
                ", customerRating=" + customerRating +
                ", hotelType=" + hotelType +
                '}';
    }
}
