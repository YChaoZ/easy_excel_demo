package com.yc.easy_excel_demo.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.exception.ExcelDataConvertException;
import com.alibaba.fastjson.JSONObject;
import com.yc.easy_excel_demo.utils.RowData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：YC
 * @date：2022/2/13
 * @description：Excel监听器
 * @version: 1.0.0
 */
@Slf4j
@Data
public class ExcelListener extends AnalysisEventListener {

    private List<RowData> list = new ArrayList<RowData>();
    private List<RowData> errorList = new ArrayList<RowData>();

    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     */
    public ExcelListener() {
    }

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data
     * @param context
     */
    @Override
    public void invoke(Object data, AnalysisContext context) {
        log.info("解析一条数据：{}", data);
        list.add(new RowData(context.readRowHolder().getRowIndex(), data));
    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("数据解析完成：{}", JSONObject.toJSON(list));
    }

    /**
     * 获取转换异常
     *
     * @param exception
     * @param context
     * @throws Exception
     */
    @Override
    public void onException(Exception exception, AnalysisContext context) {
        // 如果是某一个单元格的转换异常 能获取到具体行号
        // 如果要获取头的信息 配合doAfterAllAnalysedHeadMap使用
        if (exception instanceof ExcelDataConvertException) {
            ExcelDataConvertException excelDataConvertException = (ExcelDataConvertException) exception;
            log.error("第{}行，第{}列解析异常", excelDataConvertException.getRowIndex() + 1,
                    excelDataConvertException.getColumnIndex() + 1);
            errorList.add(new RowData(
                    context.readRowHolder().getRowIndex()
                    , context.readRowHolder().getCurrentRowAnalysisResult()));
        }
    }
}
