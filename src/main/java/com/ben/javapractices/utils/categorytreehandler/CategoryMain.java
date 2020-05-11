package com.ben.javapractices.utils.categorytreehandler;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * The goal of this project is to loop through the elements of a category tree and get expiration dates for every
 * child tree element if one of the their ancestors have one.
 * If there is multiple children tree elements with existing expiration dates then the latest should be used in their
 * parent.
 */
public class CategoryMain {

    private static ExpirationInfoTree tree = new ExpirationInfoTree();

    // Initializing category tree
    static {
        tree.setId(1L);

        List<ExpirationInfoTree> mainChildren = new ArrayList<>();
        tree.setChildCategoryTreeList(mainChildren);

        // FIRST TREE

        ExpirationInfoTree c1 = new ExpirationInfoTree();
        mainChildren.add(c1);
        List<ExpirationInfoTree> c1Children = new ArrayList<>();
        c1.setChildCategoryTreeList(c1Children);
        c1.setId(2L);

        ExpirationInfoTree c1c1 = new ExpirationInfoTree();
        c1Children.add(c1c1);
        c1c1.setId(3L);
        c1c1.setExpirationDate(getDate("2018-09-01 01:59:59.0"));

        ExpirationInfoTree c1c2 = new ExpirationInfoTree();
        c1Children.add(c1c2);
        c1c2.setId(4L);
        c1c2.setExpirationDate(getDate("2018-09-02 01:59:59.0"));

        ExpirationInfoTree c1c3 = new ExpirationInfoTree();
        c1Children.add(c1c3);
        c1c3.setId(5L);
        c1c3.setExpirationDate(getDate("2018-09-03 01:59:59.0"));

        // SECOND TREE

        ExpirationInfoTree c2 = new ExpirationInfoTree();
        mainChildren.add(c2);
        List<ExpirationInfoTree> c2Children = new ArrayList<>();
        c2.setChildCategoryTreeList(c2Children);
        c2.setId(6L);

        ExpirationInfoTree c2c1 = new ExpirationInfoTree();
        c2Children.add(c2c1);
        c2c1.setId(7L);

        ExpirationInfoTree c2c2 = new ExpirationInfoTree();
        c2Children.add(c2c2);
        List<ExpirationInfoTree> c2c2Children = new ArrayList<>();
        c2c2.setId(8L);
        c2c2.setChildCategoryTreeList(c2c2Children);

        ExpirationInfoTree c2c2c1 = new ExpirationInfoTree();
        c2c2Children.add(c2c2c1);
        c2c2c1.setId(9L);
        c2c2c1.setExpirationDate(getDate("2018-09-04 01:59:59.0"));

        ExpirationInfoTree c2c2c2 = new ExpirationInfoTree();
        c2c2Children.add(c2c2c2);
        c2c2c2.setId(10L);
        c2c2c2.setExpirationDate(getDate("2018-09-05 01:59:59.0"));

        ExpirationInfoTree c2c3 = new ExpirationInfoTree();
        c2Children.add(c2c3);
        List<ExpirationInfoTree> c2c3Children = new ArrayList<>();
        c2c3.setId(11L);
        c2c3.setChildCategoryTreeList(c2c3Children);

        ExpirationInfoTree c2c3c1 = new ExpirationInfoTree();
        c2c3Children.add(c2c3c1);
        c2c3c1.setId(12L);

        ExpirationInfoTree c2c4 = new ExpirationInfoTree();
        c2Children.add(c2c4);
        c2c4.setId(13L);
        c2c4.setExpirationDate(getDate("2018-09-06 01:59:59.0"));

        // THIRD TREE

        ExpirationInfoTree c3 = new ExpirationInfoTree();
        mainChildren.add(c3);
        c3.setId(14L);
        c3.setExpirationDate(getDate("2018-09-07 01:59:59.0"));

        // FOURTH THREE

        ExpirationInfoTree c4 = new ExpirationInfoTree();
        mainChildren.add(c4);
        c4.setId(15L);
    }

    private static Long getDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");

        Date parsedDate = null;
        try {
            parsedDate = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Timestamp timestamp = new Timestamp(parsedDate.getTime());

        return timestamp.getTime();
    }

