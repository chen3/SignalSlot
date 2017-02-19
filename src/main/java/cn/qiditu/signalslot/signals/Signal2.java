package cn.qiditu.signalslot.signals;

import cn.qiditu.signalslot.Signal;
import cn.qiditu.signalslot.Slot;
import cn.qiditu.signalslot.slots.Slot2;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.lang.ref.WeakReference;

abstract class BaseSignal2<T, U> extends BaseSignal1<T> {

    public BaseSignal2(@NotNull Object sender) {
        super(sender);
    }

    public BaseSignal2(@NotNull WeakReference sender) {
        super(sender);
    }

    /**
     * @see Signal#connect(Signal)
     */
    public Slot2<T, U> connect(@NotNull final Signal2<T, U> signal) {
        return (Slot2<T, U>)super.connect(signal);
    }

    /**
     * @see Signal#connect(Signal, int)
     */
    public Slot2<T, U> connect(@NotNull final Signal2<T, U> signal, int count) {
        return (Slot2<T, U>)super.connect(signal, count);
    }

    /**
     * @see Signal#connect(Slot)
     */
    public Slot2<T, U> connect(@NotNull final Slot2<T, U> slot) {
        super.connect(slot);
        return slot;
    }

    /**
     * @see Signal#connect(Slot, int)
     */
    public Slot2<T, U> connect(@NotNull final Slot2<T, U> slot, final int count) {
        super.connect(slot, count);
        return slot;
    }

    /**
     * @see Signal#disconnect(Signal)
     */
    public boolean disconnect(@NotNull final Signal2<T, U> signal) {
        return super.disconnect(signal);
    }

    /**
     * @see Signal#disconnect(Slot)
     */
    public boolean disconnect(@NotNull final Slot2<T, U> slot) {
        return super.disconnect(slot);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void actuate(@NotNull final Slot slot, @NotNull final Object[] args) {
        if(slot instanceof Slot2) {
            ((Slot2<T, U>)slot).accept((T)args[0], (U)args[1]);
        }
        else {
            super.actuate(slot, args);
        }
    }
}

/**
 * A signalslot with 2 generic arguments.
 *
 * @param <T> The type of the first argument.
 * @param <U> The type of the second argument.
 */
public class Signal2<T, U> extends BaseSignal2<T, U> {

    public Signal2(@NotNull Object sender) {
        super(sender);
    }

    public Signal2(@NotNull WeakReference sender) {
        super(sender);
    }

    private final Slot2<T, U> slotEmit = this::emit;
    @Override
    protected Slot getSlotEmit() {
        return slotEmit;
    }

    /**
     * @see Signal#emit(Object...)
     */
    public void emit(@Nullable final T t, @Nullable final U u) {
        super.emit(t, u);
    }

}
