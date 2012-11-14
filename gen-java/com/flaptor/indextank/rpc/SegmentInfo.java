/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.flaptor.indextank.rpc;

import org.apache.thrift.TBase;
import org.apache.thrift.TBaseHelper;
import org.apache.thrift.TException;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.TFieldRequirementType;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolUtil;
import org.apache.thrift.protocol.TStruct;
import org.apache.thrift.protocol.TType;

import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
public class SegmentInfo implements TBase<SegmentInfo, SegmentInfo._Fields>, java.io.Serializable, Cloneable {
    private static final TStruct STRUCT_DESC = new TStruct("SegmentInfo");

    private static final TField TIMESTAMP_FIELD_DESC = new TField("timestamp", TType.I64, (short) 1);
    private static final TField END_TIMESTAMP_FIELD_DESC = new TField("end_timestamp", TType.I64, (short) 2);
    private static final TField VALID_LENGTH_FIELD_DESC = new TField("valid_length", TType.I64, (short) 3);
    private static final TField ACTUAL_LENGTH_FIELD_DESC = new TField("actual_length", TType.I64, (short) 4);
    private static final TField RECORD_COUNT_FIELD_DESC = new TField("record_count", TType.I32, (short) 5);
    private static final TField SORTED_FIELD_DESC = new TField("sorted", TType.BOOL, (short) 6);

    private long timestamp;
    private long end_timestamp;
    private long valid_length;
    private long actual_length;
    private int record_count;
    private boolean sorted;

    /**
     * The set of fields this struct contains, along with convenience methods for finding and manipulating them.
     */
    public enum _Fields implements TFieldIdEnum {
        TIMESTAMP((short) 1, "timestamp"),
        END_TIMESTAMP((short) 2, "end_timestamp"),
        VALID_LENGTH((short) 3, "valid_length"),
        ACTUAL_LENGTH((short) 4, "actual_length"),
        RECORD_COUNT((short) 5, "record_count"),
        SORTED((short) 6, "sorted");

        private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

        static {
            for (_Fields field : EnumSet.allOf(_Fields.class)) {
                byName.put(field.getFieldName(), field);
            }
        }

        /**
         * Find the _Fields constant that matches fieldId, or null if its not found.
         */
        public static _Fields findByThriftId(int fieldId) {
            switch (fieldId) {
                case 1: // TIMESTAMP
                    return TIMESTAMP;
                case 2: // END_TIMESTAMP
                    return END_TIMESTAMP;
                case 3: // VALID_LENGTH
                    return VALID_LENGTH;
                case 4: // ACTUAL_LENGTH
                    return ACTUAL_LENGTH;
                case 5: // RECORD_COUNT
                    return RECORD_COUNT;
                case 6: // SORTED
                    return SORTED;
                default:
                    return null;
            }
        }

        /**
         * Find the _Fields constant that matches fieldId, throwing an exception
         * if it is not found.
         */
        public static _Fields findByThriftIdOrThrow(int fieldId) {
            _Fields fields = findByThriftId(fieldId);
            if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
            return fields;
        }

        /**
         * Find the _Fields constant that matches name, or null if its not found.
         */
        public static _Fields findByName(String name) {
            return byName.get(name);
        }

        private final short _thriftId;
        private final String _fieldName;

        _Fields(short thriftId, String fieldName) {
            _thriftId = thriftId;
            _fieldName = fieldName;
        }

        public short getThriftFieldId() {
            return _thriftId;
        }

        public String getFieldName() {
            return _fieldName;
        }
    }

    // isset id assignments
    private static final int __TIMESTAMP_ISSET_ID = 0;
    private static final int __END_TIMESTAMP_ISSET_ID = 1;
    private static final int __VALID_LENGTH_ISSET_ID = 2;
    private static final int __ACTUAL_LENGTH_ISSET_ID = 3;
    private static final int __RECORD_COUNT_ISSET_ID = 4;
    private static final int __SORTED_ISSET_ID = 5;
    private BitSet __isset_bit_vector = new BitSet(6);

    public static final Map<_Fields, FieldMetaData> metaDataMap;

