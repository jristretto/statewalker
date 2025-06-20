package io.github.jristretto.statewalkerpile;

import io.github.jristretto.statewalker.ContextBase;

/**
 *
 * @author Pieter van den Hombergh {@code <pieter.van.den.hombergh@gmail.com>}
 */
public class Context extends ContextBase<Context, Dev, State> {

    public Context( Class<?> stateClass ) {
        super( stateClass );
    }

    void e1() {
        getTopState().e1( this );
    }

    void e2() {
        getTopState().e2( this );
    }

    void e3() {
        getTopState().e3( this );
    }

    void e4() {
        getTopState().e4( this );
    }

    void e5() {
        getTopState().e5( this );
    }

    void e6() {
        getTopState().e6( this );
    }

    void e7() {
        getTopState().e7( this );
    }

    void e8() {
        getTopState().e8( this );
    }

    void e9() {
        getTopState().e9( this );
    }

    void e10() {
        getTopState().e10( this );
    }

    void e11() {
        getTopState().e11( this );
    }

    void e12() {
        getTopState().e12( this );
    }

    void e13() {
        getTopState().e13( this );
    }

    static Dev dev = new Dev();

    @Override
    public Dev getDevice() {
        return dev;
    }

}
