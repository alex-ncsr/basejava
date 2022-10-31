package com.alexnan.webapp.storage;

import com.alexnan.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private final Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {

        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void save(Resume r) {

        if (storage.length <= size) {
            System.out.println("ERROR: not enough space in storage");
        } else if (!isPresent(r)) {
            storage[size] = r;
            System.out.println("Resume " + r.getUuid() + " was added to storage");
            size++;
        } else {
            System.out.println("Resume " + r.getUuid() + " already exist in storage");
        }
    }

    public Resume get(String uuid) {

        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    public void update(Resume resume) {

    }

    public void delete(String uuid) {

        if (isPresent(get(uuid))) {
            for (int i = 0; i < size; i++) {
                if (storage[i].getUuid().equals(uuid)) {
                    storage[i] = storage[size - 1];
                    storage[size - 1] = null;
                    size--;
                    break;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {

        return Arrays.copyOf(storage, size);
    }

    public int size() {

        return size;
    }

    boolean isPresent(Resume resume) {

        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(resume.getUuid())) {
                return true;
            }
        }
        System.out.println("Resume " + resume.getUuid() + " does not exist");
        return false;
    }
}

