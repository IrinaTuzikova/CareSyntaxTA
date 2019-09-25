package ebay.helpers;

import ebay.builders.JSOnPageWaiter;

public class WaitingHelper {

    public static void waitAllRequestsOnPage() {
        JSOnPageWaiter waiter = new JSOnPageWaiter();
        waiter.waitAllRequest();
    }
}
