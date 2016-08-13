package com.pro.test.core.common.tags;

import com.pro.test.core.util.EntityUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.List;

/**
 * Created by hxpeng on 2016/8/12.
 */
public class TranslateTag extends TagSupport {


    private static final long serialVersionUID = 8805320924250394444L;
    private static final Logger logger = LoggerFactory.getLogger(TranslateTag.class);
    private Object value;
    private Object source;
    private String sourceKey;

    public int doStartTag()
            throws JspException {
        return 0;
    }

    public int doEndTag()
            throws JspException {
        if ((this.source == null) || (this.value == null) || (StringUtils.isEmpty(this.sourceKey))) {
            return 6;
        }
        try {
            String[] sourceKeyArray = sourceKey.split(",");

            // key列，source为非dict时有效
            String keyField = sourceKeyArray[0];

            // value列，source为非dict时有效
            String valueField = sourceKeyArray.length > 1 ? sourceKeyArray[1] : sourceKeyArray[0];

            Object result = value;

            try {
                if (source instanceof List<?>) {
                    List<Object> dataList = (List<Object>)source;

                    for (int i = 0, len = dataList.size(); i < len; i++) {
                        Object object = dataList.get(i);
                        Object tempObject = EntityUtils.getVariableValue(object, keyField);

                        if (value.equals(tempObject)) {
                            result = EntityUtils.getVariableValue(object, valueField);
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                logger.error("Exception: ", e);
            }

            this.pageContext.getOut().print(result == null ? value : result);
//            this.pageContext.getOut().print(TagHelper.translate(this.source, this.sourceKey, this.value));
        } catch (IOException e) {
            logger.info("Exception: ", e);
        }
        return 6;
    }


    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public String getSourceKey() {
        return sourceKey;
    }

    public void setSourceKey(String sourceKey) {
        this.sourceKey = sourceKey;
    }
}
