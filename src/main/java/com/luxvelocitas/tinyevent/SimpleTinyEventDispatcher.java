package com.luxvelocitas.tinyevent;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 *
 * @param <T>
 * @param <D>
 */
public class SimpleTinyEventDispatcher<T extends Enum, D> implements ITinyEventDispatcher<T, D> {
    protected Map<T, Set<ITinyEventListener<T, D>>> mListeners;

    public SimpleTinyEventDispatcher() {
        mListeners = new HashMap<T, Set<ITinyEventListener<T, D>>>();
    }

    @Override
    public void addListener(T eventType, ITinyEventListener<T, D> listener) {
        if (!mListeners.containsKey(eventType)) {
            mListeners.put(eventType,
                    new CopyOnWriteArraySet<ITinyEventListener<T, D>>());
        }
        mListeners.get(eventType).add(listener);
    }

    @Override
    public void removeListener(T eventType, ITinyEventListener<T, D> listener) {
        if (mListeners.containsKey(eventType)) {
            mListeners.get(eventType).remove(listener);
        }
    }

    @Override
    public void notify(TinyEvent<T, D> event) {
        if (mListeners.containsKey(event.getEventType())) {
            Set<ITinyEventListener<T, D>> listeners =
                    mListeners.get(event.getEventType());

            for (ITinyEventListener<T, D> listener : listeners) {
                listener.receive(event);
            }
        }
    }

    @Override
    public void notify(T eventType, D eventData) {
        TinyEvent<T, D> event = new TinyEvent<T, D>(eventType, eventData);
        notify(event);
    }

    @Override
    public void notify(T eventType) {
        TinyEvent<T, D> event = new TinyEvent<T, D>(eventType, null);
        notify(event);
    }
}
