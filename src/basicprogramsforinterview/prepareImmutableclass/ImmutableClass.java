package basicprogramsforinterview.prepareImmutableclass;

import java.util.HashSet;
import java.util.Set;

/**
 * Immutable class properties:
 * 1. Class can't be extended
 * 2. Variable of this class can't be changed from outside the class
 * 3. This class won't have any setter methods; only getter methods are allowed
 */

//for point 1 we have made class as final
public final class ImmutableClass {

    // for point 2 we have made the access modifier to 'private' keyword and final as once they are set they can't be
    // changed
    private final int id;
    private final String str; // String in itself an immutable object so no issue

    //BUT ::
    private final Set<Integer> set;

    public ImmutableClass(int id, String str, Set<Integer> set) {
        this.id = id;
        this.str = str;
        //****> point 4b: we make deep copy of the object and return to get method
        this.set = new HashSet<>(set);
    }

    //only getters are present for each variable

    public int getId(){
        return this.id;
    }

    public String getStr(){
        return this.str;
    }

    public Set getSet(){
        //return this.set;
        //****> point 4a: we make deep copy of the object and return to get method
        return new HashSet<Integer>(set);
    }

}
