package cn.qiditu.signalslot.signals;

import cn.qiditu.signalslot.Signal;
import cn.qiditu.signalslot.Slot;
import cn.qiditu.signalslot.slots.Slot1;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.lang.ref.WeakReference;

abstract class BaseSignal1<T> extends BaseSignal0 {

    public BaseSignal1(@NotNull Object sender) {
        super(sender);
    }

    public BaseSignal1(@NotNull WeakReference<Object> sender) {
        super(sender);
    }

    /**
     * @see Signal#connect(Signal)
     */
    public Slot1<T> connect(@NotNull final Signal1<T> signal) {
        return (Slot1<T>)super.connect(signal);
    }

    /**
     * @see Signal#connect(Signal, int)
     */
    public Slot1<T> connect(@NotNull final Signal1<T> signal, int count) {
        return (Slot1<T>)super.connect(signal, count);
    }

    /**
     * @see Signal#connect(Slot)
     */
    public Slot1<T> connect(@NotNull final Slot1<T> slot) {
        super.connect(slot);
        return slot;
    }

    /**
     * @see Signal#connect(Slot, int)
     */
    public Slot1<T> connect(@NotNull final Slot1<T> slot, final int count) {
        super.connect(slot, count);
        return slot;
    }

    /**
     * @see Signal#disconnect(Signal)
     */
    public boolean disconnect(@NotNull final Signal1<T> signal) {
        return super.disconnect(signal);
    }

    /**
     * @see Signal#disconnect(Slot)
     */
    public boolean disconnect(@NotNull final Slot1<T> slot) {
        return super.disconnect(slot);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void actuate(@NotNull final Slot slot, @NotNull final Object[] args) {
        if(slot instanceof Slot1) {
            ((Slot1<T>)slot).accept((T)args[0]);
        }
        else {
            super.actuate(slot, args);
        }
    }
}

/**
 * A signalslot with 1 generic argument.
 *
 * @param <T> The Type of the argument.
 */
public class Signal1<T> extends BaseSignal1<T> {

    public Signal1(@NotNull Object sender) {
        super(sender);
    }

    public Signal1(@NotNull WeakReference sender) {
        super(sender);
    }

    private final Slot1<T> slotEmit = this::emit;
    @Override
    protected Slot getSlotEmit() {
        return slotEmit;
    }

    /**
     * @see Signal#emit(Object...)
     */
    public void emit(@Nullable final T t) {
        super.emit(t);
    }

}
