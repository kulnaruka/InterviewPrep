package learnjavanewfeatureLambdaExp.HotelDao.filter


import learnjavanewfeatureLambdaExp.HotelDao.Hotel

/**
 * This is a Functional interface, which will only allow one abstract method, --->*1 the reason behind it ::
 * The compiler will be confused to use which method/function of the interface, for the implementation of the lambda statement
 * Although default, static and override methods (in case of Comparator equals() method is override from Object class) are allowed
 * */
@FunctionalInterface
interface FilteringLogic {
    abstract boolean filter(Hotel hotel)
    //*1
    // abstract boolean filterLogic(Hotel hotel)

}