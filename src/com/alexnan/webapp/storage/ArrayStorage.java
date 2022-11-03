package com.alexnan.webapp.storage;

import com.alexnan.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage implements Storage{

    protected static final int STORAGE_LIMIT = 1000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        if (STORAGE_LIMIT <= size) {
            System.out.println("ERROR: not enough space in storage");
        } else if (findIndex(r.getUuid()) == -1) {
            storage[size] = r;
            System.out.println("Resume " + r.getUuid() + " was added to storage");
            size++;
        } else {
            System.out.println("Resume " + r.getUuid() + " already exist in storage");
        }
    }

    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index != -1) {
            return storage[index];
        }
        return null;
    }

    public void update(Resume resume) {
        storage[findIndex(resume.getUuid())] = resume;
    }

    public void delete(String uuid) {
        if (findIndex(uuid) != -1) {
            storage[findIndex(uuid)] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {

        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    private int findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        System.out.println("Resume " + uuid + " does not exist");
        return -1;
    }
}
