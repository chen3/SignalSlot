package cn.qiditu.signalslot.slots;

import cn.qiditu.signalslot.Slot;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


/**
 * A slot with 34 generic arguments.
 *
 * @param <T> The type of the first argument.
 * @param <U> The type of the second argument.
 * @param <V> The type of the third argument.
 * @param <W> The type of the forth argument.
 * @param <X> The type of the fifth argument.
 * @param <Y> The type of the sixth argument.
 * @param <Z> The type of the seventh argument.
 * @param <S> The type of the eighth argument.
 */
@FunctionalInterface
public interface Slot8<T, U, V, W, X, Y, Z, S> extends Slot {

    void accept(@Nullable final T t, @Nullable final U u, @Nullable final V v,
                @Nullable final W w, @Nullable final X x, @Nullable final Y y,
                @Nullable final Z z, @Nullable final S s);

    @NotNull
    default Slot8<T, U, V, W, X, Y, Z, S>
    andThen(@NotNull final Slot8<? super T, ? super U, ? super V, ? super W,
            ? super X, ? super Y, ? super Z, ? super S> after) {
        return (t, u, v, w, x, y, z, s) -> {
            accept(t, u, v, w, x, y, z, s);
            after.accept(t, u, v, w, x, y, z, s);
        };
    }
}
