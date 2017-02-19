package cn.qiditu.signalslot.slots;

import cn.qiditu.signalslot.Slot;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;


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
 * @param <R> The type of the ninth argument.
 */
@FunctionalInterface
public interface Slot9<T, U, V, W, X, Y, Z, S, R> extends Slot {

    void accept(@Nullable final T t, @Nullable final U u, @Nullable final V v,
                @Nullable final W w, @Nullable final X x, @Nullable final Y y,
                @Nullable final Z z, @Nullable final S s, @Nullable final R r);

    @NotNull
    default Slot9<T, U, V, W, X, Y, Z, S, R>
    andThen(@NotNull final Slot9<? super T, ? super U, ? super V, ? super W,
            ? super X, ? super Y, ? super Z, ? super S,
            ? super R> after) {
        return (t, u, v, w, x, y, z, s, r) -> {
            accept(t, u, v, w, x, y, z, s, r);
            after.accept(t, u, v, w, x, y, z, s, r);
        };
    }
}
