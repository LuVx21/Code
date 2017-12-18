package me.ren.pattern.Prototype;

public class Report extends ReportTemplate {

    private String attr;

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public String getAttr() {
        return this.attr;
    }

    /**
     * 克隆方法
     *
     * @return
     */
//    public ReportTemplate cloneReport() {
//        //创建新对象
//        ReportTemplate report = new Report();
//        report.setAttr(this.attr);
//        return report;
//    }
    public ReportTemplate cloneReport1() {
        Object object = null;
        try {
            object = super.clone();
        } catch (CloneNotSupportedException exception) {
            System.err.println("Not support cloneable");
        }
        return (ReportTemplate) object;
    }
}
