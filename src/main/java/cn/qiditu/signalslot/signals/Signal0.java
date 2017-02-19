package cn.qiditu.signalslot.signals;

import cn.qiditu.signalslot.Signal;
import cn.qiditu.signalslot.slots.Slot0;
import cn.qiditu.signalslot.Slot;
import org.jetbrains.annotations.NotNull;

import java.lang.ref.WeakReference;

abstract class BaseSignal0 extends Signal {

    BaseSignal0(@NotNull Object sender) {
        super(sender);
    }

    BaseSignal0(@NotNull WeakReference<Object> sender) {
        super(sender);
    }

    /**
     * @see Signal#connect(Slot)
     */
    public Slot0 connect(@NotNull final Slot0 slot) {
        super.connect(slot);
        return slot;
    }

    /**
     * @see Signal#connect(Slot, int)
     */
    public Slot0 connect(@NotNull final Slot0 slot, final int count) {
        super.connect(slot, count);
        return slot;
    }

    /**
     * @see Signal#connect(Signal)
     */
    public Slot0 connect(@NotNull final Signal0 signal) {
        return (Slot0)super.connect(signal);
    }

    /**
     * @see Signal#connect(Signal, int)
     */
    public Slot0 connect(@NotNull final Signal0 signal, int count) {
        return (Slot0)super.connect(signal, count);
    }

    /**
     * @see Signal#disconnect(Signal)
     */
    public boolean disconnect(@NotNull final Signal0 signal) {
        return super.disconnect(signal);
    }

    /**
     * @see Signal#disconnect(Slot)
     */
    public boolean disconnect(@NotNull final Slot0 slot) {
        return super.disconnect(slot);
    }

    @Override
    protected void actuate(@NotNull final Slot slot, @NotNull final Object[] args) {
        if(slot instanceof Slot0) {
            ((Slot0) slot).accept();
        }
        else {
            //TODO write exception
            throw new RuntimeException("arguments number too much");
        }
//        ((Slot0)slot).accept();
    }

}

/**
 * A signalslot with 0 arguments.
 */
public class Signal0 extends BaseSignal0 {

    @SuppressWarnings("unused")
    public Signal0(@NotNull Object sender) {
        super(sender);
    }

    @SuppressWarnings("unused")
    public Signal0(@NotNull WeakReference<Object> sender) {
        super(sender);
    }

    private final Slot0 slotEmit = this::emit;
    @Override
    protected Slot getSlotEmit() {
        return slotEmit;
    }

    /**
     * @see Signal#emit(Object...)
     */
    public void emit() {
        super.emit();
    }

}
