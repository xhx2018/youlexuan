package com.offcn.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author 邢会兴
 * date 2019/11/14   19:00
 */
public class PageResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long total;

    private List<?> rows;

    public PageResult() {
    }

    public PageResult(Long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
