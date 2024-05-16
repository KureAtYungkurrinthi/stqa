/**
 * Class that simulates a list for storing Strings.
 *
 * @author << your name goes here >>
 * @version << version number here >>
 */
public class StringList {

    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 4;

    /**
     * The amount to grow this {@code StringList} when {@code grow()} is called.
     */
    private static final int GROW = 5;
    /**
     * The size of the {@code StringList} (the number of elements it contains).
     */
    private int size;
    /**
     * The array buffer into which the elements of the {@code StringList} are stored.
     */
    private String[] elementData;

    /**
     * Default constructor that creates an empty list to hold 4 Strings (use the constant).
     */
    public StringList() {
        this.size = 0;
        this.elementData = new String[DEFAULT_CAPACITY];
    }

    /**
     * Increases the size of elementData by {@code GROW} and copies the old elements.
     */
    public void grow() {
        String[] temp = new String[size + GROW];
        for (int i = 0; i < size; i++) {
            temp[i] = elementData[i];
        }
        elementData = temp;
    }

    /**
     * Append the specified element to the end of the list.
     *
     * @param element the element to append
     * @return true if successful
     */
    public boolean add(String element) {
        if (size >= elementData.length) {
            grow();
        }
        elementData[size] = element;
        size++;
        return true;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IllegalArgumentException if the index is invalid
     */
    public String get(int index) {
        if (index >= size) {
            throw new IllegalArgumentException("Invalid index: " + index);
        } else {
            return elementData[index];
        }
    }

    /**
     * Returns a formatted String of the elements in the list.
     *
     * @return a formatted String of the elements in the list
     */
    @Override
    public String toString() {
        if (size == 0) {
            return "List is empty: []";
        } else {
            String output = "Printing List: [";
            for (int i = 0; i < size; i++) {
                output += elementData[i] + ", ";
            }
            return output + "]";
        }
    }
}
