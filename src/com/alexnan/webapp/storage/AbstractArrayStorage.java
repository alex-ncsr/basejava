package com.alexnan.webapp.storage;

import com.alexnan.webapp.model.Resume;

public abstract class AbstractArrayStorage implements Storage {

    protected static final int STORAGE_LIMIT = 1000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

//    public Resume get(String uuid) {
//        int index = getIndex(uuid);
//        if (index == -1) {
//            System.out.println("Resume " + uuid + " not exist");
//            return null;
//        }
//        return storage[index];
//    }

    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index != -1) {
            return storage[index];
        }
        return null;
    }

    protected abstract int findIndex(String uuid);
}
