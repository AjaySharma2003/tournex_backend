package com.tournex.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "database.sql")
@Data
public class SqlQueriesConfig {

    private User user;
    private Tournament tournament;

    @Data
    public static class User {
        private Select select;
        private Insert insert;
        private Update update;
        private Delete delete;

        @Data
        public static class Select {
            private String byEmail;
            private String byId;
            private String all;
        }

        @Data
        public static class Insert {
            private String newUser;
        }

        @Data
        public static class Update {
            private String userDetails;
        }

        @Data
        public static class Delete {
            private String byId;
        }
    }

    @Data
    public static class Tournament {
        private Select select;
        private Insert insert;
        private Update update;
        private Delete delete;

        @Data
        public static class Select {
            private String byId;
            private String all;
        }

        @Data
        public static class Insert {
            private String newTournament;
        }

        @Data
        public static class Update {
            private String tournamentDetails;
        }

        @Data
        public static class Delete {
            private String byId;
        }
    }
}
