package io.github.jristretto.statewalkertest;

import static org.assertj.core.api.Assertions.assertThatCode;
import org.junit.jupiter.api.Test;

/**
 * For coverage. Some methods are never called in the transition tests.
 *
 * @author Pieter van den Hombergh {@code <pieter.van.den.hombergh@gmail.com>}
 */
public class StateTest {

    public StateTest() {
    }

    @Test
    public void testDefaultMethods() {
        State x = StateEnum.A;
        Context ctx = new Context( StateEnum.class ).initialize();
        assertThatCode( () -> {
            ctx.enterState( x );
            x.e1( ctx );
            x.e2( ctx );
            x.e3( ctx );
            x.e4( ctx );
            x.e5( ctx );
            x.e6( ctx );
            x.e7( ctx );
            x.e8( ctx );
            x.e9( ctx );
            x.e10( ctx );
            x.e11( ctx );
            x.e12( ctx );
            x.e13( ctx );
            x.enter( ctx );
            x.exit( ctx );
        } ).doesNotThrowAnyException();
    }

}
