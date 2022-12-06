package com.alexnan.webapp.storage;

import com.alexnan.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapStorage extends AbstractStorage {

    private final Map<String, Resume> resumeMap = new HashMap<>();

    @Override
    protected Resume getSearchKey(String uuid) {
        Set<String> keySet = resumeMap.keySet();
        for (String s : keySet) {
            if (s.equals(uuid))
                return resumeMap.get(s);
        }
        return null;
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
        resumeMap.putIfAbsent(r.getUuid(), r);

    }

    @Override
    protected Resume doGet(Object searchKey) {
        return resumeMap.get(searchKey);
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        resumeMap.replace(r.getUuid(), r);
    }

    @Override
    protected void doDelete(Object searchKey) {
        resumeMap.remove(searchKey);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    @Override
    public void clear() {
        resumeMap.clear();
    }

    @Override
    public Resume[] getAll() {
        return resumeMap.values().toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return resumeMap.size();
    }
}
