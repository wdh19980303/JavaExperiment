package cn.itcast.thread;

public enum Season {
    Spring("春天"),
    Summer("夏天"),
    Autumn("秋天"),
    Winter("冬天");
    private String Chinese;

    Season(String Chinese) {
        this.Chinese = Chinese;
    }

    public String getChinese(){
        return this.Chinese;
    }
}
