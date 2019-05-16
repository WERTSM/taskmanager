package ru.khmelev.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import ru.khmelev.tm.dto.SessionDTO;

import java.util.Collection;

public interface ISessionRepository {

    void persist(@NotNull String id, @NotNull SessionDTO sessionDTO);

    @NotNull SessionDTO findOne(@NotNull String id);

    @NotNull Collection<SessionDTO> findAll();

    @NotNull Collection<SessionDTO> findAll(@NotNull String userId);

    void merge(@NotNull String id, @NotNull SessionDTO sessionDTO);

    void remove(@NotNull String id);

    void removeAll();
}