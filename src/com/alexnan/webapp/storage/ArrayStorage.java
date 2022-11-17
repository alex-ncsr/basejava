package com.alexnan.webapp.storage;

import com.alexnan.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void extractItemFromArray(int index) {
        storage[index] = storage[size - 1];
    }

    @Override
    public void insertItemInArray(Resume r, int index) {
        storage[size] = r;
    }

    protected int findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        System.out.println("Resume " + uuid + " does not exist");
        return -1;
    }
}
