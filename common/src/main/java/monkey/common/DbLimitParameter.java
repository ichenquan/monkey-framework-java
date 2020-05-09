package monkey.common;

import javax.persistence.Transient;

public class DbLimitParameter {

    @Transient
    private Integer maxSize = 2000;

    public Integer getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
    }
}
