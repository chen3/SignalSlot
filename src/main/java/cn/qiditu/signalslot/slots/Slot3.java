package cn.qiditu.signalslot.slots;

import cn.qiditu.signalslot.Slot;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

/**
 * A slot with 3 generic arguments.
 *
 * @param <T> The type of the first argument.
 * @param <U> The type of the second argument.
 * @param <V> The type of the third argument.
 */
@FunctionalInterface
public interface Slot3<T, U, V> extends Slot {

    void accept(@Nullable final T t, @Nullable final U u, @Nullable final V v);

    @NotNull
    default Slot3<T, U, V>
    andThen(@NotNull final Slot3<? super T, ? super U, ? super V> after) {
        return (t, u, v) -> {
            accept(t, u, v);
            after.accept(t, u, v);
        };
    }
}
