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
 */
@FunctionalInterface
public interface Slot6<T, U, V, W, X, Y> extends Slot {

    void accept(@Nullable final T t, @Nullable final U u, @Nullable final V v,
                @Nullable final W w, @Nullable final X x, @Nullable final Y y);

    @NotNull
    default Slot6<T, U, V, W, X, Y>
    andThen(@NotNull final Slot6<? super T, ? super U, ? super V, ? super W,
            ? super X, ? super Y> after) {
        return (t, u, v, w, x, y) -> {
            accept(t, u, v, w, x, y);
            after.accept(t, u, v, w, x, y);
        };
    }
}
