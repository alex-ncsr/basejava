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
        Resume temp;
        for (int i = 0; i < storage.length - 1; i++) {
            if (storage[i] != null && storage[i].uuid.equals(uuid) && storage[i + 1] != null) {
                temp = storage[i + 1];
                storage[i + 1] = storage[i];
                storage[i] = temp;
                break;
            }
        }
        storage[size - 1] = null;
        size--;
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
