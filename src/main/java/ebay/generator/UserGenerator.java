package ebay.generator;

import ebay.entities.User;
import ebay.helpers.DateHelper;

public class UserGenerator {

    public static final String currentTimeStamp = DateHelper.getCurrentDateTimeFormatted();

    public static final User randomGeneratedUser = new User(
            "autName" + currentTimeStamp,
            "autLastName" + currentTimeStamp,
            "autEmail" + currentTimeStamp + "@fls.com",
            "autPass" + currentTimeStamp
    );
}
