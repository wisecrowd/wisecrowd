package ghortpanda.config

import io.schinzel.basicutils.RandomUtil
import io.schinzel.basicutils.configvar.ConfigVar

/**
 * Purpose of this file is to hold different databases as enums
 * Written by Rebecca Fransson on 2018-03-14
 */
enum class Database constructor(val hostUrl: String) {
    /**
     * The runtime database.
     */
    RUNTIME(ConfigVar.create(".env").getValue("MONGOHQ_URL")),
    /**
     * The database used for tests.
     * Randomize database name with 9 characters so it can never be same as runtime name wisecrowd (10 chars)
     */
    TEST("mongodb://localhost:27017/${RandomUtil.getRandomString(9)}");
}
