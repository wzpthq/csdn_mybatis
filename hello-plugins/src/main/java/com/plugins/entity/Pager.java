package com.plugins.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 分页类
 * Created by wangzhiping on 17/3/10.
 */
public class Pager<T> implements Serializable{

    /**
     * 开始位置
     */
    private int startPos;

    /**
     * 当前页码
     */
    private int curPage;

    /**
     * 每页大小
     */
    private int pageSize;

    /**
     * 每一页的数据
     */
    private List<T> datas;

    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 总数量
     */
    private int totalCount;

    public Pager(int curPage, int pageSize) {
        this.curPage = curPage;
        this.pageSize = pageSize;

        this.startPos = (this.curPage - 1) * this.pageSize;
    }

    public int getStartPos() {
        return startPos;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        this.totalPage = (this.totalCount - 1) / this.pageSize + 1;
    }

    @Override
    public String toString() {
        return "Pager{" +
                "startPos=" + startPos +
                ", curPage=" + curPage +
                ", pageSize=" + pageSize +
                ", datas=" + datas +
                ", totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                '}';
    }
}
