package io.github.jristretto.statewalkertest;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;


/**
 * For coverage.
 * @author Pieter van den Hombergh {@code <pieter.van.den.hombergh@gmail.com>}
 */
public class ContextTest {
    
    public ContextTest() {
    }

    @Test
    public void testGetDevice() {
        Context ctx= new Context(S.class);
        assertThat(ctx.getDevice()).as("has device").isNotNull();
    }
    
}
