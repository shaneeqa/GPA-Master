package com.gpa.web.constants;

public class URLConstants {

    public static final String REDIRECT = "redirect:";

    public class URLs {

        public static final String INDEX = "/";

        public static final String PREDICTED = "/gpa";

        public static final String TEST = "/test";

        public static final String CHECK_CASE = "/checkcase";

        public static final String SAVE_CASE = "/list";

        public static final String ADMIN = "/admin";

        public static final String LOG_IN = "/login";

        public static final String STUDENT = "/student";

        public static final String NEW_CASE = "/newcase";

        private URLs() {
        }

    }

    public class Views {

        public static final String INDEX = "index";

        public static final String PREDICTED = "gpa";

        public static final String SAVED_CASES = "list";

        public static final String ADMIN = "admin";

        public static final String LOG_IN = "login";

        public static final String STUDENT = "student";

        public static final String NEW_CASE = "newcase";

        private Views() {
        }

    }

    public class Redirects {

        public static final String INDEX = REDIRECT + URLs.INDEX;

        public static final String PREDICTED = REDIRECT + URLs.PREDICTED;

        public static final String ADMIN = REDIRECT + URLs.ADMIN;

        public static final String LOG_IN = REDIRECT + URLs.LOG_IN;

        public static final String STUDENT = REDIRECT + URLs.STUDENT;

        public static final String SAVE_CASE = REDIRECT + URLs.SAVE_CASE;

        public static final String NEW_CASE = REDIRECT + URLs.NEW_CASE;

        private Redirects() {
        }

    }

}
