/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i <= size() + 1; i++) {
            System.out.println(size());
            storage[i] = null;
        }

//        for (int i = 0; i < storage.length; i++) {
////            System.out.println(size());
//            storage[i] = null;
//        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
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
        Resume temp = new Resume();
        for (int i = 0; i < storage.length - 1; i++) {
            if (storage[i] != null && storage[i].uuid.equals(uuid) && storage[i + 1] != null) {
                temp = storage[i + 1];
                storage[i + 1] = storage[i];
                storage[i] = temp;
            }
        }
        storage[size() - 1] = null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] existingResumes = new Resume[size()];
        for (int i = 0; i < existingResumes.length; i++) {
            existingResumes[i] = storage[i];
            if (storage[i] == null) {
                break;
            }
        }
        return existingResumes;
    }

    int size() {
        int count = 0;
        for (Resume resume : storage) {
            if ((resume != null)) {
                count++;
            }
        }
        return count;
    }
}
