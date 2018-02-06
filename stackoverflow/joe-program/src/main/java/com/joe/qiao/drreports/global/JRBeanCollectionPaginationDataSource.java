package com.joe.qiao.drreports.global;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.data.JRAbstractBeanDataSource;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author Joe Qiao
 * @Date 02/02/2018.
 */
public class JRBeanCollectionPaginationDataSource extends JRAbstractBeanDataSource {
    private Integer start;
    private Integer size;
    private Integer count;
    private Collection<?> data;
    private Iterator<?> iterator;
    private Object currentBean;

    public JRBeanCollectionPaginationDataSource(Collection<?> beanCollection) {
        this(beanCollection,null,null, true);
    }
    
    public JRBeanCollectionPaginationDataSource(Collection<?> beanCollection,Integer start,Integer size) {
        this(beanCollection,start,size, true);
    }

    public JRBeanCollectionPaginationDataSource(Collection<?> beanCollection,Integer start,Integer size, boolean isUseFieldDescription) {
        super(isUseFieldDescription);
        this.data = beanCollection;
        this.start=start;
        this.size=size;
        if(this.data != null) {
            this.iterator = this.data.iterator();
            initPagination();
        }
    }

    private void initPagination() {
        if(start!=null){
            if(start>=0&&start<data.size()){
                if(iterator!=null){
                    for(int i = 0;i<start;i++){
                        if(iterator.hasNext()){
                            iterator.next();
                        }
                    }
                }
            }
        }
        if(size!=null){
            count = 0;
        }
    }

    public boolean next() {
        if(count != null&&count==size){
            return false;
        }
        boolean hasNext = false;
        if(this.iterator != null) {
            hasNext = this.iterator.hasNext();
            if(hasNext) {
                this.currentBean = this.iterator.next();
            }
        }if(count!=null) {
            count++;
        }
        return hasNext;
    }

    public Object getFieldValue(JRField field) throws JRException {
        return this.getFieldValue(this.currentBean, field);
    }

    public void moveFirst() {
        if(this.data != null) {
            this.iterator = this.data.iterator();
        }

    }

    public Collection<?> getData() {
        return this.data;
    }

    public int getRecordCount() {
        return this.data == null?0:this.data.size();
    }

    public JRBeanCollectionPaginationDataSource cloneDataSource() {
        return new JRBeanCollectionPaginationDataSource(this.data);
    }
}
