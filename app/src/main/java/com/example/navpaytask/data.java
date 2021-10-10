package com.example.navpaytask;

public class data {
        private String name;
        private String fromUser;
        private String date;
        private String amount;

        public data(String name, String fromUser, String date, String amount) {
            this.name = name;
            this.fromUser = fromUser;
            this.date = date;
            this.amount = amount;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFromUser() {
            return fromUser;
        }


        public String getDate() {
            return date;
        }


        public String getAmount() {
            return amount;
        }



}

