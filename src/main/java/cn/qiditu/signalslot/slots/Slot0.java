package cn.qiditu.signalslot.slots;

import cn.qiditu.signalslot.Slot;
import org.jetbrains.annotations.NotNull;

/**
 * A slot with 0 arguments.
 */
@FunctionalInterface
public interface Slot0 extends Slot {

    void accept();

    @NotNull
    default Slot0 andThen(@NotNull final Slot0 after) {
        return () -> {
            accept();
            after.accept();
        };
    }
}