    static {
        Map<_Fields, FieldMetaData> tmpMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
        tmpMap.put(_Fields.TIMESTAMP, new FieldMetaData("timestamp", TFieldRequirementType.DEFAULT,
                new FieldValueMetaData(TType.I64)));
        tmpMap.put(_Fields.END_TIMESTAMP, new FieldMetaData("end_timestamp", TFieldRequirementType.DEFAULT,
                new FieldValueMetaData(TType.I64)));
        tmpMap.put(_Fields.VALID_LENGTH, new FieldMetaData("valid_length", TFieldRequirementType.DEFAULT,
                new FieldValueMetaData(TType.I64)));
        tmpMap.put(_Fields.ACTUAL_LENGTH, new FieldMetaData("actual_length", TFieldRequirementType.DEFAULT,
                new FieldValueMetaData(TType.I64)));
        tmpMap.put(_Fields.RECORD_COUNT, new FieldMetaData("record_count", TFieldRequirementType.DEFAULT,
                new FieldValueMetaData(TType.I32)));
        tmpMap.put(_Fields.SORTED, new FieldMetaData("sorted", TFieldRequirementType.DEFAULT,
                new FieldValueMetaData(TType.BOOL)));
        metaDataMap = Collections.unmodifiableMap(tmpMap);
        FieldMetaData.addStructMetaDataMap(SegmentInfo.class, metaDataMap);
    }

    public SegmentInfo() {
    }

