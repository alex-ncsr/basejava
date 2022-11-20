package com.alexnan.webapp.storage;

import com.alexnan.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void extractItemFromArray(int index) {
        int numberMoved = size - index - 1;
        if (numberMoved > 0) {
            System.arraycopy(storage, index + 1, storage, index, numberMoved);
        }
    }

    @Override
    public void insertItemInArray(Resume r, int index) {
        int insertIndex = -index - 1;
        System.arraycopy(storage, insertIndex, storage, insertIndex + 1, size - insertIndex);
        storage[insertIndex] = r;
    }

    @Override
    protected int findIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
