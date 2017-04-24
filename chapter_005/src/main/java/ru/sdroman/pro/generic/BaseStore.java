package ru.sdroman.pro.generic;

/**
 * Class BaseStore.
 *
 * @author sdroman
 * @since 04.17
 */
public class BaseStore implements Store<Base> {

    /**
     * SimpleArray instance.
     */
    private SimpleArray<Base> storage;

    /**
     * Constructs a new BaseStore object.
     */
    public BaseStore() {
        storage = new SimpleArray<>();
    }

    /**
     * Add new element.
     *
     * @param value T
     */
    @Override
    public void add(Base value) {
        this.storage.add(value);
    }

    /**
     * Remove element by id.
     *
     * @param id String
     * @return removed element
     */
    @Override
    public Base remove(String id) throws ElementNotFoundException {
        return this.storage.remove(findIndex(id));
    }

    /**
     * Returns element by id.
     *
     * @param id String
     * @return T old value
     */
    @Override
    public Base get(String id) throws ElementNotFoundException {
        return this.storage.get(findIndex(id));
    }

    /**
     * Update element.
     *
     * @param id    String
     * @param value T
     * @return T old value
     */
    @Override
    public Base update(String id, Base value) throws ElementNotFoundException {
        return this.storage.update(findIndex(id), value);
    }

    /**
     * Finde index of element by id.
     *
     * @param id String
     * @return int
     * @throws ElementNotFoundException exception
     */
    private int findIndex(String id) throws ElementNotFoundException {
        Base current;
        int index = 0;
        boolean done = false;
        while ((current = this.storage.get(index)) != null) {
            if (id.equals(current.getId())) {
                done = true;
                break;
            }
            index++;
        }
        if (!done) {
            throw new ElementNotFoundException("Not found.");
        }
        return index;
    }
}
