package qvident.helpers;

import qvident.builders.JSWaiter;

public class WaitingHelper {

    public static void waitAllRequestsOnPage() {
        JSWaiter waiter = new JSWaiter();
        waiter.waitAllRequest();
    }
}
