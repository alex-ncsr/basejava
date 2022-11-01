package com.alexnan.webapp.storage;

import com.alexnan.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    protected static final int STORAGE_LIMIT = 1000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

    public void clear() {

        Arrays.fill(storage, null);
        size = 0;
    }

    public void save(Resume r) {

        if (STORAGE_LIMIT <= size) {
            System.out.println("ERROR: not enough space in storage");
        } else if (findIndex(r) == -1) {
            storage[size] = r;
            System.out.println("Resume " + r.getUuid() + " was added to storage");
            size++;
        } else {
            System.out.println("Resume " + r.getUuid() + " already exist in storage");
        }
    }

    public Resume get(String uuid) {

        Resume resume = new Resume();
        resume.setUuid(uuid);
        if (findIndex(resume) != -1) {
            return storage[findIndex(resume)];
        }
        return null;

//        for (int i = 0; i < size; i++) {
//            if (storage[i].getUuid().equals(uuid)) {
//                return storage[i];
//            }
//        }
//        return null;
    }

    public void update(Resume resume) {

        findIndex(resume);
        storage[findIndex(resume)] = resume;
//        for (int i = 0; i < size; i++) {
//            if (storage[i].getUuid().equals(resume.getUuid())) {
//                storage[i] = resume;
//            }
//        }
    }

    public void delete(String uuid) {

//        if (isPresent(get(uuid))) {
//            for (int i = 0; i < size; i++) {
//                if (storage[i].getUuid().equals(uuid)) {
//                    storage[i] = storage[size - 1];
//                    storage[size - 1] = null;
//                    size--;
//                    break;
//                }
//            }
//        }
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

//    boolean isPresent(Resume resume) {
//
//        for (int i = 0; i < size; i++) {
//            if (storage[i].getUuid().equals(resume.getUuid())) {
//                return true;
//            }
//        }
//        System.out.println("Resume " + resume.getUuid() + " does not exist");
//        return false;
//    }

    public int findIndex(Resume resume) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(resume.getUuid())) {
                return i;
            }
        }
        System.out.println("Resume " + resume.getUuid() + " does not exist");
        return -1;
    }
}

