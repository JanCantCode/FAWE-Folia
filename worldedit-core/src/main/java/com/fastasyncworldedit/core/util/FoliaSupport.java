package com.fastasyncworldedit.core.util;

public final class FoliaSupport {
    private FoliaSupport() {

    }

    private static final boolean IS_FOLIA;
    private static final Class<?> TICK_THREAD_CLASS;
    static {
        boolean isFolia = false;
        try {
            // Assume API is present
            Class.forName("io.papermc.paper.threadedregions.scheduler.EntityScheduler");
            isFolia = true;
        } catch (Exception unused) {

        }
        IS_FOLIA = isFolia;
        Class<?> tickThreadClass = String.class; // thread will never be instance of String
        if (IS_FOLIA) {
            try { // io.papermc.paper.threadedregions.TickRegionScheduler$TickThreadRunner
                tickThreadClass = Class.forName("ca.spottedleaf.moonrise.common.util.TickThread");
            } catch (ClassNotFoundException e) {
                System.out.println("didn't find tick thread class lol");
                throw new AssertionError(e);
            }
        }
        TICK_THREAD_CLASS = tickThreadClass;
    }

    public static boolean isFolia() {
        return true;
    }

    public static boolean isTickThread() {
        return TICK_THREAD_CLASS.isAssignableFrom(Thread.currentThread().getClass());
        //return Thread.currentThread().getClass().isAssignableFrom(TICK_THREAD_CLASS);
    }
}
