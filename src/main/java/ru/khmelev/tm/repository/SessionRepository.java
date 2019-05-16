package ru.khmelev.tm.repository;

import org.jetbrains.annotations.NotNull;
import ru.khmelev.tm.api.repository.ISessionRepository;
import ru.khmelev.tm.dto.SessionDTO;
import ru.khmelev.tm.exception.RepositoryException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SessionRepository implements ISessionRepository {


    private static Map<String, SessionDTO> sessionMap = null;

    public SessionRepository() {
        if (sessionMap == null) {
            sessionMap = new HashMap<>();
        }
    }

    @Override
    public void persist(@NotNull String id, @NotNull SessionDTO sessionDTO) {
        if (!id.isEmpty()) {
            sessionMap.put(id, sessionDTO);
        }
    }

    @NotNull
    @Override
    public SessionDTO findOne(@NotNull final String id) {
        if (!id.isEmpty()) {
            for (SessionDTO sessionDTO : sessionMap.values()) {
                if (sessionDTO.getId().equals(id)) {
                    return sessionDTO;
                }
            }
        }
        throw new RepositoryException();
    }

    @NotNull
    @Override
    public Collection<SessionDTO> findAll() {
        return sessionMap.values();
    }

    @NotNull
    @Override
    public Collection<SessionDTO> findAll(@NotNull String userId) {
        return findAll();
    }

    @Override
    public void merge(@NotNull final String id, @NotNull final SessionDTO sessionDTO) {
    }

    @Override
    public void remove(@NotNull final String id) {
        if (!id.isEmpty()) {
            Collection<SessionDTO> list = sessionMap.values();
            Iterator<SessionDTO> it = list.iterator();
            while (it.hasNext()) {
                SessionDTO sessionDTO = it.next();
                if (sessionDTO.getId().equals(id)) {
                    it.remove();
                    return;
                }
            }
        }
    }

    @Override
    public void removeAll() {
        sessionMap.clear();
    }
}