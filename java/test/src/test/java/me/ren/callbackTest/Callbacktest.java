package me.ren.callbackTest;

import me.ren.callback.Callbackimpl;
import me.ren.callback.Callerimpl;
import org.junit.Test;

public class Callbacktest {

    @Test
    public void funtest() {

        Callerimpl caller = new Callerimpl();

        caller.call("test", new Callbackimpl());
    }
}
