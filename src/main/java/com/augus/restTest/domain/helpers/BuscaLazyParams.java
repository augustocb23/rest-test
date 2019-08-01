package com.augus.restTest.domain.helpers;

public class BuscaLazyParams {
    private String filter;
    private SortOrder sortOrder;
    private String sortColumn;
    private int pageNumber;
    private int pageSize;

    public BuscaLazyParams(String filter, String sortOrder, String sortColumn, String pageNumber, String pageSize)
            throws IllegalArgumentException {
        this.filter = "%" + filter + "%";

        try {
            this.sortOrder = SortOrder.valueOf(sortOrder.toUpperCase());
            this.sortColumn = sortColumn;

            this.pageNumber = Integer.parseInt(pageNumber);
            this.pageSize = Integer.parseInt(pageSize);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public String getFilter() {
        return filter;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public String getSortColumn() {
        return sortColumn;
    }

    public SortOrder getSortOrder() {
        return sortOrder;
    }
}
