// In order to compare the individual objects later (in isSorted) T must extend 
// the Comparable class. This constraint should be made when declaring the class,
// rather than when this functionality is needed.
public class GenericPair<T extends Comparable<T>> {
    T thing1;
    T thing2;
    
    public GenericPair(T thing1, T thing2){
        this.thing1 = thing1;
        this.thing2 = thing2;
    }

    // return __ if this is ____ than the param.
    // less than : -
    // equal : 0
    // greater than : +
    public int isSorted(){ 
        return thing1.compareTo(thing2);
    }

    public static void main(String[] args){
        GenericPair<Integer> onetwo = new GenericPair<Integer>(1, 2);
        System.out.println(onetwo.isSorted());
    }
}
