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
public class RangeFilter implements TBase<RangeFilter, RangeFilter._Fields>, java.io.Serializable, Cloneable {
    private static final TStruct STRUCT_DESC = new TStruct("RangeFilter");

    private static final TField KEY_FIELD_DESC = new TField("key", TType.I32, (short) 1);
    private static final TField FLOOR_FIELD_DESC = new TField("floor", TType.DOUBLE, (short) 2);
    private static final TField NO_FLOOR_FIELD_DESC = new TField("no_floor", TType.BOOL, (short) 3);
    private static final TField CEIL_FIELD_DESC = new TField("ceil", TType.DOUBLE, (short) 4);
    private static final TField NO_CEIL_FIELD_DESC = new TField("no_ceil", TType.BOOL, (short) 5);

    private int key;
    private double floor;
    private boolean no_floor;
    private double ceil;
    private boolean no_ceil;

    /**
     * The set of fields this struct contains, along with convenience methods for finding and manipulating them.
     */
    public enum _Fields implements TFieldIdEnum {
        KEY((short) 1, "key"),
        FLOOR((short) 2, "floor"),
        NO_FLOOR((short) 3, "no_floor"),
        CEIL((short) 4, "ceil"),
        NO_CEIL((short) 5, "no_ceil");

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
                case 1: // KEY
                    return KEY;
                case 2: // FLOOR
                    return FLOOR;
                case 3: // NO_FLOOR
                    return NO_FLOOR;
                case 4: // CEIL
                    return CEIL;
                case 5: // NO_CEIL
                    return NO_CEIL;
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
    private static final int __KEY_ISSET_ID = 0;
    private static final int __FLOOR_ISSET_ID = 1;
    private static final int __NO_FLOOR_ISSET_ID = 2;
    private static final int __CEIL_ISSET_ID = 3;
    private static final int __NO_CEIL_ISSET_ID = 4;
    private BitSet __isset_bit_vector = new BitSet(5);

    public static final Map<_Fields, FieldMetaData> metaDataMap;

    static {
        Map<_Fields, FieldMetaData> tmpMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
        tmpMap.put(_Fields.KEY, new FieldMetaData("key", TFieldRequirementType.DEFAULT,
                new FieldValueMetaData(TType.I32)));
        tmpMap.put(_Fields.FLOOR, new FieldMetaData("floor", TFieldRequirementType.DEFAULT,
                new FieldValueMetaData(TType.DOUBLE)));
        tmpMap.put(_Fields.NO_FLOOR, new FieldMetaData("no_floor", TFieldRequirementType.DEFAULT,
                new FieldValueMetaData(TType.BOOL)));
        tmpMap.put(_Fields.CEIL, new FieldMetaData("ceil", TFieldRequirementType.DEFAULT,
                new FieldValueMetaData(TType.DOUBLE)));
        tmpMap.put(_Fields.NO_CEIL, new FieldMetaData("no_ceil", TFieldRequirementType.DEFAULT,
                new FieldValueMetaData(TType.BOOL)));
        metaDataMap = Collections.unmodifiableMap(tmpMap);
        FieldMetaData.addStructMetaDataMap(RangeFilter.class, metaDataMap);
    }

    public RangeFilter() {
    }