    private static void fillEndDates(ExpirationInfoTree tree) {
        List<ExpirationInfoTree> childCategoryTreeList = tree.getChildCategoryTreeList();

        if (!childCategoryTreeList.isEmpty() && tree.getExpirationDate() == null && isTreeHasAnEndDate(tree)) {
            if (allOfTheChildrenHaveEndDates(childCategoryTreeList)) {
                List<Long> expirationDates = new ArrayList<>();

                for (ExpirationInfoTree childCategoryTree : childCategoryTreeList) {
                    Long expirationDate = childCategoryTree.getExpirationDate();

                    if (expirationDate != null) {
                        expirationDates.add(expirationDate);
                    }
                }

                Long latestExpirationDate = Collections.max(expirationDates);
                tree.setExpirationDate(latestExpirationDate);
            } else {
                for (ExpirationInfoTree childCategoryTree : childCategoryTreeList) {
                    fillEndDates(childCategoryTree);
                }
            }
        } else if (tree.getExpirationDate() == null && !isTreeHasAnEndDate(tree)) {
            System.out.println(System.currentTimeMillis());
            tree.setExpirationDate(System.currentTimeMillis());
        }
    }

    private static boolean allOfTheChildrenHaveEndDates(List<ExpirationInfoTree> childCategoryTreeList) {
        boolean result = true;

        for (ExpirationInfoTree childCategoryTree : childCategoryTreeList) {
            if (
                childCategoryTree.getExpirationDate() == null
                && isTreeHasAnEndDate(childCategoryTree)
            ) {
                result = false;
            }
        }

        return result;
    }

    private static boolean isTreeHasAnEndDate(ExpirationInfoTree categoryTree) {
        boolean result = false;

        if (categoryTree.getExpirationDate() != null) {
            result = true;
        } else if (!categoryTree.getChildCategoryTreeList().isEmpty()) {
            for (ExpirationInfoTree childCategory : categoryTree.getChildCategoryTreeList()) {
                result = isTreeHasAnEndDate(childCategory);

                if (result) {
                    break;
                }
            }
        }

        return result;
    }

    private static void getExpirationInfoListFromCategoryTree(
        ExpirationInfoTree expirationTree,
        List<ExpirationInfo> expirationInfoList
    ) {
        if (expirationTree.getExpirationDate() != null) {
            Long categoryId = expirationTree.getId();
            Long expirationDate = expirationTree.getExpirationDate();

            ExpirationInfo expirationInfo = new ExpirationInfo();
            expirationInfo.setId(categoryId);
            expirationInfo.setExpirationDate(expirationDate);

            expirationInfoList.add(expirationInfo);

            if (!expirationTree.getChildCategoryTreeList().isEmpty()) {
                for (ExpirationInfoTree childTree : expirationTree.getChildCategoryTreeList()) {
                    getExpirationInfoListFromCategoryTree(childTree, expirationInfoList);
                }
            }
        }
    }

    private static void checkIfResultIsOk(List<ExpirationInfo> infoList) throws Exception {
        Map<Long, Long> referenceMap = new HashMap<>();
        referenceMap.put(1L, 1536278399000L);
        referenceMap.put(2L, 1535932799000L);
        referenceMap.put(3L, 1535759999000L);
        referenceMap.put(4L, 1535846399000L);
        referenceMap.put(5L, 1535932799000L);
        referenceMap.put(6L, 1536191999000L);
        referenceMap.put(8L, 1536105599000L);
        referenceMap.put(9L, 1536019199000L);
        referenceMap.put(10L, 1536105599000L);
        referenceMap.put(13L, 1536191999000L);
        referenceMap.put(14L, 1536278399000L);

        if (infoList.size() != referenceMap.size()) {
            throw new Exception();
        }

        for (Long id : referenceMap.keySet()) {
            boolean hasCategory = false;

            for (ExpirationInfo info : infoList) {
                if (info.getId().equals(id)) {
                    hasCategory = true;

                    if (!referenceMap.get(id).equals(info.getExpirationDate())) {
                        throw new Exception();
                    }
                }
            }

            if (!hasCategory) {
                throw new Exception();
            }
        }
    }

    public static void main(String[] args) {
        while (tree.getExpirationDate() == null) {
            fillEndDates(tree);
        }

        List<ExpirationInfo> infoList = new ArrayList<>();

        getExpirationInfoListFromCategoryTree(tree, infoList);

        try {
            checkIfResultIsOk(infoList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
