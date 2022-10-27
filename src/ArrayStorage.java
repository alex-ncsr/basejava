import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private int size = 0;

    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i <= size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                size++;
                break;
            }
        }
    }

    Resume get(String uuid) {
        for (Resume searchingResume : storage) {
            if (searchingResume != null && searchingResume.uuid.equals(uuid)) {
                return searchingResume;
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[size-1];
                storage[size-1] = null;
                size--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }
}
