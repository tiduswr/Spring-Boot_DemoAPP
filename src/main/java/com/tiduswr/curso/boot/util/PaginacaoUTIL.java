package com.tiduswr.curso.boot.util;

import java.util.List;

public class PaginacaoUTIL<T> {

    private int rowLen;
    private int page;
    private long pageLen;
    private String direcao;
    private List<T> items;

    public PaginacaoUTIL(int rowLen, int page, long pageLen, String direcao, List<T> items) {
        this.rowLen = rowLen;
        this.page = page;
        this.pageLen = pageLen;
        this.direcao = direcao;
        this.items = items;
    }

    public String getDirecao() {
        return direcao;
    }

    public int getRowLen() {
        return rowLen;
    }

    public int getPage() {
        return page;
    }

    public long getPageLen() {
        return pageLen;
    }

    public List<T> getItems() {
        return items;
    }
}
