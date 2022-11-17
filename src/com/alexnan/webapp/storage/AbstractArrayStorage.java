package com.alexnan.webapp.storage;

import com.alexnan.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {

    protected static final int STORAGE_LIMIT = 1000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        int index = findIndex(r.getUuid());
        if (STORAGE_LIMIT <= size) {
            System.out.println("ERROR: not enough space in storage");
        } else {
            if (index < 0) {
                insertItemInArray(r, index);
                System.out.println("Resume " + r.getUuid() + " was added to storage");
                size++;
            } else {
                System.out.println("Resume " + r.getUuid() + " already exist in storage");
            }
        }
    }

    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index > 0) {
            extractItemFromArray(index);
            storage[size - 1] = null;
            size--;
        }
    }

    protected abstract void extractItemFromArray(int index);

    public abstract void insertItemInArray(Resume r, int index);

    public void update(Resume resume) {
        storage[findIndex(resume.getUuid())] = resume;
    }

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index > 0) {
            return storage[index];
        }
        return null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    protected abstract int findIndex(String uuid);
}
