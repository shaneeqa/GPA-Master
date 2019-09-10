package com.gpa.web.constants;

public class URLConstants {

    public static final String REDIRECT = "redirect:";

    public class URLs {

        public static final String INDEX = "/";

        public static final String GPA = "/gpa";

        public static final String TEST = "/test";

        public static final String SAVE = "/save";

        public static final String SAVE_ADMIN = "/list";

        public static final String ADMIN = "/admin";

        private URLs() {
        }

    }

    public class Views {

        public static final String INDEX = "index";

        public static final String GPA = "gpa";

        public static final String SAVE_ADMIN = "list";

        public static final String ADMIN = "admin";

        private Views() {
        }

    }

    public class Redirects {

        public static final String INDEX = REDIRECT + URLs.INDEX;

        public static final String GPA = REDIRECT + URLs.GPA;

        public static final String ADMIN = REDIRECT + URLs.ADMIN;

        public static final String SAVE_ADMIN = REDIRECT + URLs.SAVE_ADMIN;

        private Redirects() {
        }

    }

}
