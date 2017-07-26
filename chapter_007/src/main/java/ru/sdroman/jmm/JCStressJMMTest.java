package ru.sdroman.jmm;

import org.openjdk.jcstress.annotations.Actor;
import org.openjdk.jcstress.annotations.JCStressTest;
import org.openjdk.jcstress.annotations.Outcome;
import org.openjdk.jcstress.annotations.State;
import org.openjdk.jcstress.infra.results.II_Result;

import static org.openjdk.jcstress.annotations.Expect.ACCEPTABLE;
import static org.openjdk.jcstress.annotations.Expect.ACCEPTABLE_INTERESTING;

/**
 * @author sdroman
 * @since 07.2017
 */
public class JCStressJMMTest {

    /**
     * SameRead.
     */
    @JCStressTest
    @Outcome(id = "0, 0", expect = ACCEPTABLE, desc = "Doing both reads early.")
    @Outcome(id = "1, 1", expect = ACCEPTABLE, desc = "Doing both reads late.")
    @Outcome(id = "0, 1", expect = ACCEPTABLE, desc = "Doing first read early.")
    @Outcome(id = "1, 0", expect = ACCEPTABLE_INTERESTING, desc = "First read seen racy value early, and the second one did not.")
    @State
    public static class SameRead {

        /**
         * Holder1.
         */
        private final Holder h1 = new Holder();

        /**
         * Holder2.
         */
        private final Holder h2 = h1;

        /**
         * Class Holder.
         */
        private static class Holder {
            /**
             * a.
             */
            int a;

            /**
             * trap.
             */
            int trap;
        }

        /**
         * Actor1.
         */
        @Actor
        public void actor1() {
            h1.a = 1;
        }

        /**
         * Actor2.
         * @param r II_Result
         */
        @Actor
        public void actor2(II_Result r) {
            Holder h1 = this.h1;
            Holder h2 = this.h2;

            h1.trap = 0;
            h2.trap = 0;

            r.r1 = h1.a;
            r.r2 = h2.a;
        }
    }
}
