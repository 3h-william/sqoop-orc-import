// ORM class for table 'IMPORT_TABLE_1'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Mon Aug 31 16:53:53 CST 2015
// For connector: org.apache.sqoop.manager.HsqldbManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import com.cloudera.sqoop.lib.JdbcWritableBridge;
import com.cloudera.sqoop.lib.DelimiterSet;
import com.cloudera.sqoop.lib.FieldFormatter;
import com.cloudera.sqoop.lib.RecordParser;
import com.cloudera.sqoop.lib.BooleanParser;
import com.cloudera.sqoop.lib.BlobRef;
import com.cloudera.sqoop.lib.ClobRef;
import com.cloudera.sqoop.lib.LargeObjectLoader;
import com.cloudera.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class IMPORT_TABLE_1 extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  protected ResultSet __cur_result_set;
  private java.math.BigDecimal DATA_COL0;
  public java.math.BigDecimal get_DATA_COL0() {
    return DATA_COL0;
  }
  public void set_DATA_COL0(java.math.BigDecimal DATA_COL0) {
    this.DATA_COL0 = DATA_COL0;
  }
  public IMPORT_TABLE_1 with_DATA_COL0(java.math.BigDecimal DATA_COL0) {
    this.DATA_COL0 = DATA_COL0;
    return this;
  }
  private java.math.BigDecimal DATA_COL1;
  public java.math.BigDecimal get_DATA_COL1() {
    return DATA_COL1;
  }
  public void set_DATA_COL1(java.math.BigDecimal DATA_COL1) {
    this.DATA_COL1 = DATA_COL1;
  }
  public IMPORT_TABLE_1 with_DATA_COL1(java.math.BigDecimal DATA_COL1) {
    this.DATA_COL1 = DATA_COL1;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof IMPORT_TABLE_1)) {
      return false;
    }
    IMPORT_TABLE_1 that = (IMPORT_TABLE_1) o;
    boolean equal = true;
    equal = equal && (this.DATA_COL0 == null ? that.DATA_COL0 == null : this.DATA_COL0.equals(that.DATA_COL0));
    equal = equal && (this.DATA_COL1 == null ? that.DATA_COL1 == null : this.DATA_COL1.equals(that.DATA_COL1));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof IMPORT_TABLE_1)) {
      return false;
    }
    IMPORT_TABLE_1 that = (IMPORT_TABLE_1) o;
    boolean equal = true;
    equal = equal && (this.DATA_COL0 == null ? that.DATA_COL0 == null : this.DATA_COL0.equals(that.DATA_COL0));
    equal = equal && (this.DATA_COL1 == null ? that.DATA_COL1 == null : this.DATA_COL1.equals(that.DATA_COL1));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.DATA_COL0 = JdbcWritableBridge.readBigDecimal(1, __dbResults);
    this.DATA_COL1 = JdbcWritableBridge.readBigDecimal(2, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.DATA_COL0 = JdbcWritableBridge.readBigDecimal(1, __dbResults);
    this.DATA_COL1 = JdbcWritableBridge.readBigDecimal(2, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeBigDecimal(DATA_COL0, 1 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(DATA_COL1, 2 + __off, 2, __dbStmt);
    return 2;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeBigDecimal(DATA_COL0, 1 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(DATA_COL1, 2 + __off, 2, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.DATA_COL0 = null;
    } else {
    this.DATA_COL0 = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.DATA_COL1 = null;
    } else {
    this.DATA_COL1 = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.DATA_COL0) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.DATA_COL0, __dataOut);
    }
    if (null == this.DATA_COL1) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.DATA_COL1, __dataOut);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.DATA_COL0) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.DATA_COL0, __dataOut);
    }
    if (null == this.DATA_COL1) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.DATA_COL1, __dataOut);
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(DATA_COL0==null?"null":"" + DATA_COL0, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(DATA_COL1==null?"null":"" + DATA_COL1, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(DATA_COL0==null?"null":"" + DATA_COL0, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(DATA_COL1==null?"null":"" + DATA_COL1, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.DATA_COL0 = null; } else {
      this.DATA_COL0 = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.DATA_COL1 = null; } else {
      this.DATA_COL1 = new java.math.BigDecimal(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.DATA_COL0 = null; } else {
      this.DATA_COL0 = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.DATA_COL1 = null; } else {
      this.DATA_COL1 = new java.math.BigDecimal(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    IMPORT_TABLE_1 o = (IMPORT_TABLE_1) super.clone();
    return o;
  }

  public void clone0(IMPORT_TABLE_1 o) throws CloneNotSupportedException {
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new TreeMap<String, Object>();
    __sqoop$field_map.put("DATA_COL0", this.DATA_COL0);
    __sqoop$field_map.put("DATA_COL1", this.DATA_COL1);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("DATA_COL0", this.DATA_COL0);
    __sqoop$field_map.put("DATA_COL1", this.DATA_COL1);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if ("DATA_COL0".equals(__fieldName)) {
      this.DATA_COL0 = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("DATA_COL1".equals(__fieldName)) {
      this.DATA_COL1 = (java.math.BigDecimal) __fieldVal;
    }
    else {
      throw new RuntimeException("No such field: " + __fieldName);
    }
  }
  public boolean setField0(String __fieldName, Object __fieldVal) {
    if ("DATA_COL0".equals(__fieldName)) {
      this.DATA_COL0 = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("DATA_COL1".equals(__fieldName)) {
      this.DATA_COL1 = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else {
      return false;    }
  }
}
