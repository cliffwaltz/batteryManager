package cn.ys.dto;

import java.io.Serializable;
import java.util.List;

public class PageList<T> implements Serializable {
    private Integer total;
    private List<T> rows;

    @Override
    public String toString() {
        return "PageList{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }

    public PageList() {
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
