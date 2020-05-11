package com.ben.javapractices.utils.categorytreehandler;

import java.util.ArrayList;
import java.util.List;

public class ExpirationInfoTree {

    private Long id;

    private Long expirationDate;

    private List<ExpirationInfoTree> childCategoryTreeList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Long expirationDate) {
        this.expirationDate = expirationDate;
    }

    public List<ExpirationInfoTree> getChildCategoryTreeList() {
        return childCategoryTreeList;
    }

    public void setChildCategoryTreeList(List<ExpirationInfoTree> childCategoryTreeList) {
        this.childCategoryTreeList = childCategoryTreeList;
    }

}
