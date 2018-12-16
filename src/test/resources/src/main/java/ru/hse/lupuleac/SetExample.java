package ru.hse.lupuleac;

import java.util.*;
import java.util.function.Consumer;

public class SetExample {
    public static class MaxMap<K,V> extends HashMap<K,List<V>> {
        public MaxMap(){
        }

        @Override
        public List<V> get(Object key) {
            if (this.containsKey(key))
                return super.get(key);
            else
                return Collections.<V>emptyList();
        }
    }

    public static interface Mail <T>{
        public String getFrom();
        public String getTo();
        public T getContent();
    }

    public static class MailMessage implements Mail<String> {
        protected final String message;
        protected final String from;
        protected final String to;

        public MailMessage(String from, String to, String message) {
            this.from = from;
            this.to = to;
            this.message = message;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        public String getContent() {
            return message;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            Mail<String> that = (Mail<String>) o;

            if (message != null ? !message.equals(that.getContent()) : that.getContent() != null) return false;

            return true;
        }
    }

    public static class Salary implements Mail<Integer> {
        protected final Integer message;
        protected final String from;
        protected final String to;

        public Salary(String from, String to, Integer message) {
            this.from = from;
            this.to = to;
            this.message = message;
        }


        public String getFrom() {
            return from;
        }


        public String getTo() {
            return to;
        }

        public Integer getContent() {
            return message;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            Mail<Integer> that = (Mail<Integer>) o;

            if (message != null ? !message.equals(that.getContent()) : that.getContent() != null) return false;

            return true;
        }
    }

    public static class MailService <T> implements Consumer<Mail<T>> {

        Map<String, List<T>> messages;

        MailService(){
            this.messages = new MaxMap<String, T>();
        }


        @Override
        public void accept(Mail<T> t) {
            if (messages.containsKey(t.getTo()))
                messages.get(t.getTo()).add(t.getContent());
            else{
                messages.put(t.getTo(), new ArrayList<T>());
                messages.get(t.getTo()).add(t.getContent());
            }
        }

        Map<String, List<T>> getMailBox(){
            return messages;
        }
    }

}