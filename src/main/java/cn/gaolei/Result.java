package cn.gaolei;

/**
 * 结果封装类，把分数和获胜状态封装到一起
 */
public class Result {
    private long score;
    private String state;

    public Result() {
        super();
    }

    public Result(long score, String state) {
        this.score = score;
        this.state = state;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Result{" +
                "score=" + score +
                ", state='" + state + '\'' +
                '}';
    }
}
