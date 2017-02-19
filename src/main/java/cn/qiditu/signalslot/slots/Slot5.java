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
 */
@FunctionalInterface
public interface Slot5<T, U, V, W, X> extends Slot {

    void accept(@Nullable final T t, @Nullable final U u, @Nullable final V v,
                @Nullable final W w, @Nullable final X x);

    @NotNull
    default Slot5<T, U, V, W, X>
    andThen(@NotNull final Slot5<? super T, ? super U, ? super V, ? super W,
            ? super X> after) {
        return (t, u, v, w, x) -> {
            accept(t, u, v, w, x);
            after.accept(t, u, v, w, x);
        };
    }
}
