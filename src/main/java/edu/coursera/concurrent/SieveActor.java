package edu.coursera.concurrent;

import edu.rice.pcdp.Actor;

/**
 * An actor-based implementation of the Sieve of Eratosthenes.
 *
 * TODO Fill in the empty SieveActorActor actor class below and use it from
 * countPrimes to determin the number of primes <= limit.
 */
public final class SieveActor extends Sieve {

    private int numberOfPrimes = 0;

    /**
     * {@inheritDoc}
     *
     * TODO Use the SieveActorActor class to calculate the number of primes <=
     * limit in parallel. You might consider how you can model the Sieve of
     * Eratosthenes as a pipeline of actors, each corresponding to a single
     * prime number.
     */
    @Override
    public int countPrimes(final int limit) {
        SieveActorActor sieveActorActor = new SieveActorActor();
        for(int i=2; i<limit; i++) {
            sieveActorActor.process(i);
        }
        return numberOfPrimes;
    }

    /**
     * An actor class that helps implement the Sieve of Eratosthenes in
     * parallel.
     */
    public static final class SieveActorActor extends Actor {

        private Integer myPrime;

        /**
         * Process a single message sent to this actor.
         *
         * TODO complete this method.
         *
         * @param msg Received message
         */
        @Override
        public void process(final Object msg) {
            System.out.print("Prime " + msg);
            if(myPrime == null)
                myPrime = (Integer)msg;
            if((Integer)msg % myPrime != 0)
        }
    }
}
