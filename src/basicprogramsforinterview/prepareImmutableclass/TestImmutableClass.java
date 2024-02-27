package basicprogramsforinterview.prepareImmutableclass;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestImmutableClass {

    public static void main(String[] args) {

        Set<Integer> set = new HashSet<>(List.of(1, 2, 3, 4));
        ImmutableClass immutableClass = new ImmutableClass(7, "Kuldeep", set);

        //System.out.println(immutableClass.getId() + " " +  immutableClass.getStr() + " " +  immutableClass.getSet());

        set.addAll(List.of(5,6,7,8));

        System.out.println(immutableClass.getId() + " " +  immutableClass.getStr() + " " +  immutableClass.getSet());

        /**
         * Here we can see that even after variable 'set' (Non-primitive) the value can be changed,
         * This is happening because the reference is not changing where the set variable is pointing,
         * and we can change the value in that heap memory space
         * Whereas, in case of Primitive data type the reference was changing as soon as we change the value
         * Just like in case of String, the new memory space is allocated as soon as we change the value srt pointer
         * will start to point tho new memory space in String pool
         * and thus String was Immutable
         *
         *
         * In order to avoid this  violation of immutability concept see, point 4a and 4b changes
         */

        //immutableClass.id = 4
        // compile time error that id is a private member of ImmutableClass


    }
}
