package cn.qiditu.signalslot.slots;

import cn.qiditu.signalslot.Slot;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * A slot with 4 generic arguments.
 *
 * @param <T> The type of the first argument.
 * @param <U> The type of the second argument.
 * @param <V> The type of the third argument.
 * @param <W> The type of the forth argument.
 */
@FunctionalInterface
public interface Slot4<T, U, V, W> extends Slot {

    void accept(@Nullable final T t, @Nullable final U u, @Nullable final V v,
                @Nullable final W w);

    @NotNull
    default Slot4<T, U, V, W>
    andThen(@NotNull final Slot4<? super T, ? super U, ? super V, ? super W> after) {
        return (t, u, v, w) -> {
            accept(t, u, v, w);
            after.accept(t, u, v, w);
        };
    }
}
