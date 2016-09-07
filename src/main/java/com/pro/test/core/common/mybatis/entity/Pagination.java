package com.pro.test.core.common.mybatis.entity;

import com.pro.test.core.util.StringUtils;

/**
 * Created by hxpeng on 2016/6/29.
 */
public class Pagination {
    public static final String PARAMETER_NAME_OF_PAGE = "page";
    public static final String PARAMETER_NAME_OF_SIZE = "size";
    private int currentPage = 1;
    private int pageSize = 25;
    private int totalRecords = 0;
    private int totalPages = 0;
    private int customOffset = -1;
    private boolean totalRecordsQueryFlag = true;

    public Pagination() {}

    public Pagination(String pageSize, String currentPage)
    {
        if (StringUtils.isNumeric(pageSize)) {
            setPageSize(Integer.parseInt(pageSize));
        }
        if (StringUtils.isNumeric(currentPage)) {
            setCurrentPage(Integer.parseInt(currentPage));
        }
    }

    public Pagination(int pageSize)
    {
        setPageSize(pageSize);
    }

    public Pagination(int pageSize, int currentPage)
    {
        setPageSize(pageSize);

        setCurrentPage(currentPage);
    }

    public Pagination(int totalRecords, int pageSize, int currentPage)
    {
        setTotalRecords(totalRecords);

        setPageSize(pageSize);

        setCurrentPage(currentPage);
    }

    public int getTotalRecords()
    {
        return this.totalRecords;
    }

    public void setTotalRecords(int totalRecords)
    {
        this.totalRecords = (totalRecords <= 0 ? 0 : totalRecords);
    }

    public int getPageSize()
    {
        return this.pageSize;
    }

    public int getCurrentPageSize()
    {
        if (this.totalRecords == 0) {
            return 0;
        }
        return this.currentPage < this.totalPages ? this.pageSize : this.totalRecords - (this.currentPage - 1) * this.pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = (pageSize <= 0 ? 10 : pageSize);
    }

    public int getTotalPages()
    {
        if (this.pageSize == 0) {
            return 0;
        }
        return this.totalRecords % this.pageSize == 0 ? this.totalRecords / this.pageSize : this.totalRecords / this.pageSize + 1;
    }

    public void setTotalPages(int totalPages)
    {
        this.totalPages = totalPages;
    }

    public int getCurrentPage()
    {
        return this.currentPage;
    }

    public void setCurrentPage(int currentPage)
    {
        if (currentPage < 1) {
            this.currentPage = 1;
        } else if ((currentPage > this.totalPages) && (this.totalPages > 0)) {
            this.currentPage = this.totalPages;
        } else {
            this.currentPage = currentPage;
        }
    }

    public int getNextPage()
    {
        return isHasNextPage() ? this.currentPage + 1 : this.currentPage;
    }

    public int getPreviousPage()
    {
        return isHasPreviousPage() ? this.currentPage - 1 : this.currentPage;
    }

    public boolean isHasNextPage()
    {
        return this.currentPage != this.totalPages;
    }

    public boolean isHasPreviousPage()
    {
        return this.currentPage != 1;
    }

    public boolean isFirstPage()
    {
        return this.currentPage == 1;
    }

    public boolean isLastPage()
    {
        return this.currentPage == this.totalPages;
    }

    public int getCurrentPageStartRecord()
    {
        if (this.customOffset >= 0) {
            return this.customOffset;
        }
        return (this.currentPage - 1) * this.pageSize + 1;
    }

    public int getCurrentPageEndRecord()
    {
        return (this.currentPage - 1) * this.pageSize + getCurrentPageSize();
    }

    public int getCustomOffset()
    {
        return this.customOffset;
    }

    public void setCustomOffset(int customOffset)
    {
        this.customOffset = customOffset;
    }

    public boolean getTotalRecordsQueryFlag()
    {
        return this.totalRecordsQueryFlag;
    }

    public void setTotalRecordsQueryFlag(boolean totalRecordsQueryFlag)
    {
        this.totalRecordsQueryFlag = totalRecordsQueryFlag;
    }
}
