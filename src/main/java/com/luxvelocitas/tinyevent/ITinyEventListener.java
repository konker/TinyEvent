package com.luxvelocitas.tinyevent;


public interface ITinyEventListener<T extends Enum, D> {
    public void receive(TinyEvent<T, D> event);
}
