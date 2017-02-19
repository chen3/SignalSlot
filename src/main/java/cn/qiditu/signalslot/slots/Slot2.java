package cn.qiditu.signalslot.slots;

import cn.qiditu.signalslot.Slot;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

/**
 * A slot with 2 generic arguments.
 *
 * @param <T> The type of the first argument.
 * @param <U> The type of the second argument.
 */
@FunctionalInterface
public interface Slot2<T, U> extends Slot {

    void accept(@Nullable final T t, @Nullable final U u);

    @NotNull
    default Slot2<T, U> andThen(@NotNull final Slot2<? super T, ? super U> after) {
        return (t, u) -> {
            accept(t, u);
            after.accept(t, u);
        };
    }
}
