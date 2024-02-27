package learnjavanewfeatureLambdaExp.HotelDao

import learnjavanewfeatureLambdaExp.HotelDao.filter.FilteringLogic
import learnjavanewfeatureLambdaExp.HotelDao.services.HotelServices

import java.util.function.Consumer
import java.util.function.DoublePredicate
import java.util.function.Function
import java.util.function.IntPredicate
import java.util.function.Predicate
import java.util.function.Supplier

class JavaNewFeatures {

    static void main(String[] args) {
        HotelServices hotelServices = new HotelServices()
        //println hotelServices.getHotels()

        List<Hotel> filteredHotelByPrice = hotelServices.filterHotelByPrice(2500)
        //filteredHotelByPrice.each {it.toString()}

        //Example of Anonymous class
        /*List<Hotel> filteredHotel = hotelServices.filterHotel(new FilteringLogic() {
            @Override
            boolean test(Hotel hotel) {
                return hotel.getPricePerNight()<=3000
            }
        })*/
        //filteredHotel.each {println it.toString()}

        /**
         * 1. Create an interface
         * 2. Instantiate a class that implements the methods of the interface
         * 3. Implement the method of the interface, where the method body = function body which you want to pass as a parameter
         * 4. Pass an object of the concrete implementation of the interface
         */

        // Doing same above ops using lambda
        List<Hotel> filteredHotelFinal = hotelServices.filterHotel((hotel) -> {return hotel.getPricePerNight() <= 3000})

        filteredHotelFinal = hotelServices.filterHotel((hotel) -> hotel.getPricePerNight() <= 3000)
        //Both above statements are true
        //filteredHotelFinal.each {println it.toString()}


        /**
         * Examples of the inbuilt functional interfaces in Java :
         * 1. Comparator---> it has compare as the only abstract method
         * 2. Runnable---> it has run as the only abstract method
         */

        List<Integer> list = [1,3,4,5,2,3,4]
        def newList = list.collect{it-> (++it)}
        //println newList
        Collections.sort(list, ( a,  b)-> a - b )
        Collections.sort(list, (Integer a,  Integer b)-> a - b )
        //println list

        Collections.sort(hotelServices.hotels, ( a,  b)-> a.getPricePerNight() - b.getPricePerNight() )
        //println hotelServices.hotels.toString()

        /**
         * Rules of the lambda Expression
         * ----> 1.
         * Collections.sort(list, ( a,  b)-> a - b )
         * Collections.sort(list, (Integer a,  Integer b)-> a - b )
         * both of the above lines have same result, as a and b in 1st line is inferred based on the type of list..
         * ****** it is a lazy operation in nature *******
         *
         * ----> 2.
         * also you can't declare one parameter type, either none or both
         * Collections.sort(list, ( Integer a,  b)-> a - b ) is invalid and will throw compiler error
         *
         * ----> 3.
         * If you are declaring the parameter as 'Final' then parameter type is mandatory
         * Collections.sort(list, ( Final Integer a)-> sys out a )
         *
         */


        /**
         * Lambda expression type checking
         */

        FilteringLogic lambdaExp = (hotel) -> {return hotel.getPricePerNight() <= 3000}

        //filteredHotelFinal = hotelServices.filterHotel(lambdaExp)
        //filteredHotelFinal = hotelServices.filterHotel()

        //filteredHotelFinal = hotelServices.filterHotel((hotel) -> hotel.getPricePerNight() <= 3000)
        //Both above statements are true
        filteredHotelFinal.each {println " New "+it.toString()}


        /**
         * Predicate: its an in-built functional interface by java; also post some operation it provides boolean value
         */

        List<Hotel> filteredHotelNew = hotelServices.filterHotel(new Predicate<Hotel>() {
            @Override
            boolean test(Hotel hotel) {
                return hotel.getPricePerNight()<=3000
            }
        })

        /**
         * Combining Predicate: its an in-built functional interface by java
         * Ex: if a number is divisible by 6 --> means it should be divisible by 2 and 3
         */
        Predicate<Integer> divBy2 = (num) -> num%2==0
        Predicate<Integer> divBy3 = (num) -> num%3==0
        Predicate<Integer> divBy6 = divBy2.and(divBy3)
        // Other methods of the predicate are: or, negate,
        //Predicate<Integer> divBy6 = divBy2.or(divBy3)
        Predicate<Integer> notDivBy2 = divBy2.negate()
        println divBy6.test(234426)
        println notDivBy2.test(234426)


        /**
         * Consumer interface: its an in-built functional interface by java; it performs operation but wont return anything
         * or it 'CONSUMES' the values
         */
        List<Integer> listNew = Arrays.asList(1,2,3,4,5)
        Consumer<Integer> consumerPrint = (Integer a)-> println a
        listNew.forEach(consumerPrint)


        /**
         * Supplier interface: its an in-built functional interface by java; it doesnt take any value by supplies a value
         */
        Supplier<Double> supplier = ()-> {return Math.random()}
        println supplier.get()

        /**
         * Function interface: its an in-built functional interface by java; it doesnt take any value by supplies a value
         */
        Function<String, Integer> strToLenMap = (String str)-> str.length()
        println strToLenMap.apply("Kuldeep")

        //Composing functions: Returns a composed function that first applies the before function
        // to its input, and then applies this function to the result.
        Function<Integer, Integer> square = (a)-> a*a
        println square.apply(2)
        Function<Integer, Integer> increment = (a)-> a+1
        println increment.apply(2)

        println square.andThen(increment).apply(4)
        println increment.andThen(square).andThen(increment).apply(4)
        println square.andThen(square).apply(4)


        /**
         * Predicate<Integer> <=> IntPredicate
         */
        IntPredicate intPredicate = (a)-> a>=5
        println intPredicate.test(4)

        /**
         * Predicate<Integer> <=> StringPredicate
         * This is actually done so as to prevent boxing; unboxing of a variable which improves performance
         */
        DoublePredicate stringPredicate = (a)-> a>=5
        println intPredicate.test(4)

        /**
         * Method Referencing: sugar coating
         */

        List.of(1,2,3,4,5).forEach(a-> println a)
        List.of(1,2,3,4,5).forEach(System.out::println)

        /**
         *  it means--->
         * arg-> ClassName.staticMethod(arg)
         * is equivalent to
         * ClassName::staticMethod
         */
        List.of(1,2,3,4,5).forEach(System.out::println)

       /* 1. (arg)-> ClassName.staticMethod(arg)
            ClassNmae::staticMethod

        (arg)-> arg.someMethod()
            ClassName::StaticMethod
        2. (arg1,arg2,arg3.....)->arg1.someMethod(arg2)
            ClassName::StaticMethod

        */
        List<String> listNewNew = ["abc", "asdee", "tfee"]

        //listNewNew.sort((a, b )-> a.compareToIgnoreCase(b))
        listNewNew.sort(String::compareToIgnoreCase)
        println listNewNew

        String hello = "Hello kuldeep"
        println reverserString(hello)

    }

    static String reverserString(String str){
        char[] charArray = str.toCharArray()
        int start  = 0
        int end = str.length()-1

        while(end>start){
            char temp
            temp = charArray[start]
            charArray[start] = charArray[end]
            charArray[end] = temp
            end--
            start++
        }
        return charArray.toString()
    }

    FilteringLogic getLambdaExp(){
        final int price  = 4000
        List<Integer> list = new ArrayList<>()
        FilteringLogic logic =  (hotel) -> {return hotel.getPricePerNight() <= list.size();}
        list.add(1)
        list = new ArrayList<>()
        return logic
    }

    /**
     * 1 . You cant modify a local variable (which is part of lambda exp) in a lambda expression::
     *  The reason behind this is that once the method (getLambdaExp) has returned the value of the
     *  FilteringLogic or the functionality of the interface is now implemented ; the method getLambdaExp
     *  has no need in the stack of operations, and that's why the value capture is completed for
     *  value price in the getLambdaExp method, means that the variable price will die once the lambda expression
     *  start and the price is replace by its value
     * 2. This behaviour is not a problem in case of any reference is passed; But if you try to changes the reference itself
     *  then it will give a compiler error
     */





}
