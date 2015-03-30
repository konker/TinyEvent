package com.luxvelocitas.tinyevent;

/**
 *
 * @param <T> Event type enum
 * @param <D> Event data object
 */
public class TinyEvent<T extends Enum, D> {
    protected final T mEventType;
    protected final D mEventData;

    public TinyEvent(T eventType, D eventData, Object source) {
        mEventType = eventType;
        mEventData = eventData;
    }

    public TinyEvent(T eventType, D eventData) {
        mEventType = eventType;
        mEventData = eventData;
    }

    public TinyEvent(T eventType) {
        mEventType = eventType;
        mEventData = null;
    }

    public T getEventType() {
        return mEventType;
    }

    public D getEventData() {
        return mEventData;
    }
}
