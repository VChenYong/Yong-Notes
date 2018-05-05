package core.java8.example;

/**
 * Created by yong on 3/13/18.
 */
import java.util.function.Consumer;

class Mailer {
    private Mailer() {
    };

    public static void send(Consumer<Mailer> func) {

        Mailer m = new Mailer();
        func.accept(m);
    }

    public Mailer from(String from) {
        System.out.println("Mailer.from" + from);
        return this;
    };

    public Mailer to(String to) {
        System.out.println("Mailer.to" + to);
        return this;
    };

    public Mailer body(String body) {
        System.out.println("Mailer.body: " + body);
        return this;
    }
}

public class MailerExample {

    public static void main(String[] args) {


        Mailer.send(mailer -> {
            mailer.from(" me").to("you").body("test");
        });

    }
}
