package cn.qiditu.signalslot.signals;

import cn.qiditu.signalslot.Slot;
import cn.qiditu.signalslot.Signal;
import cn.qiditu.signalslot.slots.Slot9;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.ref.WeakReference;

abstract class BaseSignal9<T, U, V, W, X, Y, Z, S, R>
                extends BaseSignal8<T, U, V, W, X, Y, Z, S> {

    @SuppressWarnings("WeakerAccess")
    public BaseSignal9(@NotNull Object sender) {
        super(sender);
    }

    @SuppressWarnings("WeakerAccess")
    public BaseSignal9(@NotNull WeakReference<Object> sender) {
        super(sender);
    }

    /**
     * @see Signal#connect(Signal)
     */
    @SuppressWarnings("unchecked")
    public Slot9<T, U, V, W, X, Y, Z, S, R>
    connect(@NotNull final Signal9<T, U, V, W, X, Y, Z, S, R> signal) {
        return (Slot9<T, U, V, W, X, Y, Z, S, R>)super.connect(signal);
    }

    /**
     * @see Signal#connect(Signal, int)
     */
    @SuppressWarnings("unchecked")
    public Slot9<T, U, V, W, X, Y, Z, S, R>
    connect(@NotNull final Signal9<T, U, V, W, X, Y, Z, S, R> signal, int count) {
        return (Slot9<T, U, V, W, X, Y, Z, S, R>)super.connect(signal, count);
    }

    /**
     * @see Signal#connect(Slot)
     */
    public Slot9<T, U, V, W, X, Y, Z, S, R>
    connect(@NotNull final Slot9<T, U, V, W, X, Y, Z, S, R> slot) {
        super.connect(slot);
        return slot;
    }

    /**
     * @see Signal#connect(Slot, int)
     */
    public Slot9<T, U, V, W, X, Y, Z, S, R>
    connect(@NotNull final Slot9<T, U, V, W, X, Y, Z, S, R> slot, final int count) {
        super.connect(slot, count);
        return slot;
    }

    /**
     * @see Signal#disconnect(Signal)
     */
    public boolean disconnect(@NotNull final Signal9<T, U, V, W, X, Y, Z, S, R> signal) {
        return super.disconnect(signal);
    }

    /**
     * @see Signal#disconnect(Slot)
     */
    public boolean disconnect(@NotNull final Slot9<T, U, V, W, X, Y, Z, S, R> slot) {
        return super.disconnect(slot);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void actuate(@NotNull final Slot slot, @NotNull final Object[] args) {
        if(slot instanceof Slot9) {
            ((Slot9<T, U, V, W, X, Y, Z, S, R>)slot).accept(
                                        (T)args[0], (U)args[1], (V)args[2],
                                        (W)args[3], (X)args[4], (Y)args[5],
                                        (Z)args[6], (S)args[7], (R)args[8]);
        }
        else {
            super.actuate(slot, args);
        }
//        ((Slot4<T, U, V, W>)slot).accept((T)args[0], (U)args[1], (V)args[2], (W)args[3]);
    }
}

/**
 * A signalslot with 9 generic arguments.
 *
 * @param <T> The type of the first argument.
 * @param <U> The type of the second argument.
 * @param <V> The type of the third argument.
 * @param <W> The type of the forth argument.
 * @param <X> The type of the fifth argument.
 * @param <Y> The type of the sixth argument.
 * @param <Z> The type of the seventh argument.
 * @param <S> The type of the eighth argument.
 * @param <R> The type of the ninth argument.
 */
public class Signal9<T, U, V, W, X, Y, Z, S, R>
                extends BaseSignal9<T, U, V, W, X, Y, Z, S, R> {

    @SuppressWarnings("unused")
    public Signal9(@NotNull Object sender) {
        super(sender);
    }

    @SuppressWarnings("unused")
    public Signal9(@NotNull WeakReference<Object> sender) {
        super(sender);
    }

    private final Slot9<T, U, V, W, X, Y, Z, S, R> slotEmit = this::emit;
    @Override
    protected Slot getSlotEmit() {
        return slotEmit;
    }

    /**
     * @see Signal#emit(Object...)
     */
    public void emit(@Nullable final T t, @Nullable final U u, @Nullable final V v,
                     @Nullable final W w, @Nullable final X x, @Nullable final Y y,
                     @Nullable final Z z, @Nullable final S s, @Nullable final R r) {
        super.emit(t, u, v, w, x, y, z, s, r);
    }

}
