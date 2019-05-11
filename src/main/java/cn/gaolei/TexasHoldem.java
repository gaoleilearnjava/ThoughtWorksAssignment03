package cn.gaolei;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TexasHoldem {
    /**
     * 判断分数
     *
     * @param whiteCards
     * @param blackCards
     * @return
     */
    public static String judgeCards(List<String> whiteCards, List<String> blackCards) {
        Result whiteResult = getScore(whiteCards);
        Result blackResult = getScore(blackCards);
        if (whiteResult.getScore() > blackResult.getScore())
            return "White wins" + " - " + whiteResult.getState();
        if (whiteResult.getScore() == blackResult.getScore())
            return "Tie";
        return "Black wins" + " - " + blackResult.getState();
    }

    /**
     * 算分数的方法
     *
     * @param cards
     * @return
     */
    public static Result getScore(List<String> cards) {
        List<Card> newCards = convertStringToCard(cards);
        sortCards(newCards);
        Result result = new Result(0, "");
        if (isStraightFlush(newCards) != 0) {
            result.setScore(isStraightFlush(newCards));
            result.setState("Straight flush");
            return result;
        }
        if (isFourOfaKind(newCards) != 0) {
            result.setScore(isFourOfaKind(newCards));
            result.setState("Four of a kind");
            return result;
        }
        if (isFullHouse(newCards) != 0) {
            result.setScore(isFullHouse(newCards));
            result.setState("Full house");
            return result;
        }
        if (isFlush(newCards) != 0) {
            result.setScore(isFlush(newCards));
            result.setState("Flush");
            return result;
        }
        if (isStraight(newCards) != 0) {
            result.setScore(isStraight(newCards));
            result.setState("Straight");
            return result;
        }
        if (isThreeOfaKind(newCards) != 0) {
            result.setScore(isThreeOfaKind(newCards));
            result.setState("Three of a kind");
            return result;
        }
        if (isTwoPairs(newCards) != 0) {
            result.setScore(isTwoPairs(newCards));
            result.setState("Two pairs");
            return result;
        }
        if (isPair(newCards) != 0) {
            result.setScore(isPair(newCards));
            result.setState("Pair");
            return result;
        }
        result.setScore(isHighCard(newCards));
        result.setState("High card");
        return result;
    }

    /**
     * 将String的集合转换为扑克牌集合的方法
     *
     * @param cards
     * @return
     */
    public static List<Card> convertStringToCard(List<String> cards) {
        List<Card> newCards = new ArrayList<>();
        if (cards != null) {
            int length = cards.size();
            for (int i = 0; i < length; i++) {
                String cardString = cards.get(i);
                Card card = new Card();
                card.setType(cardString.charAt(1));
                char number = cardString.charAt(0);
                if (number >= '2' && number <= '9') {
                    card.setNum(number - '0');
                } else {
                    switch (number) {
                        case 'T':
                            card.setNum(10);
                            break;
                        case 'J':
                            card.setNum(11);
                            break;
                        case 'Q':
                            card.setNum(12);
                            break;
                        case 'K':
                            card.setNum(13);
                            break;
                        case 'A':
                            card.setNum(14);
                            break;
                        default:
                            break;
                    }
                }
                newCards.add(card);
            }
        }
        return newCards;
    }

    /**
     * 对扑克牌从大到小进行排序
     *
     * @param cards
     */
    public static void sortCards(List<Card> cards) {
        if (cards != null) {
            cards.sort(new Comparator<Card>() {
                public int compare(Card o1, Card o2) {
                    return -o1.getNum().compareTo(o2.getNum());
                }
            });
        }
    }

    /**
     * 是否是同花顺,不是返回0,是就返回分数(最大值*14的12次方)
     *
     * @param cards
     * @return
     */
    public static long isStraightFlush(List<Card> cards) {
        char type = cards.get(0).getType();
        int num = cards.get(0).getNum();
        int flag = 1;
        for (int i = 1; i < cards.size(); i++) {
            if (cards.get(i).getType() != type || cards.get(i).getNum() != num - 1) {
                flag = 0;
                break;
            }
            num = cards.get(i).getNum();
        }
        if (flag == 1)
            return cards.get(0).getNum() * (long) Math.pow(14, 12);
        return 0;
    }

    /**
     * 是否为铁支,不是返回0,是就返回分数(相同牌的点数*14的11次方)
     *
     * @param cards
     * @return
     */
    public static long isFourOfaKind(List<Card> cards) {
        if (cards.get(1).getNum() == cards.get(2).getNum() && cards.get(1).getNum() == cards.get(3).getNum()) {
            if (cards.get(0).getNum() == cards.get(1).getNum() || cards.get(4).getNum() == cards.get(1).getNum()) {
                return cards.get(1).getNum() * (long) Math.pow(14, 11);
            }
        }
        return 0;
    }

    /**
     * 是否为葫芦,不是返回0,是就返回分数(三张相同牌的点数*14的10次方)
     *
     * @param cards
     * @return
     */
    public static long isFullHouse(List<Card> cards) {
        if (cards.get(0).getNum() == cards.get(1).getNum()) {
            if (cards.get(1).getNum() == cards.get(2).getNum()) {
                if (cards.get(3).getNum() == cards.get(4).getNum()) {
                    return cards.get(0).getNum() * (long) Math.pow(14, 10);
                }
                return 0;
            }
            if (cards.get(2).getNum() == cards.get(3).getNum() && cards.get(3).getNum() == cards.get(4).getNum()) {
                return cards.get(4).getNum() * (long) Math.pow(14, 10);
            }
        }
        return 0;
    }

    /**
     * 是否为同花,不是返回0,是就返回分数(最大牌*14的9次方+第二*14的8次方+第三*14的7次方+第四*14的6次方+第五*14的5次方)
     *
     * @param cards
     * @return
     */
    public static long isFlush(List<Card> cards) {
        char type = cards.get(0).getType();
        int flag = 1;
        for (int i = 1; i < cards.size(); i++) {
            if (cards.get(i).getType() != type) {
                flag = 0;
                break;
            }
        }
        if (flag == 1)
            return cards.get(0).getNum() * (long) Math.pow(14, 9) +
                    cards.get(1).getNum() * (long) Math.pow(14, 8) +
                    cards.get(2).getNum() * (long) Math.pow(14, 7) +
                    cards.get(3).getNum() * (long) Math.pow(14, 6) +
                    cards.get(4).getNum() * (long) Math.pow(14, 5);
        return 0;
    }

    /**
     * 是否为顺子,不是就返回0,是就返回分数(最大牌*14的8次方)
     *
     * @param cards
     * @return
     */
    public static long isStraight(List<Card> cards) {
        int num = cards.get(0).getNum();
        int flag = 1;
        for (int i = 1; i < cards.size(); i++) {
            if (cards.get(i).getNum() != num - 1) {
                flag = 0;
                break;
            }
            num = cards.get(i).getNum();
        }
        if (flag == 0)
            return cards.get(0).getNum() * (long) Math.pow(14, 8);
        return 0;
    }

    /**
     * 是否为三条,不是就返回0,是就返回分数(三张相同的牌*14的7次方)
     *
     * @param cards
     * @return
     */
    public static long isThreeOfaKind(List<Card> cards) {
        if (cards.get(0).getNum() == cards.get(1).getNum() && cards.get(2).getNum() == cards.get(1).getNum()) {
            return cards.get(0).getNum() * (long) Math.pow(14, 7);
        }
        if (cards.get(1).getNum() == cards.get(2).getNum() && cards.get(2).getNum() == cards.get(3).getNum()) {
            return cards.get(1).getNum() * (long) Math.pow(14, 7);
        }
        if (cards.get(2).getNum() == cards.get(3).getNum() && cards.get(2).getNum() == cards.get(4).getNum()) {
            return cards.get(2).getNum() * (long) Math.pow(14, 7);
        }
        return 0;
    }

    /**
     * 是否为两对,不是返回0,是就返回分数(大对*14的6次方+小对*14的5次方)
     *
     * @param cards
     * @return
     */
    public static long isTwoPairs(List<Card> cards) {
        if (cards.get(0).getNum() == cards.get(1).getNum() && cards.get(3).getNum() == cards.get(4).getNum()) {
            return cards.get(0).getNum() * (long) Math.pow(14, 6) + cards.get(3).getNum() * (long) Math.pow(14, 5);
        }
        if (cards.get(1).getNum() == cards.get(2).getNum() && cards.get(3).getNum() == cards.get(4).getNum()) {
            return cards.get(1).getNum() * (long) Math.pow(14, 6) + cards.get(3).getNum() * (long) Math.pow(14, 5);
        }
        if (cards.get(0).getNum() == cards.get(1).getNum() && cards.get(3).getNum() == cards.get(2).getNum()) {
            return cards.get(0).getNum() * (long) Math.pow(14, 6) + cards.get(2).getNum() * (long) Math.pow(14, 5);
        }
        return 0;
    }

    /**
     * 是否为对子,不是就返回0,是就返回分数(对子*14的5次方)
     *
     * @param cards
     * @return
     */
    public static long isPair(List<Card> cards) {
        for (int i = 0; i < cards.size() - 1; i++) {
            int number = cards.get(i).getNum();
            for (int j = i + 1; j < cards.size(); j++) {
                if (cards.get(j).getNum() == number) {
                    return number * (long) Math.pow(12, 5);
                }
            }
        }
        return 0;
    }

    /**
     * 若为散牌,则返回分数,(最大牌*14的4次方+第二*14的3次方+第三*14的2次方+第四*14的1次方+第五*14的0次方)
     *
     * @param cards
     * @return
     */
    public static long isHighCard(List<Card> cards) {
        return cards.get(0).getNum() * (long) Math.pow(14, 4) +
                cards.get(1).getNum() * (long) Math.pow(14, 3) +
                cards.get(2).getNum() * (long) Math.pow(14, 2) +
                cards.get(3).getNum() * (long) Math.pow(14, 1) +
                cards.get(4).getNum() * (long) Math.pow(14, 0);
    }
}
