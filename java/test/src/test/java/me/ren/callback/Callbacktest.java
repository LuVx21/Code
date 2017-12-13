package me.ren.callback;

import org.junit.Test;

public class Callbacktest {

    @Test
    public void funtest() {

        Callerimpl caller = new Callerimpl();

        caller.call("test", new Callbackimpl());
    }
}
