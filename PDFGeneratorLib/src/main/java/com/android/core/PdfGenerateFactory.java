package com.android.core;

import android.content.Context;

import com.android.custom.Dimension;
import com.android.io.PageCount;
import com.android.kernel.PageSize;
import com.android.layout.CreateContainer;
import com.android.layout.CreateStatic;

import java.io.File;
import java.io.IOException;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class PdfGenerateFactory {

    private CreateStatic staticHeader;
    private CreateStatic staticFooter;
    private CreateContainer container;

    public void init(Document document) {

        initDimension(document.context);

        initPageSize(document);

        initStaticLayout(document);

        initPageCount(document);

        initContainer(document);

    }

    private void initContainer(Document document) {

        container = new CreateContainer(document, staticHeader.create(), staticFooter.create());

        container.create();

    }

    private void initPageCount(Document document) {

        PageCount pageCount = document.getPageCount();

        if (pageCount != null) {

            CreateContainer calculatePageCount = new CreateContainer(document, staticHeader.create(), staticFooter.create());

            pageCount.setTotalPageCount(calculatePageCount.create().getPageCount());

        }
    }

    private void initStaticLayout(Document document) {

        staticHeader = new CreateStatic(document.getContext(), document.getHeaderCells(), document.getPageSize(), document.getColumnWeight());

        staticFooter = new CreateStatic(document.getContext(), document.getFooterCells(), document.getPageSize(), document.getColumnWeight());

    }

    private void initDimension(Context context) {

        if (context == null) {

            throw new Error("You been must call 'init' method to initialize library. or Null Context");

        } else {

            new Dimension(context);

        }

    }

    private void initPageSize(Document document) {

        int paddingWidth = document.paddingLeft + document.paddingRight;
        int paddingHeight = document.paddingTop + document.paddingBottom;

        PageSize pageSize = document.pageSize;
        pageSize.decreasePadding(paddingWidth, paddingHeight);

    }

    public void finish(File file) throws IOException {

        container.finish(file);

    }
}