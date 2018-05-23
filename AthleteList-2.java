/**
 * An AthleteList that manages the athletes.
 *
 * @author ehuang42
 * @version 9.0.1
 * @param <T> A subtype of Athlete
 */


public class AthleteList<T extends Athlete> implements AthleteListInterface<T> {

    private Object[] lst;
    private Object[] newLst;
    private Object[] returnLst;
    private Athlete current;

    /**
     * Public constructor for AthleteList. Creates a backing array for the list
     * with initial capacity constant.
     *
     */

    public AthleteList() {
        lst = new Athlete[INITIAL_CAPACITY];
    }

    /**
     * The implementation for add() in AthleteLIstInterface.
     * @throws IllegalArgumentException if the element to be added is null
     * @throws IndexOutOfBoundsException if the index is out of reasonable
     * range, e.g. negative, or bigger than the size of the array
     * @param t Element to be added to the AthleteList
     */

    @Override
    public void add(T t) throws IllegalArgumentException {
        if (t == null) {
            throw new IllegalArgumentException("element can't be empty!");
        }
        try {
            if (lst[size()] == null) {
                lst[size()] = t;
            }
        } catch (IndexOutOfBoundsException e) {
            newLst = new Athlete[lst.length * 2];
            for (int i = 0; i < lst.length; i++) {
                newLst[i] = lst[i];
            }
            newLst[lst.length] = t;
            lst = newLst;
        }
    }
    /**
     * The implementation for remove() in AthleteLIstInterface.
     * @throws IndexOutOfBoundsException if the index is less than zero or is
     * greater than or equal to the number of elements in the AthleteList.
     * @param index Index of the element to be removed.
     * @return The Athlete removed from the AthleteList.
     */

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {

        T target = (T) lst[index];
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("index has to be in the range");
        }
        for (int i = index; i < size(); i++) {
            lst[i] = lst[i + 1];
        }
        return target;
    }

    /**
     * The implementation for get() in AthleteLIstInterface.
     * @throws IndexOutOfBoundsException if the index is less than zero or
     * greater than or equal to the number of elements in the AthleteList.
     * @param index Index of the element to be returned.
     * @return Athlete at the passed-in index
     */

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("index has to be in the range");
        }
        return (T) lst[index];
    }

    /**
     * The implementation for clear() in AthleteLIstInterface.
     */

    @Override
    public void clear() {
        for (int i = 0; i < lst.length; i++) {
            lst[i] = null;
        }
    }

    /**
     * The implementation for size() in AthleteLIstInterface.
     * @return The number of elements in the AthleteList
     */

    @Override
    public int size() {
        if (lst[0] == null) {
            return 0;
        }
        for (int i = 0; i < lst.length; i++) {
            if (lst[i] == null) {
                return i;
            }
        }
        return lst.length;
    }

    /**
     * The implementation for isEmpty() in AthleteLIstInterface.
     * @return true if this AthleteList is empty, false otherwise.
     */

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < lst.length; i++) {
            if (!(lst[i] == null)) {
                return false;
            }
        }
        return true;
    }

    /**
     * The implementation for train() in AthleteLIstInterface.
     * @throws IndexOutOfBoundsException if index is less than zero or greater
     * than or equal to the number of elements in the AthleteList.
     * @throws OvertrainedAthleteException if the athlete's energy is less than
     * his/her strength.
     * @param index Index of the Athlete to be trained.
     */

    @Override
    public void train(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        } else {
            try {
                current = get(index);
                current.train();
            } catch (OvertrainedAthleteException e) {
                throw new OvertrainedAthleteException("overtrained");
            }
        }
    }

    /**
     * The implementation for rest() in AthleteLIstInterface.
     * @throws IndexOutOfBoundsException if index is less than zero or greater
     * than or equal to the number of elements in the AthleteList.
     * @param index Index of the athlete to be rested.
     */

    @Override
    public void rest(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        } else {
            current = get(index);
            current.rest();
        }
    }

    /**
     * The implementation for asArray() in AthleteLIstInterface.
     * @return an array of Athletes as described above.
     */

    @Override
    public T[] asArray() {
        returnLst = new Athlete[size()];
        for (int i = 0; i < size(); i++) {
            returnLst[i] = (T) lst[i];
        }
        return (T[]) returnLst;
    }










}