    public RangeFilter(
            int key,
            double floor,
            boolean no_floor,
            double ceil,
            boolean no_ceil) {
        this();
        this.key = key;
        set_key_isSet(true);
        this.floor = floor;
        set_floor_isSet(true);
        this.no_floor = no_floor;
        set_no_floor_isSet(true);
        this.ceil = ceil;
        set_ceil_isSet(true);
        this.no_ceil = no_ceil;
        set_no_ceil_isSet(true);
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public RangeFilter(RangeFilter other) {
        __isset_bit_vector.clear();
        __isset_bit_vector.or(other.__isset_bit_vector);
        this.key = other.key;
        this.floor = other.floor;
        this.no_floor = other.no_floor;
        this.ceil = other.ceil;
        this.no_ceil = other.no_ceil;
    }

    public RangeFilter deepCopy() {
        return new RangeFilter(this);
    }

    @Override
    public void clear() {
        set_key_isSet(false);
        this.key = 0;
        set_floor_isSet(false);
        this.floor = 0.0;
        set_no_floor_isSet(false);
        this.no_floor = false;
        set_ceil_isSet(false);
        this.ceil = 0.0;
        set_no_ceil_isSet(false);
        this.no_ceil = false;
    }

    public int get_key() {
        return this.key;
    }

    public RangeFilter set_key(int key) {
        this.key = key;
        set_key_isSet(true);
        return this;
    }

    public void unset_key() {
        __isset_bit_vector.clear(__KEY_ISSET_ID);
    }

    /**
     * Returns true if field key is set (has been asigned a value) and false otherwise
     */
    public boolean is_set_key() {
        return __isset_bit_vector.get(__KEY_ISSET_ID);
    }

    public void set_key_isSet(boolean value) {
        __isset_bit_vector.set(__KEY_ISSET_ID, value);
    }

    public double get_floor() {
        return this.floor;
    }

    public RangeFilter set_floor(double floor) {
        this.floor = floor;
        set_floor_isSet(true);
        return this;
    }

    public void unset_floor() {
        __isset_bit_vector.clear(__FLOOR_ISSET_ID);
    }

    /**
     * Returns true if field floor is set (has been asigned a value) and false otherwise
     */
    public boolean is_set_floor() {
        return __isset_bit_vector.get(__FLOOR_ISSET_ID);
    }

    public void set_floor_isSet(boolean value) {
        __isset_bit_vector.set(__FLOOR_ISSET_ID, value);
    }

    public boolean is_no_floor() {
        return this.no_floor;
    }

    public RangeFilter set_no_floor(boolean no_floor) {
        this.no_floor = no_floor;
        set_no_floor_isSet(true);
        return this;
    }

    public void unset_no_floor() {
        __isset_bit_vector.clear(__NO_FLOOR_ISSET_ID);
    }

    /**
     * Returns true if field no_floor is set (has been asigned a value) and false otherwise
     */
    public boolean is_set_no_floor() {
        return __isset_bit_vector.get(__NO_FLOOR_ISSET_ID);
    }

    public void set_no_floor_isSet(boolean value) {
        __isset_bit_vector.set(__NO_FLOOR_ISSET_ID, value);
    }

    public double get_ceil() {
        return this.ceil;
    }

    public RangeFilter set_ceil(double ceil) {
        this.ceil = ceil;
        set_ceil_isSet(true);
        return this;
    }

    public void unset_ceil() {
        __isset_bit_vector.clear(__CEIL_ISSET_ID);
    }

    /**
     * Returns true if field ceil is set (has been asigned a value) and false otherwise
     */
    public boolean is_set_ceil() {
        return __isset_bit_vector.get(__CEIL_ISSET_ID);
    }

    public void set_ceil_isSet(boolean value) {
        __isset_bit_vector.set(__CEIL_ISSET_ID, value);
    }

    public boolean is_no_ceil() {
        return this.no_ceil;
    }

    public RangeFilter set_no_ceil(boolean no_ceil) {
        this.no_ceil = no_ceil;
        set_no_ceil_isSet(true);
        return this;
    }

    public void unset_no_ceil() {
        __isset_bit_vector.clear(__NO_CEIL_ISSET_ID);
    }

    /**
     * Returns true if field no_ceil is set (has been asigned a value) and false otherwise
     */
    public boolean is_set_no_ceil() {
        return __isset_bit_vector.get(__NO_CEIL_ISSET_ID);
    }

    public void set_no_ceil_isSet(boolean value) {
        __isset_bit_vector.set(__NO_CEIL_ISSET_ID, value);
    }

    public void setFieldValue(_Fields field, Object value) {
        switch (field) {
            case KEY:
                if (value == null) {
                    unset_key();
                } else {
                    set_key((Integer) value);
                }
                break;

            case FLOOR:
                if (value == null) {
                    unset_floor();
                } else {
                    set_floor((Double) value);
                }
                break;

            case NO_FLOOR:
                if (value == null) {
                    unset_no_floor();
                } else {
                    set_no_floor((Boolean) value);
                }
                break;

            case CEIL:
                if (value == null) {
                    unset_ceil();
                } else {
                    set_ceil((Double) value);
                }
                break;

            case NO_CEIL:
                if (value == null) {
                    unset_no_ceil();
                } else {
                    set_no_ceil((Boolean) value);
                }
                break;

        }
    }

    public Object getFieldValue(_Fields field) {
        switch (field) {
            case KEY:
                return new Integer(get_key());

            case FLOOR:
                return new Double(get_floor());

            case NO_FLOOR:
                return new Boolean(is_no_floor());

            case CEIL:
                return new Double(get_ceil());

            case NO_CEIL:
                return new Boolean(is_no_ceil());

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
            case KEY:
                return is_set_key();
            case FLOOR:
                return is_set_floor();
            case NO_FLOOR:
                return is_set_no_floor();
            case CEIL:
                return is_set_ceil();
            case NO_CEIL:
                return is_set_no_ceil();
        }
        throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
        if (that == null)
            return false;
        if (that instanceof RangeFilter)
            return this.equals((RangeFilter) that);
        return false;
    }

    public boolean equals(RangeFilter that) {
        if (that == null)
            return false;

        boolean this_present_key = true;
        boolean that_present_key = true;
        if (this_present_key || that_present_key) {
            if (!(this_present_key && that_present_key))
                return false;
            if (this.key != that.key)
                return false;
        }

        boolean this_present_floor = true;
        boolean that_present_floor = true;
        if (this_present_floor || that_present_floor) {
            if (!(this_present_floor && that_present_floor))
                return false;
            if (this.floor != that.floor)
                return false;
        }

        boolean this_present_no_floor = true;
        boolean that_present_no_floor = true;
        if (this_present_no_floor || that_present_no_floor) {
            if (!(this_present_no_floor && that_present_no_floor))
                return false;
            if (this.no_floor != that.no_floor)
                return false;
        }

        boolean this_present_ceil = true;
        boolean that_present_ceil = true;
        if (this_present_ceil || that_present_ceil) {
            if (!(this_present_ceil && that_present_ceil))
                return false;
            if (this.ceil != that.ceil)
                return false;
        }

        boolean this_present_no_ceil = true;
        boolean that_present_no_ceil = true;
        if (this_present_no_ceil || that_present_no_ceil) {
            if (!(this_present_no_ceil && that_present_no_ceil))
                return false;
            if (this.no_ceil != that.no_ceil)
                return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public int compareTo(RangeFilter other) {
        if (!getClass().equals(other.getClass())) {
            return getClass().getName().compareTo(other.getClass().getName());
        }

        int lastComparison = 0;
        RangeFilter typedOther = (RangeFilter) other;

        lastComparison = Boolean.valueOf(is_set_key()).compareTo(typedOther.is_set_key());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (is_set_key()) {
            lastComparison = TBaseHelper.compareTo(this.key, typedOther.key);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        lastComparison = Boolean.valueOf(is_set_floor()).compareTo(typedOther.is_set_floor());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (is_set_floor()) {
            lastComparison = TBaseHelper.compareTo(this.floor, typedOther.floor);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        lastComparison = Boolean.valueOf(is_set_no_floor()).compareTo(typedOther.is_set_no_floor());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (is_set_no_floor()) {
            lastComparison = TBaseHelper.compareTo(this.no_floor, typedOther.no_floor);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        lastComparison = Boolean.valueOf(is_set_ceil()).compareTo(typedOther.is_set_ceil());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (is_set_ceil()) {
            lastComparison = TBaseHelper.compareTo(this.ceil, typedOther.ceil);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        lastComparison = Boolean.valueOf(is_set_no_ceil()).compareTo(typedOther.is_set_no_ceil());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (is_set_no_ceil()) {
            lastComparison = TBaseHelper.compareTo(this.no_ceil, typedOther.no_ceil);
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
                case 1: // KEY
                    if (field.type == TType.I32) {
                        this.key = iprot.readI32();
                        set_key_isSet(true);
                    } else {
                        TProtocolUtil.skip(iprot, field.type);
                    }
                    break;
                case 2: // FLOOR
                    if (field.type == TType.DOUBLE) {
                        this.floor = iprot.readDouble();
                        set_floor_isSet(true);
                    } else {
                        TProtocolUtil.skip(iprot, field.type);
                    }
                    break;
                case 3: // NO_FLOOR
                    if (field.type == TType.BOOL) {
                        this.no_floor = iprot.readBool();
                        set_no_floor_isSet(true);
                    } else {
                        TProtocolUtil.skip(iprot, field.type);
                    }
                    break;
                case 4: // CEIL
                    if (field.type == TType.DOUBLE) {
                        this.ceil = iprot.readDouble();
                        set_ceil_isSet(true);
                    } else {
                        TProtocolUtil.skip(iprot, field.type);
                    }
                    break;
                case 5: // NO_CEIL
                    if (field.type == TType.BOOL) {
                        this.no_ceil = iprot.readBool();
                        set_no_ceil_isSet(true);
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
        oprot.writeFieldBegin(KEY_FIELD_DESC);
        oprot.writeI32(this.key);
        oprot.writeFieldEnd();
        oprot.writeFieldBegin(FLOOR_FIELD_DESC);
        oprot.writeDouble(this.floor);
        oprot.writeFieldEnd();
        oprot.writeFieldBegin(NO_FLOOR_FIELD_DESC);
        oprot.writeBool(this.no_floor);
        oprot.writeFieldEnd();
        oprot.writeFieldBegin(CEIL_FIELD_DESC);
        oprot.writeDouble(this.ceil);
        oprot.writeFieldEnd();
        oprot.writeFieldBegin(NO_CEIL_FIELD_DESC);
        oprot.writeBool(this.no_ceil);
        oprot.writeFieldEnd();
        oprot.writeFieldStop();
        oprot.writeStructEnd();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("RangeFilter(");
        boolean first = true;

        sb.append("key:");
        sb.append(this.key);
        first = false;
        if (!first) sb.append(", ");
        sb.append("floor:");
        sb.append(this.floor);
        first = false;
        if (!first) sb.append(", ");
        sb.append("no_floor:");
        sb.append(this.no_floor);
        first = false;
        if (!first) sb.append(", ");
        sb.append("ceil:");
        sb.append(this.ceil);
        first = false;
        if (!first) sb.append(", ");
        sb.append("no_ceil:");
        sb.append(this.no_ceil);
        first = false;
        sb.append(")");
        return sb.toString();
    }

    public void validate() throws TException {
        // check for required fields
    }

}

