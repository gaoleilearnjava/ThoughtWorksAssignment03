package cn.gaolei;

public class Card {
    private Integer num;
    private Character type;

    public Card() {
        super();
    }

    public Card(Integer num, Character type) {
        this.num = num;
        this.type = type;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Character getType() {
        return type;
    }

    public void setType(Character type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Card{" +
                "num=" + num +
                ", type=" + type +
                '}';
    }
}
