package cn.qiditu.signalslot.signals;

import cn.qiditu.signalslot.Slot;
import cn.qiditu.signalslot.Signal;
import cn.qiditu.signalslot.slots.Slot7;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.lang.ref.WeakReference;

abstract class BaseSignal7<T, U, V, W, X, Y, Z> extends BaseSignal6<T, U, V, W, X, Y> {

    public BaseSignal7(@NotNull Object sender) {
        super(sender);
    }

    public BaseSignal7(@NotNull WeakReference sender) {
        super(sender);
    }

    /**
     * @see Signal#connect(Signal)
     */
    public Slot7<T, U, V, W, X, Y, Z>
    connect(@NotNull final Signal7<T, U, V, W, X, Y, Z> signal) {
        return (Slot7<T, U, V, W, X, Y, Z>)super.connect(signal);
    }

    /**
     * @see Signal#connect(Signal, int)
     */
    public Slot7<T, U, V, W, X, Y, Z>
    connect(@NotNull final Signal7<T, U, V, W, X, Y, Z> signal, int count) {
        return (Slot7<T, U, V, W, X, Y, Z>)super.connect(signal, count);
    }

    /**
     * @see Signal#connect(Slot)
     */
    public Slot7<T, U, V, W, X, Y, Z>
    connect(@NotNull final Slot7<T, U, V, W, X, Y, Z> slot) {
        super.connect(slot);
        return slot;
    }

    /**
     * @see Signal#connect(Slot, int)
     */
    public Slot7<T, U, V, W, X, Y, Z>
    connect(@NotNull final Slot7<T, U, V, W, X, Y, Z> slot, final int count) {
        super.connect(slot, count);
        return slot;
    }

    /**
     * @see Signal#disconnect(Signal)
     */
    public boolean disconnect(@NotNull final Signal7<T, U, V, W, X, Y, Z> signal) {
        return super.disconnect(signal);
    }

    /**
     * @see Signal#disconnect(Slot)
     */
    public boolean disconnect(@NotNull final Slot7<T, U, V, W, X, Y, Z> slot) {
        return super.disconnect(slot);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void actuate(@NotNull final Slot slot, @NotNull final Object[] args) {
        if(slot instanceof Slot7) {
            ((Slot7<T, U, V, W, X, Y, Z>)slot).accept(
                                                (T)args[0], (U)args[1], (V)args[2],
                                                (W)args[3], (X)args[4], (Y)args[5],
                                                (Z)args[6]);
        }
        else {
            super.actuate(slot, args);
        }
//        ((Slot4<T, U, V, W>)slot).accept((T)args[0], (U)args[1], (V)args[2], (W)args[3]);
    }
}

/**
 * A signalslot with 7 generic arguments.
 *
 * @param <T> The type of the first argument.
 * @param <U> The type of the second argument.
 * @param <V> The type of the third argument.
 * @param <W> The type of the forth argument.
 * @param <X> The type of the fifth argument.
 * @param <Y> The type of the sixth argument.
 * @param <Z> The type of the seventh argument.
 */
public class Signal7<T, U, V, W, X, Y, Z> extends BaseSignal7<T, U, V, W, X, Y, Z> {

    public Signal7(@NotNull Object sender) {
        super(sender);
    }

    public Signal7(@NotNull WeakReference sender) {
        super(sender);
    }

    private final Slot7<T, U, V, W, X, Y, Z> slotEmit = this::emit;
    @Override
    protected Slot getSlotEmit() {
        return slotEmit;
    }

    /**
     * @see Signal#emit(Object...)
     */
    public void emit(@Nullable final T t, @Nullable final U u, @Nullable final V v,
                     @Nullable final W w, @Nullable final X x, @Nullable final Y y,
                     @Nullable final Z z) {
        super.emit(t, u, v, w, x, y, z);
    }

}
