/**
 * Class that simulates a list for storing Strings.
 *
 * @author Wang Shengfan
 * @version 0.3
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
     * Constructor that creates an empty list to hold {@code size} Strings.
     *
     * @param volume the initial size of the list
     */
    public StringList(int volume) {
        this.size = volume;
        this.elementData = new String[volume];
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
     * Inserts the specified element at the specified index in the list.
     *
     * @param index the index at which the element is to be inserted
     * @param element the element to be inserted
     * @throws IllegalArgumentException if the index is invalid
     */
    public void add(int index, String element) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("Invalid index: " + index);
        } else {
            if (size >= elementData.length) {
                grow();
            }
            for (int i = size; i > index; i--) {
                elementData[i] = elementData[i - 1];
            }
            elementData[index] = element;
            size++;
        }
    }

    /**
     * Removes the element at the specified position in the list.
     *
     * @param index the index of the element to remove
     * @return the element that was removed from the list
     * @throws IllegalArgumentException if the index is invalid
     */
    public String remove(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("Invalid index: " + index);
        } else {
            String removed = elementData[index];
            for (int i = index; i < size - 1; i++) {
                elementData[i] = elementData[i + 1];
            }
            size--;
            return removed;
        }
    }

    /**
     * Removes the first occurrence of the specified element from the list.
     *
     * @param element the element to remove
     * @return true if the list contained the element, false otherwise
     */
    public boolean remove(String element) {
        if (contains(element)) {
            remove(indexOf(element));
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes all elements from the list.
     */
    public void clear() {
        size = 0;
        elementData = new String[size];
    }

    /**
     * Returns true if the list contains no elements.
     *
     * @return true if the list contains no elements
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IllegalArgumentException if the index is invalid
     */
    public String get(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("Invalid index: " + index);
        } else {
            return elementData[index];
        }
    }

    /**
     * Checks to see if the given element is in this list.
     *
     * @param element the element to check
     * @return true if this list contains the specified element, false otherwise
     */
    public boolean contains(String element) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] != null && elementData[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     *
     * @param element the element to search for
     * @return the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element
     */
    public int indexOf(String element) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IllegalArgumentException if the index is invalid
     */
    public String set(int index, String element) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("Invalid index: " + index);
        } else {
            String temp = elementData[index];
            elementData[index] = element;
            return temp;
        }
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list
     */
    public int size() {
        return size;
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
