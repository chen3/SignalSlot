package cn.qiditu.signalslot.slots;

import cn.qiditu.signalslot.Slot;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * A slot with 1 generic argument.
 *
 * @param <T> The type of the argument.
 */
@FunctionalInterface
public interface Slot1<T> extends Slot {

    void accept(@Nullable final T t);

    @NotNull
    default Slot1<T> andThen(@NotNull final Slot1<? super T> after) {
        return (t) -> {
            accept(t);
            after.accept(t);
        };
    }
}
