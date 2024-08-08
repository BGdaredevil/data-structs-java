package interfaces;

import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public interface CustomList<T> {
    int length();

    @Nullable
    T removeAt(int idx);

    @Nullable
    T remove(T item);

    @Nullable
    T get(int idx);

    void prepend(T item);

    void append(T item);

    void insertAt(T item, int idx);

}
