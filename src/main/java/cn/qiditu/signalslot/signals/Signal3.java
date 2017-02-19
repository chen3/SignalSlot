package cn.qiditu.signalslot.signals;

import cn.qiditu.signalslot.Signal;
import cn.qiditu.signalslot.Slot;
import cn.qiditu.signalslot.slots.Slot3;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.lang.ref.WeakReference;

abstract class BaseSignal3<T, U, V> extends BaseSignal2<T, U> {

    public BaseSignal3(@NotNull Object sender) {
        super(sender);
    }

    public BaseSignal3(@NotNull WeakReference sender) {
        super(sender);
    }

    /**
     * @see Signal#connect(Signal)
     */
    public Slot3<T, U, V> connect(@NotNull final Signal3<T, U, V> signal) {
        return (Slot3<T, U, V>)super.connect(signal);
    }

    /**
     * @see Signal#connect(Signal, int)
     */
    public Slot3<T, U, V> connect(@NotNull final Signal3<T, U, V> signal, int count) {
        return (Slot3<T, U, V>)super.connect(signal, count);
    }

    /**
     * @see Signal#connect(Slot)
     */
    public Slot3<T, U, V> connect(@NotNull final Slot3<T, U, V> slot) {
        super.connect(slot);
        return slot;
    }

    /**
     * @see Signal#connect(Slot, int)
     */
    public Slot3<T, U, V> connect(@NotNull final Slot3<T, U, V> slot, final int count) {
        super.connect(slot, count);
        return slot;
    }

    /**
     * @see Signal#disconnect(Signal)
     */
    public boolean disconnect(@NotNull final Signal3<T, U, V> signal) {
        return super.disconnect(signal);
    }

    /**
     * @see Signal#disconnect(Slot)
     */
    public boolean disconnect(@NotNull final Slot3<T, U, V> slot) {
        return super.disconnect(slot);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void actuate(@NotNull final Slot slot, @NotNull final Object[] args) {
        if(slot instanceof Slot3) {
            ((Slot3<T, U, V>)slot).accept((T)args[0], (U)args[1], (V)args[2]);
        }
        else {
            super.actuate(slot, args);
        }
//        ((Slot3<T, U, V>)slot).accept((T)args[0], (U)args[1], (V)args[2]);
    }
}

/**
 * A signalslot with 3 generic arguments.
 *
 * @param <T> The type of the first argument.
 * @param <U> The type of the second argument.
 * @param <V> The type of the third argument.
 */
public class Signal3<T, U, V> extends BaseSignal3<T, U, V> {

    public Signal3(@NotNull Object sender) {
        super(sender);
    }

    public Signal3(@NotNull WeakReference sender) {
        super(sender);
    }

    private final Slot3<T, U, V> slotEmit = this::emit;
    @Override
    protected Slot getSlotEmit() {
        return slotEmit;
    }

    /**
     * @see Signal#emit(Object...)
     */
    public void emit(@Nullable final T t, @Nullable final U u, @Nullable final V v) {
        super.emit(t, u, v);
    }

}
