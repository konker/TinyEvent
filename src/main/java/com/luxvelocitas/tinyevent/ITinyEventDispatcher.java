package com.luxvelocitas.tinyevent;

/**
 *
 * @param <T> Event type enum
 * @param <D> Event data object
 */
public interface ITinyEventDispatcher<T extends Enum, D> {
    public void addListener(T eventType, ITinyEventListener<T, D> listener);
    public void addStarListener(ITinyEventListener<T, D> listener);
    public void removeListener(T eventType, ITinyEventListener<T, D> listener);
    public void removeStarListener(ITinyEventListener<T, D> listener);
    public void notify(TinyEvent<T, D> event);
    public void notify(T eventType, D eventData);
    public void notify(T eventType);
}
