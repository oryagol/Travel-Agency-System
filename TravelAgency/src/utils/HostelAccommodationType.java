package utils;

/**
 * Created by Antonio Zaitoun on 13/07/2018.
 */
public enum HostelAccommodationType {
    SHORT(0),
    LONG(1);

    private int code;
    HostelAccommodationType(int i){
        this.code = i;
    }

    public int getCode() {
        return code;
    }
    public static HostelAccommodationType fromCode(int i){
        return i == 0 ? SHORT : LONG;
    }
}
