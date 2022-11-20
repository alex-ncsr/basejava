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
        if (index >= 0) {
            System.out.println("Resume " + r.getUuid() + " already exist in storage");
        } else if (size == STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        } else {
            insertResume(r, index);
            System.out.println("Resume " + r.getUuid() + " was added to storage");
            size++;
        }
    }

    public void delete(String uuid) {
//        int index = findIndex(uuid);
//        if (index > 0) {
//            removeResume(index);
//            storage[size - 1] = null;
//            size--;
//        }

        int index = findIndex(uuid);
        if (index < 0) {
            System.out.println("Resume " + uuid + " not exist");
        } else {
            removeResume(index);
            storage[size - 1] = null;
            size--;
        }
    }

    public void update(Resume resume) {
        storage[findIndex(resume.getUuid())] = resume;
    }

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
//        int index = findIndex(uuid);
//        if (index > 0) {
//            return storage[index];
//        }
//        return null;

        int index = findIndex(uuid);
        if (index < 0) {
            System.out.println("Resume " + uuid + " not exist");
            return null;
        }
        return storage[index];
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    protected abstract void removeResume(int index);

    public abstract void insertResume(Resume r, int index);

    protected abstract int findIndex(String uuid);
}
