package com.example.my_health;

public class LoginResponse {
    private String message;
    private User user;

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }

    public static class User {
        private String id;
        private String email;
        private String role;
        private String name;

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
