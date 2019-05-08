package cn.gaolei;

import java.util.List;

public class TexasHoldem {
    public static String judgeCards(List<String> whiteCards, List<String> blackCards) {

        return "Hello";
    }

    /**
     * 对扑克牌从大到小进行排序
     *
     * @param cards
     */
    public static void sortCards(List<String> cards) {

    }

    /**
     * 是否是同花顺,不是返回0,是就返回分数(最大值*14的12次方)
     *
     * @param cards
     * @return
     */
    public static long isStraightFlush(List<String> cards) {
        return 0;
    }

    /**
     * 是否为铁支,不是返回0,是就返回分数(相同牌的点数*14的11次方)
     *
     * @param cards
     * @return
     */
    public static long isFourOfaKind(List<String> cards) {
        return 0;
    }

    /**
     * 是否为葫芦,不是返回0,是就返回分数(三张相同牌的点数*14的10次方)
     *
     * @param cards
     * @return
     */
    public static long isFullHouse(List<String> cards) {
        return 0;
    }

    /**
     * 是否为同花,不是返回0,是就返回分数(最大牌*14的9次方+第二*14的8次方+第三*14的7次方+第四*14的6次方+第五*14的5次方)
     *
     * @param cards
     * @return
     */
    public static long isFlush(List<String> cards) {
        return 0;
    }

    /**
     * 是否为顺子,不是就返回0,是就返回分数(最大牌*14的8次方)
     *
     * @param cards
     * @return
     */
    public static long isStraight(List<String> cards) {
        return 0;
    }

    /**
     * 是否为三条,不是就返回0,是就返回分数(三张相同的牌*14的7次方)
     *
     * @param cards
     * @return
     */
    public static long isThreeOfaKind(List<String> cards) {
        return 0;
    }

    /**
     * 是否为两对,不是返回0,是就返回分数(大对*14的6次方+小对*14的5次方)
     *
     * @param cards
     * @return
     */
    public static long isTwoPairs(List<String> cards) {
        return 0;
    }

    /**
     * 是否为对子,不是就返回0,是就返回分数(对子*14的5次方)
     *
     * @param cards
     * @return
     */
    public static long isPair(List<String> cards) {
        return 0;
    }

    /**
     * 若为散牌,则返回分数,(最大牌*14的4次方+第二*14的3次方+第三*14的2次方+第四*14的1次方+第五*14的0次方)
     *
     * @param cards
     * @return
     */
    public static long isHighCard(List<String> cards) {
        return 0;
    }
}
