package func_Helpers;

public class Column {
    private int colId;
    private String colName;
    private String type;
    private String value;

    public Column() {

    }

    public Column(int colId, String colName, String type, String value) {
        this.colId = colId;
        this.colName = colName;
        this.type = type;
        this.value = value;
    }

    public Integer getColId() {return colId;}

    public void setColId(int colId) {this.colId = colId;}

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }


}
