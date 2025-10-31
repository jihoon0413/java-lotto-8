package domain;

public class Splitter {

    private final Validator validator = new Validator();

    public String[] split(String str) {
        return str.split(",");
    }

}