    public SegmentInfo(
            long timestamp,
            long end_timestamp,
            long valid_length,
            long actual_length,
            int record_count,
            boolean sorted) {
        this();
        this.timestamp = timestamp;
        set_timestamp_isSet(true);
        this.end_timestamp = end_timestamp;
        set_end_timestamp_isSet(true);
        this.valid_length = valid_length;
        set_valid_length_isSet(true);
        this.actual_length = actual_length;
        set_actual_length_isSet(true);
        this.record_count = record_count;
        set_record_count_isSet(true);
        this.sorted = sorted;
        set_sorted_isSet(true);
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public SegmentInfo(SegmentInfo other) {
        __isset_bit_vector.clear();
        __isset_bit_vector.or(other.__isset_bit_vector);
        this.timestamp = other.timestamp;
        this.end_timestamp = other.end_timestamp;
        this.valid_length = other.valid_length;
        this.actual_length = other.actual_length;
        this.record_count = other.record_count;
        this.sorted = other.sorted;
    }

    public SegmentInfo deepCopy() {
        return new SegmentInfo(this);
    }

    @Override
    public void clear() {
        set_timestamp_isSet(false);
        this.timestamp = 0;
        set_end_timestamp_isSet(false);
        this.end_timestamp = 0;
        set_valid_length_isSet(false);
        this.valid_length = 0;
        set_actual_length_isSet(false);
        this.actual_length = 0;
        set_record_count_isSet(false);
        this.record_count = 0;
        set_sorted_isSet(false);
        this.sorted = false;
    }

    public long get_timestamp() {
        return this.timestamp;
    }

    public SegmentInfo set_timestamp(long timestamp) {
        this.timestamp = timestamp;
        set_timestamp_isSet(true);
        return this;
    }

    public void unset_timestamp() {
        __isset_bit_vector.clear(__TIMESTAMP_ISSET_ID);
    }

    /**
     * Returns true if field timestamp is set (has been asigned a value) and false otherwise
     */
    public boolean is_set_timestamp() {
        return __isset_bit_vector.get(__TIMESTAMP_ISSET_ID);
    }

    public void set_timestamp_isSet(boolean value) {
        __isset_bit_vector.set(__TIMESTAMP_ISSET_ID, value);
    }

    public long get_end_timestamp() {
        return this.end_timestamp;
    }

    public SegmentInfo set_end_timestamp(long end_timestamp) {
        this.end_timestamp = end_timestamp;
        set_end_timestamp_isSet(true);
        return this;
    }

    public void unset_end_timestamp() {
        __isset_bit_vector.clear(__END_TIMESTAMP_ISSET_ID);
    }

    /**
     * Returns true if field end_timestamp is set (has been asigned a value) and false otherwise
     */
    public boolean is_set_end_timestamp() {
        return __isset_bit_vector.get(__END_TIMESTAMP_ISSET_ID);
    }

    public void set_end_timestamp_isSet(boolean value) {
        __isset_bit_vector.set(__END_TIMESTAMP_ISSET_ID, value);
    }

    public long get_valid_length() {
        return this.valid_length;
    }

    public SegmentInfo set_valid_length(long valid_length) {
        this.valid_length = valid_length;
        set_valid_length_isSet(true);
        return this;
    }

    public void unset_valid_length() {
        __isset_bit_vector.clear(__VALID_LENGTH_ISSET_ID);
    }

    /**
     * Returns true if field valid_length is set (has been asigned a value) and false otherwise
     */
    public boolean is_set_valid_length() {
        return __isset_bit_vector.get(__VALID_LENGTH_ISSET_ID);
    }

    public void set_valid_length_isSet(boolean value) {
        __isset_bit_vector.set(__VALID_LENGTH_ISSET_ID, value);
    }

    public long get_actual_length() {
        return this.actual_length;
    }

    public SegmentInfo set_actual_length(long actual_length) {
        this.actual_length = actual_length;
        set_actual_length_isSet(true);
        return this;
    }

    public void unset_actual_length() {
        __isset_bit_vector.clear(__ACTUAL_LENGTH_ISSET_ID);
    }

    /**
     * Returns true if field actual_length is set (has been asigned a value) and false otherwise
     */
    public boolean is_set_actual_length() {
        return __isset_bit_vector.get(__ACTUAL_LENGTH_ISSET_ID);
    }

    public void set_actual_length_isSet(boolean value) {
        __isset_bit_vector.set(__ACTUAL_LENGTH_ISSET_ID, value);
    }

    public int get_record_count() {
        return this.record_count;
    }

    public SegmentInfo set_record_count(int record_count) {
        this.record_count = record_count;
        set_record_count_isSet(true);
        return this;
    }

    public void unset_record_count() {
        __isset_bit_vector.clear(__RECORD_COUNT_ISSET_ID);
    }

    /**
     * Returns true if field record_count is set (has been asigned a value) and false otherwise
     */
    public boolean is_set_record_count() {
        return __isset_bit_vector.get(__RECORD_COUNT_ISSET_ID);
    }

    public void set_record_count_isSet(boolean value) {
        __isset_bit_vector.set(__RECORD_COUNT_ISSET_ID, value);
    }

    public boolean is_sorted() {
        return this.sorted;
    }

    public SegmentInfo set_sorted(boolean sorted) {
        this.sorted = sorted;
        set_sorted_isSet(true);
        return this;
    }

    public void unset_sorted() {
        __isset_bit_vector.clear(__SORTED_ISSET_ID);
    }

    /**
     * Returns true if field sorted is set (has been asigned a value) and false otherwise
     */
    public boolean is_set_sorted() {
        return __isset_bit_vector.get(__SORTED_ISSET_ID);
    }

    public void set_sorted_isSet(boolean value) {
        __isset_bit_vector.set(__SORTED_ISSET_ID, value);
    }

    public void setFieldValue(_Fields field, Object value) {
        switch (field) {
            case TIMESTAMP:
                if (value == null) {
                    unset_timestamp();
                } else {
                    set_timestamp((Long) value);
                }
                break;

            case END_TIMESTAMP:
                if (value == null) {
                    unset_end_timestamp();
                } else {
                    set_end_timestamp((Long) value);
                }
                break;

            case VALID_LENGTH:
                if (value == null) {
                    unset_valid_length();
                } else {
                    set_valid_length((Long) value);
                }
                break;

            case ACTUAL_LENGTH:
                if (value == null) {
                    unset_actual_length();
                } else {
                    set_actual_length((Long) value);
                }
                break;

            case RECORD_COUNT:
                if (value == null) {
                    unset_record_count();
                } else {
                    set_record_count((Integer) value);
                }
                break;

            case SORTED:
                if (value == null) {
                    unset_sorted();
                } else {
                    set_sorted((Boolean) value);
                }
                break;

        }
    }

    public Object getFieldValue(_Fields field) {
        switch (field) {
            case TIMESTAMP:
                return new Long(get_timestamp());

            case END_TIMESTAMP:
                return new Long(get_end_timestamp());

            case VALID_LENGTH:
                return new Long(get_valid_length());

            case ACTUAL_LENGTH:
                return new Long(get_actual_length());

            case RECORD_COUNT:
                return new Integer(get_record_count());

            case SORTED:
                return new Boolean(is_sorted());

        }
        throw new IllegalStateException();
    }

    /**
     * Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise
     */
    public boolean isSet(_Fields field) {
        if (field == null) {
            throw new IllegalArgumentException();
        }

        switch (field) {
            case TIMESTAMP:
                return is_set_timestamp();
            case END_TIMESTAMP:
                return is_set_end_timestamp();
            case VALID_LENGTH:
                return is_set_valid_length();
            case ACTUAL_LENGTH:
                return is_set_actual_length();
            case RECORD_COUNT:
                return is_set_record_count();
            case SORTED:
                return is_set_sorted();
        }
        throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
        if (that == null)
            return false;
        if (that instanceof SegmentInfo)
            return this.equals((SegmentInfo) that);
        return false;
    }

    public boolean equals(SegmentInfo that) {
        if (that == null)
            return false;

        boolean this_present_timestamp = true;
        boolean that_present_timestamp = true;
        if (this_present_timestamp || that_present_timestamp) {
            if (!(this_present_timestamp && that_present_timestamp))
                return false;
            if (this.timestamp != that.timestamp)
                return false;
        }

        boolean this_present_end_timestamp = true;
        boolean that_present_end_timestamp = true;
        if (this_present_end_timestamp || that_present_end_timestamp) {
            if (!(this_present_end_timestamp && that_present_end_timestamp))
                return false;
            if (this.end_timestamp != that.end_timestamp)
                return false;
        }

        boolean this_present_valid_length = true;
        boolean that_present_valid_length = true;
        if (this_present_valid_length || that_present_valid_length) {
            if (!(this_present_valid_length && that_present_valid_length))
                return false;
            if (this.valid_length != that.valid_length)
                return false;
        }

        boolean this_present_actual_length = true;
        boolean that_present_actual_length = true;
        if (this_present_actual_length || that_present_actual_length) {
            if (!(this_present_actual_length && that_present_actual_length))
                return false;
            if (this.actual_length != that.actual_length)
                return false;
        }

        boolean this_present_record_count = true;
        boolean that_present_record_count = true;
        if (this_present_record_count || that_present_record_count) {
            if (!(this_present_record_count && that_present_record_count))
                return false;
            if (this.record_count != that.record_count)
                return false;
        }

        boolean this_present_sorted = true;
        boolean that_present_sorted = true;
        if (this_present_sorted || that_present_sorted) {
            if (!(this_present_sorted && that_present_sorted))
                return false;
            if (this.sorted != that.sorted)
                return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public int compareTo(SegmentInfo other) {
        if (!getClass().equals(other.getClass())) {
            return getClass().getName().compareTo(other.getClass().getName());
        }

        int lastComparison = 0;
        SegmentInfo typedOther = (SegmentInfo) other;

        lastComparison = Boolean.valueOf(is_set_timestamp()).compareTo(typedOther.is_set_timestamp());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (is_set_timestamp()) {
            lastComparison = TBaseHelper.compareTo(this.timestamp, typedOther.timestamp);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        lastComparison = Boolean.valueOf(is_set_end_timestamp()).compareTo(typedOther.is_set_end_timestamp());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (is_set_end_timestamp()) {
            lastComparison = TBaseHelper.compareTo(this.end_timestamp, typedOther.end_timestamp);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        lastComparison = Boolean.valueOf(is_set_valid_length()).compareTo(typedOther.is_set_valid_length());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (is_set_valid_length()) {
            lastComparison = TBaseHelper.compareTo(this.valid_length, typedOther.valid_length);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        lastComparison = Boolean.valueOf(is_set_actual_length()).compareTo(typedOther.is_set_actual_length());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (is_set_actual_length()) {
            lastComparison = TBaseHelper.compareTo(this.actual_length, typedOther.actual_length);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        lastComparison = Boolean.valueOf(is_set_record_count()).compareTo(typedOther.is_set_record_count());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (is_set_record_count()) {
            lastComparison = TBaseHelper.compareTo(this.record_count, typedOther.record_count);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        lastComparison = Boolean.valueOf(is_set_sorted()).compareTo(typedOther.is_set_sorted());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (is_set_sorted()) {
            lastComparison = TBaseHelper.compareTo(this.sorted, typedOther.sorted);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        return 0;
    }

    public _Fields fieldForId(int fieldId) {
        return _Fields.findByThriftId(fieldId);
    }

    public void read(TProtocol iprot) throws TException {
        TField field;
        iprot.readStructBegin();
        while (true) {
            field = iprot.readFieldBegin();
            if (field.type == TType.STOP) {
                break;
            }
            switch (field.id) {
                case 1: // TIMESTAMP
                    if (field.type == TType.I64) {
                        this.timestamp = iprot.readI64();
                        set_timestamp_isSet(true);
                    } else {
                        TProtocolUtil.skip(iprot, field.type);
                    }
                    break;
                case 2: // END_TIMESTAMP
                    if (field.type == TType.I64) {
                        this.end_timestamp = iprot.readI64();
                        set_end_timestamp_isSet(true);
                    } else {
                        TProtocolUtil.skip(iprot, field.type);
                    }
                    break;
                case 3: // VALID_LENGTH
                    if (field.type == TType.I64) {
                        this.valid_length = iprot.readI64();
                        set_valid_length_isSet(true);
                    } else {
                        TProtocolUtil.skip(iprot, field.type);
                    }
                    break;
                case 4: // ACTUAL_LENGTH
                    if (field.type == TType.I64) {
                        this.actual_length = iprot.readI64();
                        set_actual_length_isSet(true);
                    } else {
                        TProtocolUtil.skip(iprot, field.type);
                    }
                    break;
                case 5: // RECORD_COUNT
                    if (field.type == TType.I32) {
                        this.record_count = iprot.readI32();
                        set_record_count_isSet(true);
                    } else {
                        TProtocolUtil.skip(iprot, field.type);
                    }
                    break;
                case 6: // SORTED
                    if (field.type == TType.BOOL) {
                        this.sorted = iprot.readBool();
                        set_sorted_isSet(true);
                    } else {
                        TProtocolUtil.skip(iprot, field.type);
                    }
                    break;
                default:
                    TProtocolUtil.skip(iprot, field.type);
            }
            iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        validate();
    }

    public void write(TProtocol oprot) throws TException {
        validate();

        oprot.writeStructBegin(STRUCT_DESC);
        oprot.writeFieldBegin(TIMESTAMP_FIELD_DESC);
        oprot.writeI64(this.timestamp);
        oprot.writeFieldEnd();
        oprot.writeFieldBegin(END_TIMESTAMP_FIELD_DESC);
        oprot.writeI64(this.end_timestamp);
        oprot.writeFieldEnd();
        oprot.writeFieldBegin(VALID_LENGTH_FIELD_DESC);
        oprot.writeI64(this.valid_length);
        oprot.writeFieldEnd();
        oprot.writeFieldBegin(ACTUAL_LENGTH_FIELD_DESC);
        oprot.writeI64(this.actual_length);
        oprot.writeFieldEnd();
        oprot.writeFieldBegin(RECORD_COUNT_FIELD_DESC);
        oprot.writeI32(this.record_count);
        oprot.writeFieldEnd();
        oprot.writeFieldBegin(SORTED_FIELD_DESC);
        oprot.writeBool(this.sorted);
        oprot.writeFieldEnd();
        oprot.writeFieldStop();
        oprot.writeStructEnd();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SegmentInfo(");
        boolean first = true;

        sb.append("timestamp:");
        sb.append(this.timestamp);
        first = false;
        if (!first) sb.append(", ");
        sb.append("end_timestamp:");
        sb.append(this.end_timestamp);
        first = false;
        if (!first) sb.append(", ");
        sb.append("valid_length:");
        sb.append(this.valid_length);
        first = false;
        if (!first) sb.append(", ");
        sb.append("actual_length:");
        sb.append(this.actual_length);
        first = false;
        if (!first) sb.append(", ");
        sb.append("record_count:");
        sb.append(this.record_count);
        first = false;
        if (!first) sb.append(", ");
        sb.append("sorted:");
        sb.append(this.sorted);
        first = false;
        sb.append(")");
        return sb.toString();
    }

    public void validate() throws TException {
        // check for required fields
    }

}

